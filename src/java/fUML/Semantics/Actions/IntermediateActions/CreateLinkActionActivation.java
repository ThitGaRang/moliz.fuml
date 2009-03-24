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
 * <em><b>fUML::Semantics::Actions::IntermediateActions::CreateLinkActionActivation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link CreateLinkActionActivation#doAction <em>doAction</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class CreateLinkActionActivation extends
        fUML.Semantics.Actions.IntermediateActions.WriteLinkActionActivation {

    // Attributes

    // Operations of the class
    /**
     * operation doAction <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void doAction() {
        // Get the extent at the current execution locus of the association for
        // which a link is being created.
        // Destroy all links that have a value for any end for which
        // isReplaceAll is true.
        // Create a new link for the association, at the current locus, with the
        // given end data values, inserted at the given insertAt position (for
        // ordered ends).

        CreateLinkAction action = (CreateLinkAction) (this.node);
        LinkEndCreationDataList endDataList = action.endData;

        ExtensionalValueList extent = this.getExecutionLocus().getExtent(this.getAssociation());

        for (int i = 0; i < extent.size(); i++) {
            ExtensionalValue value = extent.getValue(i);
            Link link = (Link) value;

            boolean noMatch = true;
            int j = 1;
            while (noMatch & j <= endDataList.size()) {
                LinkEndCreationData endData = endDataList.getValue(j - 1);
                if (endData.isReplaceAll & this.endMatchesEndData(link, endData)) {
                    link.destroy();
                    noMatch = false;
                }
                j = j + 1;
            }
        }

        Link newLink = new Link();

        for (int i = 0; i < endDataList.size(); i++) {
            LinkEndCreationData endData = endDataList.getValue(i);

            int insertAt = 0;
            if (endData.insertAt != null) {
                insertAt = ((UnlimitedNaturalValue) (this.getTokens(endData.insertAt).getValue(0))).value.naturalValue;
            }
            newLink.setFeatureValue(endData.end, this.getTokens(endData.value), insertAt);
        }

        this.getExecutionLocus().add(newLink);

    }

} // CreateLinkActionActivation
