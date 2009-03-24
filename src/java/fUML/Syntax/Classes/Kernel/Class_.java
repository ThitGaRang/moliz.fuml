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

package fUML.Syntax.Classes.Kernel;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Syntax::Classes::Kernel::Class_</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link Class_#setIsAbstract <em>setIsAbstract</em>}</li>
 * <li>{@link Class_#setIsActive <em>setIsActive</em>}</li>
 * <li>{@link Class_#addGeneralization <em>addGeneralization</em>}</li>
 * <li>{@link Class_#addOwnedAttribute <em>addOwnedAttribute</em>}</li>
 * <li>{@link Class_#addOwnedOperation <em>addOwnedOperation</em>}</li>
 * <li>{@link Class_#addOwnedReception <em>addOwnedReception</em>}</li>
 * <li>{@link Class_#inherit <em>inherit</em>}</li>
 * <li>{@link Class_#isAbstract <em>isAbstract</em>}</li>
 * <li>{@link Class_#ownedOperation <em>ownedOperation</em>}</li>
 * <li>{@link Class_#superClass <em>superClass</em>}</li>
 * <li>{@link Class_#isActive <em>isActive</em>}</li>
 * <li>{@link Class_#ownedReception <em>ownedReception</em>}</li>
 * <li>{@link Class_#ownedAttribute <em>ownedAttribute</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class Class_ extends fUML.Syntax.CommonBehaviors.BasicBehaviors.BehavioredClassifier {

    // Attributes
    public boolean isAbstract = false;
    public fUML.Syntax.Classes.Kernel.OperationList ownedOperation = new fUML.Syntax.Classes.Kernel.OperationList();
    public fUML.Syntax.Classes.Kernel.Class_List superClass = new fUML.Syntax.Classes.Kernel.Class_List();
    public boolean isActive = false;
    public fUML.Syntax.CommonBehaviors.Communications.ReceptionList ownedReception = new fUML.Syntax.CommonBehaviors.Communications.ReceptionList();
    public fUML.Syntax.Classes.Kernel.PropertyList ownedAttribute = new fUML.Syntax.Classes.Kernel.PropertyList();

    // Operations of the class
    /**
     * operation setIsAbstract <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setIsAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;

    }

    /**
     * operation setIsActive <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;

    }

    /**
     * operation addGeneralization <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void addGeneralization(fUML.Syntax.Classes.Kernel.Generalization generalization) {
        super.addGeneralization(generalization);

        if (generalization.general instanceof Class_) {
            this.superClass.addValue((Class_) generalization.general);
        }

    }

    /**
     * operation addOwnedAttribute <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void addOwnedAttribute(fUML.Syntax.Classes.Kernel.Property ownedAttribute) {
        super.addAttribute(ownedAttribute);
        super.addOwnedMember(ownedAttribute);

        this.ownedAttribute.addValue(ownedAttribute);
        ownedAttribute.class_ = this;

    }

    /**
     * operation addOwnedOperation <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void addOwnedOperation(fUML.Syntax.Classes.Kernel.Operation ownedOperation) {
        super.addFeature(ownedOperation);
        super.addOwnedMember(ownedOperation);

        this.ownedOperation.addValue(ownedOperation);
        ownedOperation.class_ = this;

    }

    /**
     * operation addOwnedReception <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void addOwnedReception(
            fUML.Syntax.CommonBehaviors.Communications.Reception ownedReception) {
        super.addOwnedMember(ownedReception);
        super.addFeature(ownedReception);

        this.ownedReception.addValue(ownedReception);
    }

    /**
     * operation inherit <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Syntax.Classes.Kernel.NamedElementList inherit(
            fUML.Syntax.Classes.Kernel.NamedElementList inhs) {
        // "The inherit operation is overridden to exclude redefined properties."

        RedefinableElementList redefinableMembers = new RedefinableElementList();

        for (int i = 0; i < this.ownedMember.size(); i++) {
            if (this.ownedMember.getValue(i) instanceof RedefinableElement) {
                redefinableMembers.addValue((RedefinableElement) this.ownedMember.getValue(i));
            }
        }

        NamedElementList inherited = new NamedElementList();

        for (int i = 0; i < inhs.size(); i++) {
            NamedElement inh = inhs.getValue(i);
            boolean exclude = false;
            for (int j = 0; j < redefinableMembers.size(); j++) {
                RedefinableElementList redefinedElements = redefinableMembers.getValue(j).redefinedElement;
                for (int k = 0; k < redefinedElements.size(); k++) {
                    if (redefinedElements.getValue(k) == inh) {
                        exclude = true;
                        break;
                    }
                }
                if (exclude)
                    break;
            }

            if (!exclude) {
                inherited.addValue(inh);
            }
        }

        return inherited;

    }

} // Class_
