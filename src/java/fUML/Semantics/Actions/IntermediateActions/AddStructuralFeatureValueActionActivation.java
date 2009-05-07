
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
 * <!-- begin-user-doc --> An implementation of the model object '
 * 
 * <em><b>fUML::Semantics::Actions::IntermediateActions::AddStructuralFeatureValueActionActivation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link AddStructuralFeatureValueActionActivation#doAction <em>doAction
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class AddStructuralFeatureValueActionActivation extends
        fUML.Semantics.Actions.IntermediateActions.WriteStructuralFeatureActionActivation {

    // Attributes

    // Operations of the class
    /**
     * operation doAction <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void doAction() {
        // Get the value of the object input pin. If it is not a structural
        // value, do nothing. Otherwise do the following.
        // Get the value on the value input pin.
        // If isReplaceAll is true, set the appropriate feature of the input
        // object to the input values.
        // Otherwise, get the current values of the feature and insert the input
        // value at the position given by the value of the insertAt pin.

        AddStructuralFeatureValueAction action = (AddStructuralFeatureValueAction) (this.node);

        Value value = this.takeTokens(action.object).getValue(0);

        if (value instanceof StructuredValue) {
            StructuredValue structuredValue = (StructuredValue) value;
            ValueList inputValues = this.takeTokens(action.value);

            if (action.isReplaceAll) {
                structuredValue.setFeatureValue(action.structuralFeature, inputValues, 0);
            } else {
                FeatureValue featureValue = structuredValue
                        .getFeatureValue(action.structuralFeature);

                int insertAt = 1;
                if (featureValue.values.size() > 0) {
                    if (action.insertAt == null) {
                        // *** If there is no insertAt pin, then the structural
                        // feature must be unordered, and the insertion position
                        // is immaterial. ***
                        insertAt = ((ChoiceStrategy) this.getExecutionLocus().factory
                                .getStrategy("choice")).choose(featureValue.values.size());
                    } else {
                        insertAt = ((UnlimitedNaturalValue) this.takeTokens(action.insertAt)
                                .getValue(0)).value.naturalValue;
                    }
                }

                // NOTE: Multiplicity of the value input pin is required to be
                // 1..1.
                Value inputValue = inputValues.getValue(0);

                if (action.structuralFeature.multiplicityElement.isUnique) {
                    // Remove any existing value that duplicates the input value
                    int j = position(inputValue, featureValue.values, 1);
                    if (j > 0) {
                        featureValue.values.remove(j - 1);
                        if (insertAt > 0 & j < insertAt) {
                            insertAt = insertAt - 1;
                        }
                    }
                }

                if (insertAt < 0) { // This indicates an unlimited value of "*"
                    featureValue.values.addValue(inputValue);
                } else {
                    featureValue.values.addValue(insertAt - 1, inputValue);
                }
            }

            if (action.result != null) {
                this.putToken(action.result, value);
            }
        }

    } // doAction

} // AddStructuralFeatureValueActionActivation
