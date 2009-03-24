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
 * <em><b>fUML::Syntax::Actions::IntermediateActions::StructuralFeatureAction</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link StructuralFeatureAction#setStructuralFeature <em>
 * setStructuralFeature</em>}</li>
 * <li>{@link StructuralFeatureAction#setObject <em>setObject</em>}</li>
 * <li>{@link StructuralFeatureAction#structuralFeature <em>structuralFeature
 * </em>}</li>
 * <li>{@link StructuralFeatureAction#object <em>object</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public abstract class StructuralFeatureAction extends fUML.Syntax.Actions.BasicActions.Action {

    // Attributes
    public fUML.Syntax.Classes.Kernel.StructuralFeature structuralFeature = null;
    public fUML.Syntax.Actions.BasicActions.InputPin object = new fUML.Syntax.Actions.BasicActions.InputPin();

    // Operations of the class
    /**
     * operation setStructuralFeature <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */

    public void setStructuralFeature(fUML.Syntax.Classes.Kernel.StructuralFeature structuralFeature) {
        this.structuralFeature = structuralFeature;

    }

    /**
     * operation setObject <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setObject(fUML.Syntax.Actions.BasicActions.InputPin object) {
        super.addInput(object);
        this.object = object;
    }

} // StructuralFeatureAction
