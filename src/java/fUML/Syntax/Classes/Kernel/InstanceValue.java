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
 * <em><b>fUML::Syntax::Classes::Kernel::InstanceValue</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link InstanceValue#setInstance <em>setInstance</em>}</li>
 * <li>{@link InstanceValue#instance <em>instance</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class InstanceValue extends fUML.Syntax.Classes.Kernel.ValueSpecification {

    // Attributes
    public fUML.Syntax.Classes.Kernel.InstanceSpecification instance = new fUML.Syntax.Classes.Kernel.InstanceSpecification();

    // Operations of the class
    /**
     * operation setInstance <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setInstance(fUML.Syntax.Classes.Kernel.InstanceSpecification instance) {
        this.instance = instance;

    }

} // InstanceValue
