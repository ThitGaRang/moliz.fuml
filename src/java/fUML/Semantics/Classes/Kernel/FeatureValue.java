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
 * <em><b>fUML::Semantics::Classes::Kernel::FeatureValue</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link FeatureValue#hasEqualValues <em>hasEqualValues</em>}</li>
 * <li>{@link FeatureValue#copy <em>copy</em>}</li>
 * <li>{@link FeatureValue#feature <em>feature</em>}</li>
 * <li>{@link FeatureValue#values <em>values</em>}</li>
 * <li>{@link FeatureValue#position <em>position</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class FeatureValue {

    // Attributes
    public fUML.Syntax.Classes.Kernel.StructuralFeature feature = null;
    public fUML.Semantics.Classes.Kernel.ValueList values = new fUML.Semantics.Classes.Kernel.ValueList();
    public int position = 0;

    // Operations of the class
    /**
     * operation hasEqualValues <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public boolean hasEqualValues(fUML.Semantics.Classes.Kernel.FeatureValue other) {
        // Determine if this feature value has an equal set of values as another
        // feature value.
        // If the feature is ordered, then the values also have to be in the
        // same order.

        boolean equal = true;

        if (this.values.size() != other.values.size()) {
            equal = false;

        } else {

            Debug.println("[hasEqualValues] feature = " + this.feature.name + ", "
                    + this.values.size() + " value(s).");

            if (this.feature.multiplicityElement.isOrdered) {
                int i = 1;
                while (equal & i <= this.values.size()) {
                    equal = this.values.getValue(i - 1).equals(other.values.getValue(i - 1));
                    i = i + 1;
                }

            } else {
                ValueList otherValues = new ValueList();
                ValueList values = other.values;
                for (int i = 0; i < values.size(); i++) {
                    Value value = values.getValue(i);
                    otherValues.addValue(value);
                }

                int i = 1;
                while (equal & i <= this.values.size()) {
                    Debug.println("[hasEqualValues] This value [" + (i - 1) + "] = "
                            + this.values.getValue(i - 1));

                    boolean matched = false;
                    int j = 1;
                    while (!matched & j <= otherValues.size()) {
                        if (this.values.getValue(i - 1).equals(otherValues.getValue(j - 1))) {
                            Debug.println("[hasEqualValues] Other value [" + (j - 1) + "] = "
                                    + otherValues.getValue(j - 1));
                            matched = true;
                            otherValues.remove(j - 1);
                        }
                        j = j + 1;
                    }

                    equal = matched;
                    i = i + 1;
                }
            }
        }

        return equal;

    }

    /**
     * operation copy <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.Classes.Kernel.FeatureValue copy() {
        // Create a copy of this feature value.

        FeatureValue newValue = new FeatureValue();

        newValue.feature = this.feature;
        newValue.position = this.position;

        ValueList values = this.values;
        for (int i = 0; i < values.size(); i++) {
            Value value = values.getValue(i);
            newValue.values.addValue(value.copy());
        }

        return newValue;

    }

} // FeatureValue
