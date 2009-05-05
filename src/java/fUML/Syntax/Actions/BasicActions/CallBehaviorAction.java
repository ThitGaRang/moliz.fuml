



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

package fUML.Syntax.Actions.BasicActions;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fUML::Syntax::Actions::BasicActions::CallBehaviorAction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link CallBehaviorAction#setBehavior <em>setBehavior</em>}</li>
	 	 *   <li>{@link CallBehaviorAction#behavior <em>behavior</em>}</li>
	 * </ul>
 * </p>
 *
 * @generated
 */

public   class CallBehaviorAction    extends fUML.Syntax.Actions.BasicActions.CallAction    {
    
	// Attributes
	public   fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior behavior =  null;
    
	// Operations of the class
  /**
   * operation setBehavior
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */
	public      void setBehavior(fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior behavior)   {
this.behavior = behavior;
	  } // setBehavior

} //CallBehaviorAction
