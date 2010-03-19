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
package org.modeldriven.fuml.meta;

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
import org.modeldriven.fuml.FumlObject;
import org.modeldriven.fuml.bind.DefaultValidationEventHandler;
import org.modeldriven.fuml.common.reflect.ReflectionUtils;
import org.modeldriven.fuml.meta.config.Artifact;
import org.modeldriven.fuml.meta.config.IgnoredClass;
import org.modeldriven.fuml.meta.config.IgnoredPackage;
import org.modeldriven.fuml.meta.config.ModelConfig;
import org.modeldriven.fuml.meta.config.RegisteredPackage;
import org.modeldriven.fuml.meta.merge.PackageGraphNode;
import org.modeldriven.fuml.meta.merge.PackageGraphVisitor;
import org.modeldriven.fuml.xmi.InvalidReferenceException;
import org.modeldriven.fuml.xmi.XmiException;
import org.xml.sax.SAXException;

import UMLPrimitiveTypes.UnlimitedNatural;

import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Classifier;
import fUML.Syntax.Classes.Kernel.EnumerationLiteral;
import fUML.Syntax.Classes.Kernel.Generalization;
import fUML.Syntax.Classes.Kernel.InstanceValue;
import fUML.Syntax.Classes.Kernel.LiteralBoolean;
import fUML.Syntax.Classes.Kernel.LiteralInteger;
import fUML.Syntax.Classes.Kernel.LiteralNull;
import fUML.Syntax.Classes.Kernel.LiteralString;
import fUML.Syntax.Classes.Kernel.LiteralUnlimitedNatural;
import fUML.Syntax.Classes.Kernel.NamedElement;
import fUML.Syntax.Classes.Kernel.Operation;
import fUML.Syntax.Classes.Kernel.Package;
import fUML.Syntax.Classes.Kernel.PackageableElement;
import fUML.Syntax.Classes.Kernel.ValueSpecification;

import org.modeldriven.fuml.meta.Property;

public class MetaModel extends MetaModelMapping {

    private static Log log = LogFactory.getLog(MetaModel.class);
    private static MetaModel instance = null;
    private static String configFileName = "ModelConfig.xml";

    private ModelConfig config;

    private Map<String, IgnoredPackage> ignoredPackageNameMap = new HashMap<String, IgnoredPackage>();
    private Map<String, IgnoredClass> ignoredClassNameMap = new HashMap<String, IgnoredClass>();

    private Map<String, NamedElement> elements = new HashMap<String, NamedElement>();

    private MetaModel() {
         
        log.info("initializing...");
        try {
            MetaModelConfigDataBinding configBinding = new MetaModelConfigDataBinding(
                    new DefaultValidationEventHandler());
            config = unmarshalConfig(configFileName, configBinding);

        } catch (SAXException e) {
            throw new MetaModelException(e);
        } catch (JAXBException e) {
            throw new MetaModelException(e);
        }

        Iterator<IgnoredPackage> packages = config.getIgnoredPackage().iterator();
        while (packages.hasNext()) {
            IgnoredPackage pkg = packages.next();
            ignoredPackageNameMap.put(pkg.getName(), pkg);
        }

        Iterator<IgnoredClass> classes = config.getIgnoredClass().iterator();
        while (classes.hasNext()) {
            IgnoredClass c = classes.next();
            ignoredClassNameMap.put(c.getName(), c);
        }

        this.bootstrap();
        this.construct();

    }

    private void bootstrap() {

    	Map<Artifact, MetaModelAssembler> factoryMap = new HashMap<Artifact, MetaModelAssembler>();
        Iterator<Artifact> artifacts = config.getArtifact().iterator();
        while (artifacts.hasNext()) {
        	Artifact artifact = artifacts.next();
            Mapping mapping = (Mapping)this;
            Object[] args = { this };
            Class[] types = { Mapping.class };
            try {
            	MetaModelAssembler factory = (MetaModelAssembler)ReflectionUtils.instanceForName(
                		artifact.getFactoryClassName(), 
                        args, types);
                factoryMap.put(artifact, factory);
            }
            catch (Exception e) {
            	throw new MetaModelException(e);
            }
        }
    	
        merge();
        
        artifacts = config.getArtifact().iterator();
        while (artifacts.hasNext()) {
        	Artifact artifact = artifacts.next();
        	MetaModelAssembler factory = factoryMap.get(artifact); 
            Iterator<RegisteredPackage> packages = artifact.getRegisteredPackage().iterator();
            while (packages.hasNext()) {
            	RegisteredPackage pkg = packages.next();
            	registerPackage((org.modeldriven.fuml.meta.MetaDataDocument)factory, pkg.getName());
            }           
        }    
    }

