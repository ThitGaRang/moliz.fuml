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
package org.modeldriven.fuml.assembly;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.events.Attribute;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.common.lang.JavaKeyWords;
import org.modeldriven.fuml.config.FumlConfiguration;
import org.modeldriven.fuml.config.ImportAdapter;
import org.modeldriven.fuml.config.ImportAdapterType;
import org.modeldriven.fuml.config.ReferenceMappingType;
import org.modeldriven.fuml.environment.Environment;
import org.modeldriven.fuml.library.Library;
import org.modeldriven.fuml.model.Model;
import org.modeldriven.fuml.model.uml2.UmlClass;
import org.modeldriven.fuml.model.uml2.UmlClassifier;
import org.modeldriven.fuml.model.uml2.UmlDataType;
import org.modeldriven.fuml.model.uml2.UmlEnumeration;
import org.modeldriven.fuml.model.uml2.UmlPrimitiveType;
import org.modeldriven.fuml.model.uml2.UmlProperty;
import org.modeldriven.fuml.xmi.ModelSupport;
import org.modeldriven.fuml.xmi.XmiExternalReferenceElement;
import org.modeldriven.fuml.xmi.XmiIdentity;
import org.modeldriven.fuml.xmi.XmiMappedReference;
import org.modeldriven.fuml.xmi.XmiNode;
import org.modeldriven.fuml.xmi.XmiReference;
import org.modeldriven.fuml.xmi.XmiReferenceAttribute;
import org.modeldriven.fuml.xmi.stream.StreamNode;
import org.modeldriven.fuml.xmi.validation.ErrorCode;
import org.modeldriven.fuml.xmi.validation.ErrorSeverity;
import org.modeldriven.fuml.xmi.validation.ValidationError;
import org.modeldriven.fuml.xmi.validation.ValidationException;

import UMLPrimitiveTypes.UnlimitedNatural;

import fUML.Library.LibraryClassImplementation.ImplementationObject;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Comment;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.PrimitiveType;

