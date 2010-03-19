package org.modeldriven.fuml.meta;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import fUML.Syntax.Classes.Kernel.Association;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Classifier;
import fUML.Syntax.Classes.Kernel.Enumeration;
import fUML.Syntax.Classes.Kernel.EnumerationLiteral;
import fUML.Syntax.Classes.Kernel.Generalization;
import fUML.Syntax.Classes.Kernel.InstanceSpecification;
import fUML.Syntax.Classes.Kernel.InstanceValue;
import fUML.Syntax.Classes.Kernel.LiteralBoolean;
import fUML.Syntax.Classes.Kernel.LiteralInteger;
import fUML.Syntax.Classes.Kernel.LiteralString;
import fUML.Syntax.Classes.Kernel.LiteralUnlimitedNatural;
import fUML.Syntax.Classes.Kernel.PrimitiveType;
import fUML.Syntax.Classes.Kernel.Package;
import UMLPrimitiveTypes.UnlimitedNatural;
import fUML.Syntax.Classes.Kernel.ValueSpecification;

import org.modeldriven.fuml.meta.Property;

public class MetaModelFactory 
{
    private static Log log = LogFactory.getLog(MetaModelFactory.class);
    protected Mapping mapping;

    @SuppressWarnings("unused")
	private MetaModelFactory() {}
    
    protected MetaModelFactory(Mapping mapping) {
    	this.mapping = mapping;
    }
    
    public Package createPackage(String name, String qualifiedName, String id, MetaDataDocument artifact) {
    	return createPackage(name, qualifiedName, id, null, artifact);
    }    
    
    public Package createPackage(String name, String qualifiedName, String id, Package parent, MetaDataDocument artifact) {
    	Package p = new Package();
        p.name = name;
        p.qualifiedName = qualifiedName;
        p.setHref(artifact.getURI() + "#" + p.qualifiedName);
        p.setXmiId(id);
        if (parent != null)
            parent.addPackagedElement(p);
        return p;
    }
            
    public Class_ createClass(String name, String id, Package pkg) {
        Class_ c = new Class_();
        c.name = name;
        c.qualifiedName = pkg.qualifiedName + "." + c.name;
        c.setXmiId(id);
        pkg.addPackagedElement(c);
        return c;
    }

    public Enumeration createEnumeration(String name, String id) {
        Enumeration e = new Enumeration();
        e.name = name;
        e.setXmiId(id);
        return e;
    }
    
    public PrimitiveType createPrimitiveType(String name, String id) {
        PrimitiveType t = new PrimitiveType();
        t.name = name;
        t.setXmiId(id);
        return t;
    }

    public Association createAssociation(String name, String id, Property[] members) {
        Association a = new Association();
        a.name = name;
        a.setXmiId(id);

        for (int i = 0; i < members.length; i++) {
            a.memberEnd.add(members[i]);
        }

        return a;
    }

    public void addGeneralization(Class_ c, String general) {
        Generalization g = new Generalization();
        g.general = (Classifier) mapping.get(general);
        c.generalization.add(g);
    }

    public Property addProperty(Class_ c, String name, String id, 
            String typeName, String redefinedProperty, 
            boolean readOnly, boolean derived, boolean derivedUnion) {
        Property p = createProperty(name, id, typeName, 
                redefinedProperty, readOnly, derived,
                derivedUnion);
        p.class_ = c;
        c.ownedAttribute.add(p);
        return p;
    }

    public Property createProperty(String name, String id, 
            String typeName, String redefinedProperty, 
            boolean readOnly, boolean derived, boolean derivedUnion) {
        Property p = new Property();
        p.setName(name);
        p.setXmiId(id);
        p.isDerived = derived;
        p.setIsReadOnly(readOnly);
        p.isDerivedUnion = derivedUnion;

        if ((typeName == null || typeName.length() == 0) 
                && (redefinedProperty == null || redefinedProperty.length() == 0))
            throw new MetaModelException("no type or redefinedProperty found for property '" 
                    + name + "' (" + id
                    + ")");
        if (typeName != null && typeName.length() > 0)
        {    
            Classifier type = (Classifier) mapping.find(typeName);
            if (type == null)
                log.error("could not find type '" + typeName + "' for property '" 
                        + name + "' (" + id
                        + ")");
            p.typedElement.type = type;
        } 
        else
        {
            Property redefinedProp = (Property)mapping.get(redefinedProperty);
            if (redefinedProp == null)
                throw new MetaModelException("could not find redefinedProperty '" + redefinedProperty + "' for property '" 
                    + name + "' (" + id
                    + ")");
            p.typedElement.type = redefinedProp.typedElement.type;
        }

        return p;
    }

    public void addLowerValue(Property p, boolean hasLowerValue, String value)
    {
        if ("1".equals(value)) {
            LiteralInteger lowerValue = new LiteralInteger();
            lowerValue.value = 1;
            p.setLowerValue(lowerValue);
        }
        else if (value != null && value.length() > 0)
        {
            int intValue = Integer.parseInt(value);
            LiteralInteger lowerValue = new LiteralInteger();
            lowerValue.value = 1;
            p.setLowerValue(lowerValue);
        }
        else if (hasLowerValue) {
            // it's defined, but no value attrib, give it the default
            // value for LiteralInteger (0)
            LiteralInteger lowerValue = new LiteralInteger();
            lowerValue.value = 0;
            p.setLowerValue(lowerValue);
        }
        else {
            LiteralInteger lowerValue = new LiteralInteger();
            lowerValue.value = 1;
            p.setLowerValue(lowerValue);
        }
    }
    
