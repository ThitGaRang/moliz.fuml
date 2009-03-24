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
 * <em><b>fUML::Semantics::Classes::Kernel::LiteralEvaluation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link LiteralEvaluation#getType <em>getType</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public abstract class LiteralEvaluation extends fUML.Semantics.Classes.Kernel.Evaluation {

    // Attributes

    // Operations of the class
    /**
     * operation getType <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Syntax.Classes.Kernel.PrimitiveType getType(String builtInTypeName) {
        // Get the type of the specification. If that is null, then use the
        // built-in type of the given name.

        PrimitiveType type = (PrimitiveType) (this.specification.type);

        if (type == null) {
            type = this.locus.factory.getBuiltInType(builtInTypeName);
        }

        return type;

    }

} // LiteralEvaluation
