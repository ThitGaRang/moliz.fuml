
/*
 * Initial version copyright 2008 Lockheed Martin Corporation, except  
 * as stated in the file entitled Licensing-Information. 
 * 
 * All modifications copyright 2009 Data Access Technologies, Inc.
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php), except as stated 
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
 * <em><b>fUML::Syntax::Classes::Kernel::Parameter</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link Parameter#setDirection <em>setDirection</em>}</li>
 * <li>{@link Parameter#setIsOrdered <em>setIsOrdered</em>}</li>
 * <li>{@link Parameter#setIsUnique <em>setIsUnique</em>}</li>
 * <li>{@link Parameter#setUpperValue <em>setUpperValue</em>}</li>
 * <li>{@link Parameter#setLowerValue <em>setLowerValue</em>}</li>
 * <li>{@link Parameter#setUpper <em>setUpper</em>}</li>
 * <li>{@link Parameter#setLower <em>setLower</em>}</li>
 * <li>{@link Parameter#direction <em>direction</em>}</li>
 * <li>{@link Parameter#operation <em>operation</em>}</li>
 * <li>{@link Parameter#isException <em>isException</em>}</li>
 * <li>{@link Parameter#isStream <em>isStream</em>}</li>
 * <li>{@link Parameter#effect <em>effect</em>}</li>
 * <li>{@link Parameter#multiplicityElement <em>multiplicityElement</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class Parameter extends fUML.Syntax.Classes.Kernel.TypedElement {

    // Attributes
    public fUML.Syntax.Classes.Kernel.ParameterDirectionKind direction = null;
    public fUML.Syntax.Classes.Kernel.Operation operation = null;
    public boolean isException = false;
    public boolean isStream = false;
    public fUML.Syntax.Classes.Kernel.ParameterEffectKind effect = null;
    public fUML.Syntax.Classes.Kernel.MultiplicityElement multiplicityElement = new fUML.Syntax.Classes.Kernel.MultiplicityElement();

    // Operations of the class
    /**
     * operation setDirection <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDirection(fUML.Syntax.Classes.Kernel.ParameterDirectionKind direction) {
        this.direction = direction;
    } // setDirection

    /**
     * operation setIsOrdered <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setIsOrdered(boolean isOrdered) {
        this.multiplicityElement.setIsOrdered(isOrdered);
    } // setIsOrdered

    /**
     * operation setIsUnique <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setIsUnique(boolean isUnique) {
        this.multiplicityElement.setIsUnique(isUnique);
    } // setIsUnique

    /**
     * operation setUpperValue <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setUpperValue(fUML.Syntax.Classes.Kernel.ValueSpecification upperValue) {
        this.multiplicityElement.setUpperValue(upperValue);
    } // setUpperValue

    /**
     * operation setLowerValue <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLowerValue(fUML.Syntax.Classes.Kernel.ValueSpecification lowerValue) {
        this.multiplicityElement.setLowerValue(lowerValue);
    } // setLowerValue

    /**
     * operation setUpper <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setUpper(int upper) {
        // Note: This is a convenience operation that may be used _instead_ of
        // setUpperValue, not in addition to it.

        this.multiplicityElement.setUpper(upper);
    } // setUpper

    /**
     * operation setLower <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLower(int lower) {
        // Note: This is a convenience operation that may be used _instead_ of
        // setLowerValue, not in addition to it.

        this.multiplicityElement.setLower(lower);

    } // setLower

} // Parameter
