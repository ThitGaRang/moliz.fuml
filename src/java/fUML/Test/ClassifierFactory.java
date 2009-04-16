



/*
 * Initial version copyright 2008 Lockheed Martin Corporation, except  
 * as stated in the file entitled Licensing-Information. 
 * 
 * All modifications copyright 2009 Data Access Technologies, Inc.
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php), except as stated 
 * in the file entitled Licensing-Information. 
 *
 * Contributors:
 *   MDS - initial API and implementation
 *
 */

package fUML.Test;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

 		 	 			import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.*;
import fUML.Syntax.CommonBehaviors.Communications.*;
import fUML.Syntax.Activities.IntermediateActivities.*;
import fUML.Syntax.Activities.CompleteStructuredActivities.*;
import fUML.Syntax.Actions.BasicActions.*;
import fUML.Syntax.Actions.IntermediateActions.*;
import fUML.Syntax.Actions.CompleteActions.*;

								    		

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fUML::Test::ClassifierFactory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link ClassifierFactory#ClassifierFactory <em>ClassifierFactory</em>}</li>
	 *   <li>{@link ClassifierFactory#createEnumerationType <em>createEnumerationType</em>}</li>
	 *   <li>{@link ClassifierFactory#createDataType <em>createDataType</em>}</li>
	 *   <li>{@link ClassifierFactory#createClass <em>createClass</em>}</li>
	 *   <li>{@link ClassifierFactory#createSignal <em>createSignal</em>}</li>
	 *   <li>{@link ClassifierFactory#addAttribute <em>addAttribute</em>}</li>
	 *   <li>{@link ClassifierFactory#addClassifierBehavior <em>addClassifierBehavior</em>}</li>
	 *   <li>{@link ClassifierFactory#addOperation <em>addOperation</em>}</li>
	 *   <li>{@link ClassifierFactory#addGeneralization <em>addGeneralization</em>}</li>
	 *   <li>{@link ClassifierFactory#getOperation <em>getOperation</em>}</li>
	 	 * </ul>
 * </p>
 *
 * @generated
 */


public   class ClassifierFactory    extends fUML.Test.Test    {
 	    
	// Attributes
 	    
// Operations of the class
	  /**
   * operation ClassifierFactory
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      ClassifierFactory(fUML.Test.TestEnvironment environment)   {
	 		 	 			this.environment = environment;

								     				    			  }
	
	  /**
   * operation createEnumerationType
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void createEnumerationType(String typeName, int numberOfLiterals)   {
	 		 	 			Enumeration type = new Enumeration();

type.setName(typeName);

for (int i = 0; i < numberOfLiterals; i++) {
    EnumerationLiteral literal = new EnumerationLiteral();

    literal.setName(typeName + "_" + String.valueOf(i));
    type.addOwnedLiteral(literal);
}

environment.addElement(type);

								     				    			  }
	
	  /**
   * operation createDataType
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void createDataType(String name)   {
	 		 	 			DataType dataType = new DataType();
dataType.setName(name);
environment.addElement(dataType);

								     				    			  }
	
	  /**
   * operation createClass
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void createClass(String name)   {
	 		 	 			Class_ class_ = new Class_();
class_.setName(name);
environment.addElement(class_);

								     				    			  }
	
	  /**
   * operation createSignal
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void createSignal(String name)   {
	 		 	 			Signal signal = new Signal();
signal.setName(name);
this.environment.addElement(signal);

								    			  }
	
	  /**
   * operation addAttribute
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void addAttribute(String classifierName, String attributeName, String attributeTypeName, boolean isComposite)   {
	 		 	 			Classifier type = environment.getType(classifierName);

if (type == null) {
    Debug.println("[addAttribute] " + classifierName + " not found or not a classifier.");
    return;
}

Classifier attributeType = environment.getType(attributeTypeName);

if (attributeType == null) {
    Debug.println("[addAttribute] " + attributeTypeName + " not found or not a classifier.");
    return;
}

Property attribute = new Property();
attribute.setName(attributeName);
attribute.setType(attributeType);
attribute.setIsOrdered(false);
attribute.setIsUnique(true);
attribute.setLower(1);
attribute.setUpper(1);

if (isComposite) {
    attribute.setAggregation(AggregationKind.composite);
}
else {
    attribute.setAggregation( AggregationKind.none);
}

if (type instanceof DataType) {
    // Debug.println("[addAttribute] " + type.name + " is a data type.");
    ((DataType)type).addOwnedAttribute(attribute);
} else if (type instanceof Class_) {
    // Debug.println("[addAttribute] " + type.name + " is a class.");
    ((Class_)type).addOwnedAttribute(attribute);
} else if (type instanceof Signal) {
    ((Signal)type).addOwnedAttribute(attribute);
}

								     				    			  }
	
	  /**
   * operation addClassifierBehavior
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void addClassifierBehavior(String className, String behaviorName)   {
	 		 	 			NamedElement element = this.environment.getElement(className);

if (element == null || !(element instanceof Class_)) {
    Debug.println("[addClassifierBehavior] " + className + " not found or not a class.");
    return;
}

Class_ classifier = (Class_)element;

element = this.environment.getElement(behaviorName);

if (element == null || !(element instanceof Behavior)) {
    Debug.println("[addClassifierBehavior] " + behaviorName + " not found or not a behavior.");
    return;
}

Behavior behavior = (Behavior)element;
this.environment.removeElement(element);

classifier.addOwnedBehavior(behavior);
classifier.setClassifierBehavior(behavior);


								     				    			  }
	
	  /**
   * operation addOperation
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void addOperation(String className, String baseClassName, String operationName, String methodName)   {
	 		 	 			NamedElement element = this.environment.getElement(className);

if (element == null || !(element instanceof Class_)) {
    Debug.println("[addOperation] " + className + " not found or not a class.");
    return;
}

Class_ classifier = (Class_)element;

Operation operation = new Operation();
operation.setName(operationName);

if (!baseClassName.equals("")) {
    element = this.environment.getElement(baseClassName);

    if (element == null || !(element instanceof Class_)) {
        Debug.println("[addOperation] " + baseClassName + " not found or not a class.");
        return;
    }

    Class_ baseClass = (Class_)element;
    Operation redefinedOperation = this.getOperation(baseClass, operationName);

    if (redefinedOperation == null) {
        Debug.println("[addOperation] " + operationName + " is not an operation of " + baseClassName + ".");
        return;
    }

    operation.addRedefinedOperation(redefinedOperation);
}

if (methodName.equals("")) {
    operation.setIsAbstract(true);
} else {
    element = this.environment.getElement(methodName);

    if (element == null || !(element instanceof Behavior)) {
        Debug.println("[addOperation] " + methodName + " not found or not a behavior.");
        return;
    }

    Behavior behavior = (Behavior)element;
    this.environment.removeElement(element);
    classifier.addOwnedBehavior(behavior);

    operation.addMethod(behavior);
}

classifier.addOwnedOperation(operation);


								    			  }
	
	  /**
   * operation addGeneralization
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void addGeneralization(String subtypeName, String supertypeName)   {
	 		 	 			Classifier subtype = this.environment.getType(subtypeName);

if (subtype == null) {
    Debug.println("[addGeneralization] " + subtypeName + " not found or not a classifier.");
    return;
}

Classifier supertype = this.environment.getType(supertypeName);

if (supertype == null) {
    Debug.println("[addGeneralization] " + supertypeName + " not found or not a classifier.");
    return;
}

Generalization generalization = new Generalization();
generalization.setGeneral(supertype);
subtype.addGeneralization(generalization);

								    			  }
	
	  /**
   * operation getOperation
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	protected     fUML.Syntax.Classes.Kernel.Operation getOperation(fUML.Syntax.Classes.Kernel.Class_ class_, String operationName)   {
	 		 	 			for (int i = 0; i < class_.member.size(); i++) {
    NamedElement member = class_.member.getValue(i);
    if (member.name.equals(operationName)) {
        if (!(member instanceof Operation)) {
            return null;
        }
        return (Operation)member;
    }
}

return null;

								     				    			  }
	
} //ClassifierFactory
