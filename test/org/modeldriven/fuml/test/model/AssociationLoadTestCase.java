package org.modeldriven.fuml.test.model;



import java.io.File;

import junit.framework.Test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.FUML;
import org.modeldriven.fuml.FumlException;
import org.modeldriven.fuml.environment.Environment;
import org.modeldriven.fuml.environment.ExecutionEnvironment;
import org.modeldriven.fuml.test.FUMLTest;
import org.modeldriven.fuml.test.FUMLTestSetup;

import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;

/**
 * 
 */
public class AssociationLoadTestCase extends FUMLTest {
    private static Log log = LogFactory.getLog(AssociationLoadTestCase.class);
    
    private static Environment environment; // JUnit creates a new test class for every test! 
    
    public static Test suite() {
        return FUMLTestSetup.newTestSetup(AssociationLoadTestCase.class);
    }
    
    public void setUp() throws Exception {
        if (environment == null)
        {    
            String filename = "./test/mdxml/Contacts.mdxml";
            File file = new File(filename);
            assertTrue("file '" + filename + "' does not exist", file.exists());
            FUML.load(file);
            environment = Environment.getInstance();
            log.info("done");
        }    
    }
    
    public void testR0() throws Exception {
        execute("R0");
    }
    public void testR1() throws Exception {
        execute("R1");
    }
    public void testR2() throws Exception {
        execute("R2");
    }
    
    public void testR3() throws Exception {
        execute("R3");
    }
    
    public void testR4() throws Exception {
        execute("R4");
    }
    public void testR5() throws Exception {
        execute("R5");
    }
    public void testR6() throws Exception {
        execute("R6");
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