    private void merge() {
        List<PackageGraphNode> roots = findMergeRoots();

        Iterator<PackageGraphNode> rootIter = roots.iterator();
        while (rootIter.hasNext())
        {
        	PackageGraphNode root = rootIter.next();
        	Package rootPackage = (Package)this.get(root.getId());
        	if (log.isDebugEnabled())
        	    log.debug("merging package root:  " + rootPackage.getHref());
        	PackageGraphVisitor visitor = new PackageGraphVisitor() {

				public void visit(PackageGraphNode target, PackageGraphNode source) {
					if (source != null) // it's not a root
					{	
				        if (log.isDebugEnabled())
				            log.debug("visit: " + target.getPackage().qualifiedName + "<-" + source.getPackage().qualifiedName);
					    mergePackage(source.getPackage(), target.getPackage());
					}
				}       		
        	};
        	root.accept(visitor);
        }    	
    }
    
    private Package getPackage(org.modeldriven.fuml.meta.MetaDataDocument aftifact, String qualifiedName) {
    	
        List<Package> artifactPackages = artifactToPackagesMap.get(aftifact.getURI());
   	    Iterator<Package> iter = artifactPackages.iterator();	
    	while (iter.hasNext())
    	{   			
    		Package p = iter.next();
    		if (qualifiedName.equals(p.qualifiedName))
    			return p;
    	}
    	throw new MetaModelException("could not get package, "
    			+ qualifiedName);
    }
    
    private void registerPackage(org.modeldriven.fuml.meta.MetaDataDocument aftifact, String qualifiedName) {
    	Package p = getPackage(aftifact, qualifiedName);
    	registerPackage(p);
    }
   
    private void registerPackage(Package p)
    {
		Iterator<PackageableElement> elementIter = p.packagedElement.iterator();
		while (elementIter.hasNext()) {
    		PackageableElement element = elementIter.next();
    		if (element instanceof Classifier)
    		{
    			Classifier c = (Classifier)element;
    			classifierNameToClassifierMap.put(c.name, c);
    			classifierNameToPackageNameMap.put(c.name, p.qualifiedName);
    		}
    		else if (element instanceof Package)
    			registerPackage((Package)element);
		}
    }    
    
    private List<PackageGraphNode> findMergeRoots()
    {
    	Map<String, PackageGraphNode> sources = new HashMap<String, PackageGraphNode>();
    	Iterator<String> merges = packageIdToPackageMergeMap.keySet().iterator();	
    	while (merges.hasNext())
    	{   			
    		PackageGraphNode target = packageIdToPackageMergeMap.get(merges.next());
    		Package targetPackage = (Package)this.get(target.getId());
    		target.setPackage(targetPackage); // HACKY but we must build the merge graph during mapping, and all package targets don't yet exist
    		if (target.getNodes() == null)
    			continue;
    		Iterator<PackageGraphNode> iter = target.getNodes().iterator();
    		while (iter.hasNext())
    		{	
    			PackageGraphNode source = iter.next();
        		Package sourcePackage = (Package)this.get(source.getId());
        		source.setPackage(sourcePackage);
    			sources.put(source.getId(), source);
    		}    		
    	}
    	
    	List<PackageGraphNode> roots = new ArrayList<PackageGraphNode>();
    	merges = packageIdToPackageMergeMap.keySet().iterator();	
    	while (merges.hasNext())
    	{   			
    		PackageGraphNode target = packageIdToPackageMergeMap.get(merges.next());
    		if (sources.get(target.getId()) != null) // some source points to it, not a root
    			continue;    		
    		roots.add(target);
    	} 
    	
	    if (log.isDebugEnabled())
		    log.debug("found " + String.valueOf(roots.size()) + " merge-root and " 
		    		+ String.valueOf(sources.size()) + " source packages");
	    return roots;	
    }   
    
