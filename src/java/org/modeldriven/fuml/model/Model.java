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
package org.modeldriven.fuml.model;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.xmi.BindingXmiReader;
import org.modeldriven.fuml.xmi.InvalidReferenceException;
import org.modeldriven.fuml.bind.DefaultValidationEventHandler;
import org.modeldriven.fuml.model.xmi.XmiBindingObject;
import org.modeldriven.fuml.xmi.XmiException;
import org.modeldriven.fuml.xmi.XmiValidationEventHandler;
import org.modeldriven.fuml.xmi.XmiBindingNode;
import org.modeldriven.fuml.xmi.XmiBindingNodeVisitor;
import org.modeldriven.fuml.model.ModelDataBinding;
import org.modeldriven.fuml.model.config.Artifact;
import org.modeldriven.fuml.model.config.IgnoredClass;
import org.modeldriven.fuml.model.config.ModelConfig;
import org.modeldriven.fuml.model.config.IgnoredPackage;
import org.modeldriven.fuml.model.uml2.UmlAssociationEndElement;
import org.modeldriven.fuml.model.uml2.UmlClass;
import org.modeldriven.fuml.model.uml2.UmlClassifier;
import org.modeldriven.fuml.model.uml2.UmlEnumeration;
import org.modeldriven.fuml.model.uml2.UmlGeneralization;
import org.modeldriven.fuml.model.uml2.UmlInstanceValue;
import org.modeldriven.fuml.model.uml2.UmlLiteralBoolean;
import org.modeldriven.fuml.model.uml2.UmlLiteralInteger;
import org.modeldriven.fuml.model.uml2.UmlLiteralNull;
import org.modeldriven.fuml.model.uml2.UmlLiteralString;
import org.modeldriven.fuml.model.uml2.UmlLiteralUnlimitedNatural;
import org.modeldriven.fuml.model.uml2.UmlModel;
import org.modeldriven.fuml.model.uml2.UmlOpaqueExpression;
import org.modeldriven.fuml.model.uml2.UmlOperation;
import org.modeldriven.fuml.model.uml2.UmlPackage;
import org.modeldriven.fuml.model.uml2.UmlPrimitiveType;
import org.modeldriven.fuml.model.uml2.UmlProperty;
import org.modeldriven.fuml.model.uml2.UmlTypeAssociationEnd;
import org.modeldriven.fuml.model.uml2.UmlValueSpecification;
import org.modeldriven.fuml.model.uml2.UmlValueSpecificationAssociationEnd;
import org.xml.sax.SAXException;

public class Model {

    private static Log log = LogFactory.getLog(Model.class);
    private static Model instance = null;
    private static String configFileName = "ModelConfig.xml";    
    
    private ModelConfig config;
    
    
    private UmlPackage fuml;
    private Map<String, UmlClassifier> classifierNameToClassifierMap = new HashMap<String, UmlClassifier>(); 
    private Map<String, UmlClassifier> qualifiedClassifierNameToClassifierMap = new HashMap<String, UmlClassifier>(); 
    private Map<String, String> classifierNameToPackageNameMap = new HashMap<String, String>(); 
    private Map<String, String> qualifiedClassifierNameToPackageNameMap = new HashMap<String, String>(); 
    private Map<String, XmiBindingNode> xmiIdToXmiObjectMap = new HashMap<String, XmiBindingNode>(); 
    private Map<String, Map<String, UmlProperty>> classNameToAttributeMap = new HashMap<String, Map<String, UmlProperty>>(); 
    private Map<String, Map<String, UmlOperation>> classNameToOperationMap = new HashMap<String, Map<String, UmlOperation>>(); 
    private Map<String, IgnoredPackage> ignoredPackageNameMap = new HashMap<String, IgnoredPackage>(); 
    private Map<String, IgnoredClass> ignoredClassNameMap = new HashMap<String, IgnoredClass>(); 
    
