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
 * <em><b>fUML::Semantics::Activities::IntermediateActivities::ForkedToken</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link ForkedToken#isControl <em>isControl</em>}</li>
 * <li>{@link ForkedToken#withdraw <em>withdraw</em>}</li>
 * <li>{@link ForkedToken#copy <em>copy</em>}</li>
 * <li>{@link ForkedToken#equals <em>equals</em>}</li>
 * <li>{@link ForkedToken#getValue <em>getValue</em>}</li>
 * <li>{@link ForkedToken#baseToken <em>baseToken</em>}</li>
 * <li>{@link ForkedToken#remainingOffersCount <em>remainingOffersCount</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class ForkedToken extends fUML.Semantics.Activities.IntermediateActivities.Token {

    // Attributes
    public fUML.Semantics.Activities.IntermediateActivities.Token baseToken = null;
    public int remainingOffersCount = 0;

    // Operations of the class
    /**
     * operation isControl <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public boolean isControl() {
        // Test if the base token is a control token.

        return this.baseToken.isControl();

    }

    /**
     * operation withdraw <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void withdraw() {
        // If the base token is not withdrawn, then withdraw it.
        // Decrement the remaining offers count.
        // When the remaining number of offers is zero, then remove this token
        // from its holder.

        if (!this.baseToken.isWithdrawn()) {
            this.baseToken.withdraw();
        }

        if (this.remainingOffersCount > 0) {
            this.remainingOffersCount = this.remainingOffersCount - 1;
        }

        if (this.remainingOffersCount == 0) {
            super.withdraw();
        }
    }

    /**
     * operation copy <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.Activities.IntermediateActivities.Token copy() {
        // Return a copy of the base token.

        return this.baseToken.copy();

    }

    /**
     * operation equals <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public boolean equals(fUML.Semantics.Activities.IntermediateActivities.Token otherToken) {
        // Test if this token is equal to another token.

        return this == otherToken;

    }

    /**
     * operation getValue <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.Classes.Kernel.Value getValue() {
        // Return the value of the base token.

        return this.baseToken.getValue();

    }

} // ForkedToken
