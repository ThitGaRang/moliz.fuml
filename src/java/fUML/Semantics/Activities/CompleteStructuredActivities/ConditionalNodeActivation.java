



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

package fUML.Semantics.Activities.CompleteStructuredActivities;

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
import fUML.Syntax.Actions.BasicActions.*;

import fUML.Semantics.*;
import fUML.Semantics.Classes.Kernel.*;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.*;
import fUML.Semantics.Activities.IntermediateActivities.*;
import fUML.Semantics.Actions.BasicActions.*;
import fUML.Semantics.Loci.*;

								    		

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fUML::Semantics::Activities::CompleteStructuredActivities::ConditionalNodeActivation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link ConditionalNodeActivation#doStructuredActivity <em>doStructuredActivity</em>}</li>
	 *   <li>{@link ConditionalNodeActivation#getClauseActivation <em>getClauseActivation</em>}</li>
	 *   <li>{@link ConditionalNodeActivation#runTest <em>runTest</em>}</li>
	 *   <li>{@link ConditionalNodeActivation#selectBody <em>selectBody</em>}</li>
	 	 *   <li>{@link ConditionalNodeActivation#clauseActivations <em>clauseActivations</em>}</li>
	 *   <li>{@link ConditionalNodeActivation#selectedClauses <em>selectedClauses</em>}</li>
	 * </ul>
 * </p>
 *
 * @generated
 */


public   class ConditionalNodeActivation    extends fUML.Semantics.Activities.CompleteStructuredActivities.StructuredActivityNodeActivation    {
 	    
	// Attributes
 	 		public   fUML.Semantics.Activities.CompleteStructuredActivities.ClauseActivationList clauseActivations = 	new fUML.Semantics.Activities.CompleteStructuredActivities.ClauseActivationList()	;
	 		public   fUML.Syntax.Activities.CompleteStructuredActivities.ClauseList selectedClauses = 	new fUML.Syntax.Activities.CompleteStructuredActivities.ClauseList()	;
	    
// Operations of the class
	  /**
   * operation doStructuredActivity
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void doStructuredActivity()   {
	 		 	 			// Activate all clauses in the conditional node and pass control to those that are ready (i.e., have no predecessors).
// If one or more clauses have succeeded in being selected, choose one non-deterministically and run its body, then copy the outputs of that clause to the output pins of the node.

ConditionalNode node = (ConditionalNode)(this.node);
this.clauseActivations.clear();

ClauseList clauses = node.clause;
for (int i = 0; i <clauses.size(); i++) {
    Clause clause = clauses.getValue(i);
    ClauseActivation clauseActivation = new ClauseActivation();
    clauseActivation.clause = clause;
    this.clauseActivations.addValue(clauseActivation);
}

this.selectedClauses.clear();

ClauseActivationList readyClauseActivations = new ClauseActivationList();
for (int i = 0; i < this.clauseActivations.size(); i++) {
    ClauseActivation clauseActivation = this.clauseActivations.getValue(i);
    if (clauseActivation.isReady()) {
        readyClauseActivations.addValue(clauseActivation);
    }
}

// *** Give control to all ready clauses concurrently. ***
for (Iterator i = readyClauseActivations.iterator(); i.hasNext() ;) {
    ClauseActivation clauseActivation = (ClauseActivation)i.next();
    clauseActivation.receiveControl();
}

this.activationGroup.terminateAll();

if (this.selectedClauses.size() > 0 & this.isRunning()) {
    // *** If multiple clauses are selected, choose one non-deterministically. ***
    int i = ((ChoiceStrategy)this.getExecutionLocus().factory.getStrategy("choice")).choose(this.selectedClauses.size());
    Clause selectedClause = this.selectedClauses.getValue(i-1);

    this.activationGroup.runNodes(this.makeActivityNodeList(selectedClause.body));

    OutputPinList resultPins = node.result;
    OutputPinList bodyOutputPins = selectedClause.bodyOutput;
    for (int k = 0; k < resultPins.size(); k++) {
        OutputPin resultPin = resultPins.getValue(k);
        OutputPin bodyOutputPin = bodyOutputPins.getValue(k);
        this.putTokens(resultPin, this.getPinValues(bodyOutputPin));
    }
}

								    			  }
	
	  /**
   * operation getClauseActivation
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     fUML.Semantics.Activities.CompleteStructuredActivities.ClauseActivation getClauseActivation(fUML.Syntax.Activities.CompleteStructuredActivities.Clause clause)   {
	 		 	 			// Get the clause activation corresponding to the given clause.

ClauseActivation selectedClauseActivation = null;
int i = 1;
while ((selectedClauseActivation == null) & i <= this.clauseActivations.size()) {
    ClauseActivation clauseActivation = this.clauseActivations.getValue(i-1);
    if (clauseActivation.clause == clause) {
        selectedClauseActivation = clauseActivation;
    }
    i = i + 1;
}

return selectedClauseActivation;

								    			  }
	
	  /**
   * operation runTest
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void runTest(fUML.Syntax.Activities.CompleteStructuredActivities.Clause clause)   {
	 		 	 			// Run the test for the given clause.

if (this.isRunning()) {
    this.activationGroup.runNodes(this.makeActivityNodeList(clause.test));
}

								    			  }
	
	  /**
   * operation selectBody
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void selectBody(fUML.Syntax.Activities.CompleteStructuredActivities.Clause clause)   {
	 		 	 			// Add the clause to the list of selected clauses.

this.selectedClauses.addValue(clause);


								    			  }
	
} //ConditionalNodeActivation
