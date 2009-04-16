



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

package fUML.Semantics.Loci;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

 		 	 				    		 	 			import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.*;

import fUML.Semantics.*;
import fUML.Semantics.Classes.Kernel.*;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.*;

								    		

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fUML::Semantics::Loci::ExecutionFactory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link ExecutionFactory#createExecution <em>createExecution</em>}</li>
	 *   <li>{@link ExecutionFactory#createEvaluation <em>createEvaluation</em>}</li>
	 *   <li>{@link ExecutionFactory#instantiateVisitor <em>instantiateVisitor</em>}</li>
	 *   <li>{@link ExecutionFactory#instantiateOpaqueBehaviorExecution <em>instantiateOpaqueBehaviorExecution</em>}</li>
	 *   <li>{@link ExecutionFactory#addPrimitiveBehaviorPrototype <em>addPrimitiveBehaviorPrototype</em>}</li>
	 *   <li>{@link ExecutionFactory#addBuiltInType <em>addBuiltInType</em>}</li>
	 *   <li>{@link ExecutionFactory#getBuiltInType <em>getBuiltInType</em>}</li>
	 *   <li>{@link ExecutionFactory#setStrategy <em>setStrategy</em>}</li>
	 *   <li>{@link ExecutionFactory#getStrategy <em>getStrategy</em>}</li>
	 *   <li>{@link ExecutionFactory#getStrategyIndex <em>getStrategyIndex</em>}</li>
	 	 *   <li>{@link ExecutionFactory#locus <em>locus</em>}</li>
	 *   <li>{@link ExecutionFactory#primitiveBehaviorPrototypes <em>primitiveBehaviorPrototypes</em>}</li>
	 *   <li>{@link ExecutionFactory#builtInTypes <em>builtInTypes</em>}</li>
	 *   <li>{@link ExecutionFactory#strategies <em>strategies</em>}</li>
	 * </ul>
 * </p>
 *
 * @generated
 */


public   class ExecutionFactory    {
 	    
	// Attributes
 	 		public   fUML.Semantics.Loci.Locus locus = 	 null
	;
	 		public   fUML.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecutionList primitiveBehaviorPrototypes = 	new fUML.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecutionList()	;
	 		public   fUML.Syntax.Classes.Kernel.PrimitiveTypeList builtInTypes = 	new fUML.Syntax.Classes.Kernel.PrimitiveTypeList()	;
	 		public   fUML.Semantics.Loci.SemanticStrategyList strategies = 	new fUML.Semantics.Loci.SemanticStrategyList()	;
	    
// Operations of the class
	  /**
   * operation createExecution
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     fUML.Semantics.CommonBehaviors.BasicBehaviors.Execution createExecution(fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior behavior, fUML.Semantics.Classes.Kernel.Object_ context)   {
	 		 	 			// Create an execution object for a given behavior. 
// The execution will take place at the locus of the factory in the given context.
// If the context is empty, the execution is assumed to provide its own context.

Execution execution = null;

if (behavior instanceof OpaqueBehavior) {
    execution = this.instantiateOpaqueBehaviorExecution((OpaqueBehavior)behavior);
}
else {
    execution = (Execution)(this.instantiateVisitor(behavior,"Execution"));
    execution.types.addValue(behavior);
    execution.createFeatureValues();
}

this.locus.add(execution);

if (context == null) {
    execution.context = execution;
}
else {
    execution.context = context;
}

return execution;

								    			  }
	
	  /**
   * operation createEvaluation
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     fUML.Semantics.Classes.Kernel.Evaluation createEvaluation(fUML.Syntax.Classes.Kernel.ValueSpecification specification)   {
	 		 	 			// Create an evaluation object for a given value specification. 
// The evaluation will take place at the locus of the factory.

Evaluation evaluation = (Evaluation)(this.instantiateVisitor(specification,"Evaluation"));

evaluation.specification = specification;
evaluation.locus = this.locus;

return evaluation;


								    			  }
	
	  /**
   * operation instantiateVisitor
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     fUML.Semantics.Loci.SemanticVisitor instantiateVisitor(fUML.Syntax.Classes.Kernel.Element element, String suffix)   {
	 		 	 				    		 	 			SemanticVisitor visitor = null;

if (element instanceof fUML.Syntax.Classes.Kernel.LiteralBoolean) {
  visitor = new fUML.Semantics.Classes.Kernel.LiteralBooleanEvaluation();
}

if (element instanceof fUML.Syntax.Classes.Kernel.LiteralString) {
  visitor = new fUML.Semantics.Classes.Kernel.LiteralStringEvaluation();
}

if (element instanceof fUML.Syntax.Classes.Kernel.LiteralNull) {
  visitor = new fUML.Semantics.Classes.Kernel.LiteralNullEvaluation();
}

if (element instanceof fUML.Syntax.Classes.Kernel.InstanceValue) {
  visitor = new fUML.Semantics.Classes.Kernel.InstanceValueEvaluation();
}

if (element instanceof fUML.Syntax.Classes.Kernel.LiteralUnlimitedNatural) {
  visitor = new fUML.Semantics.Classes.Kernel.LiteralUnlimitedNaturalEvaluation();
}

if (element instanceof fUML.Syntax.Classes.Kernel.LiteralInteger) {
  visitor = new fUML.Semantics.Classes.Kernel.LiteralIntegerEvaluation();
}

if (element instanceof fUML.Syntax.Activities.IntermediateActivities.Activity) {
  visitor = new fUML.Semantics.Activities.IntermediateActivities.ActivityExecution();
}

if (element instanceof fUML.Syntax.Actions.BasicActions.OutputPin) {
  visitor = new fUML.Semantics.Actions.BasicActions.OutputPinActivation();
}

if (element instanceof fUML.Syntax.Actions.BasicActions.InputPin) {
  visitor = new fUML.Semantics.Actions.BasicActions.InputPinActivation();
}

if (element instanceof fUML.Syntax.Actions.CompleteActions.StartClassifierBehaviorAction) {
  visitor = new fUML.Semantics.Actions.CompleteActions.StartClassifierBehaviorActionActivation();
}

if (element instanceof fUML.Syntax.Actions.IntermediateActions.ReadStructuralFeatureAction) {
  visitor = new fUML.Semantics.Actions.IntermediateActions.ReadStructuralFeatureActionActivation();
}

if (element instanceof fUML.Syntax.Activities.CompleteStructuredActivities.ConditionalNode) {
  visitor = new fUML.Semantics.Activities.CompleteStructuredActivities.ConditionalNodeActivation();
}

if (element instanceof fUML.Syntax.Actions.IntermediateActions.ReadSelfAction) {
  visitor = new fUML.Semantics.Actions.IntermediateActions.ReadSelfActionActivation();
}

if (element instanceof fUML.Syntax.Actions.IntermediateActions.DestroyLinkAction) {
  visitor = new fUML.Semantics.Actions.IntermediateActions.DestroyLinkActionActivation();
}

if (element instanceof fUML.Syntax.Activities.CompleteStructuredActivities.StructuredActivityNode) {
  visitor = new fUML.Semantics.Activities.CompleteStructuredActivities.StructuredActivityNodeActivation();
}

if (element instanceof fUML.Syntax.Actions.BasicActions.SendSignalAction) {
  visitor = new fUML.Semantics.Actions.BasicActions.SendSignalActionActivation();
}

if (element instanceof fUML.Syntax.Activities.ExtraStructuredActivities.ExpansionNode) {
  visitor = new fUML.Semantics.Activities.ExtraStructuredActivities.ExpansionNodeActivation();
}

if (element instanceof fUML.Syntax.Actions.IntermediateActions.CreateObjectAction) {
  visitor = new fUML.Semantics.Actions.IntermediateActions.CreateObjectActionActivation();
}

if (element instanceof fUML.Syntax.Actions.IntermediateActions.ReadLinkAction) {
  visitor = new fUML.Semantics.Actions.IntermediateActions.ReadLinkActionActivation();
}

if (element instanceof fUML.Syntax.Actions.IntermediateActions.ClearAssociationAction) {
  visitor = new fUML.Semantics.Actions.IntermediateActions.ClearAssociationActionActivation();
}

if (element instanceof fUML.Syntax.Activities.IntermediateActivities.JoinNode) {
  visitor = new fUML.Semantics.Activities.IntermediateActivities.JoinNodeActivation();
}

if (element instanceof fUML.Syntax.Actions.CompleteActions.ReclassifyObjectAction) {
  visitor = new fUML.Semantics.Actions.CompleteActions.ReclassifyObjectActionActivation();
}

if (element instanceof fUML.Syntax.Activities.IntermediateActivities.InitialNode) {
  visitor = new fUML.Semantics.Activities.IntermediateActivities.InitialNodeActivation();
}

if (element instanceof fUML.Syntax.Actions.CompleteActions.StartObjectBehaviorAction) {
  visitor = new fUML.Semantics.Actions.CompleteActions.StartObjectBehaviorActionActivation();
}

if (element instanceof fUML.Syntax.Actions.CompleteActions.ReadIsClassifiedObjectAction) {
  visitor = new fUML.Semantics.Actions.CompleteActions.ReadIsClassifiedObjectActionActivation();
}

if (element instanceof fUML.Syntax.Actions.BasicActions.CallOperationAction) {
  visitor = new fUML.Semantics.Actions.BasicActions.CallOperationActionActivation();
}

if (element instanceof fUML.Syntax.Actions.BasicActions.CallBehaviorAction) {
  visitor = new fUML.Semantics.Actions.BasicActions.CallBehaviorActionActivation();
}

if (element instanceof fUML.Syntax.Activities.ExtraStructuredActivities.ExpansionRegion) {
  visitor = new fUML.Semantics.Activities.ExtraStructuredActivities.ExpansionRegionActivation();
}

if (element instanceof fUML.Syntax.Actions.IntermediateActions.AddStructuralFeatureValueAction) {
  visitor = new fUML.Semantics.Actions.IntermediateActions.AddStructuralFeatureValueActionActivation();
}

if (element instanceof fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode) {
  visitor = new fUML.Semantics.Activities.IntermediateActivities.ActivityParameterNodeActivation();
}

if (element instanceof fUML.Syntax.Actions.IntermediateActions.ValueSpecificationAction) {
  visitor = new fUML.Semantics.Actions.IntermediateActions.ValueSpecificationActionActivation();
}

if (element instanceof fUML.Syntax.Activities.IntermediateActivities.ActivityFinalNode) {
  visitor = new fUML.Semantics.Activities.IntermediateActivities.ActivityFinalNodeActivation();
}

if (element instanceof fUML.Syntax.Activities.IntermediateActivities.ForkNode) {
  visitor = new fUML.Semantics.Activities.IntermediateActivities.ForkNodeActivation();
}

if (element instanceof fUML.Syntax.Actions.CompleteActions.AcceptEventAction) {
  visitor = new fUML.Semantics.Actions.CompleteActions.AcceptEventActionActivation();
}

if (element instanceof fUML.Syntax.Activities.CompleteStructuredActivities.LoopNode) {
  visitor = new fUML.Semantics.Activities.CompleteStructuredActivities.LoopNodeActivation();
}

if (element instanceof fUML.Syntax.Activities.IntermediateActivities.DecisionNode) {
  visitor = new fUML.Semantics.Activities.IntermediateActivities.DecisionNodeActivation();
}

if (element instanceof fUML.Syntax.Actions.CompleteActions.ReduceAction) {
  visitor = new fUML.Semantics.Actions.CompleteActions.ReduceActionActivation();
}

if (element instanceof fUML.Syntax.Actions.IntermediateActions.DestroyObjectAction) {
  visitor = new fUML.Semantics.Actions.IntermediateActions.DestroyObjectActionActivation();
}

if (element instanceof fUML.Syntax.Actions.IntermediateActions.ClearStructuralFeatureAction) {
  visitor = new fUML.Semantics.Actions.IntermediateActions.ClearStructuralFeatureActionActivation();
}

if (element instanceof fUML.Syntax.Actions.IntermediateActions.TestIdentityAction) {
  visitor = new fUML.Semantics.Actions.IntermediateActions.TestIdentityActionActivation();
}

if (element instanceof fUML.Syntax.Actions.IntermediateActions.CreateLinkAction) {
  visitor = new fUML.Semantics.Actions.IntermediateActions.CreateLinkActionActivation();
}

if (element instanceof fUML.Syntax.Actions.IntermediateActions.RemoveStructuralFeatureValueAction) {
  visitor = new fUML.Semantics.Actions.IntermediateActions.RemoveStructuralFeatureValueActionActivation();
}

if (element instanceof fUML.Syntax.Activities.IntermediateActivities.MergeNode) {
  visitor = new fUML.Semantics.Activities.IntermediateActivities.MergeNodeActivation();
}

if (element instanceof fUML.Syntax.Actions.CompleteActions.ReadExtentAction) {
  visitor = new fUML.Semantics.Actions.CompleteActions.ReadExtentActionActivation();
}

return visitor;

								    			  }
	
	  /**
   * operation instantiateOpaqueBehaviorExecution
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     fUML.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution instantiateOpaqueBehaviorExecution(fUML.Syntax.CommonBehaviors.BasicBehaviors.OpaqueBehavior behavior)   {
	 		 	 			// Return a copy of the prototype for the primitive  behavior execution of the given opaque behavior.

OpaqueBehaviorExecution execution = null;
int i = 1;
while (execution == null & i <= this.primitiveBehaviorPrototypes.size()) {
    // Debug.println("[instantiateOpaqueExecution] Checking " + this.primitiveBehaviorPrototypes.getValue(i).objectId() + "...");
    OpaqueBehaviorExecution prototype = this.primitiveBehaviorPrototypes.getValue(i-1);
    if (prototype.getBehavior() == behavior) {
        execution = (OpaqueBehaviorExecution)(prototype.copy());
   }
   i = i + 1;
}

if (execution == null) {
    Debug.println("[instantiateOpaqueExecution] No prototype execution found for " + behavior.name + ".");
}

return execution;

								    			  }
	
	  /**
   * operation addPrimitiveBehaviorPrototype
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void addPrimitiveBehaviorPrototype(fUML.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution execution)   {
	 		 	 			// Add an opaque behavior execution to use as a prototype for instantiating the corresponding primitive opaque behavior.
// Precondition: No primitive behavior prototype for the type of the given execution should already exist.

this.primitiveBehaviorPrototypes.addValue(execution);

								    			  }
	
	  /**
   * operation addBuiltInType
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void addBuiltInType(fUML.Syntax.Classes.Kernel.PrimitiveType type)   {
	 		 	 			// Add the given primitive type as a built-in type.
// Precondition: No built-in type with the same name should already exist.

this.builtInTypes.addValue(type);

								    			  }
	
	  /**
   * operation getBuiltInType
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     fUML.Syntax.Classes.Kernel.PrimitiveType getBuiltInType(String name)   {
	 		 	 			// Return the built-in type with the given name.

PrimitiveType type = null;
int i = 1;
while (type == null & i <= this.builtInTypes.size()) {
    PrimitiveType primitiveType = this.builtInTypes.getValue(i-1);
    if (primitiveType.name.equals(name)) {
        type = primitiveType;
    }
    i = i + 1;
}

return type;

								    			  }
	
	  /**
   * operation setStrategy
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void setStrategy(fUML.Semantics.Loci.SemanticStrategy strategy)   {
	 		 	 			// Set the strategy for a semantic variation point. Any existing strategy for the same SVP is replaced.

int i = this.getStrategyIndex(strategy.getName());

if (i <= this.strategies.size()) {
    this.strategies.removeValue(i-1);
}

this.strategies.addValue(strategy);

								    			  }
	
	  /**
   * operation getStrategy
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     fUML.Semantics.Loci.SemanticStrategy getStrategy(String name)   {
	 		 	 			// Get the strategy with the given name.

int i = this.getStrategyIndex(name);

SemanticStrategy strategy = null;
if (i <= this.strategies.size()) {
    strategy = this.strategies.getValue(i-1);
}

return strategy;

								    			  }
	
	  /**
   * operation getStrategyIndex
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public     int getStrategyIndex(String name)   {
	 		 	 			// Get the index of the strategy with the given name.
// If there is not such strategy, return the size of the strategies list.

SemanticStrategyList strategies = this.strategies;

int i = 1;
boolean unmatched = true;
while (unmatched & (i <= strategies.size())) {
    if (strategies.getValue(i-1).getName().equals(name)) {
        unmatched = false;
    } else {
        i = i + 1;
    }
}

return i;



								    			  }
	
} //ExecutionFactory
