
/*
 * Initial version copyright 2008 Lockheed Martin Corporation, except  
 * as stated in the file entitled Licensing-Information. 
 * 
 * All modifications copyright 2009 Data Access Technologies, Inc.
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php), except as stated 
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
 * <em><b>fUML::Semantics::Actions::BasicActions::InputPinActivation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link InputPinActivation#receiveOffer <em>receiveOffer</em>}</li>
 * <li>{@link InputPinActivation#isReady <em>isReady</em>}</li>
 * <li>{@link InputPinActivation#countUnofferedTokens <em>countUnofferedTokens
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class InputPinActivation extends fUML.Semantics.Actions.BasicActions.PinActivation {

    // Attributes

    // Operations of the class
    /**
     * operation receiveOffer <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void receiveOffer() {
        // Forward the offer to the action activation. [When all input pins are
        // ready, the action will fire them.]

        this.actionActivation.receiveOffer();
    } // receiveOffer

    /**
     * operation isReady <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isReady() {
        // Return true if the total number of tokens already being offered by
        // this pin plus those being offered by the sources of incoming edges is
        // at least equal to the minimum multiplicity of the pin.

        boolean ready;
        if (!super.isReady()) {
            ready = false;
        } else {
            int totalTokenCount = this.countUnofferedTokens();
            int i = 1;
            while (i <= this.incomingEdges.size()) {
                totalTokenCount = totalTokenCount
                        + this.incomingEdges.getValue(i - 1).countOfferedTokens();
                i = i + 1;
            }

            int minimum = ((Pin) (this.node)).multiplicityElement.lower;
            ready = totalTokenCount >= minimum;
        }

        return ready;
    } // isReady

    /**
     * operation countUnofferedTokens <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    public int countUnofferedTokens() {
        // Limit the number of tokens to be offered to no more than the upper
        // multiplicity of the pin.

        int count = super.countUnofferedTokens();

        int upper = ((Pin) (this.node)).multiplicityElement.upper.naturalValue;

        // Note that upper < 0 indicates an unbounded upper multiplicity.
        int limitedCount = upper;
        if (upper < 0 | count <= upper) {
            limitedCount = count;
        }

        return limitedCount;
    } // countUnofferedTokens

} // InputPinActivation
