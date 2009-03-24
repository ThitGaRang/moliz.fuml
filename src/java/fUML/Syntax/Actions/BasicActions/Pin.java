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

package fUML.Syntax.Actions.BasicActions;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Syntax::Actions::BasicActions::Pin</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link Pin#setIsOrdered <em>setIsOrdered</em>}</li>
 * <li>{@link Pin#setIsUnique <em>setIsUnique</em>}</li>
 * <li>{@link Pin#setUpperValue <em>setUpperValue</em>}</li>
 * <li>{@link Pin#setLowerValue <em>setLowerValue</em>}</li>
 * <li>{@link Pin#setUpper <em>setUpper</em>}</li>
 * <li>{@link Pin#setLower <em>setLower</em>}</li>
 * <li>{@link Pin#isControl <em>isControl</em>}</li>
 * <li>{@link Pin#multiplicityElement <em>multiplicityElement</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public abstract class Pin extends fUML.Syntax.Activities.IntermediateActivities.ObjectNode {

    // Attributes
    public boolean isControl = false;
    public fUML.Syntax.Classes.Kernel.MultiplicityElement multiplicityElement = new fUML.Syntax.Classes.Kernel.MultiplicityElement();

    // Operations of the class
    /**
     * operation setIsOrdered <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setIsOrdered(boolean isOrdered) {
        this.multiplicityElement.setIsOrdered(isOrdered);
    }

    /**
     * operation setIsUnique <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setIsUnique(boolean isUnique) {
        this.multiplicityElement.setIsUnique(isUnique);

    }

    /**
     * operation setUpperValue <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setUpperValue(fUML.Syntax.Classes.Kernel.ValueSpecification upperValue) {
        this.multiplicityElement.setUpperValue(upperValue);

    }

    /**
     * operation setLowerValue <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setLowerValue(fUML.Syntax.Classes.Kernel.ValueSpecification lowerValue) {
        this.multiplicityElement.setLowerValue(lowerValue);

    }

    /**
     * operation setUpper <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setUpper(int upper) {
        // Note: This is a convenience operation that may be used _instead_ of
        // setUpperValue, not in addition to it.

        this.multiplicityElement.setUpper(upper);

    }

    /**
     * operation setLower <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setLower(int lower) {
        // Note: This is a convenience operation that may be used _instead_ of
        // setLowerValue, not in addition to it.

        this.multiplicityElement.setLower(lower);

    }

} // Pin
