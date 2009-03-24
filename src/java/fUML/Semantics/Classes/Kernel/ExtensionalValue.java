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
 * <em><b>fUML::Semantics::Classes::Kernel::ExtensionalValue</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link ExtensionalValue#destroy <em>destroy</em>}</li>
 * <li>{@link ExtensionalValue#copy <em>copy</em>}</li>
 * <li>{@link ExtensionalValue#locus <em>locus</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public abstract class ExtensionalValue extends fUML.Semantics.Classes.Kernel.CompoundValue {

    // Attributes
    public fUML.Semantics.Loci.Locus locus = null;

    // Operations of the class
    /**
     * operation destroy <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void destroy() {
        // Remove this value from its locus (if it has not already been
        // destroyed).

        if (this.locus != null) {
            this.locus.remove(this);
        }
    }

    /**
     * operation copy <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.Classes.Kernel.Value copy() {
        // Create a new extensional value with the same feature values at the
        // same locus as this one.

        ExtensionalValue newValue = (ExtensionalValue) (super.copy());

        if (this.locus != null) {
            this.locus.add(newValue);
        }

        return newValue;

    }

} // ExtensionalValue
