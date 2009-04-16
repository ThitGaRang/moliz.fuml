



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

package fUML.Syntax.Activities.CompleteStructuredActivities;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

 		

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fUML::Syntax::Activities::CompleteStructuredActivities::StructuredActivityNode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link StructuredActivityNode#setMustIsolate <em>setMustIsolate</em>}</li>
	 *   <li>{@link StructuredActivityNode#addNode <em>addNode</em>}</li>
	 *   <li>{@link StructuredActivityNode#addEdge <em>addEdge</em>}</li>
	 	 *   <li>{@link StructuredActivityNode#node <em>node</em>}</li>
	 *   <li>{@link StructuredActivityNode#activity <em>activity</em>}</li>
	 *   <li>{@link StructuredActivityNode#mustIsolate <em>mustIsolate</em>}</li>
	 *   <li>{@link StructuredActivityNode#edge <em>edge</em>}</li>
	 * </ul>
 * </p>
 *
 * @generated
 */


public   class StructuredActivityNode    extends fUML.Syntax.Actions.BasicActions.Action    {
 	    
	// Attributes
 	 		public   fUML.Syntax.Activities.IntermediateActivities.ActivityNodeList node = 	new fUML.Syntax.Activities.IntermediateActivities.ActivityNodeList()	;
	 		public   fUML.Syntax.Activities.IntermediateActivities.Activity activity = 	 null	;
	 		public   boolean mustIsolate = 	false	;
	 		public   fUML.Syntax.Activities.IntermediateActivities.ActivityEdgeList edge = 	new fUML.Syntax.Activities.IntermediateActivities.ActivityEdgeList()	;
	    
// Operations of the class
	  /**
   * operation setMustIsolate
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void setMustIsolate(boolean mustIsolate)   {
	 		 	 			this.mustIsolate = mustIsolate;

								    			  }
	
	  /**
   * operation addNode
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void addNode(fUML.Syntax.Activities.IntermediateActivities.ActivityNode node)   {
	 		 	 			this.node.addValue(node);
node.inStructuredNode = this;

								    			  }
	
	  /**
   * operation addEdge
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */

	public      void addEdge(fUML.Syntax.Activities.IntermediateActivities.ActivityEdge edge)   {
	 		 	 			this.edge.addValue(edge);
edge.inStructuredNode = this;

								    			  }
	
} //StructuredActivityNode