    @SuppressWarnings("unchecked")
    private ModelConfig unmarshalConfig(String configFileName, MetaModelConfigDataBinding binding) {
        try {
            InputStream stream = MetaModel.class.getResourceAsStream(configFileName);
            if (stream == null)
                throw new MetaModelException("cannot find resource '" + configFileName + "'");
            JAXBElement root = (JAXBElement) binding.validate(stream);

            ModelConfig result = (ModelConfig) root.getValue();
            return result;
        } catch (UnmarshalException e) {
            throw new MetaModelException(e);
        } catch (JAXBException e) {
            throw new MetaModelException(e);
        }
    }

    public static MetaModel getInstance() throws MetaModelException {
        if (instance == null)
            initializeInstance();
        return instance;
    }

    private static synchronized void initializeInstance() throws MetaModelException {
        if (instance == null)
            instance = new MetaModel();
    }

    private void construct() {
        Iterator<String> classes = classifierNameToClassifierMap.keySet().iterator();
        while (classes.hasNext()) {
            String className = classes.next();
            
            Classifier Classifier = classifierNameToClassifierMap.get(className);
            Map<String, Property> attributes = new HashMap<String, Property>();
            if (Classifier instanceof Class_)
                collectAttributes((Class_) Classifier, attributes);
            classNameToAttributeMap.put(className, attributes);

            Map<String, Operation> operations = new HashMap<String, Operation>();
            if (Classifier instanceof Class_)
                collectOperations((Class_) Classifier, operations);
            classNameToOperationMap.put(className, operations);
        }
    }

    protected void collectAttributes(Class_ clss, Map<String, Property> attributes) {
        
        Iterator<fUML.Syntax.Classes.Kernel.Property> iter = clss.ownedAttribute.iterator();
        while (iter.hasNext()) {
            Property attrib = (Property)iter.next();
            attributes.put(attrib.name, attrib);
        }

        Iterator<Generalization> generalizations = clss.generalization.iterator();
        while (generalizations.hasNext()) {
            Generalization generalization = generalizations.next();
            String superclassXmiId = generalization.general.getXmiId();
            FumlObject obj = referenceMap.get(superclassXmiId);
            if (obj == null) {
                throw new InvalidReferenceException(superclassXmiId);
                // log.warn("invalid reference: " + superclassXmiId);
                // continue;
            }
            Class_ umlSuperClass = (Class_) obj;
            collectAttributes(umlSuperClass, attributes);
        }
    }

    protected void collectOperations(Class_ Class_, Map<String, Operation> operations) {
        Iterator<Operation> iter = Class_.ownedOperation.iterator();
        while (iter.hasNext()) {
            Operation oper = iter.next();
            operations.put(oper.name, oper);
        }

        Iterator<Generalization> generalizations = Class_.generalization.iterator();
        while (generalizations.hasNext()) {
            Generalization generalization = generalizations.next();
            String superclassXmiId = generalization.general.getXmiId();
            FumlObject obj = referenceMap.get(superclassXmiId);
            if (obj == null) {
                throw new InvalidReferenceException(superclassXmiId);
                // log.warn("invalid reference: " + superclassXmiId);
                // continue;
            }
            Class_ umlSuperClass = (Class_) obj;
            collectOperations(umlSuperClass, operations);
        }
    }

    public Classifier getClassifier(String name) {
        return getClassifier(name, false);
    }

    public Classifier findClassifier(String name) {
        return getClassifier(name, true);
    }

    private Classifier getClassifier(String name, boolean supressErrors) {
        Classifier result = null;
        if (name.indexOf(".") == -1)
            result = this.classifierNameToClassifierMap.get(name);
        else
            result = this.qualifiedClassifierNameToClassifierMap.get(name);

        if (result == null && !supressErrors)
            throw new MetaModelException("no classifier found for name, '" + name + "'");
        return result;
    }

