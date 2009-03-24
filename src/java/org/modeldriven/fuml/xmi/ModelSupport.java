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

import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.events.Attribute;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.environment.Environment;
import org.modeldriven.fuml.model.Model;
import org.modeldriven.fuml.xmi.XmiException;
import org.modeldriven.fuml.xmi.XmiNode;
import org.modeldriven.fuml.xmi.stream.StreamNode;
import org.modeldriven.fuml.model.uml2.UmlClass;
import org.modeldriven.fuml.model.uml2.UmlClassifier;
import org.modeldriven.fuml.model.uml2.UmlEnumeration;
import org.modeldriven.fuml.model.uml2.UmlPrimitiveType;
import org.modeldriven.fuml.model.uml2.UmlProperty;

/**
 * Stateless model-related logic delegate class. Handles metadata related logic specific 
 * for the the XMI package or it's sub-packages.
 * 
 * @author Scott Cinnamond
 */
public class ModelSupport {
    private static Log log = LogFactory.getLog(ModelSupport.class);
		
    public UmlClassifier findClassifier(XmiNode target)
    {
        UmlClassifier result = Model.getInstance().findClassifier(target.getLocalName());
        if (result != null)
            return result;
        
        // the XMI element is not a class, must be an association-end and we
        // may find its type from 
        String xmiType = target.getXmiType();
        if (xmiType != null && xmiType.length() > 0)
        {    
            result = Model.getInstance().findClassifier(xmiType);
        }
        return result;
    }
    
    public UmlClassifier findClassifier(XmiNode target, UmlClassifier sourceClassifier)
    {
    	UmlClassifier result = null;
        
    	// For nodes with an XMI type attrib, don't ignore it
    	// if no classifier found for type. Could result in
    	// abstract class being used based on default
    	// type determination below. 
    	String xmiType = target.getXmiType();
        if (xmiType != null && xmiType.length() > 0)
        {    
            result = Model.getInstance().findClassifier(xmiType);
            if (result == null)
            	return result; 
        }
        
        UmlProperty property = Model.getInstance().findAttribute(
        		(UmlClass)sourceClassifier, target.getLocalName());
        if (property != null)
        {
            UmlClassifier type = Model.getInstance().getType(property);
            result = Model.getInstance().getClassifier(type.getName());    
        }
        return result;
    }
    
    public boolean isPrimitiveTypeElement(XmiNode node, UmlClassifier classifier,
			boolean hasAttributes)
	{
		boolean result = false;
    	// if non-reference primitive type property element
    	if (UmlPrimitiveType.class.isAssignableFrom(classifier.getClass()))
    	{
    		if (node.getNodes() != null && node.getNodes().size() > 0)
    			log.warn("found child nodes(s) under primitive type, " 
    					+ classifier.getName());
    		if (hasAttributes)
    			log.warn("found attribute(s) for primitive type, " 
    					+ classifier.getName());
    		result = true; // it's a non-reference property, "can't" have attributes 
    	} 
    	return result;
	}

    /**
     * Returns true if an element is not a primitive type and it has characters 
     * or an ideref XMI attribute. This constitutes an internal reference element.  
     * @param node
     * @param classifier
     * @param hasAttributes
     * @return
     */
    public boolean isInternalReferenceElement(XmiNode node, UmlClassifier classifier,
			boolean hasAttributes)
	{
		boolean result = false;
		
		if (!isPrimitiveTypeElement(node, classifier, hasAttributes))
		{
        	if (node.hasCharacters())
        	{
        		if (hasAttributes)
        			log.warn("found attribute(s) for characters node of type, " 
        					+ classifier.getName());
        		result = true; // characters node    		
        	}
        	else {
                StreamNode eventNode = (StreamNode)node;                
                QName idref = new QName(eventNode.getContext().getXmiNamespace().getNamespaceURI(),
                        XmiConstants.ATTRIBUTE_XMI_IDREF);
                if (node.hasAttribute(idref))
                    return true;
            }
		}
    	return result;
	}

    /**
     * If not a primitive type and we have an href attrib (??). 
     * @param node
     * @param classifier
     * @param hasAttributes
     * @return
     */
    public boolean isExternalReferenceElement(XmiNode node, UmlClassifier classifier,
            boolean hasAttributes)
    {
        // has to be a ref
        boolean result = false;
        
        if (!isPrimitiveTypeElement(node, classifier, hasAttributes))
        {
            StreamNode eventNode = (StreamNode)node;
            QName href = new QName(XmiConstants.ATTRIBUTE_XMI_HREF);
            if (node.hasAttribute(href))
            {
                String hrefValue = node.getAttributeValue(href);
                if (hrefValue == null)
                    return true;
                
                if (hrefValue.startsWith("pathmap:") || // FIXME: is this pathmap stuff a valid XMI external reference or not!!
                    hrefValue.endsWith("Integer") ||
                    hrefValue.endsWith("String") ||
                    hrefValue.endsWith("Boolean") || 
                    hrefValue.endsWith("UnlimitedNatural"))
                    return false;
                else
                    return true;
            }
        }
        return result;
    }
    
	protected boolean isAbstract(UmlClassifier classifier) {
		if ("true".equals(classifier.getIsAbstract()))
		{			
			return true;  
		}
		return false;
	}
	
	public boolean isReferenceAttribute(UmlProperty property)
	{
        // must be a ref attribute
        UmlClassifier typeClassifier = Model.getInstance().getType(property);             
    	if (!UmlPrimitiveType.class.isAssignableFrom(typeClassifier.getClass()) &&
    		!UmlEnumeration.class.isAssignableFrom(typeClassifier.getClass()))
    	{
			// FIXME: HACK the FUML generalization java/mappings don't give UnlimitedNatural 
    		// a generalization (supertype). So can't implement a 'Model.instanceOf(String)' method
    		if (!"UnlimitedNatural".equals(typeClassifier.getName())) 
    		{
    			return true;
    		}
    	}
		return false;
	}}
