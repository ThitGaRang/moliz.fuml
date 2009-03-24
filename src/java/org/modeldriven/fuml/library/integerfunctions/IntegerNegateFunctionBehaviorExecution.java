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


package org.modeldriven.fuml.library.integerfunctions;

import fUML.Semantics.Classes.Kernel.IntegerValue;
import fUML.Semantics.Classes.Kernel.Value;
import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * 
 * <em><b>org::modeldriven::fuml::library::integerfunctions::IntegerNegateFunctionBehaviorExecution</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link IntegerNegateFunctionBehaviorExecution#doIntegerFunction <em>
 * doIntegerFunction</em>}</li>
 * <li>{@link IntegerNegateFunctionBehaviorExecution#new_ <em>new_</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class IntegerNegateFunctionBehaviorExecution extends
        org.modeldriven.fuml.library.integerfunctions.IntegerFunctionBehaviorExecution {

    // Attributes

    // Operations of the class
	
    /**
     * operation doIntegerFunction <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Value doIntegerFunction(UMLPrimitiveTypes.intList arguments) {

    	int i1 = arguments.getValue(0);
    	IntegerValue iv = new IntegerValue();

        // Compute the negate  function.
        iv.value = -i1;
        
    	Debug.println("[doBody] Integer Negate result = " + iv.value);
    	return iv;
    }

    /**
     * operation new_ <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public fUML.Semantics.Classes.Kernel.Value new_() {
        // Create a new instance of this kind of function behavior execution.
        return new IntegerNegateFunctionBehaviorExecution();
    }

} // IntegerNegateFunctionBehaviorExecution
