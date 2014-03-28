
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
public class InfrastructureAssembler extends ModelAssembler 
    implements RepositoryArtifact
{

    private static Log log = LogFactory.getLog(InfrastructureAssembler.class);
    private ModelFactory factory;

    public InfrastructureAssembler(Artifact artifact, RepositoryMapping mapping, Repository model) {
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
         
                     
        // InfrastructureLibrary            
    	pkg  = factory.createPackage("InfrastructureLibrary", "InfrastructureLibrary", "InfrastructureLibrary", this); // root package
    	mapping.mapPackage(pkg, null, this); 
                
                     
        // InfrastructureLibrary.Core                                                    
    	pkg  = factory.createPackage("Core", "InfrastructureLibrary.Core", "Core", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions                                                    
    	pkg  = factory.createPackage("Abstractions", "InfrastructureLibrary.Core.Abstractions", "Core-Abstractions", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.BehavioralFeatures                                                    
    	pkg  = factory.createPackage("BehavioralFeatures", "InfrastructureLibrary.Core.Abstractions.BehavioralFeatures", "Core-Abstractions-BehavioralFeatures", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Changeabilities                                                    
    	pkg  = factory.createPackage("Changeabilities", "InfrastructureLibrary.Core.Abstractions.Changeabilities", "Core-Abstractions-Changeabilities", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Classifiers                                                    
    	pkg  = factory.createPackage("Classifiers", "InfrastructureLibrary.Core.Abstractions.Classifiers", "Core-Abstractions-Classifiers", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Comments                                                    
    	pkg  = factory.createPackage("Comments", "InfrastructureLibrary.Core.Abstractions.Comments", "Core-Abstractions-Comments", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Constraints                                                    
    	pkg  = factory.createPackage("Constraints", "InfrastructureLibrary.Core.Abstractions.Constraints", "Core-Abstractions-Constraints", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Elements                                                    
    	pkg  = factory.createPackage("Elements", "InfrastructureLibrary.Core.Abstractions.Elements", "Core-Abstractions-Elements", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Expressions                                                    
    	pkg  = factory.createPackage("Expressions", "InfrastructureLibrary.Core.Abstractions.Expressions", "Core-Abstractions-Expressions", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Generalizations                                                    
    	pkg  = factory.createPackage("Generalizations", "InfrastructureLibrary.Core.Abstractions.Generalizations", "Core-Abstractions-Generalizations", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Instances                                                    
    	pkg  = factory.createPackage("Instances", "InfrastructureLibrary.Core.Abstractions.Instances", "Core-Abstractions-Instances", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Literals                                                    
    	pkg  = factory.createPackage("Literals", "InfrastructureLibrary.Core.Abstractions.Literals", "Core-Abstractions-Literals", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Multiplicities                                                    
    	pkg  = factory.createPackage("Multiplicities", "InfrastructureLibrary.Core.Abstractions.Multiplicities", "Core-Abstractions-Multiplicities", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.MultiplicityExpressions                                                    
    	pkg  = factory.createPackage("MultiplicityExpressions", "InfrastructureLibrary.Core.Abstractions.MultiplicityExpressions", "Core-Abstractions-MultiplicityExpressions", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Namespaces                                                    
    	pkg  = factory.createPackage("Namespaces", "InfrastructureLibrary.Core.Abstractions.Namespaces", "Core-Abstractions-Namespaces", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Ownerships                                                    
    	pkg  = factory.createPackage("Ownerships", "InfrastructureLibrary.Core.Abstractions.Ownerships", "Core-Abstractions-Ownerships", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Redefinitions                                                    
    	pkg  = factory.createPackage("Redefinitions", "InfrastructureLibrary.Core.Abstractions.Redefinitions", "Core-Abstractions-Redefinitions", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Relationships                                                    
    	pkg  = factory.createPackage("Relationships", "InfrastructureLibrary.Core.Abstractions.Relationships", "Core-Abstractions-Relationships", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.StructuralFeatures                                                    
    	pkg  = factory.createPackage("StructuralFeatures", "InfrastructureLibrary.Core.Abstractions.StructuralFeatures", "Core-Abstractions-StructuralFeatures", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Super                                                    
    	pkg  = factory.createPackage("Super", "InfrastructureLibrary.Core.Abstractions.Super", "Core-Abstractions-Super", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.TypedElements                                                    
    	pkg  = factory.createPackage("TypedElements", "InfrastructureLibrary.Core.Abstractions.TypedElements", "Core-Abstractions-TypedElements", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Abstractions.Visibilities                                                    
    	pkg  = factory.createPackage("Visibilities", "InfrastructureLibrary.Core.Abstractions.Visibilities", "Core-Abstractions-Visibilities", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core.Abstractions", this); 
                
                     
        // InfrastructureLibrary.Core.Basic                                                    
    	pkg  = factory.createPackage("Basic", "InfrastructureLibrary.Core.Basic", "Core-Basic", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core", this); 
                
                     
        // InfrastructureLibrary.Core.Constructs                                                    
    	pkg  = factory.createPackage("Constructs", "InfrastructureLibrary.Core.Constructs", "Core-Constructs", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary.Core", this); 
                
                     
        // InfrastructureLibrary.Profiles                                                    
    	pkg  = factory.createPackage("Profiles", "InfrastructureLibrary.Profiles", "Profiles", pkg, this);
    	mapping.mapPackage(pkg, "InfrastructureLibrary", this); 
                        
        mapping.mapPackageMerge(pkg, "Core-Constructs");
            
    }   

    private void constructPrimitiveTypes()
    {
    Package pkg = null;
    String packageId = null;
    PrimitiveType type = null;
    
    }   
       
    private void constructClasses()
    {
        Package pkg = null;
        String packageId = null;
        Class_ clss = null;
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-BehavioralFeatures";   
                      
        // InfrastructureLibrary.Core.Abstractions.BehavioralFeatures.BehavioralFeature 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.BehavioralFeatures").getDelegate();       
    	clss  = factory.createClass("BehavioralFeature", "Core-Abstractions-BehavioralFeatures-BehavioralFeature", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.BehavioralFeatures", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-BehavioralFeatures";   
                      
        // InfrastructureLibrary.Core.Abstractions.BehavioralFeatures.Parameter 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.BehavioralFeatures").getDelegate();       
    	clss  = factory.createClass("Parameter", "Core-Abstractions-BehavioralFeatures-Parameter", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.BehavioralFeatures", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Changeabilities";   
                      
        // InfrastructureLibrary.Core.Abstractions.Changeabilities.StructuralFeature 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Changeabilities").getDelegate();       
    	clss  = factory.createClass("StructuralFeature", "Core-Abstractions-Changeabilities-StructuralFeature", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Changeabilities", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Classifiers";   
                      
        // InfrastructureLibrary.Core.Abstractions.Classifiers.Classifier 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Classifiers").getDelegate();       
    	clss  = factory.createClass("Classifier", "Core-Abstractions-Classifiers-Classifier", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Classifiers", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Classifiers";   
                      
        // InfrastructureLibrary.Core.Abstractions.Classifiers.Feature 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Classifiers").getDelegate();       
    	clss  = factory.createClass("Feature", "Core-Abstractions-Classifiers-Feature", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Classifiers", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Comments";   
                      
        // InfrastructureLibrary.Core.Abstractions.Comments.Comment 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Comments").getDelegate();       
    	clss  = factory.createClass("Comment", "Core-Abstractions-Comments-Comment", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Comments", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Constraints";   
                      
        // InfrastructureLibrary.Core.Abstractions.Constraints.Constraint 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Constraints").getDelegate();       
    	clss  = factory.createClass("Constraint", "Core-Abstractions-Constraints-Constraint", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Constraints", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Constraints";   
                      
        // InfrastructureLibrary.Core.Abstractions.Constraints.NamedElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Constraints").getDelegate();       
    	clss  = factory.createClass("NamedElement", "Core-Abstractions-Constraints-NamedElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Constraints", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Constraints";   
                      
        // InfrastructureLibrary.Core.Abstractions.Constraints.Namespace 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Constraints").getDelegate();       
    	clss  = factory.createClass("Namespace", "Core-Abstractions-Constraints-Namespace", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Constraints", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Elements";   
                      
        // InfrastructureLibrary.Core.Abstractions.Elements.Element 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Elements").getDelegate();       
    	clss  = factory.createClass("Element", "Core-Abstractions-Elements-Element", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Elements", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Expressions";   
                      
        // InfrastructureLibrary.Core.Abstractions.Expressions.Expression 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Expressions").getDelegate();       
    	clss  = factory.createClass("Expression", "Core-Abstractions-Expressions-Expression", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Expressions", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Expressions";   
                      
        // InfrastructureLibrary.Core.Abstractions.Expressions.OpaqueExpression 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Expressions").getDelegate();       
    	clss  = factory.createClass("OpaqueExpression", "Core-Abstractions-Expressions-OpaqueExpression", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Expressions", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Expressions";   
                      
        // InfrastructureLibrary.Core.Abstractions.Expressions.ValueSpecification 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Expressions").getDelegate();       
    	clss  = factory.createClass("ValueSpecification", "Core-Abstractions-Expressions-ValueSpecification", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Expressions", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Generalizations";   
                      
        // InfrastructureLibrary.Core.Abstractions.Generalizations.Classifier 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Generalizations").getDelegate();       
    	clss  = factory.createClass("Classifier", "Core-Abstractions-Generalizations-Classifier", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Generalizations", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Generalizations";   
                      
        // InfrastructureLibrary.Core.Abstractions.Generalizations.Generalization 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Generalizations").getDelegate();       
    	clss  = factory.createClass("Generalization", "Core-Abstractions-Generalizations-Generalization", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Generalizations", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Instances";   
                      
        // InfrastructureLibrary.Core.Abstractions.Instances.InstanceSpecification 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Instances").getDelegate();       
    	clss  = factory.createClass("InstanceSpecification", "Core-Abstractions-Instances-InstanceSpecification", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Instances", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Instances";   
                      
        // InfrastructureLibrary.Core.Abstractions.Instances.InstanceValue 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Instances").getDelegate();       
    	clss  = factory.createClass("InstanceValue", "Core-Abstractions-Instances-InstanceValue", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Instances", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Instances";   
                      
        // InfrastructureLibrary.Core.Abstractions.Instances.Slot 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Instances").getDelegate();       
    	clss  = factory.createClass("Slot", "Core-Abstractions-Instances-Slot", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Instances", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Literals";   
                      
        // InfrastructureLibrary.Core.Abstractions.Literals.LiteralBoolean 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Literals").getDelegate();       
    	clss  = factory.createClass("LiteralBoolean", "Core-Abstractions-Literals-LiteralBoolean", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Literals", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Literals";   
                      
        // InfrastructureLibrary.Core.Abstractions.Literals.LiteralInteger 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Literals").getDelegate();       
    	clss  = factory.createClass("LiteralInteger", "Core-Abstractions-Literals-LiteralInteger", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Literals", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Literals";   
                      
        // InfrastructureLibrary.Core.Abstractions.Literals.LiteralNull 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Literals").getDelegate();       
    	clss  = factory.createClass("LiteralNull", "Core-Abstractions-Literals-LiteralNull", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Literals", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Literals";   
                      
        // InfrastructureLibrary.Core.Abstractions.Literals.LiteralReal 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Literals").getDelegate();       
    	clss  = factory.createClass("LiteralReal", "Core-Abstractions-Literals-LiteralReal", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Literals", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Literals";   
                      
        // InfrastructureLibrary.Core.Abstractions.Literals.LiteralSpecification 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Literals").getDelegate();       
    	clss  = factory.createClass("LiteralSpecification", "Core-Abstractions-Literals-LiteralSpecification", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Literals", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Literals";   
                      
        // InfrastructureLibrary.Core.Abstractions.Literals.LiteralString 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Literals").getDelegate();       
    	clss  = factory.createClass("LiteralString", "Core-Abstractions-Literals-LiteralString", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Literals", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Literals";   
                      
        // InfrastructureLibrary.Core.Abstractions.Literals.LiteralUnlimitedNatural 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Literals").getDelegate();       
    	clss  = factory.createClass("LiteralUnlimitedNatural", "Core-Abstractions-Literals-LiteralUnlimitedNatural", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Literals", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Multiplicities";   
                      
        // InfrastructureLibrary.Core.Abstractions.Multiplicities.MultiplicityElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Multiplicities").getDelegate();       
    	clss  = factory.createClass("MultiplicityElement", "Core-Abstractions-Multiplicities-MultiplicityElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Multiplicities", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-MultiplicityExpressions";   
                      
        // InfrastructureLibrary.Core.Abstractions.MultiplicityExpressions.MultiplicityElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.MultiplicityExpressions").getDelegate();       
    	clss  = factory.createClass("MultiplicityElement", "Core-Abstractions-MultiplicityExpressions-MultiplicityElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.MultiplicityExpressions", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Namespaces";   
                      
        // InfrastructureLibrary.Core.Abstractions.Namespaces.NamedElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Namespaces").getDelegate();       
    	clss  = factory.createClass("NamedElement", "Core-Abstractions-Namespaces-NamedElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Namespaces", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Namespaces";   
                      
        // InfrastructureLibrary.Core.Abstractions.Namespaces.Namespace 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Namespaces").getDelegate();       
    	clss  = factory.createClass("Namespace", "Core-Abstractions-Namespaces-Namespace", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Namespaces", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Ownerships";   
                      
        // InfrastructureLibrary.Core.Abstractions.Ownerships.Element 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Ownerships").getDelegate();       
    	clss  = factory.createClass("Element", "Core-Abstractions-Ownerships-Element", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Ownerships", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Redefinitions";   
                      
        // InfrastructureLibrary.Core.Abstractions.Redefinitions.RedefinableElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Redefinitions").getDelegate();       
    	clss  = factory.createClass("RedefinableElement", "Core-Abstractions-Redefinitions-RedefinableElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Redefinitions", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Relationships";   
                      
        // InfrastructureLibrary.Core.Abstractions.Relationships.DirectedRelationship 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Relationships").getDelegate();       
    	clss  = factory.createClass("DirectedRelationship", "Core-Abstractions-Relationships-DirectedRelationship", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Relationships", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Relationships";   
                      
        // InfrastructureLibrary.Core.Abstractions.Relationships.Relationship 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Relationships").getDelegate();       
    	clss  = factory.createClass("Relationship", "Core-Abstractions-Relationships-Relationship", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Relationships", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-StructuralFeatures";   
                      
        // InfrastructureLibrary.Core.Abstractions.StructuralFeatures.StructuralFeature 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.StructuralFeatures").getDelegate();       
    	clss  = factory.createClass("StructuralFeature", "Core-Abstractions-StructuralFeatures-StructuralFeature", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.StructuralFeatures", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Super";   
                      
        // InfrastructureLibrary.Core.Abstractions.Super.Classifier 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Super").getDelegate();       
    	clss  = factory.createClass("Classifier", "Core-Abstractions-Super-Classifier", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Super", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-TypedElements";   
                      
        // InfrastructureLibrary.Core.Abstractions.TypedElements.Type 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.TypedElements").getDelegate();       
    	clss  = factory.createClass("Type", "Core-Abstractions-TypedElements-Type", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.TypedElements", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-TypedElements";   
                      
        // InfrastructureLibrary.Core.Abstractions.TypedElements.TypedElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.TypedElements").getDelegate();       
    	clss  = factory.createClass("TypedElement", "Core-Abstractions-TypedElements-TypedElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.TypedElements", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Visibilities";   
                      
        // InfrastructureLibrary.Core.Abstractions.Visibilities.NamedElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Abstractions.Visibilities").getDelegate();       
    	clss  = factory.createClass("NamedElement", "Core-Abstractions-Visibilities-NamedElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Abstractions.Visibilities", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.Class 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("Class", "Core-Basic-Class", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.Comment 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("Comment", "Core-Basic-Comment", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.DataType 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("DataType", "Core-Basic-DataType", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.Element 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("Element", "Core-Basic-Element", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.Enumeration 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("Enumeration", "Core-Basic-Enumeration", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.EnumerationLiteral 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("EnumerationLiteral", "Core-Basic-EnumerationLiteral", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.MultiplicityElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("MultiplicityElement", "Core-Basic-MultiplicityElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.NamedElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("NamedElement", "Core-Basic-NamedElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.Operation 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("Operation", "Core-Basic-Operation", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.Package 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("Package", "Core-Basic-Package", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.Parameter 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("Parameter", "Core-Basic-Parameter", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.PrimitiveType 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("PrimitiveType", "Core-Basic-PrimitiveType", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.Property 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("Property", "Core-Basic-Property", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.Type 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("Type", "Core-Basic-Type", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.TypedElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Basic").getDelegate();       
    	clss  = factory.createClass("TypedElement", "Core-Basic-TypedElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Basic", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Association 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Association", "Core-Constructs-Association", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.BehavioralFeature 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("BehavioralFeature", "Core-Constructs-BehavioralFeature", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Class 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Class", "Core-Constructs-Class", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Classifier 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Classifier", "Core-Constructs-Classifier", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Comment 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Comment", "Core-Constructs-Comment", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Constraint 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Constraint", "Core-Constructs-Constraint", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.DataType 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("DataType", "Core-Constructs-DataType", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.DirectedRelationship 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("DirectedRelationship", "Core-Constructs-DirectedRelationship", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Element 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Element", "Core-Constructs-Element", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.ElementImport 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("ElementImport", "Core-Constructs-ElementImport", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Enumeration 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Enumeration", "Core-Constructs-Enumeration", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.EnumerationLiteral 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("EnumerationLiteral", "Core-Constructs-EnumerationLiteral", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Expression 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Expression", "Core-Constructs-Expression", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Feature 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Feature", "Core-Constructs-Feature", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.MultiplicityElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("MultiplicityElement", "Core-Constructs-MultiplicityElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.NamedElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("NamedElement", "Core-Constructs-NamedElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Namespace 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Namespace", "Core-Constructs-Namespace", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.OpaqueExpression 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("OpaqueExpression", "Core-Constructs-OpaqueExpression", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Operation 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Operation", "Core-Constructs-Operation", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Package 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Package", "Core-Constructs-Package", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.PackageImport 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("PackageImport", "Core-Constructs-PackageImport", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.PackageMerge 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("PackageMerge", "Core-Constructs-PackageMerge", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.PackageableElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("PackageableElement", "Core-Constructs-PackageableElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Parameter 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Parameter", "Core-Constructs-Parameter", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.PrimitiveType 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("PrimitiveType", "Core-Constructs-PrimitiveType", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Property 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Property", "Core-Constructs-Property", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.RedefinableElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("RedefinableElement", "Core-Constructs-RedefinableElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Relationship 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Relationship", "Core-Constructs-Relationship", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.StructuralFeature 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("StructuralFeature", "Core-Constructs-StructuralFeature", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.Type 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("Type", "Core-Constructs-Type", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.TypedElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("TypedElement", "Core-Constructs-TypedElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.ValueSpecification 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Core.Constructs").getDelegate();       
    	clss  = factory.createClass("ValueSpecification", "Core-Constructs-ValueSpecification", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Core.Constructs", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.Class 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Profiles").getDelegate();       
    	clss  = factory.createClass("Class", "Profiles-Class", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Profiles", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.Extension 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Profiles").getDelegate();       
    	clss  = factory.createClass("Extension", "Profiles-Extension", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Profiles", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.ExtensionEnd 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Profiles").getDelegate();       
    	clss  = factory.createClass("ExtensionEnd", "Profiles-ExtensionEnd", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Profiles", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.Image 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Profiles").getDelegate();       
    	clss  = factory.createClass("Image", "Profiles-Image", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Profiles", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.NamedElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Profiles").getDelegate();       
    	clss  = factory.createClass("NamedElement", "Profiles-NamedElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Profiles", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.Package 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Profiles").getDelegate();       
    	clss  = factory.createClass("Package", "Profiles-Package", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Profiles", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.PackageableElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Profiles").getDelegate();       
    	clss  = factory.createClass("PackageableElement", "Profiles-PackageableElement", pkg);
    	clss.isAbstract = true;
    	((Classifier)clss).isAbstract = true;
    	mapping.mapClass(clss, "InfrastructureLibrary.Profiles", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.Profile 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Profiles").getDelegate();       
    	clss  = factory.createClass("Profile", "Profiles-Profile", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Profiles", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.ProfileApplication 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Profiles").getDelegate();       
    	clss  = factory.createClass("ProfileApplication", "Profiles-ProfileApplication", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Profiles", this); 
                                                      
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.Stereotype 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
        //pkg = model.getPackageByQualifiedName("InfrastructureLibrary.Profiles").getDelegate();       
    	clss  = factory.createClass("Stereotype", "Profiles-Stereotype", pkg);
    	clss.isAbstract = false;
    	((Classifier)clss).isAbstract = false;
    	mapping.mapClass(clss, "InfrastructureLibrary.Profiles", this); 
    
    }   

    private void constructEnumerations()
    {
        Enumeration enumeration = null;
        EnumerationLiteral literal = null;
                                                      
        // VisibilityKind
    	enumeration  = factory.createEnumeration("VisibilityKind", "Core-Abstractions-Visibilities-VisibilityKind");
    	mapping.mapEnumeration(enumeration, "InfrastructureLibrary.Core.Abstractions.Visibilities", this); 
        
        literal = factory.createEnumerationLiteral(enumeration, 
            "public",
            "Core-Abstractions-Visibilities-VisibilityKind-public");
    	mapping.mapEnumerationLiteral(literal, "InfrastructureLibrary.Core.Abstractions.Visibilities", this); 
        
        literal = factory.createEnumerationLiteral(enumeration, 
            "private",
            "Core-Abstractions-Visibilities-VisibilityKind-private");
    	mapping.mapEnumerationLiteral(literal, "InfrastructureLibrary.Core.Abstractions.Visibilities", this); 
        
        literal = factory.createEnumerationLiteral(enumeration, 
            "protected",
            "Core-Abstractions-Visibilities-VisibilityKind-protected");
    	mapping.mapEnumerationLiteral(literal, "InfrastructureLibrary.Core.Abstractions.Visibilities", this); 
        
        literal = factory.createEnumerationLiteral(enumeration, 
            "package",
            "Core-Abstractions-Visibilities-VisibilityKind-package");
    	mapping.mapEnumerationLiteral(literal, "InfrastructureLibrary.Core.Abstractions.Visibilities", this); 
                                                          
        // ParameterDirectionKind
    	enumeration  = factory.createEnumeration("ParameterDirectionKind", "Core-Constructs-ParameterDirectionKind");
    	mapping.mapEnumeration(enumeration, "InfrastructureLibrary.Core.Constructs", this); 
        
        literal = factory.createEnumerationLiteral(enumeration, 
            "in",
            "Core-Constructs-ParameterDirectionKind-in");
    	mapping.mapEnumerationLiteral(literal, "InfrastructureLibrary.Core.Constructs", this); 
        
        literal = factory.createEnumerationLiteral(enumeration, 
            "inout",
            "Core-Constructs-ParameterDirectionKind-inout");
    	mapping.mapEnumerationLiteral(literal, "InfrastructureLibrary.Core.Constructs", this); 
        
        literal = factory.createEnumerationLiteral(enumeration, 
            "out",
            "Core-Constructs-ParameterDirectionKind-out");
    	mapping.mapEnumerationLiteral(literal, "InfrastructureLibrary.Core.Constructs", this); 
        
        literal = factory.createEnumerationLiteral(enumeration, 
            "return",
            "Core-Constructs-ParameterDirectionKind-return");
    	mapping.mapEnumerationLiteral(literal, "InfrastructureLibrary.Core.Constructs", this); 
                                                          
        // VisibilityKind
    	enumeration  = factory.createEnumeration("VisibilityKind", "Core-Constructs-VisibilityKind");
    	mapping.mapEnumeration(enumeration, "InfrastructureLibrary.Core.Constructs", this); 
        
        literal = factory.createEnumerationLiteral(enumeration, 
            "public",
            "Core-Constructs-VisibilityKind-public");
    	mapping.mapEnumerationLiteral(literal, "InfrastructureLibrary.Core.Constructs", this); 
        
        literal = factory.createEnumerationLiteral(enumeration, 
            "private",
            "Core-Constructs-VisibilityKind-private");
    	mapping.mapEnumerationLiteral(literal, "InfrastructureLibrary.Core.Constructs", this); 
        
        literal = factory.createEnumerationLiteral(enumeration, 
            "protected",
            "Core-Constructs-VisibilityKind-protected");
    	mapping.mapEnumerationLiteral(literal, "InfrastructureLibrary.Core.Constructs", this); 
        
        literal = factory.createEnumerationLiteral(enumeration, 
            "package",
            "Core-Constructs-VisibilityKind-package");
    	mapping.mapEnumerationLiteral(literal, "InfrastructureLibrary.Core.Constructs", this); 
        
    }   

    private void constructProperties()
    {
        Class_ clss = null;
        Property prop = null;
        
    
        // BehavioralFeature
    	clss  = (Class_)model.getElementById("Core-Abstractions-BehavioralFeatures-BehavioralFeature").getDelegate();
    	
        // Parameter
    	clss  = (Class_)model.getElementById("Core-Abstractions-BehavioralFeatures-Parameter").getDelegate();
    	
        // StructuralFeature
    	clss  = (Class_)model.getElementById("Core-Abstractions-Changeabilities-StructuralFeature").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "isReadOnly", 
    	    "Core-Abstractions-Changeabilities-StructuralFeature-isReadOnly",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Abstractions-Changeabilities-StructuralFeature-isReadOnly-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	
        // Classifier
    	clss  = (Class_)model.getElementById("Core-Abstractions-Classifiers-Classifier").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "feature", 
    	    "Core-Abstractions-Classifiers-Classifier-feature",
    	    "Core-Abstractions-Classifiers-Feature",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Feature
    	clss  = (Class_)model.getElementById("Core-Abstractions-Classifiers-Feature").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "featuringClassifier", 
    	    "Core-Abstractions-Classifiers-Feature-featuringClassifier",
    	    "Core-Abstractions-Classifiers-Classifier",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Comment
    	clss  = (Class_)model.getElementById("Core-Abstractions-Comments-Comment").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "annotatedElement", 
    	    "Core-Abstractions-Comments-Comment-annotatedElement",
    	    "Core-Abstractions-Ownerships-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "body", 
    	    "Core-Abstractions-Comments-Comment-body",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Constraint
    	clss  = (Class_)model.getElementById("Core-Abstractions-Constraints-Constraint").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "constrainedElement", 
    	    "Core-Abstractions-Constraints-Constraint-constrainedElement",
    	    "Core-Abstractions-Ownerships-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "context", 
    	    "Core-Abstractions-Constraints-Constraint-context",
    	    "Core-Abstractions-Constraints-Namespace",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "specification", 
    	    "Core-Abstractions-Constraints-Constraint-specification",
    	    "Core-Abstractions-Expressions-ValueSpecification",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // NamedElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-Constraints-NamedElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "namespace", 
    	    "Core-Abstractions-Constraints-NamedElement-namespace",
    	    "Core-Abstractions-Constraints-Namespace",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Namespace
    	clss  = (Class_)model.getElementById("Core-Abstractions-Constraints-Namespace").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "member", 
    	    "Core-Abstractions-Constraints-Namespace-member",
    	    "Core-Abstractions-Constraints-NamedElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedMember", 
    	    "Core-Abstractions-Constraints-Namespace-ownedMember",
    	    "Core-Abstractions-Constraints-NamedElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedRule", 
    	    "Core-Abstractions-Constraints-Namespace-ownedRule",
    	    "Core-Abstractions-Constraints-Constraint",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Element
    	clss  = (Class_)model.getElementById("Core-Abstractions-Elements-Element").getDelegate();
    	
        // Expression
    	clss  = (Class_)model.getElementById("Core-Abstractions-Expressions-Expression").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "operand", 
    	    "Core-Abstractions-Expressions-Expression-operand",
    	    "Core-Abstractions-Expressions-ValueSpecification",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "symbol", 
    	    "Core-Abstractions-Expressions-Expression-symbol",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // OpaqueExpression
    	clss  = (Class_)model.getElementById("Core-Abstractions-Expressions-OpaqueExpression").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "body", 
    	    "Core-Abstractions-Expressions-OpaqueExpression-body",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "language", 
    	    "Core-Abstractions-Expressions-OpaqueExpression-language",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // ValueSpecification
    	clss  = (Class_)model.getElementById("Core-Abstractions-Expressions-ValueSpecification").getDelegate();
    	
        // Classifier
    	clss  = (Class_)model.getElementById("Core-Abstractions-Generalizations-Classifier").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "general", 
    	    "Core-Abstractions-Generalizations-Classifier-general",
    	    "Core-Abstractions-Generalizations-Classifier",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "generalization", 
    	    "Core-Abstractions-Generalizations-Classifier-generalization",
    	    "Core-Abstractions-Generalizations-Generalization",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Generalization
    	clss  = (Class_)model.getElementById("Core-Abstractions-Generalizations-Generalization").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "general", 
    	    "Core-Abstractions-Generalizations-Generalization-general",
    	    "Core-Abstractions-Generalizations-Classifier",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "specific", 
    	    "Core-Abstractions-Generalizations-Generalization-specific",
    	    "Core-Abstractions-Generalizations-Classifier",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // InstanceSpecification
    	clss  = (Class_)model.getElementById("Core-Abstractions-Instances-InstanceSpecification").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "classifier", 
    	    "Core-Abstractions-Instances-InstanceSpecification-classifier",
    	    "Core-Abstractions-Classifiers-Classifier",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "slot", 
    	    "Core-Abstractions-Instances-InstanceSpecification-slot",
    	    "Core-Abstractions-Instances-Slot",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "specification", 
    	    "Core-Abstractions-Instances-InstanceSpecification-specification",
    	    "Core-Abstractions-Expressions-ValueSpecification",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // InstanceValue
    	clss  = (Class_)model.getElementById("Core-Abstractions-Instances-InstanceValue").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "instance", 
    	    "Core-Abstractions-Instances-InstanceValue-instance",
    	    "Core-Abstractions-Instances-InstanceSpecification",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Slot
    	clss  = (Class_)model.getElementById("Core-Abstractions-Instances-Slot").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "definingFeature", 
    	    "Core-Abstractions-Instances-Slot-definingFeature",
    	    "Core-Abstractions-StructuralFeatures-StructuralFeature",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "owningInstance", 
    	    "Core-Abstractions-Instances-Slot-owningInstance",
    	    "Core-Abstractions-Instances-InstanceSpecification",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "value", 
    	    "Core-Abstractions-Instances-Slot-value",
    	    "Core-Abstractions-Expressions-ValueSpecification",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // LiteralBoolean
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralBoolean").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "value", 
    	    "Core-Abstractions-Literals-LiteralBoolean-value",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Abstractions-Literals-LiteralBoolean-value-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	
        // LiteralInteger
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralInteger").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "value", 
    	    "Core-Abstractions-Literals-LiteralInteger-value",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Integer",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Integer(0)
                ,
    	   "",
    	   "Core-Abstractions-Literals-LiteralInteger-value-_defaultValue",  
    	   "uml:LiteralInteger",  
    	   "");
    	
        // LiteralNull
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralNull").getDelegate();
    	
        // LiteralReal
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralReal").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "value", 
    	    "Core-Abstractions-Literals-LiteralReal-value",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Real",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // LiteralSpecification
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralSpecification").getDelegate();
    	
        // LiteralString
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralString").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "value", 
    	    "Core-Abstractions-Literals-LiteralString-value",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // LiteralUnlimitedNatural
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralUnlimitedNatural").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "value", 
    	    "Core-Abstractions-Literals-LiteralUnlimitedNatural-value",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#UnlimitedNatural",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new String(""),
    	   "",
    	   "Core-Abstractions-Literals-LiteralUnlimitedNatural-value-_defaultValue",  
    	   "uml:LiteralUnlimitedNatural",  
    	   "");
    	
        // MultiplicityElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-Multiplicities-MultiplicityElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "isOrdered", 
    	    "Core-Abstractions-Multiplicities-MultiplicityElement-isOrdered",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Abstractions-Multiplicities-MultiplicityElement-isOrdered-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "isUnique", 
    	    "Core-Abstractions-Multiplicities-MultiplicityElement-isUnique",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(true),
    	   "",
    	   "Core-Abstractions-Multiplicities-MultiplicityElement-isUnique-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "lower", 
    	    "Core-Abstractions-Multiplicities-MultiplicityElement-lower",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Integer",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Integer(1)
                ,
    	   "",
    	   "Core-Abstractions-Multiplicities-MultiplicityElement-lower-_defaultValue",  
    	   "uml:LiteralInteger",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "upper", 
    	    "Core-Abstractions-Multiplicities-MultiplicityElement-upper",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#UnlimitedNatural",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new String("1"),
    	   "",
    	   "Core-Abstractions-Multiplicities-MultiplicityElement-upper-_defaultValue",  
    	   "uml:LiteralUnlimitedNatural",  
    	   "");
    	
        // MultiplicityElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-MultiplicityExpressions-MultiplicityElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "lower", 
    	    "Core-Abstractions-MultiplicityExpressions-MultiplicityElement-lower",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Integer",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Integer(1)
                ,
    	   "",
    	   "Core-Abstractions-MultiplicityExpressions-MultiplicityElement-lower-_defaultValue",  
    	   "uml:LiteralInteger",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "lowerValue", 
    	    "Core-Abstractions-MultiplicityExpressions-MultiplicityElement-lowerValue",
    	    "Core-Abstractions-Expressions-ValueSpecification",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "upper", 
    	    "Core-Abstractions-MultiplicityExpressions-MultiplicityElement-upper",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#UnlimitedNatural",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new String("1"),
    	   "",
    	   "Core-Abstractions-MultiplicityExpressions-MultiplicityElement-upper-_defaultValue",  
    	   "uml:LiteralUnlimitedNatural",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "upperValue", 
    	    "Core-Abstractions-MultiplicityExpressions-MultiplicityElement-upperValue",
    	    "Core-Abstractions-Expressions-ValueSpecification",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // NamedElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-Namespaces-NamedElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "name", 
    	    "Core-Abstractions-Namespaces-NamedElement-name",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "namespace", 
    	    "Core-Abstractions-Namespaces-NamedElement-namespace",
    	    "Core-Abstractions-Namespaces-Namespace",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "qualifiedName", 
    	    "Core-Abstractions-Namespaces-NamedElement-qualifiedName",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Namespace
    	clss  = (Class_)model.getElementById("Core-Abstractions-Namespaces-Namespace").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "member", 
    	    "Core-Abstractions-Namespaces-Namespace-member",
    	    "Core-Abstractions-Namespaces-NamedElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedMember", 
    	    "Core-Abstractions-Namespaces-Namespace-ownedMember",
    	    "Core-Abstractions-Namespaces-NamedElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Element
    	clss  = (Class_)model.getElementById("Core-Abstractions-Ownerships-Element").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "ownedComment", 
    	    "Core-Abstractions-Ownerships-Element-ownedComment",
    	    "Core-Abstractions-Comments-Comment",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedElement", 
    	    "Core-Abstractions-Ownerships-Element-ownedElement",
    	    "Core-Abstractions-Ownerships-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "owner", 
    	    "Core-Abstractions-Ownerships-Element-owner",
    	    "Core-Abstractions-Ownerships-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // RedefinableElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-Redefinitions-RedefinableElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "redefinedElement", 
    	    "Core-Abstractions-Redefinitions-RedefinableElement-redefinedElement",
    	    "Core-Abstractions-Redefinitions-RedefinableElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "redefinitionContext", 
    	    "Core-Abstractions-Redefinitions-RedefinableElement-redefinitionContext",
    	    "Core-Abstractions-Super-Classifier",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // DirectedRelationship
    	clss  = (Class_)model.getElementById("Core-Abstractions-Relationships-DirectedRelationship").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "source", 
    	    "Core-Abstractions-Relationships-DirectedRelationship-source",
    	    "Core-Abstractions-Ownerships-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "target", 
    	    "Core-Abstractions-Relationships-DirectedRelationship-target",
    	    "Core-Abstractions-Ownerships-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Relationship
    	clss  = (Class_)model.getElementById("Core-Abstractions-Relationships-Relationship").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "relatedElement", 
    	    "Core-Abstractions-Relationships-Relationship-relatedElement",
    	    "Core-Abstractions-Ownerships-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // StructuralFeature
    	clss  = (Class_)model.getElementById("Core-Abstractions-StructuralFeatures-StructuralFeature").getDelegate();
    	
        // Classifier
    	clss  = (Class_)model.getElementById("Core-Abstractions-Super-Classifier").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "general", 
    	    "Core-Abstractions-Super-Classifier-general",
    	    "Core-Abstractions-Super-Classifier",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "inheritedMember", 
    	    "Core-Abstractions-Super-Classifier-inheritedMember",
    	    "Core-Abstractions-Namespaces-NamedElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "isAbstract", 
    	    "Core-Abstractions-Super-Classifier-isAbstract",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Abstractions-Super-Classifier-isAbstract-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	
        // Type
    	clss  = (Class_)model.getElementById("Core-Abstractions-TypedElements-Type").getDelegate();
    	
        // TypedElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-TypedElements-TypedElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "type", 
    	    "Core-Abstractions-TypedElements-TypedElement-type",
    	    "Core-Abstractions-TypedElements-Type",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // NamedElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-Visibilities-NamedElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "visibility", 
    	    "Core-Abstractions-Visibilities-NamedElement-visibility",
    	    "Core-Abstractions-Visibilities-VisibilityKind",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Class
    	clss  = (Class_)model.getElementById("Core-Basic-Class").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "isAbstract", 
    	    "Core-Basic-Class-isAbstract",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Basic-Class-isAbstract-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "ownedAttribute", 
    	    "Core-Basic-Class-ownedAttribute",
    	    "Core-Basic-Property",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedOperation", 
    	    "Core-Basic-Class-ownedOperation",
    	    "Core-Basic-Operation",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "superClass", 
    	    "Core-Basic-Class-superClass",
    	    "Core-Basic-Class",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Comment
    	clss  = (Class_)model.getElementById("Core-Basic-Comment").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "annotatedElement", 
    	    "Core-Basic-Comment-annotatedElement",
    	    "Core-Basic-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "body", 
    	    "Core-Basic-Comment-body",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // DataType
    	clss  = (Class_)model.getElementById("Core-Basic-DataType").getDelegate();
    	
        // Element
    	clss  = (Class_)model.getElementById("Core-Basic-Element").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "ownedComment", 
    	    "Core-Basic-Element-ownedComment",
    	    "Core-Basic-Comment",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Enumeration
    	clss  = (Class_)model.getElementById("Core-Basic-Enumeration").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "ownedLiteral", 
    	    "Core-Basic-Enumeration-ownedLiteral",
    	    "Core-Basic-EnumerationLiteral",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // EnumerationLiteral
    	clss  = (Class_)model.getElementById("Core-Basic-EnumerationLiteral").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "enumeration", 
    	    "Core-Basic-EnumerationLiteral-enumeration",
    	    "Core-Basic-Enumeration",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // MultiplicityElement
    	clss  = (Class_)model.getElementById("Core-Basic-MultiplicityElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "isOrdered", 
    	    "Core-Basic-MultiplicityElement-isOrdered",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Basic-MultiplicityElement-isOrdered-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "isUnique", 
    	    "Core-Basic-MultiplicityElement-isUnique",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(true),
    	   "",
    	   "Core-Basic-MultiplicityElement-isUnique-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "lower", 
    	    "Core-Basic-MultiplicityElement-lower",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Integer",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Integer(1)
                ,
    	   "",
    	   "Core-Basic-MultiplicityElement-lower-_defaultValue",  
    	   "uml:LiteralInteger",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "upper", 
    	    "Core-Basic-MultiplicityElement-upper",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#UnlimitedNatural",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new String("1"),
    	   "",
    	   "Core-Basic-MultiplicityElement-upper-_defaultValue",  
    	   "uml:LiteralUnlimitedNatural",  
    	   "");
    	
        // NamedElement
    	clss  = (Class_)model.getElementById("Core-Basic-NamedElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "name", 
    	    "Core-Basic-NamedElement-name",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Operation
    	clss  = (Class_)model.getElementById("Core-Basic-Operation").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "class", 
    	    "Core-Basic-Operation-class",
    	    "Core-Basic-Class",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedParameter", 
    	    "Core-Basic-Operation-ownedParameter",
    	    "Core-Basic-Parameter",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "raisedException", 
    	    "Core-Basic-Operation-raisedException",
    	    "Core-Basic-Type",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Package
    	clss  = (Class_)model.getElementById("Core-Basic-Package").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "nestedPackage", 
    	    "Core-Basic-Package-nestedPackage",
    	    "Core-Basic-Package",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "nestingPackage", 
    	    "Core-Basic-Package-nestingPackage",
    	    "Core-Basic-Package",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedType", 
    	    "Core-Basic-Package-ownedType",
    	    "Core-Basic-Type",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Parameter
    	clss  = (Class_)model.getElementById("Core-Basic-Parameter").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "operation", 
    	    "Core-Basic-Parameter-operation",
    	    "Core-Basic-Operation",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // PrimitiveType
    	clss  = (Class_)model.getElementById("Core-Basic-PrimitiveType").getDelegate();
    	
        // Property
    	clss  = (Class_)model.getElementById("Core-Basic-Property").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "class", 
    	    "Core-Basic-Property-class",
    	    "Core-Basic-Class",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "default", 
    	    "Core-Basic-Property-default",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "isComposite", 
    	    "Core-Basic-Property-isComposite",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Basic-Property-isComposite-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "isDerived", 
    	    "Core-Basic-Property-isDerived",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Basic-Property-isDerived-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "isID", 
    	    "Core-Basic-Property-isID",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Basic-Property-isID-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "isReadOnly", 
    	    "Core-Basic-Property-isReadOnly",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Basic-Property-isReadOnly-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "opposite", 
    	    "Core-Basic-Property-opposite",
    	    "Core-Basic-Property",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Type
    	clss  = (Class_)model.getElementById("Core-Basic-Type").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "package", 
    	    "Core-Basic-Type-package",
    	    "Core-Basic-Package",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // TypedElement
    	clss  = (Class_)model.getElementById("Core-Basic-TypedElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "type", 
    	    "Core-Basic-TypedElement-type",
    	    "Core-Basic-Type",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Association
    	clss  = (Class_)model.getElementById("Core-Constructs-Association").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "endType", 
    	    "Core-Constructs-Association-endType",
    	    "Core-Constructs-Type",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "isDerived", 
    	    "Core-Constructs-Association-isDerived",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Constructs-Association-isDerived-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "memberEnd", 
    	    "Core-Constructs-Association-memberEnd",
    	    "Core-Constructs-Property",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "2");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "navigableOwnedEnd", 
    	    "Core-Constructs-Association-navigableOwnedEnd",
    	    "Core-Constructs-Property",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedEnd", 
    	    "Core-Constructs-Association-ownedEnd",
    	    "Core-Constructs-Property",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // BehavioralFeature
    	clss  = (Class_)model.getElementById("Core-Constructs-BehavioralFeature").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "ownedParameter", 
    	    "Core-Constructs-BehavioralFeature-ownedParameter",
    	    "Core-Constructs-Parameter",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "raisedException", 
    	    "Core-Constructs-BehavioralFeature-raisedException",
    	    "Core-Constructs-Type",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Class
    	clss  = (Class_)model.getElementById("Core-Constructs-Class").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "isAbstract", 
    	    "Core-Constructs-Class-isAbstract",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Constructs-Class-isAbstract-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "ownedAttribute", 
    	    "Core-Constructs-Class-ownedAttribute",
    	    "Core-Constructs-Property",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedOperation", 
    	    "Core-Constructs-Class-ownedOperation",
    	    "Core-Constructs-Operation",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "superClass", 
    	    "Core-Constructs-Class-superClass",
    	    "Core-Constructs-Class",
    	    "Core-Constructs-Classifier-general",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Classifier
    	clss  = (Class_)model.getElementById("Core-Constructs-Classifier").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "attribute", 
    	    "Core-Constructs-Classifier-attribute",
    	    "Core-Constructs-Property",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "feature", 
    	    "Core-Constructs-Classifier-feature",
    	    "Core-Constructs-Feature",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "general", 
    	    "Core-Constructs-Classifier-general",
    	    "Core-Constructs-Classifier",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "inheritedMember", 
    	    "Core-Constructs-Classifier-inheritedMember",
    	    "Core-Constructs-NamedElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "isFinalSpecialization", 
    	    "Core-Constructs-Classifier-isFinalSpecialization",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Constructs-Classifier-isFinalSpecialization-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	
        // Comment
    	clss  = (Class_)model.getElementById("Core-Constructs-Comment").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "annotatedElement", 
    	    "Core-Constructs-Comment-annotatedElement",
    	    "Core-Constructs-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "body", 
    	    "Core-Constructs-Comment-body",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Constraint
    	clss  = (Class_)model.getElementById("Core-Constructs-Constraint").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "constrainedElement", 
    	    "Core-Constructs-Constraint-constrainedElement",
    	    "Core-Constructs-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "context", 
    	    "Core-Constructs-Constraint-context",
    	    "Core-Constructs-Namespace",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "specification", 
    	    "Core-Constructs-Constraint-specification",
    	    "Core-Constructs-ValueSpecification",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // DataType
    	clss  = (Class_)model.getElementById("Core-Constructs-DataType").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "ownedAttribute", 
    	    "Core-Constructs-DataType-ownedAttribute",
    	    "Core-Constructs-Property",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedOperation", 
    	    "Core-Constructs-DataType-ownedOperation",
    	    "Core-Constructs-Operation",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // DirectedRelationship
    	clss  = (Class_)model.getElementById("Core-Constructs-DirectedRelationship").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "source", 
    	    "Core-Constructs-DirectedRelationship-source",
    	    "Core-Constructs-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "target", 
    	    "Core-Constructs-DirectedRelationship-target",
    	    "Core-Constructs-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Element
    	clss  = (Class_)model.getElementById("Core-Constructs-Element").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "ownedComment", 
    	    "Core-Constructs-Element-ownedComment",
    	    "Core-Constructs-Comment",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedElement", 
    	    "Core-Constructs-Element-ownedElement",
    	    "Core-Constructs-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "owner", 
    	    "Core-Constructs-Element-owner",
    	    "Core-Constructs-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // ElementImport
    	clss  = (Class_)model.getElementById("Core-Constructs-ElementImport").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "alias", 
    	    "Core-Constructs-ElementImport-alias",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "importedElement", 
    	    "Core-Constructs-ElementImport-importedElement",
    	    "Core-Constructs-PackageableElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "importingNamespace", 
    	    "Core-Constructs-ElementImport-importingNamespace",
    	    "Core-Constructs-Namespace",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "visibility", 
    	    "Core-Constructs-ElementImport-visibility",
    	    "Core-Constructs-VisibilityKind",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new String(""),
    	   "Core-Constructs-VisibilityKind-public",
    	   "Core-Constructs-ElementImport-visibility-_defaultValue",  
    	   "uml:InstanceValue",  
    	   "Core-Constructs-VisibilityKind");
    	
        // Enumeration
    	clss  = (Class_)model.getElementById("Core-Constructs-Enumeration").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "ownedLiteral", 
    	    "Core-Constructs-Enumeration-ownedLiteral",
    	    "Core-Constructs-EnumerationLiteral",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // EnumerationLiteral
    	clss  = (Class_)model.getElementById("Core-Constructs-EnumerationLiteral").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "enumeration", 
    	    "Core-Constructs-EnumerationLiteral-enumeration",
    	    "Core-Constructs-Enumeration",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Expression
    	clss  = (Class_)model.getElementById("Core-Constructs-Expression").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "operand", 
    	    "Core-Constructs-Expression-operand",
    	    "Core-Constructs-ValueSpecification",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Feature
    	clss  = (Class_)model.getElementById("Core-Constructs-Feature").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "featuringClassifier", 
    	    "Core-Constructs-Feature-featuringClassifier",
    	    "Core-Constructs-Classifier",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // MultiplicityElement
    	clss  = (Class_)model.getElementById("Core-Constructs-MultiplicityElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "isOrdered", 
    	    "Core-Constructs-MultiplicityElement-isOrdered",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Constructs-MultiplicityElement-isOrdered-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "isUnique", 
    	    "Core-Constructs-MultiplicityElement-isUnique",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(true),
    	   "",
    	   "Core-Constructs-MultiplicityElement-isUnique-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "lower", 
    	    "Core-Constructs-MultiplicityElement-lower",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Integer",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Integer(1)
                ,
    	   "",
    	   "Core-Constructs-MultiplicityElement-lower-_defaultValue",  
    	   "uml:LiteralInteger",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "upper", 
    	    "Core-Constructs-MultiplicityElement-upper",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#UnlimitedNatural",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new String("1"),
    	   "",
    	   "Core-Constructs-MultiplicityElement-upper-_defaultValue",  
    	   "uml:LiteralUnlimitedNatural",  
    	   "");
    	
        // NamedElement
    	clss  = (Class_)model.getElementById("Core-Constructs-NamedElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "name", 
    	    "Core-Constructs-NamedElement-name",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "namespace", 
    	    "Core-Constructs-NamedElement-namespace",
    	    "Core-Constructs-Namespace",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "qualifiedName", 
    	    "Core-Constructs-NamedElement-qualifiedName",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "visibility", 
    	    "Core-Constructs-NamedElement-visibility",
    	    "Core-Constructs-VisibilityKind",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Namespace
    	clss  = (Class_)model.getElementById("Core-Constructs-Namespace").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "elementImport", 
    	    "Core-Constructs-Namespace-elementImport",
    	    "Core-Constructs-ElementImport",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "importedMember", 
    	    "Core-Constructs-Namespace-importedMember",
    	    "Core-Constructs-PackageableElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "member", 
    	    "Core-Constructs-Namespace-member",
    	    "Core-Constructs-NamedElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedMember", 
    	    "Core-Constructs-Namespace-ownedMember",
    	    "Core-Constructs-NamedElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedRule", 
    	    "Core-Constructs-Namespace-ownedRule",
    	    "Core-Constructs-Constraint",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "packageImport", 
    	    "Core-Constructs-Namespace-packageImport",
    	    "Core-Constructs-PackageImport",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // OpaqueExpression
    	clss  = (Class_)model.getElementById("Core-Constructs-OpaqueExpression").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "body", 
    	    "Core-Constructs-OpaqueExpression-body",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "language", 
    	    "Core-Constructs-OpaqueExpression-language",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Operation
    	clss  = (Class_)model.getElementById("Core-Constructs-Operation").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "bodyCondition", 
    	    "Core-Constructs-Operation-bodyCondition",
    	    "Core-Constructs-Constraint",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "class", 
    	    "Core-Constructs-Operation-class",
    	    "Core-Constructs-Class",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "datatype", 
    	    "Core-Constructs-Operation-datatype",
    	    "Core-Constructs-DataType",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "isOrdered", 
    	    "Core-Constructs-Operation-isOrdered",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Constructs-Operation-isOrdered-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "isQuery", 
    	    "Core-Constructs-Operation-isQuery",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Constructs-Operation-isQuery-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "isUnique", 
    	    "Core-Constructs-Operation-isUnique",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(true),
    	   "",
    	   "Core-Constructs-Operation-isUnique-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "lower", 
    	    "Core-Constructs-Operation-lower",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Integer",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Integer(1)
                ,
    	   "",
    	   "Core-Constructs-Operation-lower-_defaultValue",  
    	   "uml:LiteralInteger",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "ownedParameter", 
    	    "Core-Constructs-Operation-ownedParameter",
    	    "Core-Constructs-Parameter",
    	    "Core-Constructs-BehavioralFeature-ownedParameter",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "postcondition", 
    	    "Core-Constructs-Operation-postcondition",
    	    "Core-Constructs-Constraint",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "precondition", 
    	    "Core-Constructs-Operation-precondition",
    	    "Core-Constructs-Constraint",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "raisedException", 
    	    "Core-Constructs-Operation-raisedException",
    	    "Core-Constructs-Type",
    	    "Core-Constructs-BehavioralFeature-raisedException",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "redefinedOperation", 
    	    "Core-Constructs-Operation-redefinedOperation",
    	    "Core-Constructs-Operation",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "type", 
    	    "Core-Constructs-Operation-type",
    	    "Core-Constructs-Type",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "upper", 
    	    "Core-Constructs-Operation-upper",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#UnlimitedNatural",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new String("1"),
    	   "",
    	   "Core-Constructs-Operation-upper-_defaultValue",  
    	   "uml:LiteralUnlimitedNatural",  
    	   "");
    	
        // Package
    	clss  = (Class_)model.getElementById("Core-Constructs-Package").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "URI", 
    	    "Core-Constructs-Package-URI",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "nestedPackage", 
    	    "Core-Constructs-Package-nestedPackage",
    	    "Core-Constructs-Package",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "nestingPackage", 
    	    "Core-Constructs-Package-nestingPackage",
    	    "Core-Constructs-Package",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedType", 
    	    "Core-Constructs-Package-ownedType",
    	    "Core-Constructs-Type",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "packageMerge", 
    	    "Core-Constructs-Package-packageMerge",
    	    "Core-Constructs-PackageMerge",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "packagedElement", 
    	    "Core-Constructs-Package-packagedElement",
    	    "Core-Constructs-PackageableElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // PackageImport
    	clss  = (Class_)model.getElementById("Core-Constructs-PackageImport").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "importedPackage", 
    	    "Core-Constructs-PackageImport-importedPackage",
    	    "Core-Constructs-Package",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "importingNamespace", 
    	    "Core-Constructs-PackageImport-importingNamespace",
    	    "Core-Constructs-Namespace",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "visibility", 
    	    "Core-Constructs-PackageImport-visibility",
    	    "Core-Constructs-VisibilityKind",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new String(""),
    	   "Core-Constructs-VisibilityKind-public",
    	   "Core-Constructs-PackageImport-visibility-_defaultValue",  
    	   "uml:InstanceValue",  
    	   "Core-Constructs-VisibilityKind");
    	
        // PackageMerge
    	clss  = (Class_)model.getElementById("Core-Constructs-PackageMerge").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "mergedPackage", 
    	    "Core-Constructs-PackageMerge-mergedPackage",
    	    "Core-Constructs-Package",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "receivingPackage", 
    	    "Core-Constructs-PackageMerge-receivingPackage",
    	    "Core-Constructs-Package",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // PackageableElement
    	clss  = (Class_)model.getElementById("Core-Constructs-PackageableElement").getDelegate();
    	
        // Parameter
    	clss  = (Class_)model.getElementById("Core-Constructs-Parameter").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "default", 
    	    "Core-Constructs-Parameter-default",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "direction", 
    	    "Core-Constructs-Parameter-direction",
    	    "Core-Constructs-ParameterDirectionKind",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new String(""),
    	   "Core-Constructs-ParameterDirectionKind-in",
    	   "Core-Constructs-Parameter-direction-_defaultValue",  
    	   "uml:InstanceValue",  
    	   "Core-Constructs-ParameterDirectionKind");
    	    	
    	prop = factory.createProperty(clss, "operation", 
    	    "Core-Constructs-Parameter-operation",
    	    "Core-Constructs-Operation",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // PrimitiveType
    	clss  = (Class_)model.getElementById("Core-Constructs-PrimitiveType").getDelegate();
    	
        // Property
    	clss  = (Class_)model.getElementById("Core-Constructs-Property").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "association", 
    	    "Core-Constructs-Property-association",
    	    "Core-Constructs-Association",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "class", 
    	    "Core-Constructs-Property-class",
    	    "Core-Constructs-Class",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "datatype", 
    	    "Core-Constructs-Property-datatype",
    	    "Core-Constructs-DataType",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "default", 
    	    "Core-Constructs-Property-default",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "isComposite", 
    	    "Core-Constructs-Property-isComposite",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Constructs-Property-isComposite-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "isDerived", 
    	    "Core-Constructs-Property-isDerived",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Constructs-Property-isDerived-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "isDerivedUnion", 
    	    "Core-Constructs-Property-isDerivedUnion",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Constructs-Property-isDerivedUnion-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "isID", 
    	    "Core-Constructs-Property-isID",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Constructs-Property-isID-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "isReadOnly", 
    	    "Core-Constructs-Property-isReadOnly",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Constructs-Property-isReadOnly-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "opposite", 
    	    "Core-Constructs-Property-opposite",
    	    "Core-Constructs-Property",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "owningAssociation", 
    	    "Core-Constructs-Property-owningAssociation",
    	    "Core-Constructs-Association",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "redefinedProperty", 
    	    "Core-Constructs-Property-redefinedProperty",
    	    "Core-Constructs-Property",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "subsettedProperty", 
    	    "Core-Constructs-Property-subsettedProperty",
    	    "Core-Constructs-Property",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // RedefinableElement
    	clss  = (Class_)model.getElementById("Core-Constructs-RedefinableElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "isLeaf", 
    	    "Core-Constructs-RedefinableElement-isLeaf",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Core-Constructs-RedefinableElement-isLeaf-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "redefinedElement", 
    	    "Core-Constructs-RedefinableElement-redefinedElement",
    	    "Core-Constructs-RedefinableElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "redefinitionContext", 
    	    "Core-Constructs-RedefinableElement-redefinitionContext",
    	    "Core-Constructs-Classifier",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Relationship
    	clss  = (Class_)model.getElementById("Core-Constructs-Relationship").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "relatedElement", 
    	    "Core-Constructs-Relationship-relatedElement",
    	    "Core-Constructs-Element",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // StructuralFeature
    	clss  = (Class_)model.getElementById("Core-Constructs-StructuralFeature").getDelegate();
    	
        // Type
    	clss  = (Class_)model.getElementById("Core-Constructs-Type").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "package", 
    	    "Core-Constructs-Type-package",
    	    "Core-Constructs-Package",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // TypedElement
    	clss  = (Class_)model.getElementById("Core-Constructs-TypedElement").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "type", 
    	    "Core-Constructs-TypedElement-type",
    	    "Core-Constructs-Type",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // ValueSpecification
    	clss  = (Class_)model.getElementById("Core-Constructs-ValueSpecification").getDelegate();
    	
        // Class
    	clss  = (Class_)model.getElementById("Profiles-Class").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "extension", 
    	    "Profiles-Class-extension",
    	    "Profiles-Extension",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Extension
    	clss  = (Class_)model.getElementById("Profiles-Extension").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "isRequired", 
    	    "Profiles-Extension-isRequired",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Profiles-Extension-isRequired-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "metaclass", 
    	    "Profiles-Extension-metaclass",
    	    "Profiles-Class",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "ownedEnd", 
    	    "Profiles-Extension-ownedEnd",
    	    "Profiles-ExtensionEnd",
    	    "Core-Constructs-Association-ownedEnd",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // ExtensionEnd
    	clss  = (Class_)model.getElementById("Profiles-ExtensionEnd").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "lower", 
    	    "Profiles-ExtensionEnd-lower",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Integer",
    	    "Core-Constructs-MultiplicityElement-lower",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Integer(0)
                ,
    	   "",
    	   "Profiles-ExtensionEnd-lower-_defaultValue",  
    	   "uml:LiteralInteger",  
    	   "");
    	    	
    	prop = factory.createProperty(clss, "type", 
    	    "Profiles-ExtensionEnd-type",
    	    "Profiles-Stereotype",
    	    "Core-Constructs-TypedElement-type",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // Image
    	clss  = (Class_)model.getElementById("Profiles-Image").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "content", 
    	    "Profiles-Image-content",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "format", 
    	    "Profiles-Image-format",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "location", 
    	    "Profiles-Image-location",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#String",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // NamedElement
    	clss  = (Class_)model.getElementById("Profiles-NamedElement").getDelegate();
    	
        // Package
    	clss  = (Class_)model.getElementById("Profiles-Package").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "ownedStereotype", 
    	    "Profiles-Package-ownedStereotype",
    	    "Profiles-Stereotype",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "packagedElement", 
    	    "Profiles-Package-packagedElement",
    	    "Profiles-PackageableElement",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "profileApplication", 
    	    "Profiles-Package-profileApplication",
    	    "Profiles-ProfileApplication",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // PackageableElement
    	clss  = (Class_)model.getElementById("Profiles-PackageableElement").getDelegate();
    	
        // Profile
    	clss  = (Class_)model.getElementById("Profiles-Profile").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "metaclassReference", 
    	    "Profiles-Profile-metaclassReference",
    	    "Core-Constructs-ElementImport",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "metamodelReference", 
    	    "Profiles-Profile-metamodelReference",
    	    "Core-Constructs-PackageImport",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
        // ProfileApplication
    	clss  = (Class_)model.getElementById("Profiles-ProfileApplication").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "appliedProfile", 
    	    "Profiles-ProfileApplication-appliedProfile",
    	    "Profiles-Profile",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "applyingPackage", 
    	    "Profiles-ProfileApplication-applyingPackage",
    	    "Profiles-Package",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "isStrict", 
    	    "Profiles-ProfileApplication-isStrict",
    	    "http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi#Boolean",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
     	factory.createDefault(prop,
    	   new Boolean(false),
    	   "",
    	   "Profiles-ProfileApplication-isStrict-_defaultValue",  
    	   "uml:LiteralBoolean",  
    	   "");
    	
        // Stereotype
    	clss  = (Class_)model.getElementById("Profiles-Stereotype").getDelegate();
    	    	
    	prop = factory.createProperty(clss, "icon", 
    	    "Profiles-Stereotype-icon",
    	    "Profiles-Image",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(clss, prop, this);    
     	
    	    	
    	prop = factory.createProperty(clss, "profile", 
    	    "Profiles-Stereotype-profile",
    	    "Profiles-Profile",
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(clss, prop, this);    
     	
    	
    }
    
    private void constructGeneralizations()
    {
        Class_ clss = null;
        
    
        // BehavioralFeature
    	clss  = (Class_)model.getElementById("Core-Abstractions-BehavioralFeatures-BehavioralFeature").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Classifiers-Feature");
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Namespaces-Namespace");
    	
        // Parameter
    	clss  = (Class_)model.getElementById("Core-Abstractions-BehavioralFeatures-Parameter").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-TypedElements-TypedElement");
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Namespaces-NamedElement");
    	
        // StructuralFeature
    	clss  = (Class_)model.getElementById("Core-Abstractions-Changeabilities-StructuralFeature").getDelegate();
    	
        // Classifier
    	clss  = (Class_)model.getElementById("Core-Abstractions-Classifiers-Classifier").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Namespaces-Namespace");
    	
        // Feature
    	clss  = (Class_)model.getElementById("Core-Abstractions-Classifiers-Feature").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Namespaces-NamedElement");
    	
        // Comment
    	clss  = (Class_)model.getElementById("Core-Abstractions-Comments-Comment").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Ownerships-Element");
    	
        // Constraint
    	clss  = (Class_)model.getElementById("Core-Abstractions-Constraints-Constraint").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Constraints-NamedElement");
    	
        // NamedElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-Constraints-NamedElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Ownerships-Element");
    	
        // Namespace
    	clss  = (Class_)model.getElementById("Core-Abstractions-Constraints-Namespace").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Constraints-NamedElement");
    	
        // Element
    	clss  = (Class_)model.getElementById("Core-Abstractions-Elements-Element").getDelegate();
    	
        // Expression
    	clss  = (Class_)model.getElementById("Core-Abstractions-Expressions-Expression").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Expressions-ValueSpecification");
    	
        // OpaqueExpression
    	clss  = (Class_)model.getElementById("Core-Abstractions-Expressions-OpaqueExpression").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Expressions-ValueSpecification");
    	
        // ValueSpecification
    	clss  = (Class_)model.getElementById("Core-Abstractions-Expressions-ValueSpecification").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Ownerships-Element");
    	
        // Classifier
    	clss  = (Class_)model.getElementById("Core-Abstractions-Generalizations-Classifier").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-TypedElements-Type");
    	
        // Generalization
    	clss  = (Class_)model.getElementById("Core-Abstractions-Generalizations-Generalization").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Relationships-DirectedRelationship");
    	
        // InstanceSpecification
    	clss  = (Class_)model.getElementById("Core-Abstractions-Instances-InstanceSpecification").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Namespaces-NamedElement");
    	
        // InstanceValue
    	clss  = (Class_)model.getElementById("Core-Abstractions-Instances-InstanceValue").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Expressions-ValueSpecification");
    	
        // Slot
    	clss  = (Class_)model.getElementById("Core-Abstractions-Instances-Slot").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Ownerships-Element");
    	
        // LiteralBoolean
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralBoolean").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Literals-LiteralSpecification");
    	
        // LiteralInteger
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralInteger").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Literals-LiteralSpecification");
    	
        // LiteralNull
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralNull").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Literals-LiteralSpecification");
    	
        // LiteralReal
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralReal").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Literals-LiteralSpecification");
    	
        // LiteralSpecification
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralSpecification").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Expressions-ValueSpecification");
    	
        // LiteralString
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralString").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Literals-LiteralSpecification");
    	
        // LiteralUnlimitedNatural
    	clss  = (Class_)model.getElementById("Core-Abstractions-Literals-LiteralUnlimitedNatural").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Literals-LiteralSpecification");
    	
        // MultiplicityElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-Multiplicities-MultiplicityElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Elements-Element");
    	
        // MultiplicityElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-MultiplicityExpressions-MultiplicityElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Ownerships-Element");
    	
        // NamedElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-Namespaces-NamedElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Ownerships-Element");
    	
        // Namespace
    	clss  = (Class_)model.getElementById("Core-Abstractions-Namespaces-Namespace").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Namespaces-NamedElement");
    	
        // Element
    	clss  = (Class_)model.getElementById("Core-Abstractions-Ownerships-Element").getDelegate();
    	
        // RedefinableElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-Redefinitions-RedefinableElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Namespaces-NamedElement");
    	
        // DirectedRelationship
    	clss  = (Class_)model.getElementById("Core-Abstractions-Relationships-DirectedRelationship").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Relationships-Relationship");
    	
        // Relationship
    	clss  = (Class_)model.getElementById("Core-Abstractions-Relationships-Relationship").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Ownerships-Element");
    	
        // StructuralFeature
    	clss  = (Class_)model.getElementById("Core-Abstractions-StructuralFeatures-StructuralFeature").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-TypedElements-TypedElement");
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Classifiers-Feature");
    	
        // Classifier
    	clss  = (Class_)model.getElementById("Core-Abstractions-Super-Classifier").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Namespaces-Namespace");
    	
        // Type
    	clss  = (Class_)model.getElementById("Core-Abstractions-TypedElements-Type").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Namespaces-NamedElement");
    	
        // TypedElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-TypedElements-TypedElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Abstractions-Namespaces-NamedElement");
    	
        // NamedElement
    	clss  = (Class_)model.getElementById("Core-Abstractions-Visibilities-NamedElement").getDelegate();
    	
        // Class
    	clss  = (Class_)model.getElementById("Core-Basic-Class").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-Type");
    	
        // Comment
    	clss  = (Class_)model.getElementById("Core-Basic-Comment").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-Element");
    	
        // DataType
    	clss  = (Class_)model.getElementById("Core-Basic-DataType").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-Type");
    	
        // Element
    	clss  = (Class_)model.getElementById("Core-Basic-Element").getDelegate();
    	
        // Enumeration
    	clss  = (Class_)model.getElementById("Core-Basic-Enumeration").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-DataType");
    	
        // EnumerationLiteral
    	clss  = (Class_)model.getElementById("Core-Basic-EnumerationLiteral").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-NamedElement");
    	
        // MultiplicityElement
    	clss  = (Class_)model.getElementById("Core-Basic-MultiplicityElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-Element");
    	
        // NamedElement
    	clss  = (Class_)model.getElementById("Core-Basic-NamedElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-Element");
    	
        // Operation
    	clss  = (Class_)model.getElementById("Core-Basic-Operation").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-TypedElement");
    	
    	factory.createGeneralization(clss, "Core-Basic-MultiplicityElement");
    	
        // Package
    	clss  = (Class_)model.getElementById("Core-Basic-Package").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-NamedElement");
    	
        // Parameter
    	clss  = (Class_)model.getElementById("Core-Basic-Parameter").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-MultiplicityElement");
    	
    	factory.createGeneralization(clss, "Core-Basic-TypedElement");
    	
        // PrimitiveType
    	clss  = (Class_)model.getElementById("Core-Basic-PrimitiveType").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-DataType");
    	
        // Property
    	clss  = (Class_)model.getElementById("Core-Basic-Property").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-TypedElement");
    	
    	factory.createGeneralization(clss, "Core-Basic-MultiplicityElement");
    	
        // Type
    	clss  = (Class_)model.getElementById("Core-Basic-Type").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-NamedElement");
    	
        // TypedElement
    	clss  = (Class_)model.getElementById("Core-Basic-TypedElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Basic-NamedElement");
    	
        // Association
    	clss  = (Class_)model.getElementById("Core-Constructs-Association").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Relationship");
    	
    	factory.createGeneralization(clss, "Core-Constructs-Classifier");
    	
        // BehavioralFeature
    	clss  = (Class_)model.getElementById("Core-Constructs-BehavioralFeature").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Namespace");
    	
    	factory.createGeneralization(clss, "Core-Constructs-Feature");
    	
        // Class
    	clss  = (Class_)model.getElementById("Core-Constructs-Class").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Classifier");
    	
        // Classifier
    	clss  = (Class_)model.getElementById("Core-Constructs-Classifier").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Type");
    	
    	factory.createGeneralization(clss, "Core-Constructs-Namespace");
    	
        // Comment
    	clss  = (Class_)model.getElementById("Core-Constructs-Comment").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Element");
    	
        // Constraint
    	clss  = (Class_)model.getElementById("Core-Constructs-Constraint").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-PackageableElement");
    	
        // DataType
    	clss  = (Class_)model.getElementById("Core-Constructs-DataType").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Classifier");
    	
        // DirectedRelationship
    	clss  = (Class_)model.getElementById("Core-Constructs-DirectedRelationship").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Relationship");
    	
        // Element
    	clss  = (Class_)model.getElementById("Core-Constructs-Element").getDelegate();
    	
        // ElementImport
    	clss  = (Class_)model.getElementById("Core-Constructs-ElementImport").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-DirectedRelationship");
    	
        // Enumeration
    	clss  = (Class_)model.getElementById("Core-Constructs-Enumeration").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-DataType");
    	
        // EnumerationLiteral
    	clss  = (Class_)model.getElementById("Core-Constructs-EnumerationLiteral").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-NamedElement");
    	
        // Expression
    	clss  = (Class_)model.getElementById("Core-Constructs-Expression").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-ValueSpecification");
    	
        // Feature
    	clss  = (Class_)model.getElementById("Core-Constructs-Feature").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-RedefinableElement");
    	
        // MultiplicityElement
    	clss  = (Class_)model.getElementById("Core-Constructs-MultiplicityElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Element");
    	
        // NamedElement
    	clss  = (Class_)model.getElementById("Core-Constructs-NamedElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Element");
    	
        // Namespace
    	clss  = (Class_)model.getElementById("Core-Constructs-Namespace").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-NamedElement");
    	
        // OpaqueExpression
    	clss  = (Class_)model.getElementById("Core-Constructs-OpaqueExpression").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-ValueSpecification");
    	
        // Operation
    	clss  = (Class_)model.getElementById("Core-Constructs-Operation").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-BehavioralFeature");
    	
        // Package
    	clss  = (Class_)model.getElementById("Core-Constructs-Package").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-PackageableElement");
    	
    	factory.createGeneralization(clss, "Core-Constructs-Namespace");
    	
        // PackageImport
    	clss  = (Class_)model.getElementById("Core-Constructs-PackageImport").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-DirectedRelationship");
    	
        // PackageMerge
    	clss  = (Class_)model.getElementById("Core-Constructs-PackageMerge").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-DirectedRelationship");
    	
        // PackageableElement
    	clss  = (Class_)model.getElementById("Core-Constructs-PackageableElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-NamedElement");
    	
        // Parameter
    	clss  = (Class_)model.getElementById("Core-Constructs-Parameter").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-MultiplicityElement");
    	
    	factory.createGeneralization(clss, "Core-Constructs-TypedElement");
    	
        // PrimitiveType
    	clss  = (Class_)model.getElementById("Core-Constructs-PrimitiveType").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-DataType");
    	
        // Property
    	clss  = (Class_)model.getElementById("Core-Constructs-Property").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-StructuralFeature");
    	
        // RedefinableElement
    	clss  = (Class_)model.getElementById("Core-Constructs-RedefinableElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-NamedElement");
    	
        // Relationship
    	clss  = (Class_)model.getElementById("Core-Constructs-Relationship").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Element");
    	
        // StructuralFeature
    	clss  = (Class_)model.getElementById("Core-Constructs-StructuralFeature").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-TypedElement");
    	
    	factory.createGeneralization(clss, "Core-Constructs-MultiplicityElement");
    	
    	factory.createGeneralization(clss, "Core-Constructs-Feature");
    	
        // Type
    	clss  = (Class_)model.getElementById("Core-Constructs-Type").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-PackageableElement");
    	
        // TypedElement
    	clss  = (Class_)model.getElementById("Core-Constructs-TypedElement").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-NamedElement");
    	
        // ValueSpecification
    	clss  = (Class_)model.getElementById("Core-Constructs-ValueSpecification").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-TypedElement");
    	
    	factory.createGeneralization(clss, "Core-Constructs-PackageableElement");
    	
        // Class
    	clss  = (Class_)model.getElementById("Profiles-Class").getDelegate();
    	
    	factory.createGeneralization(clss, "Profiles-PackageableElement");
    	
    	factory.createGeneralization(clss, "Core-Constructs-Classifier");
    	
        // Extension
    	clss  = (Class_)model.getElementById("Profiles-Extension").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Association");
    	
        // ExtensionEnd
    	clss  = (Class_)model.getElementById("Profiles-ExtensionEnd").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Property");
    	
        // Image
    	clss  = (Class_)model.getElementById("Profiles-Image").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Element");
    	
        // NamedElement
    	clss  = (Class_)model.getElementById("Profiles-NamedElement").getDelegate();
    	
        // Package
    	clss  = (Class_)model.getElementById("Profiles-Package").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-Namespace");
    	
        // PackageableElement
    	clss  = (Class_)model.getElementById("Profiles-PackageableElement").getDelegate();
    	
        // Profile
    	clss  = (Class_)model.getElementById("Profiles-Profile").getDelegate();
    	
    	factory.createGeneralization(clss, "Profiles-Package");
    	
    	factory.createGeneralization(clss, "Core-Constructs-Package");
    	
        // ProfileApplication
    	clss  = (Class_)model.getElementById("Profiles-ProfileApplication").getDelegate();
    	
    	factory.createGeneralization(clss, "Core-Constructs-DirectedRelationship");
    	
        // Stereotype
    	clss  = (Class_)model.getElementById("Profiles-Stereotype").getDelegate();
    	
    	factory.createGeneralization(clss, "Profiles-Class");
    	
    }

    private void constructAssociations()
    {
        Package pkg = null;
        String packageId = null;
        Association assoc = null;
        Property prop = null;
        
                                                      
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Classifiers";   
                      
        // InfrastructureLibrary.Core.Abstractions.Classifiers.A_feature_featuringClassifier 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_feature_featuringClassifier", "Core-Abstractions-Classifiers-A_feature_featuringClassifier");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Classifiers", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Classifiers-Classifier-feature Core-Abstractions-Classifiers-Feature-featuringClassifier");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Comments";   
                      
        // InfrastructureLibrary.Core.Abstractions.Comments.A_annotatedElement_comment 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_annotatedElement_comment", "Core-Abstractions-Comments-A_annotatedElement_comment");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Comments", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "comment", 
    	    "Core-Abstractions-Comments-A_annotatedElement_comment-comment",
    	    "Core-Abstractions-Comments-Comment",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Comments-Comment-annotatedElement Core-Abstractions-Comments-A_annotatedElement_comment-comment");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Constraints";   
                      
        // InfrastructureLibrary.Core.Abstractions.Constraints.A_constrainedElement_constraint 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_constrainedElement_constraint", "Core-Abstractions-Constraints-A_constrainedElement_constraint");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Constraints", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "constraint", 
    	    "Core-Abstractions-Constraints-A_constrainedElement_constraint-constraint",
    	    "Core-Abstractions-Constraints-Constraint",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Constraints-Constraint-constrainedElement Core-Abstractions-Constraints-A_constrainedElement_constraint-constraint");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Constraints";   
                      
        // InfrastructureLibrary.Core.Abstractions.Constraints.A_member_memberNamespace 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_member_memberNamespace", "Core-Abstractions-Constraints-A_member_memberNamespace");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Constraints", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "memberNamespace", 
    	    "Core-Abstractions-Constraints-A_member_memberNamespace-memberNamespace",
    	    "Core-Abstractions-Constraints-Namespace",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Constraints-Namespace-member Core-Abstractions-Constraints-A_member_memberNamespace-memberNamespace");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Constraints";   
                      
        // InfrastructureLibrary.Core.Abstractions.Constraints.A_ownedMember_namespace 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedMember_namespace", "Core-Abstractions-Constraints-A_ownedMember_namespace");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Constraints", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Constraints-Namespace-ownedMember Core-Abstractions-Constraints-NamedElement-namespace");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Constraints";   
                      
        // InfrastructureLibrary.Core.Abstractions.Constraints.A_ownedRule_context 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedRule_context", "Core-Abstractions-Constraints-A_ownedRule_context");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Constraints", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Constraints-Namespace-ownedRule Core-Abstractions-Constraints-Constraint-context");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Constraints";   
                      
        // InfrastructureLibrary.Core.Abstractions.Constraints.A_specification_owningConstraint 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_specification_owningConstraint", "Core-Abstractions-Constraints-A_specification_owningConstraint");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Constraints", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "owningConstraint", 
    	    "Core-Abstractions-Constraints-A_specification_owningConstraint-owningConstraint",
    	    "Core-Abstractions-Constraints-Constraint",
    	    "Core-Abstractions-Ownerships-Element-owner",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Constraints-Constraint-specification Core-Abstractions-Constraints-A_specification_owningConstraint-owningConstraint");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Expressions";   
                      
        // InfrastructureLibrary.Core.Abstractions.Expressions.A_operand_expression 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_operand_expression", "Core-Abstractions-Expressions-A_operand_expression");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Expressions", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "expression", 
    	    "Core-Abstractions-Expressions-A_operand_expression-expression",
    	    "Core-Abstractions-Expressions-Expression",
    	    "Core-Abstractions-Ownerships-Element-owner",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Expressions-Expression-operand Core-Abstractions-Expressions-A_operand_expression-expression");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Generalizations";   
                      
        // InfrastructureLibrary.Core.Abstractions.Generalizations.A_general_classifier 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_general_classifier", "Core-Abstractions-Generalizations-A_general_classifier");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Generalizations", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "classifier", 
    	    "Core-Abstractions-Generalizations-A_general_classifier-classifier",
    	    "Core-Abstractions-Generalizations-Classifier",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Generalizations-Classifier-general Core-Abstractions-Generalizations-A_general_classifier-classifier");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Generalizations";   
                      
        // InfrastructureLibrary.Core.Abstractions.Generalizations.A_general_generalization 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_general_generalization", "Core-Abstractions-Generalizations-A_general_generalization");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Generalizations", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "generalization", 
    	    "Core-Abstractions-Generalizations-A_general_generalization-generalization",
    	    "Core-Abstractions-Generalizations-Generalization",
    	    "Core-Abstractions-Relationships-A_target_directedRelationship-directedRelationship",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Generalizations-Generalization-general Core-Abstractions-Generalizations-A_general_generalization-generalization");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Generalizations";   
                      
        // InfrastructureLibrary.Core.Abstractions.Generalizations.A_generalization_specific 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_generalization_specific", "Core-Abstractions-Generalizations-A_generalization_specific");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Generalizations", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Generalizations-Classifier-generalization Core-Abstractions-Generalizations-Generalization-specific");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Instances";   
                      
        // InfrastructureLibrary.Core.Abstractions.Instances.A_classifier_instanceSpecification 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_classifier_instanceSpecification", "Core-Abstractions-Instances-A_classifier_instanceSpecification");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Instances", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "instanceSpecification", 
    	    "Core-Abstractions-Instances-A_classifier_instanceSpecification-instanceSpecification",
    	    "Core-Abstractions-Instances-InstanceSpecification",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Instances-InstanceSpecification-classifier Core-Abstractions-Instances-A_classifier_instanceSpecification-instanceSpecification");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Instances";   
                      
        // InfrastructureLibrary.Core.Abstractions.Instances.A_definingFeature_slot 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_definingFeature_slot", "Core-Abstractions-Instances-A_definingFeature_slot");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Instances", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "slot", 
    	    "Core-Abstractions-Instances-A_definingFeature_slot-slot",
    	    "Core-Abstractions-Instances-Slot",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Instances-Slot-definingFeature Core-Abstractions-Instances-A_definingFeature_slot-slot");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Instances";   
                      
        // InfrastructureLibrary.Core.Abstractions.Instances.A_instance_instanceValue 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_instance_instanceValue", "Core-Abstractions-Instances-A_instance_instanceValue");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Instances", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "instanceValue", 
    	    "Core-Abstractions-Instances-A_instance_instanceValue-instanceValue",
    	    "Core-Abstractions-Instances-InstanceValue",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Instances-InstanceValue-instance Core-Abstractions-Instances-A_instance_instanceValue-instanceValue");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Instances";   
                      
        // InfrastructureLibrary.Core.Abstractions.Instances.A_slot_owningInstance 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_slot_owningInstance", "Core-Abstractions-Instances-A_slot_owningInstance");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Instances", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Instances-InstanceSpecification-slot Core-Abstractions-Instances-Slot-owningInstance");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Instances";   
                      
        // InfrastructureLibrary.Core.Abstractions.Instances.A_specification_owningInstanceSpec 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_specification_owningInstanceSpec", "Core-Abstractions-Instances-A_specification_owningInstanceSpec");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Instances", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "owningInstanceSpec", 
    	    "Core-Abstractions-Instances-A_specification_owningInstanceSpec-owningInstanceSpec",
    	    "Core-Abstractions-Instances-InstanceSpecification",
    	    "Core-Abstractions-Ownerships-Element-owner",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Instances-InstanceSpecification-specification Core-Abstractions-Instances-A_specification_owningInstanceSpec-owningInstanceSpec");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Instances";   
                      
        // InfrastructureLibrary.Core.Abstractions.Instances.A_value_owningSlot 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_value_owningSlot", "Core-Abstractions-Instances-A_value_owningSlot");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Instances", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "owningSlot", 
    	    "Core-Abstractions-Instances-A_value_owningSlot-owningSlot",
    	    "Core-Abstractions-Instances-Slot",
    	    "Core-Abstractions-Ownerships-Element-owner",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Instances-Slot-value Core-Abstractions-Instances-A_value_owningSlot-owningSlot");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-MultiplicityExpressions";   
                      
        // InfrastructureLibrary.Core.Abstractions.MultiplicityExpressions.A_lowerValue_owningLower 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_lowerValue_owningLower", "Core-Abstractions-MultiplicityExpressions-A_lowerValue_owningLower");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.MultiplicityExpressions", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "owningLower", 
    	    "Core-Abstractions-MultiplicityExpressions-A_lowerValue_owningLower-owningLower",
    	    "Core-Abstractions-MultiplicityExpressions-MultiplicityElement",
    	    "Core-Abstractions-Ownerships-Element-owner",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-MultiplicityExpressions-MultiplicityElement-lowerValue Core-Abstractions-MultiplicityExpressions-A_lowerValue_owningLower-owningLower");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-MultiplicityExpressions";   
                      
        // InfrastructureLibrary.Core.Abstractions.MultiplicityExpressions.A_upperValue_owningUpper 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_upperValue_owningUpper", "Core-Abstractions-MultiplicityExpressions-A_upperValue_owningUpper");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.MultiplicityExpressions", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "owningUpper", 
    	    "Core-Abstractions-MultiplicityExpressions-A_upperValue_owningUpper-owningUpper",
    	    "Core-Abstractions-MultiplicityExpressions-MultiplicityElement",
    	    "Core-Abstractions-Ownerships-Element-owner",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-MultiplicityExpressions-MultiplicityElement-upperValue Core-Abstractions-MultiplicityExpressions-A_upperValue_owningUpper-owningUpper");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Namespaces";   
                      
        // InfrastructureLibrary.Core.Abstractions.Namespaces.A_member_memberNamespace 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_member_memberNamespace", "Core-Abstractions-Namespaces-A_member_memberNamespace");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Namespaces", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "memberNamespace", 
    	    "Core-Abstractions-Namespaces-A_member_memberNamespace-memberNamespace",
    	    "Core-Abstractions-Namespaces-Namespace",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Namespaces-Namespace-member Core-Abstractions-Namespaces-A_member_memberNamespace-memberNamespace");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Namespaces";   
                      
        // InfrastructureLibrary.Core.Abstractions.Namespaces.A_ownedMember_namespace 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedMember_namespace", "Core-Abstractions-Namespaces-A_ownedMember_namespace");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Namespaces", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Namespaces-Namespace-ownedMember Core-Abstractions-Namespaces-NamedElement-namespace");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Ownerships";   
                      
        // InfrastructureLibrary.Core.Abstractions.Ownerships.A_ownedComment_owningElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedComment_owningElement", "Core-Abstractions-Ownerships-A_ownedComment_owningElement");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Ownerships", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "owningElement", 
    	    "Core-Abstractions-Ownerships-A_ownedComment_owningElement-owningElement",
    	    "Core-Abstractions-Ownerships-Element",
    	    "Core-Abstractions-Ownerships-Element-owner",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Ownerships-Element-ownedComment Core-Abstractions-Ownerships-A_ownedComment_owningElement-owningElement");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Ownerships";   
                      
        // InfrastructureLibrary.Core.Abstractions.Ownerships.A_ownedElement_owner 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedElement_owner", "Core-Abstractions-Ownerships-A_ownedElement_owner");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Ownerships", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Ownerships-Element-ownedElement Core-Abstractions-Ownerships-Element-owner");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Redefinitions";   
                      
        // InfrastructureLibrary.Core.Abstractions.Redefinitions.A_redefinedElement_redefinableElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_redefinedElement_redefinableElement", "Core-Abstractions-Redefinitions-A_redefinedElement_redefinableElement");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Redefinitions", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "redefinableElement", 
    	    "Core-Abstractions-Redefinitions-A_redefinedElement_redefinableElement-redefinableElement",
    	    "Core-Abstractions-Redefinitions-RedefinableElement",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Redefinitions-RedefinableElement-redefinedElement Core-Abstractions-Redefinitions-A_redefinedElement_redefinableElement-redefinableElement");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Redefinitions";   
                      
        // InfrastructureLibrary.Core.Abstractions.Redefinitions.A_redefinitionContext_redefinableElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_redefinitionContext_redefinableElement", "Core-Abstractions-Redefinitions-A_redefinitionContext_redefinableElement");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Redefinitions", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "redefinableElement", 
    	    "Core-Abstractions-Redefinitions-A_redefinitionContext_redefinableElement-redefinableElement",
    	    "Core-Abstractions-Redefinitions-RedefinableElement",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Redefinitions-RedefinableElement-redefinitionContext Core-Abstractions-Redefinitions-A_redefinitionContext_redefinableElement-redefinableElement");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Relationships";   
                      
        // InfrastructureLibrary.Core.Abstractions.Relationships.A_relatedElement_relationship 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_relatedElement_relationship", "Core-Abstractions-Relationships-A_relatedElement_relationship");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Relationships", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "relationship", 
    	    "Core-Abstractions-Relationships-A_relatedElement_relationship-relationship",
    	    "Core-Abstractions-Relationships-Relationship",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Relationships-Relationship-relatedElement Core-Abstractions-Relationships-A_relatedElement_relationship-relationship");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Relationships";   
                      
        // InfrastructureLibrary.Core.Abstractions.Relationships.A_source_directedRelationship 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_source_directedRelationship", "Core-Abstractions-Relationships-A_source_directedRelationship");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Relationships", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "directedRelationship", 
    	    "Core-Abstractions-Relationships-A_source_directedRelationship-directedRelationship",
    	    "Core-Abstractions-Relationships-DirectedRelationship",
    	    "Core-Abstractions-Relationships-A_relatedElement_relationship-relationship",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Relationships-DirectedRelationship-source Core-Abstractions-Relationships-A_source_directedRelationship-directedRelationship");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Relationships";   
                      
        // InfrastructureLibrary.Core.Abstractions.Relationships.A_target_directedRelationship 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_target_directedRelationship", "Core-Abstractions-Relationships-A_target_directedRelationship");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Relationships", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "directedRelationship", 
    	    "Core-Abstractions-Relationships-A_target_directedRelationship-directedRelationship",
    	    "Core-Abstractions-Relationships-DirectedRelationship",
    	    "Core-Abstractions-Relationships-A_relatedElement_relationship-relationship",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Relationships-DirectedRelationship-target Core-Abstractions-Relationships-A_target_directedRelationship-directedRelationship");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Super";   
                      
        // InfrastructureLibrary.Core.Abstractions.Super.A_general_classifier 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_general_classifier", "Core-Abstractions-Super-A_general_classifier");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Super", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "classifier", 
    	    "Core-Abstractions-Super-A_general_classifier-classifier",
    	    "Core-Abstractions-Super-Classifier",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Super-Classifier-general Core-Abstractions-Super-A_general_classifier-classifier");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-Super";   
                      
        // InfrastructureLibrary.Core.Abstractions.Super.A_inheritedMember_classifier 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_inheritedMember_classifier", "Core-Abstractions-Super-A_inheritedMember_classifier");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.Super", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "classifier", 
    	    "Core-Abstractions-Super-A_inheritedMember_classifier-classifier",
    	    "Core-Abstractions-Super-Classifier",
    	    "Core-Abstractions-Namespaces-A_member_memberNamespace-memberNamespace",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-Super-Classifier-inheritedMember Core-Abstractions-Super-A_inheritedMember_classifier-classifier");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Abstractions-TypedElements";   
                      
        // InfrastructureLibrary.Core.Abstractions.TypedElements.A_type_typedElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_type_typedElement", "Core-Abstractions-TypedElements-A_type_typedElement");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Abstractions.TypedElements", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "typedElement", 
    	    "Core-Abstractions-TypedElements-A_type_typedElement-typedElement",
    	    "Core-Abstractions-TypedElements-TypedElement",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Abstractions-TypedElements-TypedElement-type Core-Abstractions-TypedElements-A_type_typedElement-typedElement");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.A_annotatedElement_comment 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_annotatedElement_comment", "Core-Basic-A_annotatedElement_comment");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Basic", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "comment", 
    	    "Core-Basic-A_annotatedElement_comment-comment",
    	    "Core-Basic-Comment",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Basic-Comment-annotatedElement Core-Basic-A_annotatedElement_comment-comment");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.A_nestedPackage_nestingPackage 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_nestedPackage_nestingPackage", "Core-Basic-A_nestedPackage_nestingPackage");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Basic", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Basic-Package-nestedPackage Core-Basic-Package-nestingPackage");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.A_opposite_property 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_opposite_property", "Core-Basic-A_opposite_property");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Basic", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "property", 
    	    "Core-Basic-A_opposite_property-property",
    	    "Core-Basic-Property",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Basic-Property-opposite Core-Basic-A_opposite_property-property");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.A_ownedAttribute_class 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedAttribute_class", "Core-Basic-A_ownedAttribute_class");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Basic", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Basic-Class-ownedAttribute Core-Basic-Property-class");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.A_ownedComment_owningElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedComment_owningElement", "Core-Basic-A_ownedComment_owningElement");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Basic", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "owningElement", 
    	    "Core-Basic-A_ownedComment_owningElement-owningElement",
    	    "Core-Basic-Element",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Basic-Element-ownedComment Core-Basic-A_ownedComment_owningElement-owningElement");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.A_ownedLiteral_enumeration 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedLiteral_enumeration", "Core-Basic-A_ownedLiteral_enumeration");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Basic", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Basic-Enumeration-ownedLiteral Core-Basic-EnumerationLiteral-enumeration");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.A_ownedOperation_class 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedOperation_class", "Core-Basic-A_ownedOperation_class");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Basic", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Basic-Class-ownedOperation Core-Basic-Operation-class");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.A_ownedParameter_operation 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedParameter_operation", "Core-Basic-A_ownedParameter_operation");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Basic", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Basic-Operation-ownedParameter Core-Basic-Parameter-operation");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.A_ownedType_package 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedType_package", "Core-Basic-A_ownedType_package");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Basic", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Basic-Package-ownedType Core-Basic-Type-package");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.A_raisedException_operation 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_raisedException_operation", "Core-Basic-A_raisedException_operation");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Basic", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "operation", 
    	    "Core-Basic-A_raisedException_operation-operation",
    	    "Core-Basic-Operation",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Basic-Operation-raisedException Core-Basic-A_raisedException_operation-operation");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.A_superClass_class 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_superClass_class", "Core-Basic-A_superClass_class");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Basic", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "class", 
    	    "Core-Basic-A_superClass_class-class",
    	    "Core-Basic-Class",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Basic-Class-superClass Core-Basic-A_superClass_class-class");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Basic";   
                      
        // InfrastructureLibrary.Core.Basic.A_type_typedElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_type_typedElement", "Core-Basic-A_type_typedElement");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Basic", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "typedElement", 
    	    "Core-Basic-A_type_typedElement-typedElement",
    	    "Core-Basic-TypedElement",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Basic-TypedElement-type Core-Basic-A_type_typedElement-typedElement");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_annotatedElement_comment 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_annotatedElement_comment", "Core-Constructs-A_annotatedElement_comment");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "comment", 
    	    "Core-Constructs-A_annotatedElement_comment-comment",
    	    "Core-Constructs-Comment",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Comment-annotatedElement Core-Constructs-A_annotatedElement_comment-comment");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_attribute_classifier 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_attribute_classifier", "Core-Constructs-A_attribute_classifier");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "classifier", 
    	    "Core-Constructs-A_attribute_classifier-classifier",
    	    "Core-Constructs-Classifier",
    	    "Core-Constructs-RedefinableElement-redefinitionContext Core-Constructs-Feature-featuringClassifier",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Classifier-attribute Core-Constructs-A_attribute_classifier-classifier");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_bodyCondition_bodyContext 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_bodyCondition_bodyContext", "Core-Constructs-A_bodyCondition_bodyContext");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "bodyContext", 
    	    "Core-Constructs-A_bodyCondition_bodyContext-bodyContext",
    	    "Core-Constructs-Operation",
    	    "Core-Constructs-Constraint-context",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Operation-bodyCondition Core-Constructs-A_bodyCondition_bodyContext-bodyContext");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_constrainedElement_constraint 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_constrainedElement_constraint", "Core-Constructs-A_constrainedElement_constraint");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "constraint", 
    	    "Core-Constructs-A_constrainedElement_constraint-constraint",
    	    "Core-Constructs-Constraint",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Constraint-constrainedElement Core-Constructs-A_constrainedElement_constraint-constraint");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_elementImport_importingNamespace 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_elementImport_importingNamespace", "Core-Constructs-A_elementImport_importingNamespace");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Namespace-elementImport Core-Constructs-ElementImport-importingNamespace");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_endType_association 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_endType_association", "Core-Constructs-A_endType_association");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "association", 
    	    "Core-Constructs-A_endType_association-association",
    	    "Core-Constructs-Association",
    	    "Core-Constructs-A_relatedElement_relationship-relationship",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Association-endType Core-Constructs-A_endType_association-association");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_feature_featuringClassifier 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_feature_featuringClassifier", "Core-Constructs-A_feature_featuringClassifier");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Classifier-feature Core-Constructs-Feature-featuringClassifier");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_general_classifier 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_general_classifier", "Core-Constructs-A_general_classifier");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "classifier", 
    	    "Core-Constructs-A_general_classifier-classifier",
    	    "Core-Constructs-Classifier",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Classifier-general Core-Constructs-A_general_classifier-classifier");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_importedElement_elementImport 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_importedElement_elementImport", "Core-Constructs-A_importedElement_elementImport");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "elementImport", 
    	    "Core-Constructs-A_importedElement_elementImport-elementImport",
    	    "Core-Constructs-ElementImport",
    	    "Core-Constructs-A_target_directedRelationship-directedRelationship",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-ElementImport-importedElement Core-Constructs-A_importedElement_elementImport-elementImport");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_importedMember_namespace 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_importedMember_namespace", "Core-Constructs-A_importedMember_namespace");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "namespace", 
    	    "Core-Constructs-A_importedMember_namespace-namespace",
    	    "Core-Constructs-Namespace",
    	    "Core-Constructs-A_member_memberNamespace-memberNamespace",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Namespace-importedMember Core-Constructs-A_importedMember_namespace-namespace");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_importedPackage_packageImport 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_importedPackage_packageImport", "Core-Constructs-A_importedPackage_packageImport");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "packageImport", 
    	    "Core-Constructs-A_importedPackage_packageImport-packageImport",
    	    "Core-Constructs-PackageImport",
    	    "Core-Constructs-A_target_directedRelationship-directedRelationship",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-PackageImport-importedPackage Core-Constructs-A_importedPackage_packageImport-packageImport");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_inheritedMember_classifier 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_inheritedMember_classifier", "Core-Constructs-A_inheritedMember_classifier");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "classifier", 
    	    "Core-Constructs-A_inheritedMember_classifier-classifier",
    	    "Core-Constructs-Classifier",
    	    "Core-Constructs-A_member_memberNamespace-memberNamespace",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Classifier-inheritedMember Core-Constructs-A_inheritedMember_classifier-classifier");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_memberEnd_association 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_memberEnd_association", "Core-Constructs-A_memberEnd_association");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Association-memberEnd Core-Constructs-Property-association");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_member_memberNamespace 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_member_memberNamespace", "Core-Constructs-A_member_memberNamespace");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "memberNamespace", 
    	    "Core-Constructs-A_member_memberNamespace-memberNamespace",
    	    "Core-Constructs-Namespace",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Namespace-member Core-Constructs-A_member_memberNamespace-memberNamespace");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_mergedPackage_packageMerge 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_mergedPackage_packageMerge", "Core-Constructs-A_mergedPackage_packageMerge");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "packageMerge", 
    	    "Core-Constructs-A_mergedPackage_packageMerge-packageMerge",
    	    "Core-Constructs-PackageMerge",
    	    "Core-Constructs-A_target_directedRelationship-directedRelationship",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-PackageMerge-mergedPackage Core-Constructs-A_mergedPackage_packageMerge-packageMerge");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_navigableOwnedEnd_association 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_navigableOwnedEnd_association", "Core-Constructs-A_navigableOwnedEnd_association");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "association", 
    	    "Core-Constructs-A_navigableOwnedEnd_association-association",
    	    "Core-Constructs-Association",
    	    "Core-Constructs-Property-owningAssociation",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Association-navigableOwnedEnd Core-Constructs-A_navigableOwnedEnd_association-association");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_nestedPackage_nestingPackage 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_nestedPackage_nestingPackage", "Core-Constructs-A_nestedPackage_nestingPackage");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Package-nestedPackage Core-Constructs-Package-nestingPackage");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_operand_expression 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_operand_expression", "Core-Constructs-A_operand_expression");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "expression", 
    	    "Core-Constructs-A_operand_expression-expression",
    	    "Core-Constructs-Expression",
    	    "Core-Constructs-Element-owner",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Expression-operand Core-Constructs-A_operand_expression-expression");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_opposite_property 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_opposite_property", "Core-Constructs-A_opposite_property");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "property", 
    	    "Core-Constructs-A_opposite_property-property",
    	    "Core-Constructs-Property",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Property-opposite Core-Constructs-A_opposite_property-property");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_ownedAttribute_class 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedAttribute_class", "Core-Constructs-A_ownedAttribute_class");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Class-ownedAttribute Core-Constructs-Property-class");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_ownedAttribute_datatype 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedAttribute_datatype", "Core-Constructs-A_ownedAttribute_datatype");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-DataType-ownedAttribute Core-Constructs-Property-datatype");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_ownedComment_owningElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedComment_owningElement", "Core-Constructs-A_ownedComment_owningElement");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "owningElement", 
    	    "Core-Constructs-A_ownedComment_owningElement-owningElement",
    	    "Core-Constructs-Element",
    	    "Core-Constructs-Element-owner",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Element-ownedComment Core-Constructs-A_ownedComment_owningElement-owningElement");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_ownedElement_owner 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedElement_owner", "Core-Constructs-A_ownedElement_owner");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Element-ownedElement Core-Constructs-Element-owner");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_ownedEnd_owningAssociation 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedEnd_owningAssociation", "Core-Constructs-A_ownedEnd_owningAssociation");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Association-ownedEnd Core-Constructs-Property-owningAssociation");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_ownedLiteral_enumeration 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedLiteral_enumeration", "Core-Constructs-A_ownedLiteral_enumeration");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Enumeration-ownedLiteral Core-Constructs-EnumerationLiteral-enumeration");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_ownedMember_namespace 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedMember_namespace", "Core-Constructs-A_ownedMember_namespace");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Namespace-ownedMember Core-Constructs-NamedElement-namespace");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_ownedOperation_class 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedOperation_class", "Core-Constructs-A_ownedOperation_class");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Class-ownedOperation Core-Constructs-Operation-class");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_ownedOperation_datatype 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedOperation_datatype", "Core-Constructs-A_ownedOperation_datatype");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-DataType-ownedOperation Core-Constructs-Operation-datatype");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_ownedParameter_operation 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedParameter_operation", "Core-Constructs-A_ownedParameter_operation");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Operation-ownedParameter Core-Constructs-Parameter-operation");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_ownedParameter_ownerFormalParam 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedParameter_ownerFormalParam", "Core-Constructs-A_ownedParameter_ownerFormalParam");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "ownerFormalParam", 
    	    "Core-Constructs-A_ownedParameter_ownerFormalParam-ownerFormalParam",
    	    "Core-Constructs-BehavioralFeature",
    	    "Core-Constructs-NamedElement-namespace",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-BehavioralFeature-ownedParameter Core-Constructs-A_ownedParameter_ownerFormalParam-ownerFormalParam");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_ownedRule_context 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedRule_context", "Core-Constructs-A_ownedRule_context");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Namespace-ownedRule Core-Constructs-Constraint-context");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_ownedType_package 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedType_package", "Core-Constructs-A_ownedType_package");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Package-ownedType Core-Constructs-Type-package");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_packageImport_importingNamespace 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_packageImport_importingNamespace", "Core-Constructs-A_packageImport_importingNamespace");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Namespace-packageImport Core-Constructs-PackageImport-importingNamespace");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_packageMerge_receivingPackage 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_packageMerge_receivingPackage", "Core-Constructs-A_packageMerge_receivingPackage");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Package-packageMerge Core-Constructs-PackageMerge-receivingPackage");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_packagedElement_owningPackage 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_packagedElement_owningPackage", "Core-Constructs-A_packagedElement_owningPackage");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "owningPackage", 
    	    "Core-Constructs-A_packagedElement_owningPackage-owningPackage",
    	    "Core-Constructs-Package",
    	    "Core-Constructs-NamedElement-namespace",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Package-packagedElement Core-Constructs-A_packagedElement_owningPackage-owningPackage");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_postcondition_postContext 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_postcondition_postContext", "Core-Constructs-A_postcondition_postContext");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "postContext", 
    	    "Core-Constructs-A_postcondition_postContext-postContext",
    	    "Core-Constructs-Operation",
    	    "Core-Constructs-Constraint-context",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Operation-postcondition Core-Constructs-A_postcondition_postContext-postContext");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_precondition_preContext 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_precondition_preContext", "Core-Constructs-A_precondition_preContext");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "preContext", 
    	    "Core-Constructs-A_precondition_preContext-preContext",
    	    "Core-Constructs-Operation",
    	    "Core-Constructs-Constraint-context",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Operation-precondition Core-Constructs-A_precondition_preContext-preContext");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_raisedException_behavioralFeature 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_raisedException_behavioralFeature", "Core-Constructs-A_raisedException_behavioralFeature");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "behavioralFeature", 
    	    "Core-Constructs-A_raisedException_behavioralFeature-behavioralFeature",
    	    "Core-Constructs-BehavioralFeature",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-BehavioralFeature-raisedException Core-Constructs-A_raisedException_behavioralFeature-behavioralFeature");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_raisedException_operation 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_raisedException_operation", "Core-Constructs-A_raisedException_operation");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "operation", 
    	    "Core-Constructs-A_raisedException_operation-operation",
    	    "Core-Constructs-Operation",
    	    "Core-Constructs-A_raisedException_behavioralFeature-behavioralFeature",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Operation-raisedException Core-Constructs-A_raisedException_operation-operation");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_redefinedElement_redefinableElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_redefinedElement_redefinableElement", "Core-Constructs-A_redefinedElement_redefinableElement");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "redefinableElement", 
    	    "Core-Constructs-A_redefinedElement_redefinableElement-redefinableElement",
    	    "Core-Constructs-RedefinableElement",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-RedefinableElement-redefinedElement Core-Constructs-A_redefinedElement_redefinableElement-redefinableElement");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_redefinedOperation_operation 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_redefinedOperation_operation", "Core-Constructs-A_redefinedOperation_operation");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "operation", 
    	    "Core-Constructs-A_redefinedOperation_operation-operation",
    	    "Core-Constructs-Operation",
    	    "Core-Constructs-A_redefinedElement_redefinableElement-redefinableElement",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Operation-redefinedOperation Core-Constructs-A_redefinedOperation_operation-operation");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_redefinedProperty_property 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_redefinedProperty_property", "Core-Constructs-A_redefinedProperty_property");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "property", 
    	    "Core-Constructs-A_redefinedProperty_property-property",
    	    "Core-Constructs-Property",
    	    "Core-Constructs-A_redefinedElement_redefinableElement-redefinableElement",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Property-redefinedProperty Core-Constructs-A_redefinedProperty_property-property");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_redefinitionContext_redefinableElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_redefinitionContext_redefinableElement", "Core-Constructs-A_redefinitionContext_redefinableElement");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "redefinableElement", 
    	    "Core-Constructs-A_redefinitionContext_redefinableElement-redefinableElement",
    	    "Core-Constructs-RedefinableElement",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-RedefinableElement-redefinitionContext Core-Constructs-A_redefinitionContext_redefinableElement-redefinableElement");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_relatedElement_relationship 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_relatedElement_relationship", "Core-Constructs-A_relatedElement_relationship");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "relationship", 
    	    "Core-Constructs-A_relatedElement_relationship-relationship",
    	    "Core-Constructs-Relationship",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Relationship-relatedElement Core-Constructs-A_relatedElement_relationship-relationship");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_source_directedRelationship 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_source_directedRelationship", "Core-Constructs-A_source_directedRelationship");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "directedRelationship", 
    	    "Core-Constructs-A_source_directedRelationship-directedRelationship",
    	    "Core-Constructs-DirectedRelationship",
    	    "Core-Constructs-A_relatedElement_relationship-relationship",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-DirectedRelationship-source Core-Constructs-A_source_directedRelationship-directedRelationship");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_specification_owningConstraint 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_specification_owningConstraint", "Core-Constructs-A_specification_owningConstraint");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "owningConstraint", 
    	    "Core-Constructs-A_specification_owningConstraint-owningConstraint",
    	    "Core-Constructs-Constraint",
    	    "Core-Constructs-Element-owner",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Constraint-specification Core-Constructs-A_specification_owningConstraint-owningConstraint");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_subsettedProperty_property 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_subsettedProperty_property", "Core-Constructs-A_subsettedProperty_property");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "property", 
    	    "Core-Constructs-A_subsettedProperty_property-property",
    	    "Core-Constructs-Property",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Property-subsettedProperty Core-Constructs-A_subsettedProperty_property-property");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_superClass_class 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_superClass_class", "Core-Constructs-A_superClass_class");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "class", 
    	    "Core-Constructs-A_superClass_class-class",
    	    "Core-Constructs-Class",
    	    "Core-Constructs-A_general_classifier-classifier",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Class-superClass Core-Constructs-A_superClass_class-class");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_target_directedRelationship 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_target_directedRelationship", "Core-Constructs-A_target_directedRelationship");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "directedRelationship", 
    	    "Core-Constructs-A_target_directedRelationship-directedRelationship",
    	    "Core-Constructs-DirectedRelationship",
    	    "Core-Constructs-A_relatedElement_relationship-relationship",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-DirectedRelationship-target Core-Constructs-A_target_directedRelationship-directedRelationship");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_type_operation 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_type_operation", "Core-Constructs-A_type_operation");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "operation", 
    	    "Core-Constructs-A_type_operation-operation",
    	    "Core-Constructs-Operation",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-Operation-type Core-Constructs-A_type_operation-operation");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Core-Constructs";   
                      
        // InfrastructureLibrary.Core.Constructs.A_type_typedElement 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_type_typedElement", "Core-Constructs-A_type_typedElement");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Core.Constructs", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "typedElement", 
    	    "Core-Constructs-A_type_typedElement-typedElement",
    	    "Core-Constructs-TypedElement",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Core-Constructs-TypedElement-type Core-Constructs-A_type_typedElement-typedElement");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.A_appliedProfile_profileApplication 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_appliedProfile_profileApplication", "Profiles-A_appliedProfile_profileApplication");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Profiles", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "profileApplication", 
    	    "Profiles-A_appliedProfile_profileApplication-profileApplication",
    	    "Profiles-ProfileApplication",
    	    "Core-Constructs-A_target_directedRelationship-directedRelationship",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Profiles-ProfileApplication-appliedProfile Profiles-A_appliedProfile_profileApplication-profileApplication");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.A_extension_metaclass 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_extension_metaclass", "Profiles-A_extension_metaclass");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Profiles", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Profiles-Class-extension Profiles-Extension-metaclass");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.A_icon_stereotype 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_icon_stereotype", "Profiles-A_icon_stereotype");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Profiles", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "stereotype", 
    	    "Profiles-A_icon_stereotype-stereotype",
    	    "Profiles-Stereotype",
    	    "Core-Constructs-Element-owner",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Profiles-Stereotype-icon Profiles-A_icon_stereotype-stereotype");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.A_metaclassReference_profile 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_metaclassReference_profile", "Profiles-A_metaclassReference_profile");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Profiles", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "profile", 
    	    "Profiles-A_metaclassReference_profile-profile",
    	    "Profiles-Profile",
    	    "Core-Constructs-ElementImport-importingNamespace",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Profiles-Profile-metaclassReference Profiles-A_metaclassReference_profile-profile");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.A_metamodelReference_profile 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_metamodelReference_profile", "Profiles-A_metamodelReference_profile");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Profiles", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "profile", 
    	    "Profiles-A_metamodelReference_profile-profile",
    	    "Profiles-Profile",
    	    "Core-Constructs-PackageImport-importingNamespace",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Profiles-Profile-metamodelReference Profiles-A_metamodelReference_profile-profile");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.A_ownedEnd_extension 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedEnd_extension", "Profiles-A_ownedEnd_extension");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Profiles", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "extension", 
    	    "Profiles-A_ownedEnd_extension-extension",
    	    "Profiles-Extension",
    	    "Core-Constructs-Property-owningAssociation",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Profiles-Extension-ownedEnd Profiles-A_ownedEnd_extension-extension");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.A_ownedStereotype_owningPackage 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_ownedStereotype_owningPackage", "Profiles-A_ownedStereotype_owningPackage");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Profiles", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "owningPackage", 
    	    "Profiles-A_ownedStereotype_owningPackage-owningPackage",
    	    "Profiles-Package",
    	    "",    	    
    	    "Profiles-A_packagedElement_owningPackage-owningPackage",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, false, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Profiles-Package-ownedStereotype Profiles-A_ownedStereotype_owningPackage-owningPackage");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.A_packagedElement_owningPackage 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_packagedElement_owningPackage", "Profiles-A_packagedElement_owningPackage");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Profiles", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "owningPackage", 
    	    "Profiles-A_packagedElement_owningPackage-owningPackage",
    	    "Profiles-Package",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, false, "");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Profiles-Package-packagedElement Profiles-A_packagedElement_owningPackage-owningPackage");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.A_profileApplication_applyingPackage 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_profileApplication_applyingPackage", "Profiles-A_profileApplication_applyingPackage");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Profiles", this);
        // create owned ends
    	
        factory.createAssociationEnds(assoc, "Profiles-Package-profileApplication Profiles-ProfileApplication-applyingPackage");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.A_profile_stereotype 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_profile_stereotype", "Profiles-A_profile_stereotype");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Profiles", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "stereotype", 
    	    "Profiles-A_profile_stereotype-stereotype",
    	    "Profiles-Stereotype",
    	    "",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Profiles-Stereotype-profile Profiles-A_profile_stereotype-stereotype");
                                                              
        packageId = this.artifact.getUrn() + "#" + "Profiles";   
                      
        // InfrastructureLibrary.Profiles.A_type_extensionEnd 
        pkg = (Package)model.getElementById(packageId).getDelegate();       
     	assoc  = factory.createAssociation("A_type_extensionEnd", "Profiles-A_type_extensionEnd");
        mapping.mapAssociation(assoc, "InfrastructureLibrary.Profiles", this);
        // create owned ends
    	    	
    	prop = factory.createProperty(assoc, "extensionEnd", 
    	    "Profiles-A_type_extensionEnd-extensionEnd",
    	    "Profiles-ExtensionEnd",
    	    "Core-Constructs-A_type_typedElement-typedElement",    	    
    	    "",    	    
    		false, false, false);    	
        factory.createLowerValue(prop, true, "");
        factory.createUpperValue(prop, true, "*");
    	mapping.mapProperty(assoc, prop, this);
    	
        factory.createAssociationEnds(assoc, "Profiles-ExtensionEnd-type Profiles-A_type_extensionEnd-extensionEnd");
            
    }

}
    
    