/*
 * Copyright 2008 Lockheed Martin Corporation, except as stated in the file 
 * entitled Licensing-Information. Licensed under the Academic Free License 
 * version 3.0 (http://www.opensource.org/licenses/afl-3.0.php), except as stated 
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
 * <em><b>fUML::Semantics::Actions::IntermediateActions::RemoveStructuralFeatureValueActionActivation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link RemoveStructuralFeatureValueActionActivation#doAction <em>doAction
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class RemoveStructuralFeatureValueActionActivation extends
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
        // Get the values of the appropriate feature of the input object. Get
        // the value of the value input pin.
        // If isRemoveDuplicates is true, then remove all feature values equal
        // to the input value.
        // If isRemoveDuplicates is false and there is no removeAt input pin,
        // remove any one feature value equal to the input value (if there are
        // any that are equal).
        // If isRemoveDuplicates is false, there is a removeAt input pin and the
        // feature value at the removeAt position is equal to the input value,
        // remove that feature value.
        // Set the appropriate feature of the input object to have the modified
        // set of values.

        RemoveStructuralFeatureValueAction action = (RemoveStructuralFeatureValueAction) (this.node);

        Value value = this.getTokens(action.object).getValue(0);

        if (value instanceof StructuredValue) {
            Value inputValue = this.getTokens(action.value).getValue(0);
            FeatureValue featureValue = ((StructuredValue) value)
                    .getFeatureValue(action.structuralFeature);

            if (action.isRemoveDuplicates) {
                int j = this.position(value, featureValue.values, 1);
                while (j > 0) {
                    featureValue.values.remove(j - 1);
                    j = this.position(value, featureValue.values, j);
                }

            } else if (action.removeAt == null) {

                ValueList values = featureValue.values;
                intList positions = new intList();
                for (int i = 0; i < values.size(); i++) {
                    Value thisValue = values.getValue(i);
                    if (thisValue.equals(inputValue)) {
                        positions.addValue(i + 1);
                    }
                }

                if (positions.size() > 0) {
                    // *** Nondeterministically choose which value to remove.
                    // ***
                    int j = ((ChoiceStrategy) this.getExecutionLocus().factory
                            .getStrategy("choice")).choose(positions.size());

                    featureValue.values.remove(positions.getValue(j - 1) - 1);
                }

            } else {
                int removeAt = ((UnlimitedNaturalValue) (this.getTokens(action.removeAt)
                        .getValue(0))).value.naturalValue;
                if (featureValue.values.getValue(removeAt - 1).equals(inputValue)) {
                    featureValue.values.remove(removeAt - 1);
                }
            }

            this.putToken(action.result, value);
        }

    }

} // RemoveStructuralFeatureValueActionActivation
