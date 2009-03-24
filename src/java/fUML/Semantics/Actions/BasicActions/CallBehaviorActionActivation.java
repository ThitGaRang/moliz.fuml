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

package fUML.Semantics.Actions.BasicActions;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.*;
import fUML.Syntax.CommonBehaviors.Communications.*;
import fUML.Syntax.Activities.IntermediateActivities.*;
import fUML.Syntax.Actions.BasicActions.*;

import fUML.Semantics.*;
import fUML.Semantics.Classes.Kernel.*;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.*;
import fUML.Semantics.Loci.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Semantics::Actions::BasicActions::CallBehaviorActionActivation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link CallBehaviorActionActivation#getCallExecution <em>getCallExecution
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class CallBehaviorActionActivation extends
        fUML.Semantics.Actions.BasicActions.CallActionActivation {

    // Attributes

    // Operations of the class
    /**
     * operation getCallExecution <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.CommonBehaviors.BasicBehaviors.Execution getCallExecution() {
        // Create and execution for the given behavior at the current locus and
        // return the resulting execution object.
        // If the given behavior is in the context of a classifier, then pass
        // the current context object as the context for the call.
        // Otherwise, use a null context.
        // [Note that this requires the behavior context to be compatible with
        // the type of the current contect object.]

        Behavior behavior = ((CallBehaviorAction) (this.node)).behavior;

        Object_ context = null;
        if (behavior.context != null) {
            // Debug.println("[getCallExecution] behavior context = " +
            // behavior.context.name);
            context = this.getExecutionContext();
        }

        // Debug.println("[getCallExecution] context = " + context);

        return this.getExecutionLocus().factory.createExecution(behavior, context);

    }

} // CallBehaviorActionActivation
