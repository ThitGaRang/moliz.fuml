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

package fUML.Semantics.Classes.Kernel;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;

import fUML.Semantics.*;
import fUML.Semantics.Loci.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Semantics::Classes::Kernel::Link</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link Link#destroy <em>destroy</em>}</li>
 * <li>{@link Link#copy <em>copy</em>}</li>
 * <li>{@link Link#new_ <em>new_</em>}</li>
 * <li>{@link Link#getTypes <em>getTypes</em>}</li>
 * <li>{@link Link#setFeatureValue <em>setFeatureValue</em>}</li>
 * <li>{@link Link#type <em>type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class Link extends fUML.Semantics.Classes.Kernel.ExtensionalValue {

    // Attributes
    public fUML.Syntax.Classes.Kernel.Association type = new fUML.Syntax.Classes.Kernel.Association();

    // Operations of the class
    /**
     * operation destroy <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void destroy() {
        // Remove the type of this link and destroy it.

        this.type = null;
        super.destroy();

    }

    /**
     * operation copy <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.Classes.Kernel.Value copy() {
        // Create a new link with the same type, locus and feature values as
        // this link.

        Link newValue = (Link) (super.copy());

        newValue.type = this.type;

        return newValue;

    }

    /**
     * operation new_ <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    protected fUML.Semantics.Classes.Kernel.Value new_() {
        // Create a new link with no type or properies.

        return new Link();

    }

    /**
     * operation getTypes <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Syntax.Classes.Kernel.ClassifierList getTypes() {
        // Return the single type of this link (if any).

        ClassifierList types = new ClassifierList();

        if (this.type != null) {
            types.addValue(this.type);
        }

        return types;

    }

    /**
     * operation setFeatureValue <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setFeatureValue(fUML.Syntax.Classes.Kernel.StructuralFeature feature,
            fUML.Semantics.Classes.Kernel.ValueList values, int position) {
        // If a position is given, before setting the given feature value,
        // adjust the position values of the ends of other links for this same
        // feature.

        if (position > 0) {
            ExtensionalValueList extent = this.locus.getExtent(this.type);
            for (int i = 0; i < extent.size(); i++) {
                ExtensionalValue value = extent.getValue(i);
                FeatureValue featureValue = value.getFeatureValue(feature);
                if (featureValue.position >= position) {
                    featureValue.position = featureValue.position + 1;
                }
            }
        }

        super.setFeatureValue(feature, values, position);

    }

} // Link
