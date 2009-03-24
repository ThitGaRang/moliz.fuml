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

package fUML.Semantics.Classes.Kernel;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;

import fUML.Semantics.*;
import fUML.Semantics.Loci.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Semantics::Classes::Kernel::LiteralIntegerEvaluation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link LiteralIntegerEvaluation#evaluate <em>evaluate</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class LiteralIntegerEvaluation extends fUML.Semantics.Classes.Kernel.LiteralEvaluation {

    // Attributes

    // Operations of the class
    /**
     * operation evaluate <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.Classes.Kernel.Value evaluate() {
        // Evaluate a literal integer, producing an integer value.

        LiteralInteger literal = (LiteralInteger) specification;
        IntegerValue integerValue = new IntegerValue();
        integerValue.type = this.getType("Integer");
        integerValue.value = literal.value;

        return integerValue;

    }

} // LiteralIntegerEvaluation
