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

package org.modeldriven.fuml.xmi.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Namespace;
import javax.xml.stream.events.XMLEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.config.FumlConfiguration;
import org.modeldriven.fuml.config.ImportElement;
import org.modeldriven.fuml.config.NamespaceDomain;
import org.modeldriven.fuml.config.SupportedNamespace;
import org.modeldriven.fuml.xmi.XmiConstants;
import org.modeldriven.fuml.xmi.XmiException;

/**
 * Encapsulates context information for the current XMI stream, including 
 * namespaces and other resources. Namespaces are loaded from the (XML) root 
 * element based on a configurable set of supported namespaces for various 
 * domains. If no namespace is found within the supported namespaces for a 
 * particular domain, an error is thrown. 
 * 
 * @author Scott Cinnamond
 */
public class StreamContext {
    private static Log log = LogFactory.getLog(StreamContext.class);
    
    private Namespace[] namespaces;
    private Namespace defaultNamespace;
    private Map<NamespaceDomain, Namespace> namespaceMap = new HashMap<NamespaceDomain, Namespace>();

	@SuppressWarnings("unused")
	private StreamContext() {}

	public StreamContext(XMLEvent root) {
		loadNamespaces(root);
		loadDefaultNamespace(root);
	}
	
	private void loadDefaultNamespace(XMLEvent root)
	{
	    defaultNamespace = this.getUmlNamespace(); 	    
	}
	
	private void loadNamespaces(XMLEvent root) {
		
		List<Namespace> list = new ArrayList<Namespace> ();
    	Iterator<Namespace> namespaceIter = root.asStartElement().getNamespaces();
    	while (namespaceIter.hasNext())
    	{
    		Namespace namespace = namespaceIter.next();
    		list.add(namespace);
    		
    		QName name = namespace.getName();
    		if (log.isDebugEnabled())
    		    log.debug("root namespace: " + name.toString());
    		String uri = namespace.getValue();
    		if (!XmiConstants.NAMESPACE_PREFIX.equals(name.getPrefix()))
    		    continue; //not a namespace
        		    
    		NamespaceDomain domain = FumlConfiguration.getInstance().findNamespaceDomain(uri);
    		if (domain == null)
    		{    
    		    log.debug("cannot find domain for namespace, " + uri);
    		    continue;
    		}
    		
    		Namespace existing = this.namespaceMap.get(domain);
    		if (existing != null)
    		    throw new XmiException("multiple " + domain.value() + " namespaces ("
                        + existing.getNamespaceURI() + ", "
                        + namespace.getNamespaceURI() + ")");
    		
    		this.namespaceMap.put(domain, namespace);
    		
    	} // while()
    	
    	if (getXmiNamespace() == null)
    	{	
            throw new XmiException(createNamespaceMessge(NamespaceDomain.XMI));
    	}
    	if (getUmlNamespace() == null)
    	{	
    		throw new XmiException(createNamespaceMessge(NamespaceDomain.UML));
    	}
    	
    	namespaces = new Namespace[list.size()];
    	list.toArray(namespaces);    	
	}
	
	private String createNamespaceMessge(NamespaceDomain domain)
	{
        String[] supported = 
            FumlConfiguration.getInstance().getSupportedNamespaceURIsForDomain(domain);
        String msg = "no supported " + domain.value().toUpperCase() 
            +  " namespace found - expected one of [";
        for (int i = 0; i < supported.length; i++)
        {    
            if (i > 0)
                msg += ", ";
            msg += supported[i];
        }
        msg += "] (remedy: use supported namespace or modify configuration file '" + 
            FumlConfiguration.getInstance().getActiveConfigFileName() + "')";
	    return msg;
	}

	public Namespace getXmiNamespace() {
		return namespaceMap.get(NamespaceDomain.XMI);
	}

	public Namespace getUmlNamespace() {
        return namespaceMap.get(NamespaceDomain.UML);
	}

    public Namespace getDefaultNamespace() {
        return defaultNamespace;
    }
	
	public Namespace getEcoreNamespace() {
        return namespaceMap.get(NamespaceDomain.ECORE);
    }

    public Namespace getMagicdrawNamespace() {
        return namespaceMap.get(NamespaceDomain.MAGICDRAW);
    }

    public Namespace[] getNamespaces() {
		return namespaces;
	}
	
	
	
}
