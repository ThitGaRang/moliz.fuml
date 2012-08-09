package fUML.Semantics.Activities.IntermediateActivities;

import fUML.Debug;
import fUML.Semantics.Activities.IntermediateActivities.ControlNodeActivation;;

public class FlowFinalNodeActivation extends ControlNodeActivation {
	
	public void fire(
			fUML.Semantics.Activities.IntermediateActivities.TokenList incomingTokens) {
		// Consume all incoming tokens.

		Debug.println("[fire] Flow final node " + this.node.name + "...");
		
		for (int i = 0; i < incomingTokens.size(); i++) {
			Token token = incomingTokens.getValue(i);
			token.withdraw();
		}

	} // fire

}
