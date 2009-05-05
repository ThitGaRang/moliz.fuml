



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
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fUML::Semantics::Activities::IntermediateActivities::ActivityEdgeInstance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link ActivityEdgeInstance#sendOffer <em>sendOffer</em>}</li>
	 *   <li>{@link ActivityEdgeInstance#takeOfferedTokens <em>takeOfferedTokens</em>}</li>
	 *   <li>{@link ActivityEdgeInstance#countOfferedTokens <em>countOfferedTokens</em>}</li>
	 *   <li>{@link ActivityEdgeInstance#hasOffer <em>hasOffer</em>}</li>
	 *   <li>{@link ActivityEdgeInstance#getOfferedTokens <em>getOfferedTokens</em>}</li>
	 *   <li>{@link ActivityEdgeInstance#getNextOffer <em>getNextOffer</em>}</li>
	 	 *   <li>{@link ActivityEdgeInstance#edge <em>edge</em>}</li>
	 *   <li>{@link ActivityEdgeInstance#group <em>group</em>}</li>
	 *   <li>{@link ActivityEdgeInstance#source <em>source</em>}</li>
	 *   <li>{@link ActivityEdgeInstance#target <em>target</em>}</li>
	 *   <li>{@link ActivityEdgeInstance#offers <em>offers</em>}</li>
	 * </ul>
 * </p>
 *
 * @generated
 */

public   class ActivityEdgeInstance    {
    
	// Attributes
	public   fUML.Syntax.Activities.IntermediateActivities.ActivityEdge edge =  null;
	public   fUML.Semantics.Activities.IntermediateActivities.ActivityNodeActivationGroup group =  null;
	public   fUML.Semantics.Activities.IntermediateActivities.ActivityNodeActivation source =  null;
	public   fUML.Semantics.Activities.IntermediateActivities.ActivityNodeActivation target =  null;
	public   fUML.Semantics.Activities.IntermediateActivities.OfferList offers = new fUML.Semantics.Activities.IntermediateActivities.OfferList();
    
	// Operations of the class
  /**
   * operation sendOffer
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */
	public      void sendOffer(fUML.Semantics.Activities.IntermediateActivities.TokenList tokens)   {
// Send an offer  from the source to the target.
// Keep the offered tokens until taken by the target.
// (Note that any one edge should only be handling either all object tokens or all control tokens.)

Offer offer = new Offer();

for (int i = 0; i < tokens.size(); i++) {
    Token token = tokens.getValue(i);
    // Debug.println("[sendOffer] token value = " + token.getValue());
    offer.offeredTokens.addValue(token);
}

this.offers.addValue(offer);

this.target.receiveOffer();

	  } // sendOffer

  /**
   * operation takeOfferedTokens
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */
	public     fUML.Semantics.Activities.IntermediateActivities.TokenList takeOfferedTokens()   {
// Take all the offered tokens and return them.

TokenList tokens = this.getOfferedTokens();

if (this.hasOffer()) {
    this.offers.removeValue(0);
}

return tokens;
	  } // takeOfferedTokens

  /**
   * operation countOfferedTokens
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */
	public     int countOfferedTokens()   {
// Return the number of tokens being offered.
// Remove any tokens that have already been consumed and don't include them in the count.

Offer offer = this.getNextOffer();

int count = 0;
if (offer != null) {
    count = offer.countOfferedTokens();
}

return count;	  } // countOfferedTokens

  /**
   * operation hasOffer
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */
	public     boolean hasOffer()   {
// Return true if there are any pending offers.

return this.getNextOffer() != null;
	  } // hasOffer

  /**
   * operation getOfferedTokens
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */
	public     fUML.Semantics.Activities.IntermediateActivities.TokenList getOfferedTokens()   {
// Get the offered tokens (after which the tokens will still be offered).

Offer nextOffer = this.getNextOffer();

TokenList offeredTokens = new TokenList();
if (nextOffer != null) {
   offeredTokens = nextOffer.getOfferedTokens();
}

return offeredTokens;
	  } // getOfferedTokens

  /**
   * operation getNextOffer
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */
	public     fUML.Semantics.Activities.IntermediateActivities.Offer getNextOffer()   {
// Return the next offer on this edge instance that still has tokens that are not withdrawn.
// Remove any empty offers before the one returned.

Offer nextOffer = null;
while (nextOffer == null & this.offers.size() > 0) {
    Offer offer = this.offers.getValue(0);
    offer.removeWithdrawnTokens();
    if (offer.countOfferedTokens() == 0) {
        this.offers.remove(0);
    } else {
        nextOffer = offer;
    }
}

return nextOffer;	  } // getNextOffer

} //ActivityEdgeInstance
