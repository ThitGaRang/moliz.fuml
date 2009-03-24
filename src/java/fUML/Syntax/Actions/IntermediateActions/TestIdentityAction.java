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
 * <em><b>fUML::Syntax::Actions::IntermediateActions::TestIdentityAction</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link TestIdentityAction#setFirst <em>setFirst</em>}</li>
 * <li>{@link TestIdentityAction#setSecond <em>setSecond</em>}</li>
 * <li>{@link TestIdentityAction#setResult <em>setResult</em>}</li>
 * <li>{@link TestIdentityAction#second <em>second</em>}</li>
 * <li>{@link TestIdentityAction#result <em>result</em>}</li>
 * <li>{@link TestIdentityAction#first <em>first</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class TestIdentityAction extends fUML.Syntax.Actions.BasicActions.Action {

    // Attributes
    public fUML.Syntax.Actions.BasicActions.InputPin second = new fUML.Syntax.Actions.BasicActions.InputPin();
    public fUML.Syntax.Actions.BasicActions.OutputPin result = new fUML.Syntax.Actions.BasicActions.OutputPin();
    public fUML.Syntax.Actions.BasicActions.InputPin first = new fUML.Syntax.Actions.BasicActions.InputPin();

    // Operations of the class
    /**
     * operation setFirst <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setFirst(fUML.Syntax.Actions.BasicActions.InputPin first) {
        super.addInput(first);
        this.first = first;

    }

    /**
     * operation setSecond <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setSecond(fUML.Syntax.Actions.BasicActions.InputPin second) {
        super.addInput(second);
        this.second = second;

    }

    /**
     * operation setResult <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setResult(fUML.Syntax.Actions.BasicActions.OutputPin result) {
        super.addOutput(result);
        this.result = result;

    }

} // TestIdentityAction
