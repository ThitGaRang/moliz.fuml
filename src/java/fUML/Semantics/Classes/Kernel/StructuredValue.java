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
 * <em><b>fUML::Semantics::Classes::Kernel::StructuredValue</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link StructuredValue#specify <em>specify</em>}</li>
 * <li>{@link StructuredValue#getFeatureValue <em>getFeatureValue</em>}</li>
 * <li>{@link StructuredValue#setFeatureValue <em>setFeatureValue</em>}</li>
 * <li>{@link StructuredValue#getFeatureValues <em>getFeatureValues</em>}</li>
 * <li>{@link StructuredValue#createFeatureValues <em>createFeatureValues</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public abstract class StructuredValue extends fUML.Semantics.Classes.Kernel.Value {

    // Attributes

    // Operations of the class
    /**
     * operation specify <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Syntax.Classes.Kernel.ValueSpecification specify() {
        // Return an instance value that specifies this structured value.

        // Debug.println("[specify] StructuredValue...");

        InstanceValue instanceValue = new InstanceValue();
        InstanceSpecification instance = new InstanceSpecification();

        instanceValue.type = null;
        instanceValue.instance = instance;

        instance.classifier = this.getTypes();

        FeatureValueList featureValues = this.getFeatureValues();
        // Debug.println("[specify] " + featureValues.size() + " feature(s).");

        for (int i = 0; i < featureValues.size(); i++) {
            FeatureValue featureValue = featureValues.getValue(i);

            Slot slot = new Slot();
            slot.definingFeature = featureValue.feature;

            // Debug.println("[specify] feature = " + featureValue.feature.name
            // + ", " + featureValue.values.size() + " value(s).");

            ValueList values = featureValue.values;
            for (int j = 0; j < values.size(); j++) {
                Value value = values.getValue(j);
                // Debug.println("[specify] value = " + value);
                slot.value.addValue(value.specify());
            }

            instance.slot.addValue(slot);
        }

        return instanceValue;

    }

    /**
     * operation getFeatureValue <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public abstract fUML.Semantics.Classes.Kernel.FeatureValue getFeatureValue(
            fUML.Syntax.Classes.Kernel.StructuralFeature feature);

    /**
     * operation setFeatureValue <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public abstract void setFeatureValue(fUML.Syntax.Classes.Kernel.StructuralFeature feature,
            fUML.Semantics.Classes.Kernel.ValueList values, int position);

    /**
     * operation getFeatureValues <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public abstract fUML.Semantics.Classes.Kernel.FeatureValueList getFeatureValues();

    /**
     * operation createFeatureValues <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */

    public void createFeatureValues() {
        // Create empty feature values for all structural features, direct and
        // inherited, of the types of this structured value.

        ClassifierList types = this.getTypes();

        for (int i = 0; i < types.size(); i++) {
            Classifier type = types.getValue(i);
            NamedElementList members = type.member;

            for (int j = 0; j < members.size(); j++) {
                NamedElement member = members.getValue(j);
                if (member instanceof StructuralFeature) {
                    this.setFeatureValue((StructuralFeature) member, new ValueList(), 0);
                }
            }
        }

    }

} // StructuredValue
