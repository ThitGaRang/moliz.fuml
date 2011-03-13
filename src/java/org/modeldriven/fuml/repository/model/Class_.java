package org.modeldriven.fuml.repository.model;

import java.util.Iterator;
import java.util.Map;

import org.modeldriven.fuml.repository.Property;
import org.modeldriven.fuml.repository.RepositoryArtifact;
import org.modeldriven.fuml.xmi.XmiException;

import fUML.Syntax.Classes.Kernel.Operation;



public class Class_ extends Classifier 
    implements org.modeldriven.fuml.repository.Class_ {

	private fUML.Syntax.Classes.Kernel.Class_ class_;
	private Map<String, Property> attributes;
	private Map<String, Operation> operations;
	    
    public Class_(fUML.Syntax.Classes.Kernel.Class_ class_,
    		RepositoryArtifact artifact) {
    	super(class_, artifact);
    	this.class_ = class_;
    }
    
    // note: package-level access only
    void setAttributes(Map<String, Property> attributes) {    	
    	this.attributes = attributes;
    }

    // note: package-level access only
    void setOperations(Map<String, Operation> operations) {
    	this.operations = operations;
    }
    
    public fUML.Syntax.Classes.Kernel.PropertyList getOwnedAttribute() {
    	return this.class_.ownedAttribute;
    }
    
    public fUML.Syntax.Classes.Kernel.OperationList getOwnedOperation() {
    	return this.class_.ownedOperation;
    }
    
	public fUML.Syntax.Classes.Kernel.Class_ getDelegate() {
		return this.class_;
	}
 
    public Property getProperty(String name) {
        return getProperty(name, false);
    }

    public Property findProperty(String name) {
        return getProperty(name, true);
    }

    private Property getProperty(String name, boolean supressErrors) {
        Property result = null;
        if (this.attributes != null)
        	result = this.attributes.get(name);
        if (result == null && !supressErrors)
            throw new XmiException("no attribute found for, " + this.getName() + "." + name);
        return result;
    }
    
    public org.modeldriven.fuml.repository.Property[] getProperties() {
        Property[] result = new Property[0];
        if (attributes != null) {
            result = new Property[attributes.size()];
            int i = 0;
    		for (Iterator<Property> it = attributes.values().iterator(); it.hasNext();) {
    			result[i] = it.next();
    			i++;
    		}	
        }
        return result;
    }

    
} // Class_
