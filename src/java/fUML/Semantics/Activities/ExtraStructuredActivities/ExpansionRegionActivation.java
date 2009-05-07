
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

package fUML.Semantics.Activities.ExtraStructuredActivities;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

import java.util.Iterator;

import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.*;
import fUML.Syntax.CommonBehaviors.Communications.*;
import fUML.Syntax.Activities.IntermediateActivities.*;
import fUML.Syntax.Activities.CompleteStructuredActivities.*;
import fUML.Syntax.Activities.ExtraStructuredActivities.*;
import fUML.Syntax.Actions.BasicActions.*;

import fUML.Semantics.*;
import fUML.Semantics.Classes.Kernel.*;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.*;
import fUML.Semantics.CommonBehaviors.Communications.*;
import fUML.Semantics.Activities.IntermediateActivities.*;
import fUML.Semantics.Activities.CompleteStructuredActivities.*;
import fUML.Semantics.Actions.BasicActions.*;
import fUML.Semantics.Loci.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Semantics::Activities::ExtraStructuredActivities::ExpansionRegionActivation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link ExpansionRegionActivation#takeOfferedTokens <em>takeOfferedTokens
 * </em>}</li>
 * <li>{@link ExpansionRegionActivation#doAction <em>doAction</em>}</li>
 * <li>{@link ExpansionRegionActivation#doStructuredActivity <em>
 * doStructuredActivity</em>}</li>
 * <li>{@link ExpansionRegionActivation#terminate <em>terminate</em>}</li>
 * <li>{@link ExpansionRegionActivation#isReady <em>isReady</em>}</li>
 * <li>{@link ExpansionRegionActivation#sendOffers <em>sendOffers</em>}</li>
 * <li>{@link ExpansionRegionActivation#activateGroup <em>activateGroup</em>}</li>
 * <li>{@link ExpansionRegionActivation#getExpansionNodeActivation <em>
 * getExpansionNodeActivation</em>}</li>
 * <li>{@link ExpansionRegionActivation#numberOfValues <em>numberOfValues</em>}</li>
 * <li>{@link ExpansionRegionActivation#activationGroups <em>activationGroups
 * </em>}</li>
 * <li>{@link ExpansionRegionActivation#inputTokens <em>inputTokens</em>}</li>
 * <li>{@link ExpansionRegionActivation#inputExpansionTokens <em>
 * inputExpansionTokens</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class ExpansionRegionActivation extends fUML.Semantics.Actions.BasicActions.ActionActivation {

    // Attributes
    public fUML.Semantics.Activities.ExtraStructuredActivities.ExpansionActivationGroupList activationGroups = new fUML.Semantics.Activities.ExtraStructuredActivities.ExpansionActivationGroupList();
    public fUML.Semantics.Activities.ExtraStructuredActivities.TokenSetList inputTokens = new fUML.Semantics.Activities.ExtraStructuredActivities.TokenSetList();
    public fUML.Semantics.Activities.ExtraStructuredActivities.TokenSetList inputExpansionTokens = new fUML.Semantics.Activities.ExtraStructuredActivities.TokenSetList();

    // Operations of the class
    /**
     * operation takeOfferedTokens <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public fUML.Semantics.Activities.IntermediateActivities.TokenList takeOfferedTokens() {
        // Create a number of expansion region activation groups equal to the
        // number of values expanded in the region, setting the region inputs
        // and group inputs for each group.

        ExpansionRegion region = (ExpansionRegion) (this.node);
        InputPinList inputPins = region.input;
        ExpansionNodeList inputElements = region.inputElement;

        this.inputTokens.clear();
        this.inputExpansionTokens.clear();

        for (int i = 0; i < inputPins.size(); i++) {
            InputPin inputPin = inputPins.getValue(i);
            TokenSet tokenSet = new TokenSet();
            tokenSet.tokens = this.getPinActivation(inputPin).takeTokens();
            this.inputTokens.addValue(tokenSet);
        }

        for (int i = 0; i < inputElements.size(); i++) {
            ExpansionNode inputElement = inputElements.getValue(i);
            ExpansionNodeActivation expansionNodeActivation = this
                    .getExpansionNodeActivation(inputElement);
            expansionNodeActivation.fire(expansionNodeActivation.takeOfferedTokens());
            TokenSet tokenSet = new TokenSet();
            tokenSet.tokens = expansionNodeActivation.takeTokens();
            this.inputExpansionTokens.addValue(tokenSet);
        }

        int k = 1;
        int n = this.numberOfValues();
        while (k <= n) {
            ExpansionActivationGroup activationGroup = new ExpansionActivationGroup();
            activationGroup.regionActivation = this;
            this.activationGroups.addValue(activationGroup);

            TokenSetList inputTokens = this.inputTokens;
            for (int j = 0; j < inputTokens.size(); j++) {
                TokenSet tokenSet = inputTokens.getValue(j);
                OutputPinActivation regionInput = new OutputPinActivation();
                regionInput.addTokens(tokenSet.tokens);
                activationGroup.regionInputs.addValue(regionInput);
            }

            TokenSetList inputExpansionTokens = this.inputExpansionTokens;
            for (int j = 0; j < inputExpansionTokens.size(); j++) {
                TokenSet tokenSet = inputExpansionTokens.getValue(j);
                OutputPinActivation groupInput = new OutputPinActivation();
                groupInput.addToken(tokenSet.tokens.getValue(k));
                activationGroup.groupInputs.addValue(groupInput);
            }

            k = k + 1;
        }

        return new TokenList();
    } // takeOfferedTokens

    /**
     * operation doAction <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void doAction() {
        // If the expansion region has mustIsolate=true, then carry out its
        // behavior with isolation.
        // Otherwise just activate it normally.

        if (((StructuredActivityNode) (this.node)).mustIsolate) {
            _beginIsolation();
            this.doStructuredActivity();
            _endIsolation();
        } else {
            this.doStructuredActivity();
        }

    } // doAction

    /**
     * operation doStructuredActivity <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    public void doStructuredActivity() {
        // Activate the body of the region in each group, either iteratively or
        // in parallel.
        // Add the outputs of each activation group to the corresonding output
        // expansion node activations.

        ExpansionRegion region = (ExpansionRegion) (this.node);
        ExpansionActivationGroupList activationGroups = this.activationGroups;

        if (region.mode == ExpansionKind.iterative) {
            for (int i = 0; i < activationGroups.size(); i++) {
                ExpansionActivationGroup activationGroup = activationGroups.getValue(i);
                this.activateGroup(activationGroup);
            }
        } else if (region.mode == ExpansionKind.parallel) {
            // *** Activate all groups concurrently. ***
            for (Iterator i = activationGroups.iterator(); i.hasNext();) {
                ExpansionActivationGroup activationGroup = (ExpansionActivationGroup) i.next();
                this.activateGroup(activationGroup);
            }
        }

        ExpansionNodeList outputElements = region.outputElement;

        for (int i = 0; i < activationGroups.size(); i++) {
            ExpansionActivationGroup activationGroup = activationGroups.getValue(i);
            OutputPinActivationList groupOutputs = activationGroup.groupOutputs;
            for (int j = 0; j < groupOutputs.size(); j++) {
                OutputPinActivation groupOutput = groupOutputs.getValue(j);
                ExpansionNode outputElement = outputElements.getValue(j);
                this.getExpansionNodeActivation(outputElement).addTokens(groupOutput.takeTokens());
            }
        }

    } // doStructuredActivity

    /**
     * operation terminate <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void terminate() {
        // Terminate the execution of all contained node activations (which
        // completes the performance of the expansion region activation).

        ExpansionActivationGroupList activationGroups = this.activationGroups;
        for (int i = 0; i < activationGroups.size(); i++) {
            ExpansionActivationGroup activationGroup = this.activationGroups.getValue(i);
            activationGroup.terminateAll();
        }

        super.terminate();
    } // terminate

    /**
     * operation isReady <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isReady() {
        // In addition to the usual ready checks for an action, check that all
        // expansion nodes have the same number of inputs (greater than zero).

        ExpansionRegion region = (ExpansionRegion) (this.node);

        boolean ready = false;
        if (super.isReady()) {
            int n = this.numberOfValues(); // This gets the number of values on
                                           // the first expansion node.

            if (n < 1) {
                ready = false;
            } else {
                int i = 1;
                while (ready & i <= region.inputElement.size()) {
                    ready = (this.getExpansionNodeActivation(region.inputElement.getValue(i - 1))
                            .countUnofferedTokens() == n);
                    i = i + 1;
                }
            }

        }

        return ready;

    } // isReady

    /**
     * operation sendOffers <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void sendOffers() {
        // Fire all output expansion nodes and send offers on all outgoing
        // control flows.

        ExpansionRegion region = (ExpansionRegion) (this.node);

        // *** Send offers from all output expansion nodes concurrently. ***
        ExpansionNodeList outputElements = region.outputElement;
        for (Iterator i = outputElements.iterator(); i.hasNext();) {
            ExpansionNode outputElement = (ExpansionNode) i.next();
            this.getExpansionNodeActivation(outputElement).sendUnofferedTokens();
        }

        // Send offers on all outgoing control flows.
        super.sendOffers();

    } // sendOffers

    /**
     * operation activateGroup <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void activateGroup(
            fUML.Semantics.Activities.ExtraStructuredActivities.ExpansionActivationGroup activationGroup) {
        // Activate the given group (which must be one of the groups for this
        // region activation) and then fire the group outputs.

        ExpansionRegion region = (ExpansionRegion) (this.node);
        activationGroup.activate(region.node, region.edge);

        OutputPinActivationList groupOutputs = activationGroup.groupOutputs;
        for (int i = 0; i < groupOutputs.size(); i++) {
            OutputPinActivation groupOutput = groupOutputs.getValue(i);
            groupOutput.fire(groupOutput.takeOfferedTokens());
        }

        activationGroup.terminateAll();
    } // activateGroup

    /**
     * operation getExpansionNodeActivation <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public fUML.Semantics.Activities.ExtraStructuredActivities.ExpansionNodeActivation getExpansionNodeActivation(
            fUML.Syntax.Activities.ExtraStructuredActivities.ExpansionNode node) {
        // Return the expansion node activation corresponding to the given
        // expansion node, in the context of the activity node activation group
        // this expansion region activation is in.
        // [Note: Expansion regions do not own their expansion nodes. Instead,
        // they are own as object nodes by the enclosing activity or group.
        // Therefore, they will already be activated along with their expansion
        // region.]

        return (ExpansionNodeActivation) (this.group.getNodeActivation(node));

    } // getExpansionNodeActivation

    /**
     * operation numberOfValues <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int numberOfValues() {
        // Return the number of values on the first input expansion node of the
        // expansion region of this activation.
        // (The region is required to have at least one input expansion node.)

        ExpansionRegion region = (ExpansionRegion) (this.node);

        return this.getExpansionNodeActivation(region.inputElement.getValue(0))
                .countUnofferedTokens();
    } // numberOfValues

} // ExpansionRegionActivation
