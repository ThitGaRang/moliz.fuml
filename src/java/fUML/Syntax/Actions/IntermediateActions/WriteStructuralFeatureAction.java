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

package fUML.Syntax.Actions.IntermediateActions;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Syntax::Actions::IntermediateActions::WriteStructuralFeatureAction</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link WriteStructuralFeatureAction#setResult <em>setResult</em>}</li>
 * <li>{@link WriteStructuralFeatureAction#setValue <em>setValue</em>}</li>
 * <li>{@link WriteStructuralFeatureAction#value <em>value</em>}</li>
 * <li>{@link WriteStructuralFeatureAction#result <em>result</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public abstract class WriteStructuralFeatureAction extends
        fUML.Syntax.Actions.IntermediateActions.StructuralFeatureAction {

    // Attributes
    public fUML.Syntax.Actions.BasicActions.InputPin value = new fUML.Syntax.Actions.BasicActions.InputPin();
    public fUML.Syntax.Actions.BasicActions.OutputPin result = new fUML.Syntax.Actions.BasicActions.OutputPin();

    // Operations of the class
    /**
     * operation setResult <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setResult(fUML.Syntax.Actions.BasicActions.OutputPin result) {
        super.addOutput(result);
        this.result = result;

    }

    /**
     * operation setValue <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setValue(fUML.Syntax.Actions.BasicActions.InputPin value) {
        super.addInput(value);
        this.value = value;

    }

} // WriteStructuralFeatureAction
