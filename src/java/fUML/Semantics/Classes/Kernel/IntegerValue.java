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
 * <em><b>fUML::Semantics::Classes::Kernel::IntegerValue</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link IntegerValue#specify <em>specify</em>}</li>
 * <li>{@link IntegerValue#equals <em>equals</em>}</li>
 * <li>{@link IntegerValue#copy <em>copy</em>}</li>
 * <li>{@link IntegerValue#new_ <em>new_</em>}</li>
 * <li>{@link IntegerValue#toString <em>toString</em>}</li>
 * <li>{@link IntegerValue#value <em>value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class IntegerValue extends fUML.Semantics.Classes.Kernel.PrimitiveValue {

    // Attributes
    public int value = 0;

    // Operations of the class
    /**
     * operation specify <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Syntax.Classes.Kernel.ValueSpecification specify() {
        // Return a literal integer with the value of this integer value.

        LiteralInteger literal = new LiteralInteger();

        literal.type = this.type;
        literal.value = this.value;

        return literal;
    }

    /**
     * operation equals <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public boolean equals(fUML.Semantics.Classes.Kernel.Value otherValue) {
        // Test if this integer value is equal to the otherValue.
        // To be equal, the otherValue must have the same value as this integer
        // value.

        boolean isEqual = false;
        if (otherValue instanceof IntegerValue) {
            isEqual = ((IntegerValue) otherValue).value == this.value;
        }

        return isEqual;

    }

    /**
     * operation copy <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.Classes.Kernel.Value copy() {
        // Create a new integer value with the same value as this integer value.

        IntegerValue newValue = (IntegerValue) (super.copy());

        newValue.value = this.value;
        return newValue;

    }

    /**
     * operation new_ <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    protected fUML.Semantics.Classes.Kernel.Value new_() {
        // Create a new integer value with no value.

        return new IntegerValue();
    }

    /**
     * operation toString <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public String toString() {
        return String.valueOf(this.value);
    }

} // IntegerValue
