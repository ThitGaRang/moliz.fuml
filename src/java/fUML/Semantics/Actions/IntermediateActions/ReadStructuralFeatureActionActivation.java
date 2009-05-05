



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

package fUML.Semantics.Actions.IntermediateActions;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.*;
import fUML.Syntax.CommonBehaviors.Communications.*;
import fUML.Syntax.Activities.IntermediateActivities.*;
import fUML.Syntax.Actions.BasicActions.*;
import fUML.Syntax.Actions.IntermediateActions.*;

import fUML.Semantics.*;
import fUML.Semantics.Classes.Kernel.*;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.*;
import fUML.Semantics.Activities.IntermediateActivities.*;
import fUML.Semantics.Actions.BasicActions.*;
import fUML.Semantics.Loci.*;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fUML::Semantics::Actions::IntermediateActions::ReadStructuralFeatureActionActivation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link ReadStructuralFeatureActionActivation#doAction <em>doAction</em>}</li>
	 	 * </ul>
 * </p>
 *
 * @generated
 */

public   class ReadStructuralFeatureActionActivation    extends fUML.Semantics.Actions.IntermediateActions.StructuralFeatureActionActivation    {
    
	// Attributes
    
	// Operations of the class
  /**
   * operation doAction
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */
	public      void doAction()   {
// Get the value of the object input pin. If the value is not a structural value, do nothing.
// Otherwise, get the values of the appropriate feature of the input value and place them on the result output pin.

ReadStructuralFeatureAction action = (ReadStructuralFeatureAction)(this.node);

Value value = this.takeTokens(action.object).getValue(0);

if (value instanceof StructuredValue) {
//    Debug.println("[ReadStructuralFeatureActionActivation] value = " + value +", structural feature = " + action.structuralFeature.name);
    ValueList resultValues = ((StructuredValue)value).getFeatureValue(action.structuralFeature).values;
    this.putTokens(action.result, resultValues);
}

	  } // doAction

} //ReadStructuralFeatureActionActivation
