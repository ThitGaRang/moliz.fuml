/*
 * Initial version copyright 2008 Lockheed Martin Corporation, except
 * as stated in the file entitled Licensing-Information.
 *
 * All modifications copyright 2009 Data Access Technologies, Inc.
 *
 * All modifications copyright 2009 Data Access Technologies, Inc. Licensed under the Academic Free License version 3.0
 * (http://www.opensource.org/licenses/afl-3.0.php), except as stated
 * in the file entitled Licensing-Information.
 *
 * Contributors:
 *   MDS - initial API and implementation
 *
 */

package org.modeldriven.fuml.xmi.validation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.config.FumlConfiguration;
import org.modeldriven.fuml.config.ImportAdapter;
import org.modeldriven.fuml.config.ReferenceMappingType;
import org.modeldriven.fuml.environment.Environment;
import org.modeldriven.fuml.library.Library;
import org.modeldriven.fuml.meta.MetaModel;
import org.modeldriven.fuml.xmi.AbstractXmiNodeVisitor;
import org.modeldriven.fuml.xmi.ModelSupport;
import org.modeldriven.fuml.xmi.XmiExternalReferenceElement;
import org.modeldriven.fuml.xmi.XmiInternalReferenceElement;
import org.modeldriven.fuml.xmi.XmiNode;
import org.modeldriven.fuml.xmi.XmiNodeVisitor;
import org.modeldriven.fuml.xmi.XmiNodeVisitorStatus;
import org.modeldriven.fuml.xmi.XmiReference;
import org.modeldriven.fuml.xmi.XmiReferenceAttribute;
import org.modeldriven.fuml.xmi.stream.StreamNode;

import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Classifier;

import org.modeldriven.fuml.meta.Property;

/**
 * A visitor pattern implementation class that walks a given XmiNode hierarchy checking for
 * various error conditions, creating and gathering ValidationError instances into a collection
 * helpful for user feedback. This class can be initialized with an initial list of errors gathered
 * from another context, and errors may be added to it's collection ad-hoc. This class heavily
 * leverages the fuml.model package. For more information on runtime metadata, see the fuml.model
 * package documentation.
 *
 * @author Scott Cinnamond
 */
