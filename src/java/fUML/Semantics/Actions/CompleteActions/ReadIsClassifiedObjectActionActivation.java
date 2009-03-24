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

package fUML.Semantics.Actions.CompleteActions;

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
import fUML.Syntax.Actions.CompleteActions.*;

import fUML.Semantics.*;
import fUML.Semantics.Classes.Kernel.*;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.*;
import fUML.Semantics.Activities.IntermediateActivities.*;
import fUML.Semantics.Actions.BasicActions.*;
import fUML.Semantics.Actions.IntermediateActions.*;
import fUML.Semantics.Loci.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Semantics::Actions::CompleteActions::ReadIsClassifiedObjectActionActivation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link ReadIsClassifiedObjectActionActivation#doAction <em>doAction</em>}
 * </li>
 * <li>{@link ReadIsClassifiedObjectActionActivation#checkAllParents <em>
 * checkAllParents</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class ReadIsClassifiedObjectActionActivation extends
        fUML.Semantics.Actions.BasicActions.ActionActivation {

    // Attributes

    // Operations of the class
    /**
     * operation doAction <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void doAction() {
        // Get the value on the object input pin and determine if it is
        // classified by the classifier specified in the action.
        // If the isDirect attribute of the action is false, then place true on
        // the result output pin if the input object has the specified
        // classifier or of one its (direct or indirect) descendants as a type.
        // If the isDirect attribute of the action is true, then place true on
        // the result output pin if the input object has the specified
        // classifier as a type.
        // Otherwise place false on the result output pin.

        ReadIsClassifiedObjectAction action = (ReadIsClassifiedObjectAction) (this.node);

        Value input = this.getTokens(action.object).getValue(0);
        ClassifierList types = input.getTypes();

        boolean result = false;
        int i = 1;
        while (!result & i <= types.size()) {
            Classifier type = types.getValue(i - 1);

            if (type == action.classifier) {
                result = true;
            } else if (!action.isDirect) {
                result = this.checkAllParents(type, action.classifier);
            }

            i = i + 1;
        }

        ValueList values = new ValueList();
        values.addValue(this.makeBooleanValue(result));

        this.putTokens(action.result, values);

    }

    /**
     * operation checkAllParents <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public boolean checkAllParents(fUML.Syntax.Classes.Kernel.Classifier type,
            fUML.Syntax.Classes.Kernel.Classifier classifier) {
        // Check if the given classifier matches any of the direct or indirect
        // ancestors of a given type.

        ClassifierList directParents = type.general;
        boolean matched = false;
        int i = 1;
        while (!matched & i <= directParents.size()) {
            Classifier directParent = directParents.getValue(i - 1);
            if (directParent == classifier) {
                matched = true;
            } else {
                matched = this.checkAllParents(directParent, classifier);
            }
            i = i + 1;
        }

        return matched;

    }

} // ReadIsClassifiedObjectActionActivation
