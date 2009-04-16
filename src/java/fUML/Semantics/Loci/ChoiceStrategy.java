



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

package fUML.Semantics.Loci;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

 		 	 				    		

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fUML::Semantics::Loci::ChoiceStrategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link ChoiceStrategy#getName <em>getName</em>}</li>
	 *   <li>{@link ChoiceStrategy#choose <em>choose</em>}</li>
	 	 * </ul>
 * </p>
 *
 * @generated
 */


public  abstract class ChoiceStrategy    extends fUML.Semantics.Loci.SemanticStrategy    {
 	    
	// Attributes
 	    
// Operations of the class
	  /**
   * operation getName
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     String getName()   {
	 		 	 			// The name of a choice strategy is always "choice".

return "choice";

								    			  }
	
	  /**
   * operation choose
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public  abstract   int choose(int size)  ;
} //ChoiceStrategy
