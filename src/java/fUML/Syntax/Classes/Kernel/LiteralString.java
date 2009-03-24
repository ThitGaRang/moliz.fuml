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

package fUML.Syntax.Classes.Kernel;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Syntax::Classes::Kernel::LiteralString</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link LiteralString#setValue <em>setValue</em>}</li>
 * <li>{@link LiteralString#value <em>value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class LiteralString extends fUML.Syntax.Classes.Kernel.LiteralSpecification {

    // Attributes
    public String value = new String();

    // Operations of the class
    /**
     * operation setValue <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setValue(String value) {
        this.value = value;

    }

} // LiteralString
