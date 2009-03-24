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
package org.modeldriven.fuml.assembly;

import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.model.Model;
import org.modeldriven.fuml.model.uml2.UmlClassifier;
import org.modeldriven.fuml.xmi.ModelSupport;
import org.modeldriven.fuml.xmi.XmiNode;
import org.modeldriven.fuml.xmi.stream.StreamNode;

import fUML.Syntax.Classes.Kernel.Comment;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.NamedElement;

public class ElementStubAssembler
{    
    public static String STUB_TOKEN = "#STUB#";
    
    private static Log log = LogFactory.getLog(ElementStubAssembler.class);
    private Model metadata = Model.getInstance();
    private ElementAssembler result;
    private ModelSupport modelSupport = new ModelSupport();
    private XmiNode target;
    
    @SuppressWarnings("unused")
    private ElementStubAssembler() {}

    public ElementStubAssembler(XmiNode xmiRoot) {
        this.target = xmiRoot;
        assemble();
    }    
    
    public void clear() {
        this.result = null;
    }
    
    private void assemble()
    {        
        StreamNode eventNode = (StreamNode)target;
                        
        UmlClassifier classifier = modelSupport.findClassifier(target);
        if (classifier == null)
        {
            classifier = metadata.findClassifier("Activity");
        }
    	if (log.isDebugEnabled())
    		log.debug("identified element '" + target.getLocalName() + "' as classifier, "
    			+ classifier.getName());
    	
        ElementAssembler assembler = new ElementAssembler(target, null,
                classifier, null);
        assembler.assembleElementClass();
        
        // FIXME: need some UML model to represent a "stub" element that
        // is intuitive and generic. 
        if (assembler.getTarget() instanceof NamedElement)
        {
            NamedElement namedElement = (NamedElement)assembler.getTarget();
            namedElement.name = "unknown";
            String name = target.getAttributeValue(new QName("name"));
            if (name != null && name.trim().length() > 0)
                namedElement.name = name;
            Comment comment = new Comment();
            comment.body = STUB_TOKEN;
            assembler.getTarget().ownedComment.add(comment);
        }
        else
            throw new AssemblyException("expected instance of NamedElement as target");        
        
        result = assembler;        
    }
    
    public void addErrorText(String text)
    {
        Comment comment = new Comment();
        comment.body = text;
        result.getTarget().ownedComment.add(comment);
    }

    public Element getResult()
    {
        return result.getTarget();
    }
    
    public String getResultId()
    {
        return result.getXmiId();  
    }
}
