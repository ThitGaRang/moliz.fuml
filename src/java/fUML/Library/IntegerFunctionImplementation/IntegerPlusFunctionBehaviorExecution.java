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

package fUML.Library.IntegerFunctionImplementation;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * 
 * <em><b>fUML::Library::IntegerFunctionImplementation::IntegerPlusFunctionBehaviorExecution</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link IntegerPlusFunctionBehaviorExecution#doIntegerFunction <em>
 * doIntegerFunction</em>}</li>
 * <li>{@link IntegerPlusFunctionBehaviorExecution#new_ <em>new_</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class IntegerPlusFunctionBehaviorExecution extends
        fUML.Library.IntegerFunctionImplementation.IntegerFunctionBehaviorExecution {

    // Attributes

    // Operations of the class
    /**
     * operation doIntegerFunction <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public int doIntegerFunction(UMLPrimitiveTypes.intList arguments) {
        // Compute the integer plus function.

        // Debug.println("[doIntegerFunction] arguments[0] = " +
        // arguments.getValue(0) + ", arguments[1] = " + arguments.getValue(1));
        // Debug.println("[doIntegerFunction] sum = " + (arguments.getValue(0) +
        // arguments.getValue(1)));

        return arguments.getValue(0) + arguments.getValue(1);

    }

    /**
     * operation new_ <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.Classes.Kernel.Value new_() {
        // Create a new instance of this kind of function behavior execution.

        return new IntegerPlusFunctionBehaviorExecution();

    }

} // IntegerPlusFunctionBehaviorExecution
