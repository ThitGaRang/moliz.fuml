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

package fUML.Semantics.Actions.BasicActions;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.*;
import fUML.Syntax.CommonBehaviors.Communications.*;
import fUML.Syntax.Activities.IntermediateActivities.*;
import fUML.Syntax.Actions.BasicActions.*;

import fUML.Semantics.*;
import fUML.Semantics.Classes.Kernel.*;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.*;
import fUML.Semantics.Loci.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Semantics::Actions::BasicActions::CallActionActivation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link CallActionActivation#doAction <em>doAction</em>}</li>
 * <li>{@link CallActionActivation#getCallExecution <em>getCallExecution</em>}</li>
 * <li>{@link CallActionActivation#terminate <em>terminate</em>}</li>
 * <li>{@link CallActionActivation#callExecution <em>callExecution</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public abstract class CallActionActivation extends
        fUML.Semantics.Actions.BasicActions.InvocationActionActivation {

    // Attributes
    public fUML.Semantics.CommonBehaviors.BasicBehaviors.Execution callExecution = null;

    // Operations of the class
    /**
     * operation doAction <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void doAction() {
        // Get the call execution object, set its input parameters from the
        // argument pins and execute it.
        // Once execution completes, copy the values of the output parameters of
        // the call execution to the result pins of the call action execution,
        // then destroy the execution.

        this.callExecution = this.getCallExecution();

        if (this.callExecution != null) {

            CallAction callAction = (CallAction) (this.node);
            InputPinList argumentPins = callAction.argument;
            OutputPinList resultPins = callAction.result;

            ParameterList parameters = this.callExecution.getBehavior().ownedParameter;

            int pinNumber = 1;
            int i = 1;
            while (i <= parameters.size()) {
                Parameter parameter = parameters.getValue(i - 1);
                if (parameter.direction == ParameterDirectionKind.in
                        | parameter.direction == ParameterDirectionKind.inout) {
                    ParameterValue parameterValue = new ParameterValue();
                    parameterValue.parameter = parameter;
                    parameterValue.values = this.getTokens(argumentPins.getValue(pinNumber - 1));
                    this.callExecution.setParameterValue(parameterValue);
                    pinNumber = pinNumber + 1;
                }
                i = i + 1;
            }

            this.callExecution.execute();

            ParameterValueList outputParameterValues = this.callExecution
                    .getOutputParameterValues();
            for (int j = 0; j < outputParameterValues.size(); j++) {
                ParameterValue outputParameterValue = outputParameterValues.getValue(j);
                OutputPin resultPin = resultPins.getValue(j);
                this.putTokens(resultPin, outputParameterValue.values);
            }

            this.callExecution.destroy();
            this.callExecution = null;
        }

    }

    /**
     * operation getCallExecution <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public abstract fUML.Semantics.CommonBehaviors.BasicBehaviors.Execution getCallExecution();

    /**
     * operation terminate <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void terminate() {
        // Terminate the call execution (if there is one), then terminate the
        // call action activation (self).

        if (this.callExecution != null) {
            this.callExecution.terminate();
        }

        super.terminate();

    }

} // CallActionActivation
