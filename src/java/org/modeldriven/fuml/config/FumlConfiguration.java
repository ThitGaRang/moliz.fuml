/*
 * Copyright 2008 Lockheed Martin Corporation, except as stated in the file 
 * entitled Licensing-Information. All modifications copyright 2009 Data Access Technologies, Inc. Licensed under the Academic Free License 
 * version 3.0 (http://www.opensource.org/licenses/afl-3.0.php), except as stated 
 * in the file entitled Licensing-Information. 
 *
 * Contributors:
 *   MDS - initial API and implementation
 *
 */
package org.modeldriven.fuml.config;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.FumlException;
import org.modeldriven.fuml.bind.DefaultValidationEventHandler;
import org.modeldriven.fuml.model.uml2.UmlClassifier;
import org.modeldriven.fuml.model.uml2.UmlProperty;
import org.xml.sax.SAXException;

public class FumlConfiguration {

    private static Log log = LogFactory.getLog(FumlConfiguration.class);
    private static FumlConfiguration instance = null;
    private static String defaultConfigFileName = "FumlConfig.xml";  
    private Map<String, BehaviorExecutionMapping> executions = 
        new HashMap<String, BehaviorExecutionMapping>();
    private Map<String, ImportElement> importElements = new HashMap<String, ImportElement>();
    private Map<String, ImportAdapter> importAdapters = new HashMap<String, ImportAdapter>();
    private String activeConfigFileName;
    
    private Configuration config;
        
    private FumlConfiguration()
    {
        log.info("initializing...");
        try {
            FumlConfigDataBinding configBinding = new FumlConfigDataBinding(
	        		new DefaultValidationEventHandler());
	        
            activeConfigFileName = defaultConfigFileName; // TODO: add command line support for this            
            config = unmarshalConfig(activeConfigFileName, configBinding);
	        
            Iterator<BehaviorExecutionMapping> mappings = config.getMappingConfiguration().getBehaviorExecutionMapping().iterator();
            while (mappings.hasNext())
            {
                BehaviorExecutionMapping mapping = mappings.next();
                executions.put(mapping.getClassName(), mapping);
            }

            Iterator<ImportElement> elements = 
                config.getImportConfiguration().getElement().iterator();  
            while (elements.hasNext())
            {
                ImportElement elem = elements.next();
                importElements.put(elem.getLocalName(), elem);
            }
        
            Iterator<ImportAdapter> adapters = 
                config.getImportConfiguration().getAdapter().iterator();  
            while (adapters.hasNext())
            {
                ImportAdapter adapter = adapters.next();
                importAdapters.put(adapter.getClassName(), adapter);
            }        
        }
        catch (SAXException e) {
            throw new FumlException(e);
        }
        catch (JAXBException e) {
            throw new FumlException(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    private Configuration unmarshalConfig(String configFileName, FumlConfigDataBinding binding)
    {
    	try {
	        InputStream stream = FumlConfiguration.class.getResourceAsStream(configFileName);
	        if (stream == null)
	            throw new FumlException("cannot find resource '" + configFileName + "'");
	        JAXBElement root = (JAXBElement)binding.validate(stream);
	        
	        Configuration result = (Configuration)root.getValue();
            return result;
    	}
        catch (UnmarshalException e) {
            throw new FumlException(e);
        }
        catch (JAXBException e) {
            throw new FumlException(e);
        }
    }
    
    public static FumlConfiguration getInstance()
        throws FumlException
    {
        if (instance == null)
            initializeInstance();
        return instance;
    }
    
    private static synchronized void initializeInstance()
        throws FumlException
    {
        if (instance == null)
            instance = new FumlConfiguration();
    }

    public Configuration getConfig() {
        return config;
    } 
    
    public String[] getSupportedNamespaceURIsForDomain(NamespaceDomain domain)
    {
        List<String> list = new ArrayList<String>();
    
        Iterator<SupportedNamespace> namespaces = 
            getConfig().getImportConfiguration().getSupportedNamespace().iterator();  
        while (namespaces.hasNext())
        {
            SupportedNamespace namespace = namespaces.next();
            if (namespace.getDomain().value().equals(domain.value()))
                list.add(namespace.getUri());
        }
        
        String[] results = new String[list.size()];
        list.toArray(results);
        return results;
    }
    
    public NamespaceDomain findNamespaceDomain(String namespaceUri)
    {
        Iterator<SupportedNamespace> namespaces = 
            getConfig().getImportConfiguration().getSupportedNamespace().iterator();  
        while (namespaces.hasNext())
        {
            SupportedNamespace namespace = namespaces.next();
            if (namespace.getUri().equals(namespaceUri))
                return namespace.getDomain();
        }
        return null;
    }
    
    public boolean hasReferenceMapping(UmlClassifier classifier, UmlProperty property)
    {
        Iterator<ReferenceMapping> mappings = 
            getConfig().getMappingConfiguration().getReferenceMapping().iterator();  
        while (mappings.hasNext())
        {
            ReferenceMapping mapping = mappings.next();
            if (mapping.getClassName().equals(classifier.getName()) &&
                    mapping.getPropertyName().equals(property.getName()))
                return true;
        }
        return false;
    }
    
    public ReferenceMappingType getReferenceMappingType(UmlClassifier classifier, UmlProperty property)
    {
        Iterator<ReferenceMapping> mappings = 
            getConfig().getMappingConfiguration().getReferenceMapping().iterator();  
        while (mappings.hasNext())
        {
            ReferenceMapping mapping = mappings.next();
            if (mapping.getClassName().equals(classifier.getName()) &&
                    mapping.getPropertyName().equals(property.getName()))
                return mapping.getType();
        }
        throw new FumlException("no mapping found for, " 
                + classifier.getName() + "." + property.getName());
    }
    
    public String findExecutionClassName(String name)
    {
        BehaviorExecutionMapping mapping = this.executions.get(name);
        if (mapping != null)
            return mapping.getExecutionClassName();
        return null;
    }

    public String getActiveConfigFileName() {
        return activeConfigFileName;
    }
    
    public ImportElement findImportElement(String name) {
        return this.importElements.get(name);
    }
    
    public ImportAdapter findImportAdapter(String name) {
        return this.importAdapters.get(name);
    }
    
}
