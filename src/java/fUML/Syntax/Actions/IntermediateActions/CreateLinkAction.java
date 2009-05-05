



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

package fUML.Syntax.Actions.IntermediateActions;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fUML::Syntax::Actions::IntermediateActions::CreateLinkAction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link CreateLinkAction#addEndData <em>addEndData</em>}</li>
	 	 *   <li>{@link CreateLinkAction#endData <em>endData</em>}</li>
	 * </ul>
 * </p>
 *
 * @generated
 */

public   class CreateLinkAction    extends fUML.Syntax.Actions.IntermediateActions.WriteLinkAction    {
    
	// Attributes
	public   fUML.Syntax.Actions.IntermediateActions.LinkEndCreationDataList endData = new fUML.Syntax.Actions.IntermediateActions.LinkEndCreationDataList();
    
	// Operations of the class
  /**
   * operation addEndData
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */
	public      void addEndData(fUML.Syntax.Actions.IntermediateActions.LinkEndCreationData endData)   {
super.addEndData(endData);
this.endData.addValue(endData);
	  } // addEndData

} //CreateLinkAction
