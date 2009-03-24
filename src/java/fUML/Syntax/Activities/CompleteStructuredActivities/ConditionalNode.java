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

package fUML.Syntax.Activities.CompleteStructuredActivities;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Syntax::Activities::CompleteStructuredActivities::ConditionalNode</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link ConditionalNode#setIsDeterminate <em>setIsDeterminate</em>}</li>
 * <li>{@link ConditionalNode#setIsAssured <em>setIsAssured</em>}</li>
 * <li>{@link ConditionalNode#addClause <em>addClause</em>}</li>
 * <li>{@link ConditionalNode#addResult <em>addResult</em>}</li>
 * <li>{@link ConditionalNode#isDeterminate <em>isDeterminate</em>}</li>
 * <li>{@link ConditionalNode#isAssured <em>isAssured</em>}</li>
 * <li>{@link ConditionalNode#clause <em>clause</em>}</li>
 * <li>{@link ConditionalNode#result <em>result</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class ConditionalNode extends
        fUML.Syntax.Activities.CompleteStructuredActivities.StructuredActivityNode {

    // Attributes
    public boolean isDeterminate = false;
    public boolean isAssured = false;
    public fUML.Syntax.Activities.CompleteStructuredActivities.ClauseList clause = new fUML.Syntax.Activities.CompleteStructuredActivities.ClauseList();
    public fUML.Syntax.Actions.BasicActions.OutputPinList result = new fUML.Syntax.Actions.BasicActions.OutputPinList();

    // Operations of the class
    /**
     * operation setIsDeterminate <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setIsDeterminate(boolean isDeterminate) {
        this.isDeterminate = isDeterminate;
    }

    /**
     * operation setIsAssured <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void setIsAssured(boolean isAssured) {
        this.isAssured = isAssured;

    }

    /**
     * operation addClause <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void addClause(fUML.Syntax.Activities.CompleteStructuredActivities.Clause clause) {
        super.addOwnedElement(clause);
        this.clause.addValue(clause);

    }

    /**
     * operation addResult <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void addResult(fUML.Syntax.Actions.BasicActions.OutputPin result) {
        super.addOutput(result);
        this.result.addValue(result);

    }

} // ConditionalNode
