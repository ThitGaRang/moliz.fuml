package org.modeldriven.fuml.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.FumlObject;
import org.modeldriven.fuml.meta.merge.PackageGraphNode;
import org.modeldriven.fuml.xmi.InvalidReferenceException;

import UMLPrimitiveTypes.UnlimitedNatural;

import fUML.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Classifier;
import fUML.Syntax.Classes.Kernel.Enumeration;
import fUML.Syntax.Classes.Kernel.EnumerationLiteral;
import fUML.Syntax.Classes.Kernel.Generalization;
import fUML.Syntax.Classes.Kernel.InstanceValue;
import fUML.Syntax.Classes.Kernel.LiteralBoolean;
import fUML.Syntax.Classes.Kernel.LiteralInteger;
import fUML.Syntax.Classes.Kernel.LiteralNull;
import fUML.Syntax.Classes.Kernel.LiteralString;
import fUML.Syntax.Classes.Kernel.LiteralUnlimitedNatural;
import fUML.Syntax.Classes.Kernel.Operation;
import fUML.Syntax.Classes.Kernel.PackageableElement;
import fUML.Syntax.Classes.Kernel.PackageableElementList;
import fUML.Syntax.Classes.Kernel.PrimitiveType;
import fUML.Syntax.Classes.Kernel.ValueSpecification;
import fUML.Syntax.Classes.Kernel.Package;

import org.modeldriven.fuml.meta.Property;


public class MetaModelMapping implements Mapping 
{
    private Log log = LogFactory.getLog(MetaModelMapping.class);

    protected Map<String, Classifier> classifierNameToClassifierMap = new HashMap<String, Classifier>();
    protected Map<String, Classifier> qualifiedClassifierNameToClassifierMap = new HashMap<String, Classifier>();
    
    protected Map<String, String> classifierNameToPackageNameMap = new HashMap<String, String>();
    protected Map<String, String> qualifiedClassifierNameToPackageNameMap = new HashMap<String, String>();

    protected Map<String, Map<String, Property>> classNameToAttributeMap = new HashMap<String, Map<String, Property>>();
    protected Map<String, Map<String, Operation>> classNameToOperationMap = new HashMap<String, Map<String, Operation>>();

    protected Map<String, FumlObject> referenceMap = new HashMap<String, FumlObject>();

    protected Map<String, Package> qualifiedPackageNameToPackageMap = new HashMap<String, Package>();
    protected Map<String, PackageGraphNode> packageIdToPackageMergeMap = new HashMap<String, PackageGraphNode>();
    protected Map<String, List<Package>> artifactToPackagesMap = new HashMap<String, List<Package>>();
       
    protected MetaModelMapping() {}
    
	public Object get(String id) 
	{
		Object result = referenceMap.get(id);
		if (result != null)
			return result;
		else
			throw new MetaModelException("could not get model object from XMI ID, '" 
					+ id + "'");		
	}
	
	public Object find(String id) 
	{
		return referenceMap.get(id);
	}
	
	public Classifier getClassifierByName(String name) {
		return classifierNameToClassifierMap.get(name);
	}
	
	public Classifier getClassifierByQualifiedName(String qualifiedName) {
		return qualifiedClassifierNameToClassifierMap.get(qualifiedName);
	}
 
	public Package getPackageByQualifiedName(String qualifiedName) {
		Package result = qualifiedPackageNameToPackageMap.get(qualifiedName);
		if (result != null)
			return result;
		else
			throw new MetaModelException("could not get package from qualified name, '" 
					+ qualifiedName + "'");		
	}
	