    public String getPackageForClass(String className) {
        return getPackageForClass(className, false);
    }

    public String findPackageForClass(String name) {
        return getPackageForClass(name, true);
    }

    private String getPackageForClass(String name, boolean supressErrors) {
        String result = null;
        if (name.indexOf(".") == -1)
            result = this.classifierNameToPackageNameMap.get(name);
        else
            result = this.qualifiedClassifierNameToPackageNameMap.get(name);

        if (result == null && !supressErrors)
            throw new XmiException("no package found for class, " + name);
        return result;
    }

    public boolean isIgnoredClassifier(String classifierName) {
        return this.ignoredClassNameMap.get(classifierName) != null;
    }

    public boolean isIgnoredClassifier(Classifier classifier) {
        String packageName = getPackageForClass(classifier.name);
        if (isIgnoredPackage(packageName))
            return true;
        else
            return this.ignoredClassNameMap.get(classifier.name) != null;
    }

    public boolean isIgnoredPackage(String packageName) {
        return this.ignoredPackageNameMap.get(packageName) != null;
    }

    public Property getAttribute(Class_ Class_, String name) {
        return getAttribute(Class_, name, false);
    }

    public Property findAttribute(Class_ Class_, String name) {
        return getAttribute(Class_, name, true);
    }

    private Property getAttribute(Class_ Class_, String name, boolean supressErrors) {
        Property result = null;
        Map<String, Property> map = this.classNameToAttributeMap.get(Class_.name);
        if (map != null)
            result = map.get(name);

        if (result == null && !supressErrors)
            throw new XmiException("no attribute found for, " + Class_.name + "." + name);
        return result;
    }

    public Property[] getAttributes(Class_ Class_) {
        Property[] result = new Property[0];
        Map<String, Property> map = this.classNameToAttributeMap.get(Class_.name);
        if (map != null) {
            result = new Property[map.size()];
            Iterator<String> keys = map.keySet().iterator();
            for (int i = 0; keys.hasNext(); i++)
                result[i] = map.get(keys.next());
        }
        return result;
    }

    public String getAttributeDefault(Property property) {
        return getAttributeDefaultValue(property, false);
    }

    public String findAttributeDefault(Property property) {
        return getAttributeDefaultValue(property, true);
    }

    public boolean hasAttributeDefaultValue(Property property) {
        String value = getAttributeDefaultValue(property, true);
        return value != null && value.trim().length() > 0;
    }

    private String getAttributeDefaultValue(Property property, boolean supressErrors) {
        ValueSpecification valueSpec = findDefaultValueSpecification(property);
        if (valueSpec != null)
            return getValue(valueSpec);
        else
            return null;
    }

    private String getValue(ValueSpecification valueSpec) {
        if (LiteralString.class.isAssignableFrom(valueSpec.getClass())) {
            return ((LiteralString)valueSpec).value;
        }
        else if (LiteralInteger.class.isAssignableFrom(valueSpec.getClass())) {
            return String.valueOf(((LiteralInteger)valueSpec).value); // use specifically typed value in subclass
        }
        else if (LiteralBoolean.class.isAssignableFrom(valueSpec.getClass())) {
            return String.valueOf(((LiteralBoolean)valueSpec).value); // use specifically typed value in subclass
        }
        else if (LiteralNull.class.isAssignableFrom(valueSpec.getClass())) {
            return null;
        }
        else if (LiteralUnlimitedNatural.class.isAssignableFrom(valueSpec.getClass())) {
            return String.valueOf(((LiteralUnlimitedNatural)valueSpec).value.naturalValue);
        } else if (InstanceValue.class.isAssignableFrom(valueSpec.getClass())) {
        	InstanceValue instanceValue = (InstanceValue)valueSpec;
        	if (EnumerationLiteral.class.isAssignableFrom(instanceValue.instance.getClass()))
        	{
        		EnumerationLiteral enumerationLiteral = (EnumerationLiteral)instanceValue.instance;
        		return enumerationLiteral.name;
        	}
        	else
                throw new MetaModelException("unknown instance type, " 
                		+ instanceValue.instance.getClass().getName());
        } else {
            // return ((OpaqueExpression)valueSpec).getBody();
            throw new IllegalArgumentException("expected literal or instance value");
        }
    }

