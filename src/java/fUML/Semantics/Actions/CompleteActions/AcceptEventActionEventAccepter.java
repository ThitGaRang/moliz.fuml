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
 * <em><b>fUML::Semantics::Actions::CompleteActions::AcceptEventActionEventAccepter</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link AcceptEventActionEventAccepter#accept <em>accept</em>}</li>
 * <li>{@link AcceptEventActionEventAccepter#match <em>match</em>}</li>
 * <li>{@link AcceptEventActionEventAccepter#actionActivation <em>
 * actionActivation</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class AcceptEventActionEventAccepter extends
        fUML.Semantics.CommonBehaviors.Communications.EventAccepter {

    // Attributes
    public fUML.Semantics.Actions.CompleteActions.AcceptEventActionActivation actionActivation = new fUML.Semantics.Actions.CompleteActions.AcceptEventActionActivation();

    // Operations of the class
    /**
     * operation accept <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void accept(fUML.Semantics.CommonBehaviors.Communications.SignalInstance signalInstance) {
        // Accept a signal occurance for the given signal instance.
        // Forward the signal occuranceto the action activation.

        this.actionActivation.accept(signalInstance);
    }

    /**
     * operation match <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public boolean match(fUML.Semantics.CommonBehaviors.Communications.SignalInstance signalInstance) {
        // Return true if the given signal instance matches a trigger of the
        // accept action of the action activation.

        return this.actionActivation.match(signalInstance);

    }

} // AcceptEventActionEventAccepter
