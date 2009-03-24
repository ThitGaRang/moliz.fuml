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

package fUML.Test;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.*;
import fUML.Syntax.CommonBehaviors.Communications.*;
import fUML.Syntax.Activities.IntermediateActivities.*;
import fUML.Syntax.Activities.CompleteStructuredActivities.*;
import fUML.Syntax.Actions.BasicActions.*;
import fUML.Syntax.Actions.IntermediateActions.*;
import fUML.Syntax.Actions.CompleteActions.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Test::TestSuite</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link TestSuite#TestSuite <em>TestSuite</em>}</li>
 * <li>{@link TestSuite#testSimpleActivites <em>testSimpleActivites</em>}</li>
 * <li>{@link TestSuite#testHelloWorld <em>testHelloWorld</em>}</li>
 * <li>{@link TestSuite#testPolymorphicOperationCall <em>
 * testPolymorphicOperationCall</em>}</li>
 * <li>{@link TestSuite#testSuperCall <em>testSuperCall</em>}</li>
 * <li>{@link TestSuite#testSignalSend <em>testSignalSend</em>}</li>
 * <li>{@link TestSuite#activityFactory <em>activityFactory</em>}</li>
 * <li>{@link TestSuite#classifierFactory <em>classifierFactory</em>}</li>
 * <li>{@link TestSuite#executorTest <em>executorTest</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class TestSuite extends fUML.Test.Test {

    // Attributes
    private fUML.Test.ActivityFactory activityFactory = null;
    private fUML.Test.ClassifierFactory classifierFactory = null;
    private fUML.Test.ExecutorTest executorTest = null;

    // Operations of the class
    /**
     * operation TestSuite <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public TestSuite(fUML.Test.TestEnvironment environment,
            fUML.Test.ActivityFactory activityFactory,
            fUML.Test.ClassifierFactory classifierFactory, fUML.Test.ExecutorTest executorTest) {
        this.environment = environment;
        this.activityFactory = activityFactory;
        this.classifierFactory = classifierFactory;
        this.executorTest = executorTest;

    }

    /**
     * operation testSimpleActivites <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */

    public void testSimpleActivites() {
        Debug.println("");
        Debug.println("[testSimpleActivites] Setting up...");

        this.activityFactory.createCopier();
        this.activityFactory.createCaller("Copier");
        this.activityFactory.createSimpleDecision(0);
        this.activityFactory.createSimpleDecision(1);
        this.activityFactory.createForkJoin();
        this.activityFactory.createDecisionJoin();
        this.activityFactory.createForkMerge();
        this.activityFactory.createForkMergeData();
        this.activityFactory.createSelfReader();

        Debug.println("[testSimpleActivities] Testing...");

        this.executorTest.testExecute("Copier");
        this.executorTest.testExecute("CopierCaller");
        this.executorTest.testExecute("SimpleDecision0");
        this.executorTest.testExecute("SimpleDecision1");
        this.executorTest.testExecute("ForkJoin");
        this.executorTest.testExecute("DecisionJoin");
        this.executorTest.testExecute("ForkMerge");
        this.executorTest.testExecute("ForkMergeData");
        this.executorTest.testExecute("SelfReader");

        Debug.println("[testSimpleActivities] Done!");

    }

    /**
     * operation testHelloWorld <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void testHelloWorld() {
        Debug.println("");
        Debug.println("[testHelloWorld] Setting up...");
        this.activityFactory.createHelloWorld2();

        Debug.println("[testHelloWorld] Testing...");
        this.executorTest.testExecute("HelloWorld2");

        Debug.println("[testHelloWorld] Done!");

    }

    /**
     * operation testPolymorphicOperationCall <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */

    public void testPolymorphicOperationCall(String superclassMethodName, String subclassMethodName) {
        Debug.println("");
        Debug.println("[testPolymorphicOperationCall] Setting up...");

        if (activityFactory.getActivity(superclassMethodName) == null)
            return;
        if (activityFactory.getActivity(subclassMethodName) == null)
            return;

        String superclassName = "Super_" + superclassMethodName;
        String subclassName = "Sub_" + subclassMethodName;

        if (this.environment.getElement(superclassName) != null) {
            Debug.println("[testPolymorphicOperationCall] Replacing class " + superclassName + ".");
            this.environment.removeElement(superclassName);
        }

        if (this.environment.getElement(subclassName) != null) {
            Debug.println("[testPolymorphicOperationCall] Replacing class " + subclassName + ".");
            this.environment.removeElement(subclassName);
        }

        this.classifierFactory.createClass(superclassName);
        this.classifierFactory.addOperation(superclassName, "", "test", superclassMethodName);

        this.classifierFactory.createClass(subclassName);
        this.classifierFactory.addOperation(subclassName, superclassName, "test",
                subclassMethodName);

        this.activityFactory.createPolymorphicOperationCaller(subclassName, superclassName, "test");

        Debug.println("[testPolymorphicOperationCall] Testing...");

        this.executorTest.testExecute(subclassName + superclassName + "testCaller");

        Debug.println("[testPolymorphicOperationCall] Done!");

    }

    /**
     * operation testSuperCall <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void testSuperCall(String superclassMethodName, String subclassMethodName) {
        Debug.println("");
        Debug.println("[testSuperCall] Setting up...");

        if (activityFactory.getActivity(superclassMethodName) == null)
            return;
        if (activityFactory.getActivity(subclassMethodName) == null)
            return;

        String superclassName = "Super_" + superclassMethodName;
        String subclassName = "Sub_" + subclassMethodName;

        if (this.environment.getElement(superclassName) != null) {
            Debug.println("[testSuperCall] Replacing class " + superclassName + ".");
            this.environment.removeElement(superclassName);
        }

        if (this.environment.getElement(subclassName) != null) {
            Debug.println("[testSuperCall] Replacing class " + subclassName + ".");
            this.environment.removeElement(subclassName);
        }

        // Debug.println("[testSuperCall] Creating class " + superclassName +
        // "...");

        this.classifierFactory.createClass(superclassName);
        this.classifierFactory.addOperation(superclassName, "", "test", superclassMethodName);
        this.activityFactory.createSelfCaller(superclassName, "test");
        // Activity callTestMethod =
        // (Activity)(this.environment.getElement(superclassName+"testSelfCaller"));
        this.classifierFactory.addOperation(superclassName, "", "callTest", superclassName
                + "testSelfCaller");
        // Debug.println("[testSuperCall] " + superclassName + "::" +
        // "callTest method = " + callTestMethod.name + ", context = " +
        // callTestMethod.context);

        // Debug.println("[testSuperCall] Creating class " + subclassName +
        // "...");

        this.classifierFactory.createClass(subclassName);
        this.classifierFactory.addOperation(subclassName, superclassName, "test",
                subclassMethodName);
        this.activityFactory.createMethodCaller(superclassName, "callTest");
        this.classifierFactory.addOperation(subclassName, superclassName, "callTest",
                superclassName + "callTestMethodCaller");

        // Debug.println("[testSuperCall] Adding generalization...");
        this.classifierFactory.addGeneralization(subclassName, superclassName);

        // Debug.println("[testSuperCall] Creating operation caller activity...");
        this.activityFactory.createOperationCaller(subclassName, "callTest");

        Debug.println("[testSuperCall] Testing...");

        this.executorTest.testExecute(subclassName + "callTestCaller");

        Debug.println("[testSuperCall] Done!");

    }

    /**
     * operation testSignalSend <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void testSignalSend() {
        Debug.println("[testSignalSend] Setting up...");

        classifierFactory.createSignal("TestSignal");
        activityFactory.createSender("TestSignal");

        Debug.println("[testSignalSend] Testing...");

        executorTest.testExecute("TestSignalSender");

        Debug.println("[testSignalSend] Done!");

    }

} // TestSuite
