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
 * <em><b>fUML::Syntax::Actions::IntermediateActions::AddStructuralFeatureValueAction</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link AddStructuralFeatureValueAction#setIsReplaceAll <em>
 * setIsReplaceAll</em>}</li>
 * <li>{@link AddStructuralFeatureValueAction#setInsertAt <em>setInsertAt</em>}</li>
 * <li>{@link AddStructuralFeatureValueAction#isReplaceAll <em>isReplaceAll
 * </em>}</li>
 * <li>{@link AddStructuralFeatureValueAction#insertAt <em>insertAt</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class AddStructuralFeatureValueAction extends
        fUML.Syntax.Actions.IntermediateActions.WriteStructuralFeatureAction {

    // Attributes
    public boolean isReplaceAll = false;
    public fUML.Syntax.Actions.BasicActions.InputPin insertAt = new fUML.Syntax.Actions.BasicActions.InputPin();

    // Operations of the class
    /**
     * operation setIsReplaceAll <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setIsReplaceAll(boolean isReplaceAll) {
        this.isReplaceAll = isReplaceAll;

    }

    /**
     * operation setInsertAt <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setInsertAt(fUML.Syntax.Actions.BasicActions.InputPin insertAt) {
        if (insertAt != null) {
            super.addInput(insertAt);
        }

        this.insertAt = insertAt;

    }

} // AddStructuralFeatureValueAction
