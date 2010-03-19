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

package org.modeldriven.fuml.xmi;

import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.meta.MetaModel;
import org.modeldriven.fuml.xmi.stream.StreamNode;

import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Classifier;
import fUML.Syntax.Classes.Kernel.Enumeration;
import fUML.Syntax.Classes.Kernel.PrimitiveType;

import org.modeldriven.fuml.meta.Property;

/**
 * Stateless model-related logic delegate class. Handles metadata related logic specific 
 * for the the XMI package or it's sub-packages.
 * 
 * @author Scott Cinnamond
 */
public class ModelSupport {
    private static Log log = LogFactory.getLog(ModelSupport.class);
		
    public Classifier findClassifier(XmiNode target)
    {
    	Classifier result = MetaModel.getInstance().findClassifier(target.getLocalName());
        if (result != null)
            return result;
        
        // the XMI element is not a class, must be an association-end and we
        // may find its type from 
        String xmiType = target.getXmiType();
        if (xmiType != null && xmiType.length() > 0)
        {    
            result = MetaModel.getInstance().findClassifier(xmiType);
        }
        return result;
    }
    
    public Classifier findClassifier(XmiNode target, Classifier sourceClassifier)
    {
    	Classifier result = null;
    	        
    	// For nodes with an XMI type attrib, don't ignore it
    	// if no classifier found for type. Could result in
    	// abstract class being used based on default
    	// type determination below. 
    	String xmiType = target.getXmiType();
        if (xmiType != null && xmiType.length() > 0)
        {    
            result = MetaModel.getInstance().findClassifier(xmiType);
            if (result == null)
            	return result; 
        }
        
        Property property = MetaModel.getInstance().findAttribute(
        		(Class_)sourceClassifier, target.getLocalName());
        if (property != null)
        {
            Classifier type = MetaModel.getInstance().getType(property);
            result = MetaModel.getInstance().getClassifier(type.name);    
        }
        return result;
    }
    
    public boolean isPrimitiveTypeElement(XmiNode node, Classifier classifier,
			boolean hasAttributes)
	{
		boolean result = false;
    	// if non-reference primitive type property element
    	if (PrimitiveType.class.isAssignableFrom(classifier.getClass()))
    	{
    		if (node.getNodes() != null && node.getNodes().size() > 0)
    			log.warn("found child nodes(s) under primitive type, " 
    					+ classifier.name);
    		if (hasAttributes)
    			log.warn("found attribute(s) for primitive type, " 
    					+ classifier.name);
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
    public boolean isInternalReferenceElement(XmiNode node, Classifier classifier,
			boolean hasAttributes)
	{
		boolean result = false;
		
		if (!isPrimitiveTypeElement(node, classifier, hasAttributes))
		{
        	if (node.hasCharacters())
        	{
        		if (hasAttributes)
        			log.warn("found attribute(s) for characters node of type, " 
        					+ classifier.name);
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
    public boolean isExternalReferenceElement(XmiNode node, Classifier classifier,
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
    
	protected boolean isAbstract(Classifier classifier) {
		return MetaModel.getInstance().isAbstract(classifier);
	}
	
	public boolean isReferenceAttribute(Property property)
	{
		Classifier typeClassifier = MetaModel.getInstance().getType(property);             
    	if (!PrimitiveType.class.isAssignableFrom(typeClassifier.getClass()) &&
    		!Enumeration.class.isAssignableFrom(typeClassifier.getClass()))
    	{
			return true;
    	}
		return false;
	}}