    public void mapPackage(Package p, String currentPackageName, MetaDataDocument artifact) {
    	String qualifiedName = null;
        if (currentPackageName != null)
        	qualifiedName = currentPackageName + "." + p.name;
        else
        	qualifiedName = p.name;   	
    	
        if (log.isDebugEnabled())
            log.debug("mapping package, " + artifact.getURI() + "#" + qualifiedName);

        if (qualifiedPackageNameToPackageMap.get(qualifiedName) != null)
        	throw new MetaModelException("found existing package, '"
        			+ qualifiedName + ".");
        qualifiedPackageNameToPackageMap.put(qualifiedName, p);
        List<Package> artifactPackages = artifactToPackagesMap.get(artifact.getURI());
        if (artifactPackages == null)
        {
        	artifactPackages = new ArrayList<Package>();
        	artifactToPackagesMap.put(artifact.getURI(), artifactPackages);
        }
        artifactPackages.add(p);
                
        if (referenceMap.get(p.getXmiId()) != null)
        	throw new MetaModelException("found existing package reference, '"
        			+ p.getXmiId() + ".");
        referenceMap.put(p.getXmiId(), p);
        String globalId = artifact.getURI() + "#" + p.getXmiId();
        if (referenceMap.get(globalId) != null)
        	throw new MetaModelException("found existing package reference, '"
        			+ globalId + ".");
        referenceMap.put(globalId, p);
    }

    public void mapPackageMerge(Package p, String sourcePackageXmiId) {
        if (log.isDebugEnabled())
            log.debug("mapping package merge, " + p.qualifiedName + "->" + sourcePackageXmiId);
        
        PackageGraphNode target = packageIdToPackageMergeMap.get(p.getXmiId());
        if (target == null)
        {	
        	target = new PackageGraphNode(p.getXmiId());
        	packageIdToPackageMergeMap.put(p.getXmiId(), target);
        }

        PackageGraphNode source = packageIdToPackageMergeMap.get(sourcePackageXmiId);
        if (source == null) {
        	source = new PackageGraphNode(sourcePackageXmiId);
        	packageIdToPackageMergeMap.put(sourcePackageXmiId, source);
        }
        
        if (target.contains(source))
	        	throw new MetaModelException("found existing merge node (" + sourcePackageXmiId 
	        			+ ") in target, " + p.qualifiedName + " ("
	        			+ p.getXmiId() + ")");
        target.addNode(source);
    }
    
    public void mapClass(Class_ c, String currentPackageName, MetaDataDocument artifact) {
    	String qualifiedName = currentPackageName + "." + c.name;
        if (log.isDebugEnabled())
            log.debug("mapping class, " + artifact.getURI() + "#" + qualifiedName);

        //classifierNameToClassifierMap.put(c.name, c); // overwrites !! TODO: add after package merge
        //classifierNameToPackageNameMap.put(c.name, currentPackageName); // overwrites !! TODO: add after package merge
        
        if (qualifiedClassifierNameToClassifierMap.get(qualifiedName) != null)
        	throw new MetaModelException("found existing classifier, '"
        			+ qualifiedName + ".");
        qualifiedClassifierNameToClassifierMap.put(qualifiedName, c);
        qualifiedClassifierNameToPackageNameMap.put(qualifiedName,
                currentPackageName);
                
        if (referenceMap.get(c.getXmiId()) != null)
        	throw new MetaModelException("found existing classifier reference, '"
        			+ c.getXmiId() + ".");
        referenceMap.put(c.getXmiId(), c);
        String globalId = artifact.getURI() + "#" + c.getXmiId();
        if (referenceMap.get(globalId) != null)
        	throw new MetaModelException("found existing classifier reference, '"
        			+ globalId + ".");
        referenceMap.put(globalId, c);
    }

    public void mapProperty(Class_ c, Property p, MetaDataDocument artifact) {
        if (log.isDebugEnabled())
            log.debug("mapping property, " + artifact.getURI() + "#" + c.name + "." + p.name);
                
        if (referenceMap.get(p.getXmiId()) != null)
        	throw new MetaModelException("found existing property reference, '"
        			+ p.getXmiId() + ".");
        referenceMap.put(p.getXmiId(), p);
        String globalId = artifact.getURI() + "#" + p.getXmiId();
        if (referenceMap.get(globalId) != null)
        	throw new MetaModelException("found existing property reference, '"
        			+ globalId + ".");
        referenceMap.put(globalId, p);
    }
    
