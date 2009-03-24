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

package fUML.Syntax.CommonBehaviors.Communications;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Syntax::CommonBehaviors::Communications::Signal</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link Signal#addOwnedAttribute <em>addOwnedAttribute</em>}</li>
 * <li>{@link Signal#ownedAttribute <em>ownedAttribute</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class Signal extends fUML.Syntax.Classes.Kernel.Classifier {

    // Attributes
    public fUML.Syntax.Classes.Kernel.PropertyList ownedAttribute = new fUML.Syntax.Classes.Kernel.PropertyList();

    // Operations of the class
    /**
     * operation addOwnedAttribute <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void addOwnedAttribute(fUML.Syntax.Classes.Kernel.Property ownedAttribute) {
        super.addAttribute(ownedAttribute);
        super.addOwnedMember(ownedAttribute);

        this.ownedAttribute.addValue(ownedAttribute);

    }

} // Signal
