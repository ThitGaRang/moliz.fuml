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
 * <em><b>fUML::Semantics::Actions::IntermediateActions::ClearAssociationActionActivation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link ClearAssociationActionActivation#doAction <em>doAction</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class ClearAssociationActionActivation extends
        fUML.Semantics.Actions.BasicActions.ActionActivation {

    // Attributes

    // Operations of the class
    /**
     * operation doAction <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void doAction() {
        // Get the extent, at the current execution locus, of the given
        // association.
        // Read the object input pin. Destroy all links in which the object
        // participates.

        ClearAssociationAction action = (ClearAssociationAction) (this.node);

        ExtensionalValueList extent = this.getExecutionLocus().getExtent(action.association);
        Value objectValue = this.getTokens(action.object).getValue(0);

        for (int i = 0; i < extent.size(); i++) {
            Link link = (Link) (extent.getValue(i));
            if (this.valueParticipatesInLink(objectValue, link)) {
                link.destroy();
            }
        }

    }

} // ClearAssociationActionActivation
