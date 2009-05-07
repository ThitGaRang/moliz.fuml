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
package org.modeldriven.fuml.assembly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.model.Model;
import org.modeldriven.fuml.model.uml2.UmlClass;
import org.modeldriven.fuml.model.uml2.UmlClassifier;
import org.modeldriven.fuml.xmi.AbstractXmiNodeVisitor;
import org.modeldriven.fuml.xmi.XmiExternalReferenceElement;
import org.modeldriven.fuml.xmi.XmiInternalReferenceElement;
import org.modeldriven.fuml.xmi.XmiNode;
import org.modeldriven.fuml.xmi.XmiNodeVisitor;
import org.modeldriven.fuml.xmi.XmiNodeVisitorStatus;
import org.modeldriven.fuml.xmi.stream.StreamNode;
import org.modeldriven.fuml.xmi.validation.ErrorCode;
import org.modeldriven.fuml.xmi.validation.ErrorSeverity;
import org.modeldriven.fuml.xmi.validation.ValidationError;

import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Classes.Kernel.Element;

public class ElementGraphAssembler extends AbstractXmiNodeVisitor
    implements XmiNodeVisitor 
{    
    private static Log log = LogFactory.getLog(ElementGraphAssembler.class);
    private Model metadata = Model.getInstance();
    private Map<String, ElementAssembler> assemblerMap = new HashMap<String, ElementAssembler>();
    private Map<String, ElementAssembler> resultsElements = new HashMap<String, ElementAssembler>();
    private ElementAssembler root;
    private AssemblerResultsProfile resultsProfile;
    private boolean assembleExternalReferences = true;
    
    @SuppressWarnings("unused")
    private ElementGraphAssembler() {}

    public ElementGraphAssembler(XmiNode xmiRoot, AssemblerResultsProfile resultsProfile, 
            boolean assembleExternalReferences) {
        
        super(xmiRoot);
        this.resultsProfile = resultsProfile;
        this.assembleExternalReferences = assembleExternalReferences;
        
        // create an assembler hierarchy
        xmiRoot.accept(this);
        
        root.acceptBreadthFirst(new ReferenceFeatureAssembler());
        root.acceptBreadthFirst(new ElementLinker());               
        root.acceptBreadthFirst(new LibraryRegistration()); // TODO: move to library package              
    }
    
    public ElementGraphAssembler(XmiNode xmiRoot, AssemblerResultsProfile resultsProfile) {
        this(xmiRoot, resultsProfile, true);
    }
    
    public ElementGraphAssembler(XmiNode xmiRoot) {
        
        // by default look only for Activities as assembler results
    	this(xmiRoot, 
    	    new AssemblerResultsProfile(
                new UmlClass[] { 
                        (UmlClass)Model.getInstance().getClassifier(Activity.class.getSimpleName())                 
                    }
                ), true);    	    	
    }

    public ElementGraphAssembler(XmiNode xmiRoot, 
            boolean assembleExternalReferences) {
        
        // by default look only for Activities as assembler results
        this(xmiRoot, 
            new AssemblerResultsProfile(
                new UmlClass[] { 
                        (UmlClass)Model.getInstance().getClassifier(Activity.class.getSimpleName())                 
                    }
                ), assembleExternalReferences);               
    }
    
    public void clear() {
        this.assemblerMap.clear();
        this.classifierMap.clear();
        this.references.clear();
        this.resultsElements.clear();
        this.root = null;
    }
    
    public void visit(XmiNode target, XmiNode source, 
            String sourceKey, XmiNodeVisitorStatus status, int level)
    {
        if (log.isDebugEnabled())
            if (source != null)
                log.debug("visit: " + target.getLocalName() 
                    + " \t\tsource: " + source.getLocalName());
            else
                log.debug("visit: " + target.getLocalName());
        
        StreamNode eventNode = (StreamNode)target;
                        
        UmlClassifier classifier = this.findClassifier(target, source);
        if (classifier == null)
        {
        	ValidationError error = new ValidationError(eventNode, 
    				ErrorCode.UNDEFINED_CLASS, ErrorSeverity.WARN);
        	log.warn(error.toString());
        	String xmiType = target.getXmiType();
            if (xmiType != null && xmiType.length() > 0)
                log.warn("ignoring element, " + xmiType);
            else    
                log.warn("ignoring element, " + target.getLocalName());
            return;
        }
    	if (log.isDebugEnabled())
    		log.debug("identified element '" + target.getLocalName() + "' as classifier, "
    			+ classifier.getName());
    	classifierMap.put(target, classifier);
    	
        if (metadata.isIgnoredClassifier(classifier))
        {    
            if (!"OpaqueExpression".equals(classifier.getName()))
                return; // FIXME; HACK for MagicDraw
            else
                log.warn("assembling non-fUML element '" + classifier.getName() + "'");
        }
    	
        boolean hasAttributes = eventNode.hasAttributes();
    	if (isPrimitiveTypeElement(target, classifier, hasAttributes))
    		return; // must be an attribute, handled in ElementAssembler 
    	
    	ElementAssembler sourceAssembler = null;
    	if (source != null && source.getXmiId() != null)
            sourceAssembler = assemblerMap.get(source.getXmiId());      

    	// If the element is a "child" and represents just a reference, we don't need an assembler
    	// for it. Just add it as a reference to the parent for later lookup. 
    	if (sourceAssembler != null)
    	{    
        	if (isInternalReferenceElement(eventNode, classifier, hasAttributes))
        	{
        		sourceAssembler.addReference(new XmiInternalReferenceElement(eventNode)); 
            	return; 
        	}	
    
            if (isExternalReferenceElement(eventNode, classifier, hasAttributes))
            {
                sourceAssembler.addReference(new XmiExternalReferenceElement(eventNode)); 
                return; 
            }
    	}
    	
        ElementAssembler assembler = new ElementAssembler(target, source,
                classifier, assemblerMap);
        assembler.setAssembleExternalReferences(this.assembleExternalReferences);
        assembler.assembleElementClass();
        assembler.assemleFeatures();
        if (resultsProfile.isResultClass(assembler.getPrototype()))
            this.resultsElements.put(target.getXmiId(), assembler);
        
        if (target.getXmiId() != null)
            assemblerMap.put(target.getXmiId(), assembler);
        
        // build an assembler hierarchy
        if (sourceAssembler != null)
        {	
        	sourceAssembler.add(assembler);
        	assembler.setParentAssembler(sourceAssembler);
        }
        
        if (source == null)
        {
            if (root != null)
                throw new AssemblyException("cannot replace root, "
                    + root.getTargetObject().getClass().getSimpleName()
                    + "(" +  root.getXmiId() + ") with, "
                    + assembler.getTargetObject().getClass().getSimpleName()
                    + "(" +  assembler.getXmiId() + ")");
            root = assembler; 
        }         
    }

    public List<Element> getResults()
    {
        List<Element> results = new ArrayList<Element>();
        Iterator<String> keys = resultsElements.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            ElementAssembler assembler = resultsElements.get(key);
            results.add(assembler.getTarget());
        }
        return results;
    }
 
    public List<String> getResultsXmiIds()
    {
        List<String> results = new ArrayList<String>();
        Iterator<String> keys = resultsElements.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            results.add(key);
        }
        return results;
    }
    
    public Element lookupResult(String xmiId)
    {
        return resultsElements.get(xmiId).getTarget();   
    }
    
    class ReferenceFeatureAssembler implements AssemblerVisitor
    {
        private Log log = LogFactory.getLog(ReferenceFeatureAssembler.class);
        
        public void begin(AssemblerNode target, AssemblerNode source, 
                String sourceKey, int level)
        {
            ElementAssembler targetAssembler = (ElementAssembler)target;
            ElementAssembler sourceAssembler = (ElementAssembler)source;
            
            if (log.isDebugEnabled())
                if (source != null)
                    log.debug("begin: " + targetAssembler.getTargetClass().getSimpleName() 
                        + " \t\tsource: " + sourceAssembler.getTargetClass().getSimpleName());
                else
                    log.debug("begin: " + targetAssembler.getTargetClass().getSimpleName());
            if (log.isDebugEnabled())
                log.debug("postassemble: (" + targetAssembler.getTargetClass().getSimpleName() + ")" + " " 
                        + targetAssembler.getPrototype().getName());
               
            targetAssembler.assembleReferenceFeatures();
        }
        
        public void end(AssemblerNode target, AssemblerNode source, 
                String sourceKey, int level)
        {
            
        }
        
    }
 
    class ElementLinker implements AssemblerVisitor
    {
        private Log log = LogFactory.getLog(ElementLinker.class);
        
        public void begin(AssemblerNode target, AssemblerNode source, 
                String sourceKey, int level)
        {
            ElementAssembler targetAssembler = (ElementAssembler)target;
            ElementAssembler sourceAssembler = (ElementAssembler)source;
            if (log.isDebugEnabled())
                if (source != null)
                    log.debug("begin: " + targetAssembler.getTargetClass().getSimpleName() 
                        + " \t\tsource: " + sourceAssembler.getTargetClass().getSimpleName());
                else
                    log.debug("begin: " + targetAssembler.getTargetClass().getSimpleName());
            if (log.isDebugEnabled())
                log.debug("postassemble: (" + targetAssembler.getTargetClass().getSimpleName() + ")" + " " 
                        + targetAssembler.getPrototype().getName());

            
            if (sourceAssembler != null)
                targetAssembler.associateElement(sourceAssembler);

        }
        
        public void end(AssemblerNode target, AssemblerNode source, 
                String sourceKey, int level)
        {
            
        }       
    }
 
    class LibraryRegistration implements AssemblerVisitor
    {
        private Log log = LogFactory.getLog(LibraryRegistration.class);
        
        public void begin(AssemblerNode target, AssemblerNode source, 
                String sourceKey, int level)
        {
            ElementAssembler targetAssembler = (ElementAssembler)target;
            ElementAssembler sourceAssembler = (ElementAssembler)source;
            if (log.isDebugEnabled())
                if (source != null)
                    log.debug("begin: " + targetAssembler.getTargetClass().getSimpleName() 
                        + " \t\tsource: " + sourceAssembler.getTargetClass().getSimpleName());
                else
                    log.debug("begin: " + targetAssembler.getTargetClass().getSimpleName());
            if (log.isDebugEnabled())
                log.debug("postassemble: (" + targetAssembler.getTargetClass().getSimpleName() + ")" + " " 
                        + targetAssembler.getPrototype().getName());

            targetAssembler.registerElement();            
        }
        
        public void end(AssemblerNode target, AssemblerNode source, 
                String sourceKey, int level)
        {
            
        }       
    }

    public boolean isAssembleExternalReferences() {
        return assembleExternalReferences;
    }

    public void setAssembleExternalReferences(boolean assembleExternalReferences) {
        this.assembleExternalReferences = assembleExternalReferences;
    }
    
}
