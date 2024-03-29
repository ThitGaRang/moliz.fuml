
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
import fUML.Semantics.CommonBehaviors.Communications.*;
import fUML.Semantics.Loci.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Semantics::Classes::Kernel::Object</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link Object#startBehavior <em>startBehavior</em>}</li>
 * <li>{@link Object#dispatch <em>dispatch</em>}</li>
 * <li>{@link Object#send <em>send</em>}</li>
 * <li>{@link Object#destroy <em>destroy</em>}</li>
 * <li>{@link Object#register <em>register</em>}</li>
 * <li>{@link Object#unregister <em>unregister</em>}</li>
 * <li>{@link Object#copy <em>copy</em>}</li>
 * <li>{@link Object#new_ <em>new_</em>}</li>
 * <li>{@link Object#getTypes <em>getTypes</em>}</li>
 * <li>{@link Object#types <em>types</em>}</li>
 * <li>{@link Object#objectActivation <em>objectActivation</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class Object_ extends fUML.Semantics.Classes.Kernel.ExtensionalValue {

	public fUML.Syntax.Classes.Kernel.Class_List types = new fUML.Syntax.Classes.Kernel.Class_List();
	public fUML.Semantics.CommonBehaviors.Communications.ObjectActivation objectActivation = null;

	/**
	 * operation startBehavior <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void startBehavior(
			fUML.Syntax.Classes.Kernel.Class_ classifier,
			fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList inputs) {
		// Create an object activation for this object (if one does not already
		// exist) and start its behavior(s).

		// Debug.println("[startBehavior] On object...");

		if (this.objectActivation == null) {
			this.objectActivation = new ObjectActivation();
			this.objectActivation.object = this;
		}

		// Debug.println("[startBehavior] objectActivation = " +
		// objectActivation);

		this.objectActivation.startBehavior(classifier, inputs);
	} // startBehavior

	/**
	 * operation dispatch <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public fUML.Semantics.CommonBehaviors.BasicBehaviors.Execution dispatch(
			fUML.Syntax.Classes.Kernel.Operation operation) {
		// Dispatch the given operation to a method execution, using a dispatch
		// strategy.

		return ((DispatchStrategy) this.locus.factory.getStrategy("dispatch"))
				.dispatch(this, operation);
	} // dispatch

	/**
	 * operation send <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void send(
			fUML.Semantics.CommonBehaviors.Communications.SignalInstance signalInstance) {
		// If the object is active, add the given signal instance to the event
		// pool and signal that a new signal instance has arrived.

		if (this.objectActivation != null) {
			this.objectActivation.send(signalInstance);
		}

	} // send

	/**
	 * operation destroy <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void destroy() {
		// Stop the object activation (if any), clear all types and destroy the
		// object as an extensional value.

		Debug.println("[destroy] object = " + this.objectId());

		if (this.objectActivation != null) {
			this.objectActivation.stop();
			this.objectActivation = null;
		}

		this.types.clear();
		super.destroy();
	} // destroy

	/**
	 * operation register <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void register(
			fUML.Semantics.CommonBehaviors.Communications.EventAccepter accepter) {
		// Register the given accept event accepter to wait for a dispatched
		// signal event.

		if (this.objectActivation != null) {
			this.objectActivation.register(accepter);
		}
	} // register

	/**
	 * operation unregister <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unregister(
			fUML.Semantics.CommonBehaviors.Communications.EventAccepter accepter) {
		// Remove the given event accepter for the list of waiting event
		// accepters.

		if (this.objectActivation != null) {
			this.objectActivation.unregister(accepter);
		}
	} // unregister

	/**
	 * operation copy <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public fUML.Semantics.Classes.Kernel.Value copy() {
		// Create a new object that is a copy of this object at the same locus
		// as this object.
		// However, the new object will NOT have any object activation (i.e, its
		// classifier behaviors will not be started).

		Object_ newObject = (Object_) (super.copy());

		Class_List types = this.types;
		for (int i = 0; i < types.size(); i++) {
			Class_ type = types.getValue(i);
			newObject.types.addValue(type);
		}

		return newObject;

	} // copy

	/**
	 * operation new_ <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected fUML.Semantics.Classes.Kernel.Value new_() {
		// Create a new object with no type, feature values or locus.

		return new Object_();
	} // new_

	/**
	 * operation getTypes <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public fUML.Syntax.Classes.Kernel.ClassifierList getTypes() {
		// Return the types of this object.

		ClassifierList types = new ClassifierList();
		Class_List myTypes = this.types;
		for (int i = 0; i < myTypes.size(); i++) {
			Class_ type = myTypes.getValue(i);
			types.addValue(type);
		}

		return types;
	} // getTypes

} // Object