    public void mapPrimitiveType(PrimitiveType t, String currentPackageName, MetaDataDocument artifact) {
        if (log.isDebugEnabled())
            log.debug("mapping type, " + artifact.getURI() + "#" + currentPackageName + "." + t.getClass().getSimpleName());
        classifierNameToClassifierMap.put(t.name, t);
        qualifiedClassifierNameToClassifierMap.put(currentPackageName + "." + t.name, t);
        classifierNameToPackageNameMap.put(t.name, currentPackageName);
        qualifiedClassifierNameToPackageNameMap.put(currentPackageName + "." + t.name,
                currentPackageName);
        if (referenceMap.get(t.getXmiId()) != null)
        	throw new MetaModelException("found existing primitive type, '"
        			+ t.getXmiId() + ".");
        referenceMap.put(t.getXmiId(), t);
        String globalId = artifact.getURI() + "#" + t.getXmiId();
        if (referenceMap.get(globalId) != null)
        	throw new MetaModelException("found existing primitive type, '"
        			+ globalId + ".");
        referenceMap.put(globalId, t);
        
        // FIXME: HACK - where is this types document??
        referenceMap.put("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml" 
                + "#" + t.name, t);        
    }

    public void mapEnumeration(Enumeration e, String currentPackageName) {
        if (log.isDebugEnabled())
            log.debug("mapping enumeration, " + currentPackageName + "." + e.name);
        classifierNameToClassifierMap.put(e.name, e);
        qualifiedClassifierNameToClassifierMap.put(currentPackageName + "." + e.name, e);
        classifierNameToPackageNameMap.put(e.name, currentPackageName);
        qualifiedClassifierNameToPackageNameMap.put(currentPackageName + "." + e.name,
                currentPackageName);
        if (referenceMap.get(e.getXmiId()) != null)
        	throw new MetaModelException("found existing enumeration, '"
        			+ e.getXmiId() + ".");
        referenceMap.put(e.getXmiId(), e);
    }

    public void mapEnumerationLiteral(EnumerationLiteral literal, String currentPackageName) {
        if (log.isDebugEnabled())
            log.debug("mapping enumeration literal, " + currentPackageName + "." + literal.name);
        if (referenceMap.get(literal.getXmiId()) != null)
        	throw new MetaModelException("found existing enumeration literal, '"
        			+ literal.getXmiId() + ".");
        referenceMap.put(literal.getXmiId(), literal);
    }    

    public void mergePackage(Package target, Package source) {
    	if (log.isDebugEnabled())
		    log.debug("merging package " + target.getHref() + " with "
            		+ source.getHref());
    	Iterator<PackageableElement> sourceIter = source.packagedElement.iterator();
    	while (sourceIter.hasNext())
    	{
    		PackageableElement sourceElement = sourceIter.next();
            if (sourceElement instanceof Class_)
            {	
	    		Class_ sourceClass = (Class_)sourceElement;
	    		Class_ targetClass = findClass(target, sourceClass.name);
	    		if (targetClass != null)
	    		{	
	        		if (log.isDebugEnabled())
	                    log.debug("merging class (" + target.qualifiedName + ") " + targetClass.name + " with "
	                    		+ "(" + source.qualifiedName + ") " + sourceClass.name);
	    			mergeClass(targetClass, sourceClass);
	    		}	
	    		else
	    		{	
	        		if (log.isDebugEnabled())
	                    log.debug("adding class (" + source.qualifiedName + ") " + sourceClass.name
	                    		+ " to package " + target.qualifiedName);
	    			target.packagedElement.add(sourceClass);
	    		}
            }
    	}
    }
 
    private Class_ findClass(Package p, String name)
    {
    	Iterator<PackageableElement> targetIter = p.packagedElement.iterator();
    	while (targetIter.hasNext())
    	{
    		PackageableElement element = targetIter.next();
    		if (element instanceof Class_)
    		{	
    		    Class_ c = (Class_)element;
    		    if (name.equals(c.name))
    			    return c;
    		}
    	}
    	return null;
    }