    /**
     * multiplicity examples
     * ---------------------------------------
     * 1       - Default if omitted
     * *       - zero or more
     * 1..*    - 1 or more
     * 0..1    - zero or 1
     * 2..5    - At least 2 and up to 5
     * 2,5     - 2 or 5
     * n       - Unknown at compile time
     * ---------------------------------------
     * @param p
     * @param hasUpperValue
     * @param value
     */
    public void addUpperValue(Property p, boolean hasUpperValue, String value)
    {
        if ("*".equals(value)) {
            LiteralUnlimitedNatural upperValue = new LiteralUnlimitedNatural();
            UnlimitedNatural unlimitedNatural = new UnlimitedNatural();
            upperValue.value = unlimitedNatural;
            p.setUpperValue(upperValue);
        }
        else if (value != null && value.length() > 0)
        {
            int intValue = Integer.parseInt(value);
            LiteralInteger upperValue = new LiteralInteger();
            upperValue.value = intValue;
            p.setUpperValue(upperValue);
        }
        else if (hasUpperValue) {
            LiteralInteger upperValue = new LiteralInteger();
            upperValue.value = 1;
            p.setUpperValue(upperValue);
        }
        else
        {
            LiteralInteger upperValue = new LiteralInteger();
            upperValue.value = 1;
            p.setUpperValue(upperValue);
        }
    }
    
    public void addDefault(Property prop, Object value, String instance, String id, 
            String xmiType, String typeId) {
        
        ValueSpecification spec = createDefault(prop, value, instance, id, xmiType, typeId);
        prop.setDefaultValue(spec);
    }

    public ValueSpecification createDefault(Property prop, Object value, String instance, String id, 
            String xmiType, String typeId) {
        
        ValueSpecification valueSpec = null;
        
        String typeName = xmiType.substring(4);
        
        Classifier type = null;
        
        if (typeId != null && typeId.length() > 0)
        {
            type = (Classifier) mapping.get(typeId);
        }    
            
        if (LiteralString.class.getSimpleName().equals(typeName))
        {
            LiteralString literalString = new LiteralString();
            if (type != null)
                literalString.type = type;
            else
                literalString.type = mapping.getClassifierByName("String");
            literalString.value = String.valueOf(value);
            
            valueSpec = literalString;
        }
        else if (LiteralBoolean.class.getSimpleName().equals(typeName))
        {
            LiteralBoolean literalBoolean = new LiteralBoolean();
            if (type != null)
                literalBoolean.type = type;
            else
                literalBoolean.type = mapping.getClassifierByName("Boolean");
            if (value != null) {
                literalBoolean.value = Boolean.valueOf(String.valueOf(value)).booleanValue();
            }    
            else
            {    
                literalBoolean.value = false;
            }    
            valueSpec = literalBoolean;
        }
        else if (LiteralInteger.class.getSimpleName().equals(typeName))
        {
            LiteralInteger literalInteger = new LiteralInteger();                
            if (type != null)
                literalInteger.type = type;
            else
                literalInteger.type = mapping.getClassifierByName("Integer");
            if (value != null && String.valueOf(value).length() > 0) {            	
                literalInteger.value = Integer.valueOf(String.valueOf(value)).intValue();
            }    
            else
            {    
                literalInteger.value = 0;
            }    
            valueSpec = literalInteger;
        }
        else if ("OpaqueExpression".equals(typeName))
        {
        	if (value == null)
        		throw new MetaModelException("expected default value - cannot create OpaqueExpression default for property '"
        				+ prop.class_.name + "." + prop.name + "'");
        	if (value instanceof UnlimitedNatural)
        	{
        		LiteralUnlimitedNatural literalUnlimitedNatural = new LiteralUnlimitedNatural();
        		literalUnlimitedNatural.value = (UnlimitedNatural)value;
        		valueSpec = literalUnlimitedNatural;
        	}
        	else
    		    throw new MetaModelException("expected UnlimitedNatural value from OpaqueExpression default for property '"
    				+ prop.class_.name + "." + prop.name + "'");
        }
        else if (InstanceValue.class.getSimpleName().equals(typeName))
        {
            InstanceValue instanceValue = new InstanceValue();
            if (type == null)
                throw new MetaModelException("can't derive type for InstanceValue");
            instanceValue.type = type;
            valueSpec = instanceValue;
            if (instance == null || instance.length() == 0)
                throw new MetaModelException("required InstanceValue.instance ");
            instanceValue.instance = (InstanceSpecification)mapping.get(instance);
            if (instanceValue.instance == null)
                log.warn("could not lookup reference for instance by id, '"
                        + instance + "'");
        }            
        else
            throw new MetaModelException("unknown type, '" + typeName + "'");
        
        return valueSpec;
    }
    
    public EnumerationLiteral addEnumerationLiteral(Enumeration enumeration, 
            String name, String id) {
        EnumerationLiteral literal = new EnumerationLiteral();
        literal.name = name;
        literal.setXmiId(id);
        enumeration.ownedLiteral.add(literal);
        return literal;
    }
    
}
