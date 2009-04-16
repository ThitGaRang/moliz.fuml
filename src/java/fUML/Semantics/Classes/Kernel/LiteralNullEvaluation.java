



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

package fUML.Semantics.Classes.Kernel;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

 		 	 				    		 	 			import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;

import fUML.Semantics.*;
import fUML.Semantics.Loci.*;




								    		

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fUML::Semantics::Classes::Kernel::LiteralNullEvaluation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link LiteralNullEvaluation#evaluate <em>evaluate</em>}</li>
	 	 * </ul>
 * </p>
 *
 * @generated
 */


public   class LiteralNullEvaluation    extends fUML.Semantics.Classes.Kernel.LiteralEvaluation    {
 	    
	// Attributes
 	    
// Operations of the class
	  /**
   * operation evaluate
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     fUML.Semantics.Classes.Kernel.Value evaluate()   {
	 		 	 			// Evaluate a literal null, returning nothing (since a null represents an "absence of any value").

return null;

								    			  }
	
} //LiteralNullEvaluation
