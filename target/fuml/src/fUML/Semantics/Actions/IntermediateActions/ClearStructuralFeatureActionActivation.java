
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

package fUML.Semantics.Actions.IntermediateActions;

import fUML.Debug;
import UMLPrimitiveTypes.*;

import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.*;
import fUML.Syntax.CommonBehaviors.Communications.*;
import fUML.Syntax.Activities.IntermediateActivities.*;
import fUML.Syntax.Actions.BasicActions.*;
import fUML.Syntax.Actions.IntermediateActions.*;

import fUML.Semantics.*;
import fUML.Semantics.Classes.Kernel.*;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.*;
import fUML.Semantics.Activities.IntermediateActivities.*;
import fUML.Semantics.Actions.BasicActions.*;
import fUML.Semantics.Loci.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * 
 * <em><b>fUML::Semantics::Actions::IntermediateActions::ClearStructuralFeatureActionActivation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link ClearStructuralFeatureActionActivation#doAction <em>doAction</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class ClearStructuralFeatureActionActivation
		extends
		fUML.Semantics.Actions.IntermediateActions.StructuralFeatureActionActivation {

	/**
	 * operation doAction <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void doAction() {
		// Get the value of the object input pin.
		// If the given feature is an association end, then
		// destroy all links that have the object input on the opposite end.
		// Otherwise, if the object input is a structured value, then
		// set the appropriate feature of the input value to be empty.

		ClearStructuralFeatureAction action = (ClearStructuralFeatureAction) (this.node);
		StructuralFeature feature = action.structuralFeature;
		Association association = this.getAssociation(feature);

		Value value = this.takeTokens(action.object).getValue(0);

		if (association != null) {
			LinkList links = this.getMatchingLinks(association, feature, value);
			for (int i = 0; i < links.size(); i++) {
				Link link = links.getValue(i);
				link.destroy();
			}
		} else if (value instanceof StructuredValue) {
			((StructuredValue) value).setFeatureValue(action.structuralFeature,
					new ValueList(), 0);
		}

		if (action.result != null) {
			this.putToken(action.result, value);
		}
	} // doAction

} // ClearStructuralFeatureActionActivation
