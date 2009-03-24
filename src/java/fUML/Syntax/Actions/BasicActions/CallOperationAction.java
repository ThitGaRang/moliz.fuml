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
 * <em><b>fUML::Syntax::Actions::BasicActions::CallOperationAction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link CallOperationAction#setTarget <em>setTarget</em>}</li>
 * <li>{@link CallOperationAction#setOperation <em>setOperation</em>}</li>
 * <li>{@link CallOperationAction#operation <em>operation</em>}</li>
 * <li>{@link CallOperationAction#target <em>target</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class CallOperationAction extends fUML.Syntax.Actions.BasicActions.CallAction {

    // Attributes
    public fUML.Syntax.Classes.Kernel.Operation operation = new fUML.Syntax.Classes.Kernel.Operation();
    public fUML.Syntax.Actions.BasicActions.InputPin target = new fUML.Syntax.Actions.BasicActions.InputPin();

    // Operations of the class
    /**
     * operation setTarget <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setTarget(fUML.Syntax.Actions.BasicActions.InputPin target) {
        super.addInput(target);
        this.target = target;

    }

    /**
     * operation setOperation <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setOperation(fUML.Syntax.Classes.Kernel.Operation operation) {
        this.operation = operation;

    }

} // CallOperationAction
