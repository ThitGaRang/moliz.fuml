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
 * <em><b>fUML::Syntax::Actions::IntermediateActions::LinkEndCreationData</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link LinkEndCreationData#setIsReplaceAll <em>setIsReplaceAll</em>}</li>
 * <li>{@link LinkEndCreationData#setInsertAt <em>setInsertAt</em>}</li>
 * <li>{@link LinkEndCreationData#isReplaceAll <em>isReplaceAll</em>}</li>
 * <li>{@link LinkEndCreationData#insertAt <em>insertAt</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class LinkEndCreationData extends fUML.Syntax.Actions.IntermediateActions.LinkEndData {

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
        this.insertAt = insertAt;

    }

} // LinkEndCreationData
