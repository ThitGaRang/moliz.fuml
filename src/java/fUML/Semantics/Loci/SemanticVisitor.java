



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
 * An implementation of the model object '<em><b>fUML::Semantics::Loci::SemanticVisitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link SemanticVisitor#_endIsolation <em>_endIsolation</em>}</li>
	 *   <li>{@link SemanticVisitor#_beginIsolation <em>_beginIsolation</em>}</li>
	 	 * </ul>
 * </p>
 *
 * @generated
 */


public  abstract class SemanticVisitor    {
 	    
	// Attributes
 	    
// Operations of the class
	  /**
   * operation _endIsolation
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public    static  void _endIsolation()   {
	 		 	 			Debug.println("[_endIsolation] End isolation.");

								    			  }
	
	  /**
   * operation _beginIsolation
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public    static  void _beginIsolation()   {
	 		 	 			Debug.println("[_beginIsolation] Begin isolation.");

								    			  }
	
} //SemanticVisitor
