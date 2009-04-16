



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

package fUML.Semantics.Classes.Kernel;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

 		 	 				    		 	 			import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;

import fUML.Semantics.*;
import fUML.Semantics.Loci.*;




								    		

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fUML::Semantics::Classes::Kernel::Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link Reference#startBehavior <em>startBehavior</em>}</li>
	 *   <li>{@link Reference#dispatch <em>dispatch</em>}</li>
	 *   <li>{@link Reference#send <em>send</em>}</li>
	 *   <li>{@link Reference#destroy <em>destroy</em>}</li>
	 *   <li>{@link Reference#equals <em>equals</em>}</li>
	 *   <li>{@link Reference#copy <em>copy</em>}</li>
	 *   <li>{@link Reference#new_ <em>new_</em>}</li>
	 *   <li>{@link Reference#getTypes <em>getTypes</em>}</li>
	 *   <li>{@link Reference#getFeatureValue <em>getFeatureValue</em>}</li>
	 *   <li>{@link Reference#setFeatureValue <em>setFeatureValue</em>}</li>
	 *   <li>{@link Reference#getFeatureValues <em>getFeatureValues</em>}</li>
	 *   <li>{@link Reference#toString <em>toString</em>}</li>
	 	 *   <li>{@link Reference#referent <em>referent</em>}</li>
	 * </ul>
 * </p>
 *
 * @generated
 */


public   class Reference    extends fUML.Semantics.Classes.Kernel.StructuredValue    {
 	    
	// Attributes
 	 		public   fUML.Semantics.Classes.Kernel.Object_ referent = 	 null
	;
	    
// Operations of the class
	  /**
   * operation startBehavior
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void startBehavior(fUML.Syntax.Classes.Kernel.Class_ classifier, fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList inputs)   {
	 		 	 			// Asynchronously start the behavior of the given classifier for the referent object.

this.referent.startBehavior(classifier, inputs);

								    			  }
	
	  /**
   * operation dispatch
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     fUML.Semantics.CommonBehaviors.BasicBehaviors.Execution dispatch(fUML.Syntax.Classes.Kernel.Operation operation)   {
	 		 	 			// Dispatch the given operation to the referent object.

return this.referent.dispatch(operation);

								    			  }
	
	  /**
   * operation send
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void send(fUML.Semantics.CommonBehaviors.Communications.SignalInstance signalInstance)   {
	 		 	 			// Send the given signal instance to the referent object.

this.referent.send(signalInstance);

								    			  }
	
	  /**
   * operation destroy
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void destroy()   {
	 		 	 			// Destroy the referent.

this.referent.destroy();

								    			  }
	
	  /**
   * operation equals
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     boolean equals(fUML.Semantics.Classes.Kernel.Value otherValue)   {
	 		 	 			// Test if this reference is equal to the otherValue. 
// To be equal, the otherValue must also be a reference, with the same referent as this reference.

boolean isEqual = false;
if (otherValue instanceof Reference) {
    isEqual = (((Reference)otherValue).referent == this.referent);
}

return isEqual;


								    			  }
	
	  /**
   * operation copy
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     fUML.Semantics.Classes.Kernel.Value copy()   {
	 		 	 			// Create a new reference with the same referent as this reference.

Reference newValue = (Reference)(super.copy());

newValue.referent = this.referent;

return newValue;

								    			  }
	
	  /**
   * operation new_
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	protected     fUML.Semantics.Classes.Kernel.Value new_()   {
	 		 	 			// Create a new reference with no referent.

return new Reference();

								    			  }
	
	  /**
   * operation getTypes
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     fUML.Syntax.Classes.Kernel.ClassifierList getTypes()   {
	 		 	 			// Get the types of the referent object.

return this.referent.getTypes();

								    			  }
	
	  /**
   * operation getFeatureValue
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     fUML.Semantics.Classes.Kernel.FeatureValue getFeatureValue(fUML.Syntax.Classes.Kernel.StructuralFeature feature)   {
	 		 	 			// Get the feature value associated with the given feature in the referent object.

return this.referent.getFeatureValue(feature);

								    			  }
	
	  /**
   * operation setFeatureValue
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void setFeatureValue(fUML.Syntax.Classes.Kernel.StructuralFeature feature, fUML.Semantics.Classes.Kernel.ValueList values, int position)   {
	 		 	 			// Set the values associated with the given feature in the referent object.

this.referent.setFeatureValue(feature, values, position);

								    			  }
	
	  /**
   * operation getFeatureValues
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     fUML.Semantics.Classes.Kernel.FeatureValueList getFeatureValues()   {
	 		 	 			// Return the feature values of the referent.

return this.referent.getFeatureValues();

								    			  }
	
	  /**
   * operation toString
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     String toString()   {
	 		 	 			return "Reference to " + this.referent.toString();

								    			  }
	
} //Reference
