



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
import fUML.Semantics.Activities.IntermediateActivities.*;
import fUML.Semantics.Loci.*;


								    		

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fUML::Semantics::Actions::BasicActions::PinActivation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link PinActivation#fire <em>fire</em>}</li>
	 	 *   <li>{@link PinActivation#actionActivation <em>actionActivation</em>}</li>
	 * </ul>
 * </p>
 *
 * @generated
 */


public  abstract class PinActivation    extends fUML.Semantics.Activities.IntermediateActivities.ObjectNodeActivation    {
 	    
	// Attributes
 	 		public   fUML.Semantics.Actions.BasicActions.ActionActivation actionActivation = 	 null
	;
	    
// Operations of the class
	  /**
   * operation fire
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void fire(fUML.Semantics.Activities.IntermediateActivities.TokenList incomingTokens)   {
	 		 	 			// Take tokens from all incoming edges.
// [Note that a pin will consume all tokens offered to it, even if this is more than the multiplicity upper bound, but will only offer tokens up to that upper bound.]

Debug.println("[fire] Pin " + this.node.name + "...");

this.addTokens(incomingTokens);
this.sendUnofferedTokens();



								    			  }
	
} //PinActivation
