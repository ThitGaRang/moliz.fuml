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
 * <em><b>fUML::Semantics::Actions::CompleteActions::StartClassifierBehaviorActionActivation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link StartClassifierBehaviorActionActivation#doAction <em>doAction
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class StartClassifierBehaviorActionActivation extends
        fUML.Semantics.Actions.BasicActions.ActionActivation {

    // Attributes

    // Operations of the class
    /**
     * operation doAction <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void doAction() {
        // Get the value on the object input pin. If it is not a reference, then
        // do nothing.
        // Start the classifier behavior of the referent object for the
        // classifier given as the type of the object input pin.
        // If the object input pin has no type, then start the classifier
        // behaviors of all types of the referent object. [The required behavior
        // in this case is not clear from the spec.]

        StartClassifierBehaviorAction action = (StartClassifierBehaviorAction) (this.node);

        Value object = this.getTokens(action.object).getValue(0);

        if (object instanceof Reference) {
            ((Reference) object).startBehavior((Class_) (action.object.typedElement.type),
                    new ParameterValueList());
        }

    }

} // StartClassifierBehaviorActionActivation
