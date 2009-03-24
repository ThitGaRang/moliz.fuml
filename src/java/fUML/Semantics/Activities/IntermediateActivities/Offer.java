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

package fUML.Semantics.Activities.IntermediateActivities;

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
import fUML.Semantics.Actions.BasicActions.*;
import fUML.Semantics.Loci.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Semantics::Activities::IntermediateActivities::Offer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link Offer#countOfferedTokens <em>countOfferedTokens</em>}</li>
 * <li>{@link Offer#getOfferedTokens <em>getOfferedTokens</em>}</li>
 * <li>{@link Offer#removeWithdrawnTokens <em>removeWithdrawnTokens</em>}</li>
 * <li>{@link Offer#offeredTokens <em>offeredTokens</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class Offer {

    // Attributes
    public fUML.Semantics.Activities.IntermediateActivities.TokenList offeredTokens = new fUML.Semantics.Activities.IntermediateActivities.TokenList();

    // Operations of the class
    /**
     * operation countOfferedTokens <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */

    public int countOfferedTokens() {
        // Return the number of tokens being offered.

        return this.offeredTokens.size();

    }

    /**
     * operation getOfferedTokens <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.Activities.IntermediateActivities.TokenList getOfferedTokens() {
        // Get the offered tokens.

        TokenList tokens = new TokenList();
        TokenList offeredTokens = this.offeredTokens;
        for (int i = 0; i < this.offeredTokens.size(); i++) {
            Token offeredToken = offeredTokens.getValue(i);
            // Debug.println("[getOfferedTokens] token value = " +
            // offeredToken.getValue());
            tokens.addValue(offeredToken);
        }

        return tokens;

    }

    /**
     * operation removeWithdrawnTokens <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */

    public void removeWithdrawnTokens() {
        // Remove any tokens that have already been consumed.

        TokenList offeredTokens = this.offeredTokens;
        int i = 1;
        while (i <= this.offeredTokens.size()) {
            if (this.offeredTokens.getValue(i - 1).isWithdrawn()) {
                this.offeredTokens.remove(i - 1);
                i = i - 1;
            }
            i = i + 1;
        }

    }

} // Offer