public class ValidationErrorCollector extends AbstractXmiNodeVisitor
    implements XmiNodeVisitor
{
    private static Log log = LogFactory.getLog(ValidationErrorCollector.class);
	private List<ValidationError> errors = new ArrayList<ValidationError>();
	private boolean validateExternalReferences = true;

	@SuppressWarnings("unused")
	private ValidationErrorCollector() {
	}

	public ValidationErrorCollector(XmiNode root) {
		this.root = root;
		modelSupport = new ModelSupport();
	}

	/**
	 * Traverses the entire given graph ala. the visitor pattern, gathering any validation
	 * errors, other than reference errors. References are added to
	 * a collection to be validated subsequently, outside of the
	 * visitor.
	 */
	public void validate()
	{
		this.root.accept(this);
		this.validateReferences();
	}

	public void visit(XmiNode target, XmiNode source, String sourceKey,
	        XmiNodeVisitorStatus status, int level)
	{
        if (log.isDebugEnabled())
            if (source != null)
                log.debug("visit: " + target.getLocalName()
                    + " \t\tsource: " + source.getLocalName());
            else
                log.debug("visit: " + target.getLocalName());

        StreamNode eventNode = (StreamNode)target;

        if (target.getXmiId() != null)
        {
            if (this.nodeMap.get(target.getXmiId()) == null)
        	    this.nodeMap.put(target.getXmiId(), target);
            else
                addError(ErrorCode.DUPLICATE_REFERENCE,
                        ErrorSeverity.FATAL, eventNode);
        }

		Classifier classifier = findClassifier(target, source);
		if (classifier == null)
		{
			// See if this element or it's immediate parent has an import adapter
			// which means adapted elements can currently have only 2 levels otherwise
			// the results are undefined. Bad. 
            ImportAdapter importAdapter = FumlConfiguration.getInstance().findImportAdapter(
            		target.getLocalName());
            if (importAdapter == null)
            	importAdapter = FumlConfiguration.getInstance().findImportAdapter(
                		target.getXmiType()); 
            if (importAdapter == null)
            	importAdapter = FumlConfiguration.getInstance().findImportAdapter(
                		source.getLocalName()); 
            if (importAdapter == null)
            	importAdapter = FumlConfiguration.getInstance().findImportAdapter(
                		source.getXmiType()); 
            
            // if exists, assume the adapter will transform the 
            // undefined element and any descendants
            if (importAdapter == null)
                addError(ErrorCode.UNDEFINED_CLASS, ErrorSeverity.FATAL, eventNode);
            
		    return; // We're done w/this node. No way to examine further without a classifier.
		}

    	if (log.isDebugEnabled())
    		log.debug("identified element '" + target.getLocalName() + "' as classifier, "
    			+ classifier.name);
    	classifierMap.put(target, classifier);

        boolean hasAttributes = eventNode.hasAttributes();
    	if (isPrimitiveTypeElement(eventNode, classifier, hasAttributes))
    		return;

    	if (isInternalReferenceElement(eventNode, classifier, hasAttributes))
    	{
    		references.add(new XmiInternalReferenceElement(eventNode));
        	return;
    	}

        if (isExternalReferenceElement(eventNode, classifier, hasAttributes))
        {
            references.add(new XmiExternalReferenceElement(eventNode));
            return;
        }
        
    	if (isAbstract(classifier))
    	{
            addError(ErrorCode.ABSTRACT_CLASS_INSTANTIATION,
                    ErrorSeverity.FATAL, eventNode);
        	return;
    	}

    	if (eventNode.hasAttributes())
    	    validateAttributes(eventNode, source, classifier, eventNode.getAttributes());

    	validateAttributesAgainstModel(eventNode, source, classifier);
	}

	private void validateAttributes(StreamNode target, XmiNode source,
	        Classifier classifier,
			Iterator<Attribute> attributes)
	{
        // look at XML attributes
        while (attributes.hasNext())
        {
            Attribute xmlAttrib = attributes.next();

            QName name = xmlAttrib.getName();
            String prefix = name.getPrefix();
            if (prefix != null && prefix.length() > 0)
                continue; // not applicable to current element/association-end.
            if ("href".equals(name.getLocalPart()))
                continue; // FIXME: why is this "special" ?
            Property property = MetaModel.getInstance().findAttribute((Class_) classifier,
                    name.getLocalPart());
            if (property == null)
            {
                addError(ErrorCode.UNDEFINED_PROPERTY,
                        ErrorSeverity.FATAL, target, name.getLocalPart());
                continue;
            }

            if (property.typedElement.type == null)
            {
                int foo = 0;
                foo++;
            }
            if (isReferenceAttribute(property))
            {
    		    XmiReferenceAttribute reference = new XmiReferenceAttribute(target,
        				xmlAttrib);
        		this.references.add(reference);
            }
            // TODO: when this error is commented out, an erroneous 'invalid internal reference' validation
            // error was seen to be thrown during assembly. This seems to be a bug
        	if (MetaModel.getInstance().isDerived((Class_) classifier, property))
                if (checkDerivedPropertyInstantiationError(target, source, classifier, property)) {
                    addError(ErrorCode.DERIVED_PROPERTY_INSTANTIATION,
                            ErrorSeverity.FATAL, target, property.name);
                }

        }
	}

	private boolean checkDerivedPropertyInstantiationError(StreamNode target, XmiNode source,
	        Classifier classifier, Property property)
	{
		boolean error = false;

    	String value = target.getAttributeValue(property.name);
        if (value != null && value.trim().length() > 0)
        {
        	error = true;
        }
        else if (target.findChildByName(property.name) != null)
        	error = true;

		return error;
	}

	private void validateAttributesAgainstModel(StreamNode target, XmiNode source,
	        Classifier classifier)
	{
        Property[] properties = MetaModel.getInstance().getAttributes((Class_) classifier);
        for (int i = 0; i < properties.length; i++)
        {
        	if (MetaModel.getInstance().isRequired((Class_) classifier, properties[i]))
	            if (checkRequiredPropertyError(target, source, classifier, properties[i])) {
	                addError(ErrorCode.PROPERTY_REQUIRED,
	                        ErrorSeverity.FATAL, target, properties[i].name);
	            }
        	// other checks??
        }
	}

	private boolean checkRequiredPropertyError(StreamNode target, XmiNode source,
	        Classifier classifier, Property property)
	{
		boolean error = true;

    	if (MetaModel.getInstance().isDerived((Class_) classifier, property))
    	{
    		error = false;
    		return error;
    	}

    	String value = target.getAttributeValue(property.name);
        if (value != null && value.trim().length() > 0)
        {
        	error = false;
        }
        else // or we have a default
        {
            String defaultValue = MetaModel.getInstance().findAttributeDefault(property);
            if (defaultValue != null)
            	error = false;
        }

        if (target.findChildByName(property.name) != null)
        	error = false;

        // check configured mappings
        if (error && FumlConfiguration.getInstance().hasReferenceMapping(
                classifier, property))
        {
            ReferenceMappingType mappingType =
                FumlConfiguration.getInstance().getReferenceMappingType(
                        classifier, property);
            if (mappingType == ReferenceMappingType.PARENT)
            {
                // All right if the value of this reference property can be derived
                // from it's "parent", does the parent have an XMI id to
                // supply the value??
                if (source.getXmiId() != null && source.getXmiId().length() > 0)
                	error = false;
                else
                    log.warn("no parent XMI id found for, "
                        + classifier.name + "." + property.name);
            }
            else
                log.warn("unrecognized mapping type, "
                        + mappingType.value() + " ignoring mapping for, "
                        + classifier.name + "." + property.name);
        }

        return error;

	}

	private void validateReferences()
	{
        // validate references post traversal
        Iterator<XmiReference> iter =  references.iterator();
        while (iter.hasNext())
        {
            XmiReference reference = iter.next();
            Iterator<String> refIter = reference.getXmiIds();
            while (refIter.hasNext())
            {
                String id = refIter.next();

                if (reference instanceof XmiExternalReferenceElement)
                {
                    if (validateExternalReferences)
                    {
                        if (Library.getInstance().lookup(id) != null)
                            continue; // happy
                        else if (id != null && id.startsWith("pathmap:")) // FIXME: resolve these references inside/outside of lib(s)
                            continue;
                    }
                    else
                        continue;

                    errors.add(new ValidationError(reference, id,
                            ErrorCode.INVALID_EXTERNAL_REFERENCE, ErrorSeverity.FATAL));
                }
                else // internal reference
                {
                    if (nodeMap.get(id) != null)
                        continue; // it's an internal reference relative to this validation frame

                    if (Environment.getInstance().findElementById(id) != null)
                        continue; // it's an already loaded internal reference

                    errors.add(new ValidationError(reference, id,
                            ErrorCode.INVALID_REFERENCE, ErrorSeverity.FATAL));
                }

            }
        }
	}

	private void addError(ErrorCode code, ErrorSeverity severity, StreamNode eventNode)
	{
        if (log.isDebugEnabled())
            log.debug("adding " + code.toString()
                + " error for element '" + eventNode.getLocalName() + "'");
        errors.add(new ValidationError(eventNode, code, severity));
	}

    private void addError(ErrorCode code, ErrorSeverity severity,
            StreamNode eventNode, String name)
    {
        if (log.isDebugEnabled())
            log.debug("adding " + code.toString()
                + " error for element '" + eventNode.getLocalName() + "'");
        errors.add(new ValidationError(eventNode, name, code, severity));
    }

	public List<ValidationError> getErrors() {
		return errors;
	}

    public int getErrorCount() {
        return errors.size();
    }

    public List<ValidationError> getErrors(ErrorCode code) {
        List<ValidationError> results = new ArrayList<ValidationError>();
        Iterator<ValidationError> iter = errors.iterator();
        while (iter.hasNext())
        {
            ValidationError error = iter.next();
            if (error.getCode().ordinal() == code.ordinal())
                results.add(error);
        }
        return results;
    }

    public int getErrorCount(ErrorCode code) {
        return getErrors(code).size();
    }

    public List<ValidationError> getErrors(ErrorCategory category) {
        List<ValidationError> results = new ArrayList<ValidationError>();
        Iterator<ValidationError> iter = errors.iterator();
        while (iter.hasNext())
        {
            ValidationError error = iter.next();
            if (error.getCategory().ordinal() == category.ordinal())
                results.add(error);
        }
        return results;
    }

    public int getErrorCount(ErrorCategory category) {
        return getErrors(category).size();
    }

    public List<ValidationError> getErrors(ErrorSeverity severity) {
        List<ValidationError> results = new ArrayList<ValidationError>();
        Iterator<ValidationError> iter = errors.iterator();
        while (iter.hasNext())
        {
            ValidationError error = iter.next();
            if (error.getSeverity().ordinal() == severity.ordinal())
                results.add(error);
        }
        return results;
    }

    public int getErrorCount(ErrorSeverity severity) {
        return getErrors(severity).size();
    }

    public boolean isValidateExternalReferences() {
        return validateExternalReferences;
    }

    public void setValidateExternalReferences(boolean validateExternalReferences) {
        this.validateExternalReferences = validateExternalReferences;
    }


}