    @SuppressWarnings("unchecked")
	private Property findProperty(Class_ c, String name)
    {    	
	    Iterator<fUML.Syntax.Classes.Kernel.Property> iter = c.ownedAttribute.iterator();
	    while (iter.hasNext()) {
	        Property p = (Property)iter.next();
	        if (p.name.equals(name))
	            return p;
	    }
	    return null;
    }
    
    public void mergeClass(Class_ target, Class_ source) {
        
        mergeProperties(target, source);
        mergeGeneralizations(target, source);
        target.general.clear(); // HACK
        //mergeGenerals(target, source);
                
        target.isAbstract = source.isAbstract;
        target.setIsAbstract(target.isAbstract);
    }
    
    public void mergeProperties(Class_ target, Class_ source) {
        
        // merge existing properties and add new properties 
        Iterator<fUML.Syntax.Classes.Kernel.Property> sourceIter = source.ownedAttribute.iterator();
        while (sourceIter.hasNext()) {
            Property sourceProp = (Property)sourceIter.next();
            Property targetProp = findProperty(target, sourceProp.name);
            if (targetProp != null)
            {
        		if (log.isDebugEnabled())
                    log.debug("merging property " + target.qualifiedName + "." + targetProp.name + " with "
                    	+ source.qualifiedName + "." + sourceProp.name);
            	mergeProperty(targetProp, sourceProp);
            }
            else
            {
        		if (log.isDebugEnabled())
                    log.debug("adding property " + source.qualifiedName + "." + sourceProp.name + " to "
                    	+ target.name);
            	target.ownedAttribute.add(sourceProp);
            }
        }
        
        // remove obsolete properties
/*        
        List<Property> toRemove = new ArrayList<Property>();
        Iterator<Property> targetIter = target.ownedAttribute.iterator();
        while (targetIter.hasNext()) {
            Property targetProp = targetIter.next();
            sourceIter = source.ownedAttribute.iterator();
            boolean found = false;
            while (sourceIter.hasNext()) {
                Property sourceProp = sourceIter.next();
            
                if (!targetProp.name.equals(sourceProp.name))
                    continue;
                found = true;
            }
            if (!found) // target no longer in source
                toRemove.add(targetProp);
        }
        
        Iterator<Property> toRemoveTargetIter = toRemove.iterator();
        while (toRemoveTargetIter.hasNext())
        {
            Property targetProp = toRemoveTargetIter.next();
            if (!target.ownedAttribute.remove(targetProp))
                log.warn("could not remove property " 
                        + target.name + "." + targetProp.name);
        }
*/
    }

    private void mergeGeneralizations(Class_ target, Class_ source) {
        Iterator<Generalization> sourceIter = source.generalization.iterator();
        while (sourceIter.hasNext()) {
            Generalization sourceGeneralization = sourceIter.next();
            
            boolean found = false;
            Iterator<Generalization> targetIter = target.generalization.iterator();
            while (targetIter.hasNext()) {
                Generalization targetGeneralization = targetIter.next();
                if (!targetGeneralization.general.name.equals(sourceGeneralization.general.name))
                    continue;
                targetGeneralization.setXmiId(sourceGeneralization.getXmiId());
                found = true;
                break;
            }
            if (!found)
                target.generalization.add(sourceGeneralization);
        }
    }

    private void mergeGenerals(Class_ target, Class_ source) {
        Iterator<Classifier> sourceIter = source.general.iterator();
        while (sourceIter.hasNext()) {
            Classifier sourceGeneral = sourceIter.next();

            boolean found = false;
            Iterator<Classifier> targetIter = target.general.iterator();
            while (targetIter.hasNext()) {
                Classifier targetGeneral = targetIter.next();
                if (!targetGeneral.name.equals(sourceGeneral.name))
                    continue;
                found = true;
                break;
            }
            if (!found)
                target.general.add(sourceGeneral);
        }
    }
    
