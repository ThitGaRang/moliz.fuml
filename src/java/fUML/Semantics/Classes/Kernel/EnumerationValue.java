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
 * <em><b>fUML::Semantics::Classes::Kernel::EnumerationValue</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link EnumerationValue#specify <em>specify</em>}</li>
 * <li>{@link EnumerationValue#equals <em>equals</em>}</li>
 * <li>{@link EnumerationValue#copy <em>copy</em>}</li>
 * <li>{@link EnumerationValue#new_ <em>new_</em>}</li>
 * <li>{@link EnumerationValue#getTypes <em>getTypes</em>}</li>
 * <li>{@link EnumerationValue#toString <em>toString</em>}</li>
 * <li>{@link EnumerationValue#literal <em>literal</em>}</li>
 * <li>{@link EnumerationValue#type <em>type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class EnumerationValue extends fUML.Semantics.Classes.Kernel.Value {

    // Attributes
    public fUML.Syntax.Classes.Kernel.EnumerationLiteral literal = new fUML.Syntax.Classes.Kernel.EnumerationLiteral();
    public fUML.Syntax.Classes.Kernel.Enumeration type = new fUML.Syntax.Classes.Kernel.Enumeration();

    // Operations of the class
    /**
     * operation specify <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Syntax.Classes.Kernel.ValueSpecification specify() {
        // Return an instance value with literal as the instance.

        InstanceValue instanceValue = new InstanceValue();
        InstanceSpecification instance = new InstanceSpecification();

        instanceValue.type = this.type;
        instanceValue.instance = literal;

        return instanceValue;

    }

    /**
     * operation equals <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public boolean equals(fUML.Semantics.Classes.Kernel.Value otherValue) {
        // Test if this enumeration value is equal to the otherValue.
        // To be equal, the otherValue must also be an enumeration value with
        // the same literal as this enumeration value.

        boolean isEqual = false;
        if (otherValue instanceof EnumerationValue) {
            isEqual = ((EnumerationValue) otherValue).literal == this.literal;
        }

        return isEqual;

    }

    /**
     * operation copy <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.Classes.Kernel.Value copy() {
        // Create a new enumeration value with the same literal as this
        // enumeration value.

        EnumerationValue newValue = (EnumerationValue) (super.copy());

        newValue.type = this.type;
        newValue.literal = this.literal;

        return newValue;

    }

    /**
     * operation new_ <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    protected fUML.Semantics.Classes.Kernel.Value new_() {
        // Create a new enumeration value with no literal.

        return new EnumerationValue();

    }

    /**
     * operation getTypes <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Syntax.Classes.Kernel.ClassifierList getTypes() {
        // Return the single type of this enumeration value.

        ClassifierList types = new ClassifierList();
        types.addValue(this.type);

        return types;

    }

    /**
     * operation toString <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public String toString() {
        return literal.name;

    }

} // EnumerationValue