public class ElementAssembler extends AssemblerNode
    implements XmiIdentity, Assembler {

    private static Log log = LogFactory.getLog(ElementAssembler.class);
    private Model metadata = Model.getInstance();
    private List<XmiReference> references;
    private Map<String, ElementAssembler> assemblerMap;
    private ModelSupport modelSupport;
    private boolean assembleExternalReferences = true;

    private ElementAssembler parentAssembler; // FIXME: re-factor ASAP!!

    /** XMI source */
    private XmiNode source;
    private XmiNode parent;
    private Attribute xmiId;

    /** UML meta-class */
    private UmlClassifier prototype;

    /** fUML class target(s) */
    private Element target;
    private Comment targetComment;

    @SuppressWarnings("unused")
    private ElementAssembler() {
        // nope
    }

    public ElementAssembler(XmiNode source, XmiNode parent, UmlClassifier prototype,
    		Map<String, ElementAssembler> assemblerMap)
    {
        super(source);
        this.source = source;
        this.parent = parent;
        this.prototype = prototype;
        this.assemblerMap = assemblerMap;
		modelSupport = new ModelSupport();
        StreamNode eventNode = (StreamNode)this.source;

        QName idName = new QName(eventNode.getContext().getXmiNamespace().getNamespaceURI(), "id");
        xmiId = eventNode.getAttribute(idName);
    }

    public ElementAssembler getParentAssembler() {
		return parentAssembler;
	}

	public void setParentAssembler(ElementAssembler parentAssembler) {
		this.parentAssembler = parentAssembler;
	}

	@SuppressWarnings("unchecked")
    public void assembleElementClass()
    {
    	try {
	        String packageName = metadata.getPackageForClass(this.prototype.getName());
            String instancecClassName = this.prototype.getName();
            if ("Class".equals(instancecClassName))
                instancecClassName = instancecClassName + "_"; // We have a keyword map, but unclear whether upper-case 'Class' should be mapped. Definately 'class' is.
	        String qualifiedName = packageName + "." + instancecClassName;

            Object object = null;
	        ImportAdapter importAdapter = FumlConfiguration.getInstance().findImportAdapter(
	                instancecClassName);
	        if (importAdapter == null ||
	                importAdapter.getType().ordinal() != ImportAdapterType.ASSEMBLY.ordinal())
	        {
	            object = this.instanceForName(qualifiedName);
	        }
	        else
	        {
	            AssemblyAdapter adapter = (AssemblyAdapter)this.instanceForName(
	                    importAdapter.getAdapterClassName());
	            object = adapter.assemble((StreamNode)this.source);
	        }

	        if (object instanceof Element)
	        {
	            if (object instanceof PrimitiveType)
	            {
	                QName name = new QName("href");
	                StreamNode eventNode = (StreamNode)source;
	                Attribute href = eventNode.getStartElementEvent().asStartElement().getAttributeByName(name);
	                if (href == null)
	                    throw new AssemblyException("expected 'href' attribute for primitive type");
	                // FIXME; gotta be a better way! URI resolver??
	                if (href.getValue().endsWith("Integer"))
	                    this.target = Environment.getInstance().primitiveTypes.Integer;
	                else if (href.getValue().endsWith("String"))
	                    this.target = Environment.getInstance().primitiveTypes.String;
	                else if (href.getValue().endsWith("Boolean"))
	                    this.target = Environment.getInstance().primitiveTypes.Boolean;
	                else if (href.getValue().endsWith("UnlimitedNatural"))
	                    this.target = Environment.getInstance().primitiveTypes.UnlimitedNatural;
	                else
	                    throw new AssemblyException("unknown type");
	            }
	            else
	            {
	                this.target = (Element)object;
	                if (log.isDebugEnabled())
	                    log.debug("constructing class " + this.target.getClass().getName());
	            }
	        }
	        else if (object instanceof Comment)
	        {
	            this.targetComment = (Comment)object;
	            log.warn("instantiated comment (?)");
	        }
	        else
	            throw new AssemblyException("unknown instance, "
	                    + object.getClass().getName());
        }
        catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (NoSuchMethodException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (InvocationTargetException e) {
            log.error(e.getCause().getMessage(), e.getCause());
            throw new AssemblyException(e.getCause());
        }
        catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (InstantiationException e) {
        	if (e.getCause() != null)
        		log.error(e.getCause().getMessage(), e.getCause());
        	else
                log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
    }

	// TODO: move this to library.Library setting up the locus
	// as elements are registered. Current;y can't do this as opposite
	// properties are not being set. I.e. a packagedElement does not
	// know it's package (parent). We are relying on the assembler
	// hierarchy to do this (below), which is unnecessary/hacky. The metadata will
	// need to be enhanced to find opposite properties using associations.
	// This is rather easy, but not in 1 day probably.
    @SuppressWarnings("unchecked")
    public void registerElement()
    {
        try {
            if (!(this.target instanceof Class_))
                return;

            Class_ c = (Class_)this.target;

            String packageName = "";

            ElementAssembler assembler = this;
            for (int i = 0; (assembler = assembler.getParentAssembler()) != null; i++)
            {
            	if (assembler.getTarget() instanceof fUML.Syntax.Classes.Kernel.Package)
            	{
            		String name = ((fUML.Syntax.Classes.Kernel.Package)assembler.getTarget()).name;
                	if (i > 0)
                		packageName = name + "." + packageName;
                	else
                		packageName = name;
            	}
            	else
            		break;
            }

            String libraryObjectClassName = packageName + "." + c.name;

            String implObjectClassName = FumlConfiguration.getInstance().findExecutionClassName(libraryObjectClassName);
            if (implObjectClassName == null)
                return; // not mapped - we're not interested

            UmlClassifier implClassifier = metadata.findClassifier(implObjectClassName);
            if (implClassifier == null)
            {
                throw new AssemblyException("no classifier found for mapped class '"
                        + implObjectClassName + "'");
                // FIXME: get rid of or validate the config on startup so this can't happen
                //return;
            }
            if (metadata.isAbstract(implClassifier))
            {
                log.warn("abstract classifier found for mapped class '"
                        + implObjectClassName + "' - ignoring");
                return;
            }
            log.info("mapped " + c.name + " to " + implClassifier.getName());
            String implObjectPackageName = metadata.findPackageForClass(implObjectClassName);
            String qualifiedName = implObjectPackageName + "." + implObjectClassName;
            Object object = this.instanceForName(qualifiedName);

            if (object instanceof ImplementationObject)
            {
                ImplementationObject execution = (ImplementationObject)object;
                execution.types.add(c);
                log.info("adding to locus: " + execution.getClass().getName());
                Environment.getInstance().locus.add(execution);
            }
            else if (object instanceof OpaqueBehaviorExecution)
            {
                OpaqueBehaviorExecution execution = (OpaqueBehaviorExecution)object;
                execution.types.add(c);
                Environment.getInstance().locus.factory.addPrimitiveBehaviorPrototype(execution);
            }
            else
                log.warn("unknown instance, "
                    + object.getClass().getName());
        }
        catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (NoSuchMethodException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (InvocationTargetException e) {
            log.error(e.getCause().getMessage(), e.getCause());
            throw new AssemblyException(e.getCause());
        }
        catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (InstantiationException e) {
            if (e.getCause() != null)
                log.error(e.getCause().getMessage(), e.getCause());
            else
                log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
    }

    // TODO: find the "opposite" property using metadata and value
    // that as well. Metadata will need to be enhanced to use associations.
    public void associateElement(ElementAssembler other)
    {
        try {
            UmlProperty property = metadata.findAttribute((UmlClass)other.getPrototype(),
                    this.getSource().getLocalName());
            if (property == null)
                return; // we validate this elsewhere

            if (!metadata.isSingular((UmlClass)other.getPrototype(), property))
            {
                if (log.isDebugEnabled())
                    log.debug("linking collection property: "
                        + other.getPrototype().getName() + "." + this.getSource().getLocalName()
                        + " with: " + this.getPrototype().getName());
                try {
                    String methodName = "add" + this.getSource().getLocalName().substring(0,1).toUpperCase() +
                        this.getSource().getLocalName().substring(1);
                    Method adder = getMethod(
                        other.getTargetClass(),
                        methodName,
                        this.getTargetClass());
                    Object[] args = { this.getTargetObject() };
                    adder.invoke(other.getTarget(), args);
                }
                catch (NoSuchMethodException e) {
                    // try to get and add to the list field if exists
                    try {
                        Field field = other.getTargetClass().getField(this.getSource().getLocalName());
                        Object list = field.get(other.getTargetObject());
                        Method adder = getMethod(list.getClass(), "add",
                            this.getTargetClass());
                        Object[] args = { this.getTargetObject() };
                        adder.invoke(list, args);
                    }
                    catch (NoSuchFieldException e2) {
                        log.warn("no 'add' or 'List.add' method found for property, "
                            + other.getPrototype().getName() + "." + this.getSource().getLocalName());
                    }
                }
            }
            else {
                if (log.isDebugEnabled())
                    log.debug("linking singular property: "
                        + other.getPrototype().getName() + "." + this.getSource().getLocalName()
                        + " with: " + this.getPrototype().getName());
                try {
                    String methodName = "set" + this.getSource().getLocalName().substring(0,1).toUpperCase() +
                        this.getSource().getLocalName().substring(1);
                    Method setter = getMethod(
                        other.getTargetClass(),
                        methodName,
                        this.getTargetClass());
                    Object[] args = { this.getTargetObject() };
                    setter.invoke(other.getTarget(), args);
                }
                catch (NoSuchMethodException e) {
                    // try to get and add to the list field if exists
                    try {
                        Field field = other.getTargetClass().getField(this.getSource().getLocalName());
                        field.set(other.getTargetObject(), this.getTargetObject());
                    }
                    catch (NoSuchFieldException e2) {
                        log.warn("no 'set' method or public field found for property, "
                            + other.getPrototype().getName() + "." + this.getSource().getLocalName());
                    }
                }
            }
        }
        catch (NoSuchMethodException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (InvocationTargetException e) {
            log.error(e.getCause().getMessage(), e.getCause());
            throw new AssemblyException(e.getCause());
        }
        catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
    }

    public void assemleFeatures()
    {
        try {
            StreamNode eventNode = (StreamNode)source;

            Location loc = eventNode.getLocation();
            if (log.isDebugEnabled())
                log.debug("element line/column: "
                	+ loc.getLineNumber() + ":" + loc.getColumnNumber());

            // look at XML attributes
            Iterator<Attribute> attributes = eventNode.getAttributes();
            while (attributes != null && attributes.hasNext())
            {
                Attribute xmlAttrib = attributes.next();

                QName name = xmlAttrib.getName();
                String prefix = name.getPrefix();
                if (prefix != null && prefix.length() > 0)
                    continue; // not applicable to current element/association-end.
                if ("href".equals(name.getLocalPart()))
                    continue; // FIXME: find/write URI resolver

                UmlProperty property = metadata.findAttribute((UmlClass)this.prototype,
                        name.getLocalPart());
                if (property == null)
                    throw new ValidationException(new ValidationError(eventNode, name.getLocalPart(),
                            ErrorCode.UNDEFINED_PROPERTY, ErrorSeverity.FATAL));
                UmlClassifier type = metadata.getType(property);

                if (this.modelSupport.isReferenceAttribute(property))
                {
        		    XmiReferenceAttribute reference = new XmiReferenceAttribute(source,
            				xmlAttrib);
            		this.addReference(reference);
            		continue;
                }

                String value = xmlAttrib.getValue();
                if (value == null || value.length() == 0) // FIXME - ya this never happens
                {
                    String defaultValue = metadata.findAttributeDefault(property);
                    if (defaultValue != null)
                    {
                        value = defaultValue;
                        if (log.isDebugEnabled())
                            log.debug("using default '" + String.valueOf(value)
                                    + "' for enumeration feature <" + type.getName() + "> "
                                    + this.getPrototype().getName() + "." + property.getName());
                    }
                }

                this.assembleNonReferenceFeature(property, value, type);
            }

            // look at model properties
            UmlProperty[] properties = metadata.getAttributes((UmlClass)this.prototype);
            for (int i = 0; i < properties.length; i++)
            {
                QName name = new QName(properties[i].getName());
                String value = eventNode.getAttributeValue(name);
                if (value != null && value.trim().length() > 0)
                    continue; // handled above

                String defaultValue = metadata.findAttributeDefault(properties[i]);
                if (defaultValue != null)
                {
                    UmlClassifier type = metadata.getType(properties[i]);
                    if (log.isDebugEnabled())
                        log.debug("using default: '" + String.valueOf(defaultValue)
                                + "' for enumeration feature <" + type.getName() + "> "
                                + this.getPrototype().getName() + "." + properties[i].getName());
                    this.assembleNonReferenceFeature(properties[i], defaultValue, type);
                    continue;
                }

                if (!metadata.isRequired((UmlClass)this.prototype, properties[i]))
                    continue; // don't bother digging further for a value

                if (eventNode.findChildByName(properties[i].getName()) != null)
                    continue; // it has such a child, let

                if (this.modelSupport.isReferenceAttribute(properties[i]) &&
                    FumlConfiguration.getInstance().hasReferenceMapping(this.prototype, properties[i]))
                {
                    ReferenceMappingType mappingType =
                        FumlConfiguration.getInstance().getReferenceMappingType(
                                this.prototype, properties[i]);
                    if (mappingType == ReferenceMappingType.PARENT)
                    {
                        if (parent != null && parent.getXmiId() != null && parent.getXmiId().length() > 0)
                        {
                            XmiMappedReference reference = new XmiMappedReference(source,
                                    properties[i].getName(),
                                    new String[] { parent.getXmiId() });
                            this.addReference(reference);
                            continue;
                        }
                        else
                            log.warn("no parent XMI id found, ignoring mapping for, "
                                + this.prototype.getName() + "." + properties[i].getName());
                    }
                    else
                        log.warn("unrecognized mapping type, "
                            + mappingType.value() + " ignoring mapping for, "
                            + this.prototype.getName() + "." + properties[i].getName());
                }

                if (!metadata.isDerived((UmlClass)this.prototype, properties[i]))
                {
	                if (log.isDebugEnabled())
	                    log.debug("throwing " + ErrorCode.PROPERTY_REQUIRED.toString()
	                        + " error for " + this.prototype.getName() + "." + properties[i].getName());
	                throw new ValidationException(new ValidationError(eventNode,
	                        properties[i].getName(),
	                        ErrorCode.PROPERTY_REQUIRED, ErrorSeverity.FATAL));
                }
            }
        }
        catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (NoSuchMethodException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (InvocationTargetException e) {
            log.error(e.getCause().getMessage(), e.getCause());
            throw new AssemblyException(e.getCause());
        }
        catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (InstantiationException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (NoSuchFieldException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
    }

    public void assembleReferenceFeatures()
    {
        try {
        	StreamNode eventNode = (StreamNode)source;
        	if (references == null)
        		return;
        	Iterator<XmiReference> iter = references.iterator();
        	while (iter.hasNext())
        	{
        		XmiReference reference = iter.next();
                this.assembleReferenceFeature(reference);
        	}
        }
        catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (NoSuchMethodException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (InvocationTargetException e) {
            log.error(e.getCause().getMessage(), e.getCause());
            throw new AssemblyException(e.getCause());
        }
        catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (InstantiationException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
        catch (NoSuchFieldException e) {
            log.error(e.getMessage(), e);
            throw new AssemblyException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private void assembleNonReferenceFeature(UmlProperty property,
            String stringValue, UmlClassifier type)
        throws ClassNotFoundException, NoSuchMethodException,
        InvocationTargetException, IllegalAccessException, InstantiationException,
        NoSuchFieldException
    {
        if (type instanceof UmlEnumeration)
        {
            if (log.isDebugEnabled())
                log.debug("assembling enum feature <" + type.getName() + "> "
                    + this.getPrototype().getName() + "." + property.getName());
            Object value = toEnumerationValue(stringValue, type);
            assembleEnumerationFeature(property, value, type);
        }
        else if (type instanceof UmlDataType)
        {
            Class javaType = toJavaClass((UmlDataType)type);
            Object value = toPrimitiveValue(stringValue, javaType);

            if (log.isDebugEnabled())
                log.debug("assembling primitive feature <" + javaType.getName() + "> "
                    + this.getPrototype().getName() + "." + property.getName());

            if (metadata.isSingular((UmlClass)this.getPrototype(), property))
                assembleSingularPrimitiveFeature(property, value, javaType);
            else
                assembleCollectionPrimitiveFeature(property, value, javaType);
        }
        else if (type instanceof UmlClass)
        {
            if (UnlimitedNatural.class.getSimpleName().equals(type.getName()))
            {
                UnlimitedNatural value = new UnlimitedNatural();
                if ("*".equals(stringValue))
                    value.naturalValue = -1;
                else
                    try {
                        value.naturalValue = Integer.parseInt(stringValue);
                    }
                    catch (NumberFormatException e) {
                        log.error("could not parse string value '" + stringValue + "'", e);
                    }
                    if (log.isDebugEnabled())
                        log.debug("assembling primitive feature <" + UnlimitedNatural.class.getSimpleName() + "> "
                            + this.getPrototype().getName() + "." + property.getName());
                if (metadata.isSingular((UmlClass)this.getPrototype(), property))
                    assembleSingularPrimitiveFeature(property, value, UnlimitedNatural.class);
                else
                    assembleCollectionPrimitiveFeature(property, value, UnlimitedNatural.class);
            }
            else
                throw new AssemblyException("unexpected UmlClass, "
                    + type.getName());
        }
        else
            throw new AssemblyException("unexpected instance, "
                    + type.getClass().getName());
    }

    @SuppressWarnings("unchecked")
    private void assembleReferenceFeature(XmiReference reference)
        throws ClassNotFoundException, NoSuchMethodException,
        InvocationTargetException, IllegalAccessException, InstantiationException,
        NoSuchFieldException
    {
    	StreamNode eventNode = (StreamNode)this.getSource();

        UmlProperty property = metadata.getAttribute((UmlClass)this.getPrototype(),
        		reference.getLocalName());
        UmlClassifier type = metadata.getType(property);

        if (type instanceof UmlEnumeration || type instanceof UmlDataType)
            return; //handled these in pre-assembly

        String packageName = metadata.getPackageForClass(type.getName());
        String qualifiedName = packageName + "." + type.getName();
        Class fumlClass = Class.forName(qualifiedName);
        if (!Element.class.isAssignableFrom(fumlClass))
        {
            log.warn("ignoring non-element feature <" + type.getName() + "> "
                    + this.getPrototype().getName() + "." + property.getName());
            return;
        }

        if (metadata.isSingular((UmlClass)this.getPrototype(), property))
        {
            if (log.isDebugEnabled())
                log.debug("assembling singular reference feature <" + type.getName() + "> "
                        + this.getPrototype().getName() + "." + property.getName());

            if (reference.getReferenceCount() != 1)
            	log.warn("expected single reference, not "
            			+ String.valueOf(reference.getReferenceCount()));

            String id = reference.getXmiIds().next(); // expect only one for singular prop

            if (reference instanceof XmiExternalReferenceElement)
            {
                 if (assembleExternalReferences)
                 {
                     if (id == null || !id.startsWith("pathmap:")) // FIXME: resolve these references inside/outside of lib(s)
                     {
                         Element referent = Library.getInstance().lookup(id);
                         if (referent == null)
                                 throw new ValidationException(new ValidationError(reference, id,
                                     ErrorCode.INVALID_EXTERNAL_REFERENCE,
                                     ErrorSeverity.FATAL));

                         this.assembleSingularReferenceFeature(referent, property,
                             type);
                     }
                 }
            }
            else
            {
                Element target = null;

                ElementAssembler referencedAssembler = this.assemblerMap.get(id);
                if (referencedAssembler != null)
                    target = referencedAssembler.getTarget();
                else
                    target = Environment.getInstance().findElementById(id);

                if (target != null)
                    this.assembleSingularReferenceFeature(target, property,
                            type);
                else
                 	throw new ValidationException(new ValidationError(reference, id,
                    	ErrorCode.INVALID_REFERENCE,
                    	ErrorSeverity.FATAL));
            }
        }
        else
        {
            if (log.isDebugEnabled())
                log.debug("assembling collection reference feature <" + type.getName() + "> "
                        + this.getPrototype().getName() + "." + property.getName());

            Iterator<String> iter = reference.getXmiIds();
            while (iter.hasNext())
            {
            	String id = iter.next();
                if (reference instanceof XmiExternalReferenceElement)
                {
                    if (assembleExternalReferences)
                    {
                        if (id == null || !id.startsWith("pathmap:")) // FIXME: resolve these references inside/outside of lib(s)
                        {
                            Element referent = Library.getInstance().lookup(id);
                            if (referent == null)
                            {
                                ValidationError error = new ValidationError(reference, id,
                                         ErrorCode.INVALID_EXTERNAL_REFERENCE,
                                         ErrorSeverity.FATAL);
                                throw new ValidationException(error);
                            }
                            this.assembleCollectionReferenceFeature(
                                     referent, property,
                                     type);
                        }
                    }
                }
                else
                {
                    ElementAssembler referencedAssembler = this.assemblerMap.get(id);
                    if (referencedAssembler == null)
                    	throw new ValidationException(new ValidationError(reference, id,
                    			ErrorCode.INVALID_REFERENCE,
                        		ErrorSeverity.FATAL));
                    this.assembleCollectionReferenceFeature(
                            referencedAssembler.getTarget(),
                            property, type);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void assembleEnumerationFeature(
            UmlProperty property, Object value, UmlClassifier type)
        throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException
    {
        try {
            Class[] types = { value.getClass() };
            String methodName = "set" + property.getName().substring(0,1).toUpperCase() +
                property.getName().substring(1);
            Method setter = this.getTarget().getClass().getMethod(methodName, types);
            Object[] args = { value };
            setter.invoke(this.getTarget(), args);
        }
        catch (NoSuchMethodException e) {
            try {
                Field field = this.getTargetClass().getField(property.getName());
                field.set(this.getTargetObject(), value);
            }
            catch (NoSuchFieldException e2) {
                String msg = "no fUML (" + this.getTargetObject().getClass().getName()
                    + ") setter method or public field found for enumeration feature "
                    + "<" + type.getName() + "> "
                    + this.getPrototype().getName() + "." + property.getName();
                log.warn(msg);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void assembleSingularPrimitiveFeature(
            UmlProperty property, Object value, Class javaType)
        throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException,
            NoSuchFieldException
    {
        String methodName = "set" + property.getName().substring(0,1).toUpperCase() +
            property.getName().substring(1);
        Object[] args = { value };
        try {
            Method setter = this.getTargetClass().getMethod(methodName,
                    new Class[] { javaType });
            setter.invoke(this.getTargetObject(), args);
        }
        catch (NoSuchMethodException e) {
            try {
                Object targetObject = this.getTargetObject();
                Class targetClass = targetObject.getClass();
                Field field = targetClass.getField(property.getName());
                field.set(targetObject, value);
            }
            catch (NoSuchFieldException e2) {
                String msg = "no fUML (" + this.getTargetObject().getClass().getName()
                    + ") setter method or public field found for primitive feature "
                    + "<" + javaType.getName() + "> "
                    + this.getPrototype().getName() + "." + property.getName();
                log.warn(msg);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void assembleCollectionPrimitiveFeature(
            UmlProperty property, Object value, Class javaType)
        throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException,
            NoSuchFieldException
    {
        String methodName = "add" + property.getName().substring(0,1).toUpperCase() +
            property.getName().substring(1);
        try {
            Object[] args = { value };
            Method adder = this.getTargetClass().getMethod(methodName,
                    new Class[] { javaType });
            adder.invoke(this.getTargetObject(), args);
        }
        catch (NoSuchMethodException e) {
            try {
                Field field = this.getTargetClass().getField(property.getName());
                Object list = field.get(this.getTargetObject());
                Method adder = findMethod(list.getClass(), "add",
                        value.getClass());
                Object[] args = { value };
                adder.invoke(list, args);
            }
            catch (NoSuchMethodException e2) {
                String msg = "no fUML (" + this.getTargetObject().getClass().getName()
                    + ") add method or public field found for primitive collection property "
                    + "<" + javaType.getName() + "> "
                    + this.getPrototype().getName() + "." + property.getName();
                log.warn(msg);
            }
            catch (NoSuchFieldException e2) {
                String msg = "no fUML (" + this.getTargetObject().getClass().getName()
                    + ") add method or public field found for primitive collection property "
                    + "<" + javaType.getName() + "> "
                    + this.getPrototype().getName() + "." + property.getName();
                log.warn(msg);
            }
        }
    }

    private void assembleSingularReferenceFeature(Element target,
            UmlProperty property, UmlClassifier type)
        throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException
    {
        try {
            String methodName = "set" + property.getName().substring(0,1).toUpperCase() +
            property.getName().substring(1);
            Method setter = getMethod(
            		this.getTarget().getClass(),
                methodName,
                target.getClass());
            Object[] args = { target };
            setter.invoke(this.getTarget(), args);
        }
        catch (NoSuchMethodException e) {
            try {
                Field field = this.getTargetClass().getField(property.getName());
                field.set(this.getTargetObject(), target);
            }
            catch (NoSuchFieldException e2) {
                String msg = "no fUML (" + this.getTargetObject().getClass().getName()
                    + ") setter method or public field found for singular property "
                    + "<" + type.getName() + "> "
                    + this.getPrototype().getName() + "." + property.getName();
                log.warn(msg);
            }
        }
    }

    private void assembleCollectionReferenceFeature(Element target,
            UmlProperty property, UmlClassifier type)
        throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException,
            NoSuchFieldException
    {
        try {
            String methodName = "add" + property.getName().substring(0,1).toUpperCase() +
                property.getName().substring(1);
            Method adder = getMethod(
            		this.getTargetObject().getClass(),
                    methodName,
                    target.getClass());
            Object[] args = { target };
            adder.invoke(this.getTarget(), args);
        }
        catch (NoSuchMethodException e) {
            try {
                Field field = this.getTargetClass().getField(property.getName());
                Object list = field.get(this.getTargetObject());
                Method adder = findMethod(list.getClass(), "add",
                        target.getClass());
                Object[] args = { target };
                adder.invoke(list, args);
            }
            catch (NoSuchMethodException e2) {
                String msg = "no fUML (" + this.getTargetObject().getClass().getName()
                    + ") add method or public field found for collection property "
                    + "<" + type.getName() + "> "
                    + this.getPrototype().getName() + "." + property.getName();
                log.warn(msg);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private Class toJavaClass(UmlDataType dataType)
    {
    	if (UmlPrimitiveType.class.isAssignableFrom(dataType.getClass()))
    	{
    		if (dataType.getName() != null)
    		{
		        if (String.class.getSimpleName().equals(dataType.getName()))
		            return java.lang.String.class;
		        else if (Integer.class.getSimpleName().equals(dataType.getName()))
		            return int.class;
		        else if (Boolean.class.getSimpleName().equals(dataType.getName()))
		            return boolean.class;
		        else
		            throw new AssemblyException("unknown dataType, " + dataType.getClass().getName());
    		}
    		else if (dataType.getHref() != null)
    		{
		        if (dataType.getHref().endsWith(String.class.getSimpleName()))
		            return java.lang.String.class;
		        else if (dataType.getHref().endsWith(Integer.class.getSimpleName()))
		            return int.class;
		        else if (dataType.getHref().endsWith(Boolean.class.getSimpleName()))
		            return boolean.class;
		        else
		            throw new AssemblyException("unknown dataType, " + dataType.getClass().getName());
    		}
    		else
			   throw new AssemblyException("expected name or href for primitive type, "
					   + dataType.getClass().getName());
    	}
    	else {
	        if (String.class.getSimpleName().equalsIgnoreCase(dataType.getName()))
	            return java.lang.String.class;
	        else if (Integer.class.getSimpleName().equalsIgnoreCase(dataType.getName()))
	            return java.lang.Integer.class;
	        else if (Boolean.class.getSimpleName().equalsIgnoreCase(dataType.getName()))
	            return java.lang.Boolean.class;
	        else
	            throw new AssemblyException("unknown dataType, " + dataType.getName());
    	}
    }

    @SuppressWarnings("unchecked")
    private Object toPrimitiveValue(String value, Class javaType)
    {
        if (javaType.equals(java.lang.String.class))
            return value;
        else if (javaType.equals(java.lang.Integer.class))
            try {
                return Integer.valueOf(value);
            }
            catch (NumberFormatException e) {
                if (value == null || value.length() == 0)
                    return new Integer(0);
                else
                    throw e;
            }
        else if (javaType.equals(int.class))
            try {
                return Integer.valueOf(value).intValue();
            }
            catch (NumberFormatException e) {
                if (value == null || value.length() == 0)
                    return 0;
                else
                    throw e;
            }
        else if (javaType.equals(java.lang.Boolean.class))
            return Boolean.valueOf(value);
        else if (javaType.equals(boolean.class))
            return (boolean)Boolean.valueOf(value).booleanValue();
        else
            return value;
    }

    private Object toEnumerationValue(String value, UmlClassifier type)
        throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException
    {
        String pkg = metadata.getPackageForClass(type.getName());
        String qualifiedName = pkg + "." + type.getName();
        Class enumClass = Class.forName(qualifiedName);
        if (!enumClass.isEnum())
            throw new AssemblyException("expected class as enum, "
                    + enumClass.getName());

        Method valueOf = enumClass.getMethod("valueOf", new Class[] { String.class });

        if (JavaKeyWords.getInstance().isKeyWord(value))
            value = value + "_";
        Object enumValue = valueOf.invoke(enumClass, value);
        return enumValue;
    }

    @SuppressWarnings("unchecked")
    private Method findMethod(Class target, String name, Class arg)
        throws NoSuchMethodException
    {
        return findMethod(target.getMethods(), name, arg);
    }

    @SuppressWarnings("unchecked")
    private Method getMethod(Class target, String name, Class arg)
        throws NoSuchMethodException
    {
        Method method = findMethod(target.getMethods(), name, arg);
        if (method == null)
            throw new NoSuchMethodException(target.getName() + "." + name);
        return method;
    }

    @SuppressWarnings("unchecked")
    private Method findMethod(Method[] methods, String name, Class arg)
    {
        for (int i = 0; i < methods.length; i++)
        {
            if (!methods[i].getName().equals(name))
                continue;
            Class[] types = methods[i].getParameterTypes();
            if (types != null && types.length == 1)
            {
                if (types[0].isAssignableFrom(arg))
                    return methods[i];
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private Object instanceForName(String qualifiedName)
        throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException
    {
        Class targetClass = Class.forName(qualifiedName);
        Class[] types = new Class[0];
        Object[] args = new Object[0];
        int mods = targetClass.getModifiers();
        if (Modifier.isAbstract(mods))
        	throw new AssemblyException("attempt to instantiate abstract class, " +
        			qualifiedName);
        if (!Modifier.isPublic(mods))
        	throw new AssemblyException("attempt to instantiate non-public class, " +
        			qualifiedName);

        Constructor defaultConstructor = targetClass.getConstructor(types);
        Object object = defaultConstructor.newInstance(args);
        return object;
    }

    public String getXmiId()
    {
        if (xmiId != null)
            return xmiId.getValue();
        else
            return null;
    }

    public Element getTarget() {
        return target;
    }

    public Object getTargetObject() {
        if (target != null)
            return target;
        else
            return targetComment;
    }

    public Class getTargetClass() {
        if (target != null)
            return target.getClass();
        else
            return targetComment.getClass();
    }

    public Comment getTargetComment() {
        return targetComment;
    }

    public UmlClassifier getPrototype() {
        return prototype;
    }

    public XmiNode getSource() {
        return source;
    }

    public XmiNode getParent() {
        return parent;
    }

    public void addReference(XmiReference ref) {
        if (references == null)
        	references = new ArrayList<XmiReference>();
        references.add(ref);
    }

    public boolean isAssembleExternalReferences() {
        return assembleExternalReferences;
    }

    public void setAssembleExternalReferences(boolean assembleExternalReferences) {
        this.assembleExternalReferences = assembleExternalReferences;
    }

}
