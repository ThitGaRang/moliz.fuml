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
 * <em><b>fUML::Syntax::Actions::IntermediateActions::LinkEndDestructionData</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link LinkEndDestructionData#setIsDestroyDuplicates <em>
 * setIsDestroyDuplicates</em>}</li>
 * <li>{@link LinkEndDestructionData#setDestroyAt <em>setDestroyAt</em>}</li>
 * <li>{@link LinkEndDestructionData#isDestroyDuplicates <em>isDestroyDuplicates
 * </em>}</li>
 * <li>{@link LinkEndDestructionData#destroyAt <em>destroyAt</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class LinkEndDestructionData extends fUML.Syntax.Actions.IntermediateActions.LinkEndData {

    // Attributes
    public boolean isDestroyDuplicates = false;
    public fUML.Syntax.Actions.BasicActions.InputPin destroyAt = new fUML.Syntax.Actions.BasicActions.InputPin();

    // Operations of the class
    /**
     * operation setIsDestroyDuplicates <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */

    public void setIsDestroyDuplicates(boolean isDestroyDuplicates) {
        this.isDestroyDuplicates = isDestroyDuplicates;

    }

    /**
     * operation setDestroyAt <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setDestroyAt(fUML.Syntax.Actions.BasicActions.InputPin destroyAt) {
        this.destroyAt = destroyAt;

    }

} // LinkEndDestructionData
