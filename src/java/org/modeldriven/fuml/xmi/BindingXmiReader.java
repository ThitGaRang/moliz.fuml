/*
 * Copyright 2008 Lockheed Martin Corporation, except as stated in the file 
 * entitled Licensing-Information. Licensed under the Academic Free License 
 * version 3.0 (http://www.opensource.org/licenses/afl-3.0.php), except as stated 
 * in the file entitled Licensing-Information. 
 *
 * Contributors:
 *   MDS - initial API and implementation
 *
 */

package org.modeldriven.fuml.xmi;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.bind.DataBinding;
import org.modeldriven.fuml.common.xsl.XSLTUtils;
import org.modeldriven.fuml.model.uml2.UmlModel;
import org.modeldriven.fuml.model.uml2.UmlPackage;
import org.modeldriven.fuml.model.xmi.XMIType;

/**
 * XML data-bing based XMI import processor capable of expanging the input XMI stream 
 * into another format as a precursor to binding. Currently an expansion XSL template 
 * is used to "stripe" the XMI content based on declated 'type' information. The expanded 
 * "striped" XMI format lends itself far more easily to the standard JAXB data binding 
 * implementation.  
 * 
 * @author Scott Cinnamond
 */
public class BindingXmiReader implements XmiReader {
    
    private static Log log = LogFactory.getLog(BindingXmiReader.class);
    private DataBinding binding;
    private boolean expandInput = true;
    
    private static final String stylesheetFileName = "ExpandXMI.xsl";
	
	@SuppressWarnings("unused")
    private BindingXmiReader () {}
	
	public BindingXmiReader (DataBinding binding) {
        this.binding = binding;
    }		
	
	@SuppressWarnings("unchecked")
    public Collection read(InputStream stream)
	{	    
        List<UmlPackage> results = new ArrayList<UmlPackage>();
        InputStream source = stream;
    	
		try {
	        
	        if (this.isExpandInput())
	            source = this.expand(source);
	        
	        UmlPackage pkg = null;

            JAXBElement root = (JAXBElement)binding.validate(source);
	    	if (this.binding.getValidationEventHandler().getErrorCount() > 0)
	    		log.warn("found " + 
	    				String.valueOf(
	    				        this.binding.getValidationEventHandler().getErrorCount()) 
	    				        + " errors(s)");
	    	pkg = getTopLevelPackage(root);
	    	if (log.isDebugEnabled())
	    	    log.debug("marshaled: " + binding.marshal(root));
	    	results.add(pkg);
		}
		catch (TransformerException e) {
            log.error(e.getMessage(), e);
		     throw new XmiException(e);   
		}
        catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new XmiException(e);   
        }
        catch (JAXBException e) {
            log.error(e.getMessage(), e);
            throw new XmiException(e);   
        }
		finally {
		    try {
		        source.close();
		    }
		    catch (IOException e) {		        
		    }
		}
				
		return results;		
	}
	
	private InputStream expand(InputStream source)
	    throws FileNotFoundException, IOException, TransformerException
    {    
        XSLTUtils xsltUtils = new XSLTUtils();
        URL stylesheet = this.getClass().getResource(stylesheetFileName);
        File file = new File(this.getClass().getSimpleName() + ".out"); // FIXME: use real temp file
        FileOutputStream dest = new FileOutputStream(file);
        log.info("expanding input to temp file, " + file.getAbsolutePath());
        xsltUtils.transform(source, 
                dest,
                stylesheet);
        
        FileInputStream result = new FileInputStream(file);
        
        if (log.isDebugEnabled())
        {   
            FileInputStream expanded = new FileInputStream(file);
            try {
                String content = getContent(expanded);
                //log.debug("expanded content: " + content);
                result = new FileInputStream(file); // WTF? stream reset not supported?
            }
            finally {
                expanded.close();
            }
        }  
        return result;
    }
	
	@SuppressWarnings("unchecked")
    private UmlPackage getTopLevelPackage(JAXBElement root)
	{
		UmlPackage result = null;
	    
        if (root.getValue() instanceof UmlPackage)               
        	result = (UmlPackage)root.getValue();
        else if (root.getValue() instanceof XMIType)
        {
            List<Object> list = ((XMIType)root.getValue()).getAny();
            Iterator<Object> iter = list.iterator();
            while (iter.hasNext())
            {
                Object obj = iter.next();
                if (obj instanceof JAXBElement)
                {   
                    JAXBElement elem = (JAXBElement)obj;
                    if (elem.getValue() instanceof UmlPackage)
                    	result = (UmlPackage)elem.getValue();
                }    
            }
            if (result == null)
                throw new XmiException("expected top-level model or package element within XMI");
        }    
	    return result;   
	}

    public XmiValidationEventHandler getValidationEventHandler() 
        throws JAXBException 
    {
        return (XmiValidationEventHandler)this.binding.getValidationEventHandler();
    }

    private String getContent(InputStream source) throws IOException {
        byte[] buf = new byte[4000];
        ByteArrayOutputStream os = new ByteArrayOutputStream(4000);
        try {
            int len = -1;
            while ((len = source.read(buf)) != -1)
                os.write(buf, 0, len);
        }
        finally  {
            source.close();
            os.flush();
        }
        return new String(os.toByteArray());            
    }
    
    public boolean isExpandInput() {
        return expandInput;
    }

    public void setExpandInput(boolean expandInput) {
        this.expandInput = expandInput;
    }

}
