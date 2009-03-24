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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.model.Model;
import org.modeldriven.fuml.xmi.ModelSupport;
import org.modeldriven.fuml.xmi.XmiNode;
import org.modeldriven.fuml.xmi.XmiNodeVisitor;
import org.modeldriven.fuml.xmi.XmiReference;
import org.modeldriven.fuml.xmi.XmiReferenceAttribute;
import org.modeldriven.fuml.xmi.XmiReferenceElement;
import org.modeldriven.fuml.xmi.stream.StreamNode;
import org.modeldriven.fuml.model.uml2.UmlClass;
import org.modeldriven.fuml.model.uml2.UmlClassifier;
import org.modeldriven.fuml.model.uml2.UmlEnumeration;
import org.modeldriven.fuml.model.uml2.UmlPrimitiveType;
import org.modeldriven.fuml.model.uml2.UmlProperty;

/**
 * General XMINodeVisitor implementation superclass encapsulating common structure and 
 * logic across both XMI validation and target structure assembly processing.
 * 
 * @author Scott Cinnamond
 */
public abstract class AbstractXmiNodeVisitor {
    private static Log log = LogFactory.getLog(AbstractXmiNodeVisitor.class);

    protected XmiNode root;
    protected ModelSupport modelSupport;
    protected Map<XmiNode, UmlClassifier> classifierMap = new HashMap<XmiNode, UmlClassifier>();
    protected Map<String, XmiNode> nodeMap = new HashMap<String, XmiNode>();
    protected List<XmiReference> references = new ArrayList<XmiReference>();

	protected AbstractXmiNodeVisitor() {
		modelSupport = new ModelSupport();
	}
	
	protected AbstractXmiNodeVisitor(XmiNode root) {
		this();
		this.root = root;
	}
	
	protected UmlClassifier findClassifier(XmiNode target, XmiNode source)
	{
		UmlClassifier classifier = modelSupport.findClassifier(target);
		if (classifier == null)
		{	
			if (source != null)
			{	
			    UmlClassifier sourceClassifier = classifierMap.get(source);
			    if (sourceClassifier != null)
			        classifier = modelSupport.findClassifier(target, sourceClassifier);
			}
		}
		return classifier;
	}
	
	protected boolean isPrimitiveTypeElement(XmiNode node, UmlClassifier classifier,
			boolean hasAttributes)
	{
		return modelSupport.isPrimitiveTypeElement(node, classifier, hasAttributes);
	}

	protected boolean isInternalReferenceElement(XmiNode node, UmlClassifier classifier,
			boolean hasAttributes)
	{
		return modelSupport.isInternalReferenceElement(node, classifier, hasAttributes);
	}

    protected boolean isExternalReferenceElement(XmiNode node, UmlClassifier classifier,
            boolean hasAttributes)
    {
        return modelSupport.isExternalReferenceElement(node, classifier, hasAttributes);
    }
	
	protected boolean isAbstract(UmlClassifier classifier) {
		return modelSupport.isAbstract(classifier);
	}
	
	protected boolean isReferenceAttribute(UmlProperty property)
	{
		return modelSupport.isReferenceAttribute(property);
	}
	
	@Deprecated
	protected Attribute findAttribute(StreamNode node, String localName)
	{
		QName name = new QName(localName);
        return node.getStartElementEvent().asStartElement().getAttributeByName(name);
        /*
        while (attributes.hasNext())
        {
            Attribute xmlAttrib = attributes.next();

            QName name = xmlAttrib.getName();
            if (localName.equals(name.getLocalPart()))
            	return xmlAttrib;
        }   
        return null;
        */
	}
	
}
