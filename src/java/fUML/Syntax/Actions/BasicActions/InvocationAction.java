



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
 * An implementation of the model object '<em><b>fUML::Syntax::Actions::BasicActions::InvocationAction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link InvocationAction#addArgument <em>addArgument</em>}</li>
	 	 *   <li>{@link InvocationAction#argument <em>argument</em>}</li>
	 * </ul>
 * </p>
 *
 * @generated
 */

public  abstract class InvocationAction    extends fUML.Syntax.Actions.BasicActions.Action    {
    
	// Attributes
	public   fUML.Syntax.Actions.BasicActions.InputPinList argument = new fUML.Syntax.Actions.BasicActions.InputPinList();
    
	// Operations of the class
  /**
   * operation addArgument
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */
	public      void addArgument(fUML.Syntax.Actions.BasicActions.InputPin argument)   {
super.addInput(argument);
this.argument.addValue(argument);	  } // addArgument

} //InvocationAction
