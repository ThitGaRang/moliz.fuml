
package org.modeldriven.fuml.repository.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fUML.Syntax.Classes.Kernel.Association;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Generalization;
import fUML.Syntax.Classes.Kernel.Classifier;
import fUML.Syntax.Classes.Kernel.LiteralInteger;
import fUML.Syntax.Classes.Kernel.LiteralUnlimitedNatural;
import fUML.Syntax.Classes.Kernel.PrimitiveType;
import UMLPrimitiveTypes.UnlimitedNatural;
import fUML.Syntax.Classes.Kernel.ValueSpecification;
import fUML.Syntax.Classes.Kernel.Enumeration;
import fUML.Syntax.Classes.Kernel.EnumerationLiteral;
import fUML.Syntax.Classes.Kernel.Package;
import fUML.Syntax.Classes.Kernel.Property;

import org.modeldriven.fuml.repository.RepositoryArtifact;
import org.modeldriven.fuml.repository.RepositoryMapping;
import org.modeldriven.fuml.repository.Repository;

import org.modeldriven.fuml.repository.config.Artifact;

// this needs to read the artifact namespace info from the content
public class PrimitiveTypesAssembler extends ModelAssembler 
    implements RepositoryArtifact
{

    private static Log log = LogFactory.getLog(PrimitiveTypesAssembler.class);
    private ModelFactory factory;

    public PrimitiveTypesAssembler(Artifact artifact, RepositoryMapping mapping, Repository model) {
        super(artifact, mapping, model);
        this.factory = new ModelFactory(mapping, model);
        construct();
    }

    private void construct() {
        log.info("initializing...");
        constructPackages();
        constructPrimitiveTypes();
        constructEnumerations();
        constructClasses();
        constructProperties();
        constructGeneralizations();
        constructAssociations();
    } 

    public String getURN() {
        return this.artifact.getUrn();
    }
    
    public String getNamespaceURI() {
        return this.artifact.getNamespaceURI();
    }
    
    private void constructPackages()
    {
        Package pkg = null;
         
                     
        // PrimitiveTypes            
    	pkg  = factory.createPackage("PrimitiveTypes", "PrimitiveTypes", "PrimitiveTypes", this); // root package
    	mapping.mapPackage(pkg, null, this); 
            
    }   

    private void constructPrimitiveTypes()
    {
    Package pkg = null;
    String packageId = null;
    PrimitiveType type = null;
                                                      
        packageId = this.artifact.getUrn() + "#" + "PrimitiveTypes";   
        
        // PrimitiveTypes.Boolean 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        
        // Boolean
    	type  = factory.createPrimitiveType("Boolean", "Boolean", pkg);
    	mapping.mapPrimitiveType(type, "PrimitiveTypes", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "PrimitiveTypes";   
        
        // PrimitiveTypes.Integer 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        
        // Integer
    	type  = factory.createPrimitiveType("Integer", "Integer", pkg);
    	mapping.mapPrimitiveType(type, "PrimitiveTypes", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "PrimitiveTypes";   
        
        // PrimitiveTypes.Real 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        
        // Real
    	type  = factory.createPrimitiveType("Real", "Real", pkg);
    	mapping.mapPrimitiveType(type, "PrimitiveTypes", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "PrimitiveTypes";   
        
        // PrimitiveTypes.String 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        
        // String
    	type  = factory.createPrimitiveType("String", "String", pkg);
    	mapping.mapPrimitiveType(type, "PrimitiveTypes", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "PrimitiveTypes";   
        
        // PrimitiveTypes.UnlimitedNatural 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        
        // UnlimitedNatural
    	type  = factory.createPrimitiveType("UnlimitedNatural", "UnlimitedNatural", pkg);
    	mapping.mapPrimitiveType(type, "PrimitiveTypes", this); 
    
    }   
       
    private void constructClasses()
    {
        Package pkg = null;
        String packageId = null;
        Class_ clss = null;
    
    }   

    private void constructEnumerations()
    {
        Enumeration enumeration = null;
        EnumerationLiteral literal = null;
    
    }   

    private void constructProperties()
    {
        Class_ clss = null;
        Property prop = null;
        
    
    }
    
    private void constructGeneralizations()
    {
        Class_ clss = null;
        
    
    }

    private void constructAssociations()
    {
        Package pkg = null;
        String packageId = null;
        Association assoc = null;
        Property prop = null;
        
    
    }

}
    
    