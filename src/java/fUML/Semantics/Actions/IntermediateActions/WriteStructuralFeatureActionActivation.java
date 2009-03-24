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
 * <em><b>fUML::Semantics::Actions::IntermediateActions::WriteStructuralFeatureActionActivation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link WriteStructuralFeatureActionActivation#position <em>position</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public abstract class WriteStructuralFeatureActionActivation extends
        fUML.Semantics.Actions.IntermediateActions.StructuralFeatureActionActivation {

    // Attributes

    // Operations of the class
    /**
     * operation position <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public int position(fUML.Semantics.Classes.Kernel.Value value,
            fUML.Semantics.Classes.Kernel.ValueList list, int startAt) {
        // Return the position (counting from 1) of the first occurance of the
        // given value in the given list at or after the starting index, or 0 if
        // it is not found.

        boolean found = false;
        int i = startAt;
        while (!found & i <= list.size()) {
            found = list.getValue(i - 1).equals(value);
            i = i + 1;
        }

        if (!found) {
            i = 1;
        }

        return i - 1;

    }

} // WriteStructuralFeatureActionActivation