    private void setValue(ValueSpecification valueSpec, String value) {
        if (LiteralString.class.isAssignableFrom(valueSpec.getClass()))
        	((LiteralString)valueSpec).value = value;
        else if (LiteralInteger.class.isAssignableFrom(valueSpec.getClass()))
        	((LiteralInteger)valueSpec).value = Integer.parseInt(value);
        else if (LiteralBoolean.class.isAssignableFrom(valueSpec.getClass()))
            ((LiteralBoolean)valueSpec).value = Boolean.parseBoolean(value);
        //else if (LiteralNull.class.isAssignableFrom(valueSpec.getClass()))        	 	
        else if (LiteralUnlimitedNatural.class.isAssignableFrom(valueSpec.getClass())) {
        	UnlimitedNatural un = new UnlimitedNatural();
        	un.naturalValue = Integer.parseInt(value);
        	((LiteralUnlimitedNatural)valueSpec).value = un;
        } else if (InstanceValue.class.isAssignableFrom(valueSpec.getClass())) {
            valueSpec.setName(value);
        } else {
            // ((OpaqueExpression)valueSpec).setBody(value);
            throw new IllegalArgumentException("expected literal or instance value");
        }
    }

    private ValueSpecification findDefaultValueSpecification(Property property) {
        return property.getDefaultValue();
    }

    public Operation getOperation(Class_ Class_, String name) {
        return getOperation(Class_, name, false);
    }

    public Operation findOperation(Class_ Class_, String name) {
        return getOperation(Class_, name, true);
    }

    private Operation getOperation(Class_ Class_, String name, boolean supressErrors) {
        Operation result = null;
        Map<String, Operation> map = this.classNameToOperationMap.get(Class_.name);
        if (map != null)
            result = map.get(name);

        if (result == null && !supressErrors)
            throw new XmiException("no operation found for, " + Class_.name + "." + name);
        return result;
    }

    public Operation[] getOperations(Class_ Class_) {
        Operation[] result = new Operation[0];
        Map<String, Operation> map = this.classNameToOperationMap.get(Class_.name);
        if (map != null) {
            result = new Operation[map.size()];
            Iterator<String> keys = map.keySet().iterator();
            for (int i = 0; keys.hasNext(); i++)
                result[i] = map.get(keys.next());
        }
        return result;
    }

    public Classifier getType(Property property) {
        return getType(property, false);
    }

    public Classifier findType(Property property) {
        return getType(property, true);
    }

    private Classifier getType(Property property, boolean supressErrors) {
        Classifier result = null;
        
        String typeXmiId = property.typedElement.type.getXmiId(); // .getStructuralFeatureTypeAttribute();
                                                                  // // type
                                                                  // reference
        if (typeXmiId != null) {
            result = (Classifier) this.referenceMap.get(typeXmiId);
            if (result == null && !supressErrors)
                throw new InvalidReferenceException(typeXmiId);
        } else {
            result = (Classifier) property.typedElement.type;
        }
        if (result == null && !supressErrors)
            throw new MetaModelException("no type found for property, " + property.name);
        return result;
    }

    public boolean isRequired(Class_ cls, Property property) {
        return getLowerValue(cls, property) > 0;
    }

    public boolean isSingular(Class_ cls, Property property) {
        return "1".equals(getUpperValue(cls, property));
    }

    public boolean isAbstract(Classifier cls) {
         return cls.isAbstract;
    }

    public boolean isDerived(Class_ cls, Property property) {
        return "true".equals(property.isDerived);
    }

    private String getUpperValue(Class_ cls, Property property) {
        return getValue(property.multiplicityElement.upperValue);
    }

    private int getLowerValue(Class_ cls, Property property) {
    	String value = getValue(property.multiplicityElement.lowerValue);
         if (value == null || "null".equalsIgnoreCase(value))
            value = "0";
        return Integer.valueOf(value);
    }

    
    public static void main(String[] args) {
    	MetaModel.getInstance();
    }

}
