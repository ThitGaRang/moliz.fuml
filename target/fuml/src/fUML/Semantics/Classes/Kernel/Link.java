
/*
 * Initial version copyright 2008 Lockheed Martin Corporation, except  
 * as stated in the file entitled Licensing-Information. 
 * 
 * All modifications copyright 2009 Data Access Technologies, Inc.
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php), except as stated 
 * in the file entitled Licensing-Information. 
 *
 * Contributors:
 *   MDS - initial API and implementation
 *
 */

package fUML.Semantics.Classes.Kernel;

import fUML.Debug;
import UMLPrimitiveTypes.*;

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

	public fUML.Syntax.Classes.Kernel.Association type = null;

	/**
	 * operation destroy <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void destroy() {
		// Remove the type of this link and destroy it.
		// Shift the positions of the feature values of any remaining links in
		// the extent of the same association, for ends that are ordered.

		Debug.println("[destroy] link = " + this.objectId());

		PropertyList ends = this.type.memberEnd;
		ExtensionalValueList extent = this.locus.getExtent(this.type);

		for (int i = 0; i < extent.size(); i++) {
			ExtensionalValue otherLink = extent.getValue(i);
			for (int j = 0; j < ends.size(); j++) {
				Property end = ends.getValue(j);
				if (end.multiplicityElement.isOrdered) {
					FeatureValue featureValue = otherLink.getFeatureValue(end);
					if (this.getFeatureValue(end).position < featureValue.position) {
						featureValue.position = featureValue.position - 1;
					}
				}
			}
		}

		this.type = null;
		super.destroy();
	} // destroy

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
	} // copy

	/**
	 * operation new_ <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected fUML.Semantics.Classes.Kernel.Value new_() {
		// Create a new link with no type or properies.

		return new Link();
	} // new_

	/**
	 * operation getTypes <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public fUML.Syntax.Classes.Kernel.ClassifierList getTypes() {
		// Return the single type of this link (if any).

		ClassifierList types = null;

		if (this.type == null) {
			types = new ClassifierList();
		} else {
			types = new ClassifierList();
			types.addValue(this.type);
		}

		return types;

	} // getTypes

	/**
	 * operation setFeatureValue <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFeatureValue(
			fUML.Syntax.Classes.Kernel.StructuralFeature feature,
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
	} // setFeatureValue

} // Link