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
 * <em><b>fUML::Semantics::Actions::CompleteActions::ReadExtentActionActivation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link ReadExtentActionActivation#doAction <em>doAction</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class ReadExtentActionActivation extends
        fUML.Semantics.Actions.BasicActions.ActionActivation {

    // Attributes

    // Operations of the class
    /**
     * operation doAction <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void doAction() {
        // Get the extent, at the current execution locus, of the classifier
        // (which must be a class) identified in the action.
        // Place references to the resulting set of objects on the result pin.

        ReadExtentAction action = (ReadExtentAction) (this.node);
        ExtensionalValueList objects = this.getExecutionLocus().getExtent(action.classifier);

        Debug.println("[doAction] " + action.classifier.name + " has " +
           objects.size() + " instance(s).");

        ValueList references = new ValueList();
        for (int i = 0; i < objects.size(); i++) {
            Value object = objects.getValue(i);
            Reference reference = new Reference();
            reference.referent = (Object_) object;
            references.addValue(reference);
        }

        this.putTokens(action.result, references);

    }

} // ReadExtentActionActivation
