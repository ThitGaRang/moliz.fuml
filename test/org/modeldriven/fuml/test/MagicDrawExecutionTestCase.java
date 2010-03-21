package org.modeldriven.fuml.test;



import java.io.File;

import junit.framework.Test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.FUML;
import org.modeldriven.fuml.environment.Environment;
import org.modeldriven.fuml.environment.ExecutionEnvironment;

import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;

/**
 * 
 */
public class MagicDrawExecutionTestCase extends FUMLTest {
    private static Log log = LogFactory.getLog(MagicDrawExecutionTestCase.class);
    
    private static Environment environment; // JUnit creates a new test class for every test! 
    
    public static Test suite() {
        return FUMLTestSetup.newTestSetup(MagicDrawExecutionTestCase.class);
    }
    
    public void setUp() throws Exception {
        if (environment == null)
        {    
            String filename = "./test/mdxml/fUML-Tests.mdxml";
            File file = new File(filename);
            assertTrue("file '" + filename + "' does not exist", file.exists());
            FUML.load(file);
            environment = Environment.getInstance();
            log.info("done");
        }
    }
    
    public void testCopier() throws Exception {
        execute("Copier");
        log.info("done");
    }
   
    public void testCopierCaller() throws Exception {
        execute("CopierCaller");
        log.info("done");
    }
  
    public void testSimpleDecision() throws Exception {
        execute("SimpleDecision");
        log.info("done");
    }
    
    public void testForkJoin() throws Exception {
        execute("ForkJoin");
        log.info("done");
    }
    
    public void testDecisionJoin() throws Exception {
        execute("DecisionJoin");
        log.info("done");
    }

    public void testForkMerge() throws Exception {
        execute("ForkMerge");
        log.info("done");
    }

    public void testTestClassExtentReader() throws Exception {
        execute("TestClassExtentReader");
        log.info("done");
    }
    
    public void testSelfReader() throws Exception {
        execute("SelfReader");
        log.info("done");
    }

    public void testIdentityTester() throws Exception {
        execute("IdentityTester");
        log.info("done");
    }
 
    public void testTestClassObjectCreator() throws Exception {
        execute("TestClassObjectCreator");
        log.info("done");
    }

    public void testObjectDestroyer() throws Exception {
        execute("ObjectDestroyer");
        log.info("done");
    }

    public void testTestClassWriterReader() throws Exception {
        execute("TestClassWriterReader");
        log.info("done");
    }

    public void testTestClassAttributeWriter() throws Exception {
        execute("TestClassAttributeWriter");
        log.info("done");
    }

    public void testTestSimpleActivities() throws Exception {
        execute("TestSimpleActivities");
        log.info("done");
    }
    
    private void execute(String activityName)
    {
        Behavior behavior = environment.findBehavior(activityName);
        if (behavior == null)
            throw new RuntimeException("invalid behavior, " + activityName);
        log.info("executing behavior: " + behavior.name);
        ExecutionEnvironment execution = new ExecutionEnvironment(environment);
        execution.execute(behavior);
    }
    
}