    private Model()
    {
        log.info("initializing...");
        try {
	        ModelConfigDataBinding configBinding = new ModelConfigDataBinding(
	        		new DefaultValidationEventHandler());
	        config = unmarshalConfig(configFileName, configBinding);

	        Iterator<IgnoredPackage> packages = config.getIgnoredPackage().iterator();
	        while (packages.hasNext())
	        {
	        	IgnoredPackage pkg = packages.next();
	        	ignoredPackageNameMap.put(pkg.getName(), pkg);
	        } 	        

            Iterator<IgnoredClass> classes = config.getIgnoredClass().iterator();
            while (classes.hasNext())
            {
                IgnoredClass c = classes.next();
                ignoredClassNameMap.put(c.getName(), c);
            }           
	        
	        ModelDataBinding modelBinding = new ModelDataBinding(
	                new XmiValidationEventHandler(false));
	        Iterator<Artifact> artifacts = config.getArtifact().iterator();
	        while (artifacts.hasNext())
	        {
	        	Artifact artifact = artifacts.next();
	            loadModel(artifact.getName(), modelBinding);
	        } 
        }
        catch (SAXException e) {
            throw new ModelException(e);
        }
        catch (JAXBException e) {
            throw new ModelException(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    private ModelConfig unmarshalConfig(String configFileName, ModelConfigDataBinding binding)
    {
    	try {
	        InputStream stream = Model.class.getResourceAsStream(configFileName);
	        if (stream == null)
	            throw new ModelException("cannot find resource '" + configFileName + "'");
	        JAXBElement root = (JAXBElement)binding.validate(stream);
	        
	        ModelConfig result = (ModelConfig)root.getValue();
            return result;
    	}
        catch (UnmarshalException e) {
            throw new ModelException(e);
        }
        catch (JAXBException e) {
            throw new ModelException(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void loadModel(String modelFileName, ModelDataBinding binding)
    {
        log.info("loading, " + modelFileName);
        InputStream stream = Model.class.getResourceAsStream(modelFileName);
        if (stream == null)
            throw new ModelException("cannot find resource '" + modelFileName + "'");
        BindingXmiReader reader = new BindingXmiReader(binding);
        reader.setExpandInput(false);
        Collection<UmlPackage> result = reader.read(stream);
        Iterator<UmlPackage> iter = result.iterator();
        fuml = iter.next();
        if (iter.hasNext())
            throw new ModelException("expected single model");
        this.fuml.acceptBreadthFirst(new ModelVisitor());
        this.construct();	
    }

    public static Model getInstance()
        throws ModelException
    {
        if (instance == null)
            initializeInstance();
        return instance;
    }
    
    private static synchronized void initializeInstance()
        throws ModelException
    {
        if (instance == null)
            instance = new Model();
    } 
    
    private void mergeClass(UmlClass target, UmlClass source) {
        
        Iterator<UmlProperty> sourceIter =  source.getOwnedAttribute().iterator();
        while (sourceIter.hasNext())
        {    
            UmlProperty sourceProp = sourceIter.next();
            
            boolean found = false;
            Iterator<UmlProperty> targetIter =  target.getOwnedAttribute().iterator();
            while (targetIter.hasNext())
            {    
                UmlProperty targetProp = targetIter.next();
                if (!targetProp.getName().equals(sourceProp.getName()))
                    continue;
                found = true;
                mergeProperty(targetProp, sourceProp); 
                break;
            }
            if (!found)
                target.getOwnedAttribute().add(sourceProp);
        }
    }    
    
    private void mergeProperty(UmlProperty target, UmlProperty source) 
    {
        // merge defaults
        UmlValueSpecification sourceValueSpec = findDefaultValueSpecification(source);
        if (sourceValueSpec != null)
        {    
            UmlValueSpecification targetValueSpec = findDefaultValueSpecification(target);
            if (targetValueSpec == null)
                target.getDefaultValue().addAll(source.getDefaultValue());
            else
                mergeValueSpecification(targetValueSpec, sourceValueSpec);
        }    
    }
    
    private void mergeValueSpecification(UmlValueSpecification target, UmlValueSpecification source)
    {
        // NOTE; this is scary. 
        if (!target.getClass().equals(source.getClass())) 
            if (log.isDebugEnabled()) 
                log.warn("merging unequal value specification classes, " 
                        + source.getClass().getSimpleName() + " to " 
                        + target.getClass().getSimpleName());
        String value = getValue(source);
        if (value != null && value.trim().length() > 0)
            setValue(target, value);
    }
    
    public UmlClassifier getClassifier(String name)
    {
        return getClassifier(name, false);
    }

    public UmlClassifier findClassifier(String name)
    {
        return getClassifier(name, true);
    }
    
    private UmlClassifier getClassifier(String name, boolean supressErrors)
    {
    	UmlClassifier result = null;
    	if (name.indexOf(".") == -1)
	    	result = this.classifierNameToClassifierMap.get(name);
    	else
    		result = this.qualifiedClassifierNameToClassifierMap.get(name);
    	
        if (result == null && !supressErrors)
            throw new ModelException("no classifier found for name, '" 
                    + name + "'");
        return result;
    }
    
    public String getPackageForClass(String className)
    {
        return getPackageForClass(className, false);
    }

    public String findPackageForClass(String name)
    {
        return getPackageForClass(name, true);
    }
    
    private String getPackageForClass(String name, boolean supressErrors)
    {   
    	String result = null;
    	if (name.indexOf(".") == -1)
            result = this.classifierNameToPackageNameMap.get(name);
    	else
            result = this.qualifiedClassifierNameToPackageNameMap.get(name);
    	
        if (result == null && !supressErrors)
            throw new XmiException("no package found for class, " + name);
        return result;
    } 

    public boolean isIgnoredClassifier(String classifierName)
    {
        return this.ignoredClassNameMap.get(classifierName) != null;          
    }
    
    public boolean isIgnoredClassifier(UmlClassifier classifier)
    {
    	String packageName = getPackageForClass(classifier.getName());
    	if (isIgnoredPackage(packageName))
    	    return true;
    	else 
    	    return this.ignoredClassNameMap.get(classifier.getName()) != null;    	    
    }
    
    public boolean isIgnoredPackage(String packageName)
    {
        return this.ignoredPackageNameMap.get(packageName) != null;
    }

    public UmlProperty getAttribute(UmlClass umlClass, String name)
    {
        return getAttribute(umlClass, name, false);
    }
 
    public UmlProperty findAttribute(UmlClass umlClass, String name)
    {
        return getAttribute(umlClass, name, true);
    }
    
    private UmlProperty getAttribute(UmlClass umlClass, String name, boolean supressErrors)
    {
        UmlProperty result = null;
        Map<String, UmlProperty> map = this.classNameToAttributeMap.get(
                umlClass.getName());
        if (map != null)
            result = map.get(name);
            
        if (result == null && !supressErrors)    
            throw new XmiException("no attribute found for, " 
                    + umlClass.getName() + "." + name);
        return result;
    }

    public UmlProperty[] getAttributes(UmlClass umlClass)
    {
        UmlProperty[] result = new UmlProperty[0];
        Map<String, UmlProperty> map = this.classNameToAttributeMap.get(
                umlClass.getName());
        if (map != null)
        {    
            result = new UmlProperty[map.size()];
            Iterator<String> keys = map.keySet().iterator(); 
            for (int i = 0; keys.hasNext(); i++)
                result[i] = map.get(keys.next());   
        }    
        return result;
    }
    
    public String getAttributeDefault(UmlProperty property)
    {
        return getAttributeDefaultValue(property, false);
    }

    public String findAttributeDefault(UmlProperty property)
    {
        return getAttributeDefaultValue(property, true);
    }
        
    public boolean hasAttributeDefaultValue(UmlProperty property)
    {
        String value = getAttributeDefaultValue(property, true);
        return value != null && value.trim().length() > 0;
    }    
    
    private String getAttributeDefaultValue(UmlProperty property, boolean supressErrors)
    {
        UmlValueSpecification valueSpec = findDefaultValueSpecification(property);
        if (valueSpec != null)
            return getValue(valueSpec);
        else
            return null;
    }    

    private String getValue(UmlValueSpecification valueSpec)
    {
        if (UmlLiteralString.class.isAssignableFrom(valueSpec.getClass()) ||
            UmlLiteralInteger.class.isAssignableFrom(valueSpec.getClass()) ||
            UmlLiteralBoolean.class.isAssignableFrom(valueSpec.getClass()) ||
            UmlLiteralNull.class.isAssignableFrom(valueSpec.getClass()) ||
            UmlLiteralUnlimitedNatural.class.isAssignableFrom(valueSpec.getClass()))
        {
            return valueSpec.getValue();
        }
        else if (UmlInstanceValue.class.isAssignableFrom(valueSpec.getClass()))
        {
            return valueSpec.getName();
        }
        else
        {
            return ((UmlOpaqueExpression)valueSpec).getBody();
        }
    }
    
    private void setValue(UmlValueSpecification valueSpec, String value)
    {
        if (UmlLiteralString.class.isAssignableFrom(valueSpec.getClass()) ||
            UmlLiteralInteger.class.isAssignableFrom(valueSpec.getClass()) ||
            UmlLiteralBoolean.class.isAssignableFrom(valueSpec.getClass()) ||
            UmlLiteralNull.class.isAssignableFrom(valueSpec.getClass()) ||
            UmlLiteralUnlimitedNatural.class.isAssignableFrom(valueSpec.getClass()))
        {
            valueSpec.setValue(value);
        }
        else if (UmlInstanceValue.class.isAssignableFrom(valueSpec.getClass()))
        {
            valueSpec.setName(value);
        }
        else
        {
            ((UmlOpaqueExpression)valueSpec).setBody(value);
        }
    }        
    
    private UmlValueSpecification findDefaultValueSpecification(UmlProperty property)
    {
        List<UmlValueSpecificationAssociationEnd> list = property.getDefaultValue();
        if (list != null && list.size() > 0)
        {
            UmlValueSpecificationAssociationEnd assocEnd = list.get(0); // defined as zero-to-1
            
            UmlValueSpecification result = (UmlValueSpecification)
                assocEnd.getLiteralUnlimitedNaturalOrLiteralIntegerOrLiteralString();
            if (result == null)
                throw new ModelException("expected literal value specification");
            return result;
        }
        return null;
    }    
    
    public UmlOperation getOperation(UmlClass umlClass, String name)
    {
        return getOperation(umlClass, name, false);
    }
 
    public UmlOperation findOperation(UmlClass umlClass, String name)
    {
        return getOperation(umlClass, name, true);
    }
    
    private UmlOperation getOperation(UmlClass umlClass, String name, boolean supressErrors)
    {
        UmlOperation result = null;
        Map<String, UmlOperation> map = this.classNameToOperationMap.get(
                umlClass.getName());
        if (map != null)
            result = map.get(name);
            
        if (result == null && !supressErrors)    
            throw new XmiException("no operation found for, " 
                    + umlClass.getName() + "." + name);
        return result;
    }

    public UmlOperation[] getOperations(UmlClass umlClass)
    {
        UmlOperation[] result = new UmlOperation[0];
        Map<String, UmlOperation> map = this.classNameToOperationMap.get(
                umlClass.getName());
        if (map != null)
        {    
            result = new UmlOperation[map.size()];
            Iterator<String> keys = map.keySet().iterator(); 
            for (int i = 0; keys.hasNext(); i++)
                result[i] = map.get(keys.next());   
        }    
        return result;
    }
    
    public UmlClassifier getType(UmlProperty property)
    {
        return getType(property, false);
    }

    public UmlClassifier findType(UmlProperty property)
    {
        return getType(property, true);
    }
    
    private UmlClassifier getType(UmlProperty property, boolean supressErrors)
    {
        UmlClassifier result = null;
        String typeXmiId = property.getStructuralFeatureTypeAttribute(); // type reference 
        if (typeXmiId != null)
        {
            result = (UmlClassifier)this.xmiIdToXmiObjectMap.get(typeXmiId); 
            if (result == null && !supressErrors)
                throw new InvalidReferenceException(typeXmiId);
        }
        else
        {
            List<UmlTypeAssociationEnd> typeList = property.getType();
            if (typeList != null && typeList.size() == 1)
            {
                UmlTypeAssociationEnd end = typeList.get(0);
                result = end.getPrimitiveTypeOrClazz();
            } //else covered below
        }
        if (result == null && !supressErrors)
            throw new ModelException("no type found for property, " 
                    + property.getName());
        return result;
    }
    
    public boolean isRequired(UmlClass cls, UmlProperty property) {
         return getLowerValue(cls, property) > 0;   
    }

    public boolean isSingular(UmlClass cls, UmlProperty property) {
        return "1".equals(getUpperValue(cls, property));   
    }

    public boolean isAbstract(UmlClassifier cls) {
        return "true".equals(cls.getIsAbstract());   
    }
    
    private String getUpperValue(UmlClass cls, UmlProperty property)
    {                
        List<UmlValueSpecificationAssociationEnd> list = property.getUpperValue();
        if (list == null || list.size() == 0) {
            // Literal* classes don't have upper/lower value metadata!
            // FIXME: pre-process and cache this crap
            if (cls.getName().startsWith("Literal") && "value".equals(property.getName()))
                return "1";
            else
            {    
            	if (log.isDebugEnabled())
                    log.debug("expected upper value association end for property, "
                        + cls.getName() + "." + property.getName() 
                        + ", assuming upper value '1'");
                return "1";
            }
        }
        else if (list.size() > 1)
            throw new ModelException("expected single upper value association end for property, "
                    + cls.getName() + "." + property.getName());
        UmlValueSpecificationAssociationEnd upperAssoc = list.get(0);
        UmlLiteralUnlimitedNatural literalUpper = (UmlLiteralUnlimitedNatural)upperAssoc.getLiteralUnlimitedNaturalOrLiteralIntegerOrLiteralString();
        if (literalUpper == null)
            throw new ModelException("expected literal unlimited natural as lower value for property, "
                    + cls.getName() + "." + property.getName());
        return literalUpper.getValue().trim();        
    }
    
    private int getLowerValue(UmlClass cls, UmlProperty property)
    {
        List<UmlValueSpecificationAssociationEnd> list = property.getLowerValue();
        if (list == null || list.size() == 0) {
            // Literal* classes don't have upper/lower value metadata!
            // FIXME: pre-process and cache this crap
        	// FIXME: UML spec defines the 'value' ownedAttribute as 1-to-1 for these!!!
            if (cls.getName().startsWith("Literal") && "value".equals(property.getName()))
            { 
                if (cls.getName().equals("LiteralUnlimitedNatural") || 
                    cls.getName().equals("LiteralInteger") || 
                    cls.getName().equals("LiteralBoolean"))
                    return 1;
                else
                    return 0;
            }    
            else
            {    
            	if (log.isDebugEnabled())
                    log.debug("expected upper lower association end for property, "
                        + cls.getName() + "." + property.getName() 
                        + ", assuming upper value 0");
                return 0;
            }
        }
        else if (list.size() > 1)
            throw new ModelException("expected single lower value association end for property, "
                    + cls.getName() + "." + property.getName());
        UmlValueSpecificationAssociationEnd lowerAssoc = list.get(0);
        UmlLiteralInteger literalLower = 
            (UmlLiteralInteger)lowerAssoc.getLiteralUnlimitedNaturalOrLiteralIntegerOrLiteralString();
        if (literalLower == null)
            throw new ModelException("expected literal integer as lower value for property, "
                    + cls.getName() + "." + property.getName());
        String value = literalLower.getValue();
        if (value == null)
            value = "0";
        return Integer.valueOf(value);
    }
    
    private void construct()
    {
        Iterator<String> classes = classifierNameToClassifierMap.keySet().iterator();
        while (classes.hasNext())
        {
            String className = classes.next();
            UmlClassifier umlClassifier = classifierNameToClassifierMap.get(className);
            Map<String, UmlProperty> attributes =  new HashMap<String, UmlProperty>();
            if (umlClassifier instanceof UmlClass)
                collectAttributes((UmlClass)umlClassifier, attributes);
            classNameToAttributeMap.put(className, attributes);

            Map<String, UmlOperation> operations =  new HashMap<String, UmlOperation>();
            if (umlClassifier instanceof UmlClass)
                collectOperations((UmlClass)umlClassifier, operations);
            classNameToOperationMap.put(className, operations);

        }
    }
    
    private void collectAttributes(UmlClass umlClass, Map<String, UmlProperty> attributes)
    {
        Iterator<UmlProperty> iter =  umlClass.getOwnedAttribute().iterator();
        while (iter.hasNext())
        {    
            UmlProperty attrib = iter.next();
            attributes.put(attrib.getName(), attrib);
        }
        
        Iterator<UmlGeneralization> generalizations = umlClass.getGeneralization().iterator();
        while (generalizations.hasNext())
        {
            UmlGeneralization generalization = generalizations.next();
            String superclassXmiId = generalization.getGeneral();
            XmiBindingNode obj = xmiIdToXmiObjectMap.get(superclassXmiId);
            if (obj == null)
            {    
                throw new InvalidReferenceException(superclassXmiId);
                //log.warn("invalid reference: " + superclassXmiId);
                //continue;
            }    
            UmlClass umlSuperClass = (UmlClass)obj;
            collectAttributes(umlSuperClass, attributes);
        }
    }
 
    private void collectOperations(UmlClass umlClass, Map<String, UmlOperation> operations)
    {
        Iterator<UmlOperation> iter =  umlClass.getOwnedOperation().iterator();
        while (iter.hasNext())
        {    
            UmlOperation oper = iter.next();
            operations.put(oper.getName(), oper);
        }
        
        Iterator<UmlGeneralization> generalizations = umlClass.getGeneralization().iterator();
        while (generalizations.hasNext())
        {
            UmlGeneralization generalization = generalizations.next();
            String superclassXmiId = generalization.getGeneral();
            XmiBindingNode obj = xmiIdToXmiObjectMap.get(superclassXmiId);
            if (obj == null)
            {    
                throw new InvalidReferenceException(superclassXmiId);
                //log.warn("invalid reference: " + superclassXmiId);
                //continue;
            }    
            UmlClass umlSuperClass = (UmlClass)obj;
            collectOperations(umlSuperClass, operations);
        }
    }
    
    private class ModelVisitor implements XmiBindingNodeVisitor
    {
        private Stack<UmlPackage> packages = new Stack<UmlPackage>();
        private String currentPackageName;
        
        public void begin(XmiBindingNode target, XmiBindingNode source, 
                    String sourceKey, int level)
        {
            if (!(target instanceof XmiBindingObject))
            {
                //if (log.isDebugEnabled())
                //    log.debug("ignoring instance, " + target.getClass().getName());
                return;
            }
            
            XmiBindingObject element = (XmiBindingObject)target;
            String xmiId = element.getId();
            if (xmiId == null || xmiId.length() == 0)
            {
                if (source instanceof UmlAssociationEndElement)
                {
                    UmlAssociationEndElement assocEnd = (UmlAssociationEndElement)source;
                    xmiId = assocEnd.getId();
                }
            }
            if (xmiId != null)
                xmiIdToXmiObjectMap.put(xmiId, element);

            if (target instanceof UmlClass)
            {    
                UmlClass c = (UmlClass)target;
                if (log.isDebugEnabled())
                    log.debug("mapping class, " + currentPackageName + "." + c.getName());
                
                UmlClassifier existing = classifierNameToClassifierMap.get(c.getName());
                if (existing != null && existing instanceof UmlClass)
                    mergeClass(c, (UmlClass)existing);
                
                classifierNameToClassifierMap.put(c.getName(), c);
                qualifiedClassifierNameToClassifierMap.put(currentPackageName + "." + c.getName(), c);
                classifierNameToPackageNameMap.put(c.getName(), currentPackageName);
                qualifiedClassifierNameToPackageNameMap.put(currentPackageName + "." + c.getName(), currentPackageName);
            }    
            else if (target instanceof UmlPrimitiveType)
            {    
            	UmlPrimitiveType c = (UmlPrimitiveType)target;
                if (log.isDebugEnabled())
                    log.debug("mapping type, " + currentPackageName + "." 
                            + c.getClass().getSimpleName());
                classifierNameToClassifierMap.put(c.getName(), c);
                qualifiedClassifierNameToClassifierMap.put(currentPackageName + "." + c.getName(), c);
                classifierNameToPackageNameMap.put(c.getName(), currentPackageName);
                qualifiedClassifierNameToPackageNameMap.put(currentPackageName + "." + c.getName(), currentPackageName);
            }    
            else if (target instanceof UmlEnumeration)
            {    
                UmlEnumeration e = (UmlEnumeration)target;
                if (log.isDebugEnabled())
                    log.debug("mapping enumeration, " + currentPackageName + "." + e.getName());
                classifierNameToClassifierMap.put(e.getName(), e);
                qualifiedClassifierNameToClassifierMap.put(currentPackageName + "." + e.getName(), e);
                classifierNameToPackageNameMap.put(e.getName(), currentPackageName);
                qualifiedClassifierNameToPackageNameMap.put(currentPackageName + "." + e.getName(), currentPackageName);
            }    
            else if (target instanceof UmlPackage)
            {    
                UmlPackage pkg = (UmlPackage)target;
                if (log.isDebugEnabled())
                    log.debug("begin package, " + pkg.getName());
                packages.push(pkg);
                currentPackageName = currentQualifiedPackageName();
            }
        }
        public void end(XmiBindingNode target, XmiBindingNode source, 
                String sourceKey, int level)
        {
            if (target instanceof UmlPackage)
            {    
                UmlPackage pkg = (UmlPackage)target;
                if (log.isDebugEnabled())
                    log.debug("end package, " + pkg.getName());
                packages.pop();
            }
        }  
        
        private String currentQualifiedPackageName()
        {
            StringBuffer result = new StringBuffer();
            Iterator<UmlPackage> iter = this.packages.iterator();
            while(iter.hasNext())
            {
                UmlPackage pkg = iter.next();
                if (result.length() > 0)
                    result.append(".");
                result.append(pkg.getName());
            }
            return result.toString();
        }
        
    }
    
}
