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

package fUML.Semantics.Activities.IntermediateActivities;

import java.util.Iterator;

import org.modeldriven.fuml.FumlException;
import org.modeldriven.fuml.assembly.ElementStubAssembler;
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
import fUML.Semantics.Actions.BasicActions.*;
import fUML.Semantics.Loci.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Semantics::Activities::IntermediateActivities::ActivityExecution</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link ActivityExecution#execute <em>execute</em>}</li>
 * <li>{@link ActivityExecution#copy <em>copy</em>}</li>
 * <li>{@link ActivityExecution#new_ <em>new_</em>}</li>
 * <li>{@link ActivityExecution#terminate <em>terminate</em>}</li>
 * <li>{@link ActivityExecution#activationGroup <em>activationGroup</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class ActivityExecution extends fUML.Semantics.CommonBehaviors.BasicBehaviors.Execution {

    // Attributes
    public fUML.Semantics.Activities.IntermediateActivities.ActivityNodeActivationGroup activationGroup = new fUML.Semantics.Activities.IntermediateActivities.ActivityNodeActivationGroup();

    // Operations of the class
    /**
     * operation execute <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void execute() {
        // Execute the activity for this execution by creating an activity node
        // activation group and activating all the activity nodes in the
        // activity.
        // When this is complete, copy the values on the tokens offered by
        // output parameter nodes to the corresponding output parameters.

        Activity activity = (Activity) (this.getTypes().getValue(0));

        if (activity.ownedComment != null && activity.ownedComment.size() > 0 &&
                ElementStubAssembler.STUB_TOKEN.equals(activity.ownedComment.get(0).body))
        {
            Debug.println("[execute] invalid activity encountered: " 
                    + activity.name + " - see below error(s)");
            Iterator<Comment> comments = activity.ownedComment.iterator();
            comments.next(); // skip the "stub" comment
            while (comments.hasNext())                
                Debug.println("[execute] error: " + comments.next().body);
            throw new FumlException("cannot execute invalid activity '"
                    + activity.name + "' - see above errors");
        }
        Debug.println("[execute] Activity " + activity.name + "...");
        // Debug.println("[execute] context = " + this.context.objectId());

        this.activationGroup = new ActivityNodeActivationGroup();
        this.activationGroup.activityExecution = this;
        this.activationGroup.activate(activity.node, activity.edge);

        // Debug.println("[execute] Getting output parameter node activations...");

        ActivityParameterNodeActivationList outputActivations = this.activationGroup
                .getOutputParameterNodeActivations();

        // Debug.println("[execute] There are " + outputActivations.size() +
        // " output parameter node activations.");

        for (int i = 0; i < outputActivations.size(); i++) {
            ActivityParameterNodeActivation outputActivation = outputActivations.getValue(i);

            ParameterValue parameterValue = new ParameterValue();
            parameterValue.parameter = ((ActivityParameterNode) (outputActivation.node)).parameter;

            TokenList tokens = outputActivation.getTokens();
            for (int j = 0; j < tokens.size(); j++) {
                Token token = tokens.getValue(j);
                Value value = ((ObjectToken) token).value;
                if (value != null) {
                    parameterValue.values.addValue(value);
                }
            }

            this.setParameterValue(parameterValue);
        }

        Debug.println("[execute] Activity " + activity.name + " completed.");

    }

    /**
     * operation copy <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.Classes.Kernel.Value copy() {
        // Create a new activity execution that is a copy of this execution.
        // [Note: This currently just returns a non-executing execution for the
        // same behavior as this execution.]

        return super.copy();

    }

    /**
     * operation new_ <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.Classes.Kernel.Value new_() {
        // Create a new activity execution with empty properties.

        return new ActivityExecution();

    }

    /**
     * operation terminate <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void terminate() {
        // Terminate all node activations (which will ultimately result in the
        // activity execution completing).

        this.activationGroup.terminateAll();

    }

} // ActivityExecution
