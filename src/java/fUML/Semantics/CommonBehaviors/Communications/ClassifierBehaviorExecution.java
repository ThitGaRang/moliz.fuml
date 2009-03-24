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

package fUML.Semantics.CommonBehaviors.Communications;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.*;
import fUML.Syntax.CommonBehaviors.Communications.*;

import fUML.Semantics.*;
import fUML.Semantics.Classes.Kernel.*;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.*;
import fUML.Semantics.Loci.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Semantics::CommonBehaviors::Communications::ClassifierBehaviorExecution</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link ClassifierBehaviorExecution#execute <em>execute</em>}</li>
 * <li>{@link ClassifierBehaviorExecution#terminate <em>terminate</em>}</li>
 * <li>{@link ClassifierBehaviorExecution#_startObjectBehavior <em>
 * _startObjectBehavior</em>}</li>
 * <li>{@link ClassifierBehaviorExecution#execution <em>execution</em>}</li>
 * <li>{@link ClassifierBehaviorExecution#classifier <em>classifier</em>}</li>
 * <li>{@link ClassifierBehaviorExecution#objectActivation <em>objectActivation
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class ClassifierBehaviorExecution {

    // Attributes
    public fUML.Semantics.CommonBehaviors.BasicBehaviors.Execution execution = null;
    public fUML.Syntax.Classes.Kernel.Class_ classifier = new fUML.Syntax.Classes.Kernel.Class_();
    public fUML.Semantics.CommonBehaviors.Communications.ObjectActivation objectActivation = null;

    // Operations of the class
    /**
     * operation execute <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void execute(fUML.Syntax.Classes.Kernel.Class_ classifier,
            fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList inputs) {
        // Set the classifier for this classifier behavior execution to the
        // given class.
        // If the given class is a behavior, set the execution to be the object
        // of the object activation of the classifier behavior execution.
        // Otherwise the class must be an active class, so get an execution
        // object for the classifier behavior for the class.
        // Set the input parameters for the execution to the given values.
        // Then start the active behavior of this ClassifierBehaviorExecution
        // object, which will execute the execution object on a separate thread
        // of control.

        // Debug.println("[execute] Executing behavior for " + classifier.name +
        // "...");

        this.classifier = classifier;
        Object_ object = this.objectActivation.object;

        if (classifier instanceof Behavior) {
            this.execution = (Execution) object;
        } else {
            this.execution = object.locus.factory.createExecution(classifier.classifierBehavior,
                    object);
        }

        if (inputs != null) {
            for (int i = 0; i < inputs.size(); i++) {
                ParameterValue input = inputs.getValue(i);
                this.execution.setParameterValue(input);
            }
        }

        _startObjectBehavior();

    }

    /**
     * operation terminate <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void terminate() {
        // Terminate the associated execution.
        // If the execution is not itself the object of the object activation,
        // then destroy it.

        // Debug.println("[terminate] Terminating behavior for " +
        // classifier.name + "...");

        this.execution.terminate();

        if (this.execution != this.objectActivation.object) {
            this.execution.destroy();
        }

    }

    /**
     * operation _startObjectBehavior <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */

    public void _startObjectBehavior() {
        // *** This should start the asynchronous
        // ClassifierBehaviorExecutionActivity to do the following. ***
        this.execution.execute();
    }

} // ClassifierBehaviorExecution
