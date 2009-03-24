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
 * <em><b>fUML::Syntax::Classes::Kernel::Slot</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link Slot#setDefiningFeature <em>setDefiningFeature</em>}</li>
 * <li>{@link Slot#addValue <em>addValue</em>}</li>
 * <li>{@link Slot#owningInstance <em>owningInstance</em>}</li>
 * <li>{@link Slot#definingFeature <em>definingFeature</em>}</li>
 * <li>{@link Slot#value <em>value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class Slot extends fUML.Syntax.Classes.Kernel.Element {

    // Attributes
    public fUML.Syntax.Classes.Kernel.InstanceSpecification owningInstance = new fUML.Syntax.Classes.Kernel.InstanceSpecification();
    public fUML.Syntax.Classes.Kernel.StructuralFeature definingFeature = null;
    public fUML.Syntax.Classes.Kernel.ValueSpecificationList value = new fUML.Syntax.Classes.Kernel.ValueSpecificationList();

    // Operations of the class
    /**
     * operation setDefiningFeature <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */

    public void setDefiningFeature(fUML.Syntax.Classes.Kernel.StructuralFeature definingFeature) {
        this.definingFeature = definingFeature;

    }

    /**
     * operation addValue <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void addValue(fUML.Syntax.Classes.Kernel.ValueSpecification value) {
        this.addOwnedElement(value);
        this.value.addValue(value);

    }

} // Slot