    protected void mergeProperty(Property target, Property source) {
        
        // type
        target.typedElement = source.typedElement;
        
        // merge defaults
        ValueSpecification sourceDefault = source.getDefaultValue();
        if (sourceDefault != null) {
            ValueSpecification targetDefault = target.getDefaultValue();
            if (targetDefault == null) {
                target.setDefaultValue(source.getDefaultValue());
            } else
                mergeValueSpecification(targetDefault, sourceDefault);
        }
        
        // merge upper/lower value (constraints) 
        ValueSpecification sourceLower = source.multiplicityElement.lowerValue;
        if (sourceLower != null)
        {
            ValueSpecification targetLower = target.multiplicityElement.lowerValue;
            if (targetLower == null)
                target.setLowerValue(sourceLower);
            else
                mergeValueSpecification(targetLower, sourceLower);           
        }
        ValueSpecification sourceUpper = source.multiplicityElement.lowerValue;
        if (sourceUpper != null)
        {
            ValueSpecification targetUpper = target.multiplicityElement.lowerValue;
            if (targetUpper == null)
                target.setUpperValue(sourceUpper);
            else
                mergeValueSpecification(targetUpper, sourceUpper);           
        }
    }

    private void mergeValueSpecification(ValueSpecification target, ValueSpecification source) {
        // NOTE; this is scary.
        if (!target.getClass().equals(source.getClass()))
            if (log.isDebugEnabled())
                log.warn("merging unequal value specification classes, "
                        + source.getClass().getSimpleName() + " to "
                        + target.getClass().getSimpleName());
        String sourceValue = getValue(source);
        if (sourceValue != null && sourceValue.trim().length() > 0)
            setValue(target, sourceValue);
    }

    private String getValue(ValueSpecification valueSpec) {
        if (LiteralString.class.isAssignableFrom(valueSpec.getClass()))
            return ((LiteralString)valueSpec).value;		
        else if (LiteralInteger.class.isAssignableFrom(valueSpec.getClass()))
            return String.valueOf(((LiteralInteger)valueSpec).value);		
        else if (LiteralBoolean.class.isAssignableFrom(valueSpec.getClass()))
            return String.valueOf(((LiteralBoolean)valueSpec).value);		
        else if (LiteralNull.class.isAssignableFrom(valueSpec.getClass()))
            return null; //((LiteralNull)valueSpec).;		
        else if (LiteralUnlimitedNatural.class.isAssignableFrom(valueSpec.getClass())) {
            return ((LiteralString)valueSpec).value;		
        } else if (InstanceValue.class.isAssignableFrom(valueSpec.getClass())) {
            return valueSpec.name;
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
    
    public Map<String, Classifier> getClassifierNameToClassifierMap() {
        return classifierNameToClassifierMap;
    }

    public Map<String, Classifier> getQualifiedClassifierNameToClassifierMap() {
        return qualifiedClassifierNameToClassifierMap;
    }

    public Map<String, String> getClassifierNameToPackageNameMap() {
        return classifierNameToPackageNameMap;
    }

    public Map<String, String> getQualifiedClassifierNameToPackageNameMap() {
        return qualifiedClassifierNameToPackageNameMap;
    }

    public Map<String, Map<String, Property>> getClassNameToAttributeMap() {
       return classNameToAttributeMap;
    }

    public Map<String, Map<String, Operation>> getClassNameToOperationMap() {
        return classNameToOperationMap;
    }

    public Map<String, FumlObject> getReferenceMap() {
        return referenceMap;
    }

    protected void putAll(MetaModelMapping src) {
        classifierNameToClassifierMap.putAll(src.getClassifierNameToClassifierMap());
        qualifiedClassifierNameToClassifierMap.putAll(src.qualifiedClassifierNameToClassifierMap);
        classifierNameToPackageNameMap.putAll(src.getClassifierNameToPackageNameMap());
        qualifiedClassifierNameToPackageNameMap.putAll(src.getQualifiedClassifierNameToPackageNameMap());
        referenceMap.putAll(src.getReferenceMap());                
    }
    
}
