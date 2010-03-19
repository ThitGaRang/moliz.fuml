package org.modeldriven.fuml.test.library;



import java.io.File;

import junit.framework.Test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.Fuml;
import org.modeldriven.fuml.environment.Environment;
import org.modeldriven.fuml.environment.ExecutionEnvironment;
import org.modeldriven.fuml.test.FUMLTest;
import org.modeldriven.fuml.test.FUMLTestSetup;

import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;

/**
 * 
 */
public class ExternalReferenceTestCase extends FUMLTest {
    private static Log log = LogFactory.getLog(ExternalReferenceTestCase.class);
    
    private Environment environment; // JUnit creates a new test class for every test! 
    
    public static Test suite() {
        return FUMLTestSetup.newTestSetup(ExternalReferenceTestCase.class);
    }
    
    public void setUp() throws Exception {
    }
 
    public void testWriteLineExternalReference() throws Exception {
            String filename = "./test/uml/magicdraw/HelloWorldExternalReference.uml";
            File file = new File(filename);
            assertTrue("file '" + filename + "' does not exist", file.exists());
            Fuml.load(file);
            environment = Environment.getInstance();
            execute("HelloWorld");
            log.info("done");
       
    }
    
    public void testIntegerFunctionsExternalReference() throws Exception {
        String filename = "./test/uml/magicdraw/IntegerFunctionsExternalReference.uml";
        File file = new File(filename);
        assertTrue("file '" + filename + "' does not exist", file.exists());
        Fuml.load(file);
        environment = Environment.getInstance();
        execute("TestIntegerFunctions");
        log.info("done");
    }    

    public void testMDXMLExternalReference() throws Exception {
        String filename = "./test/mdxml/fUML-Tests.mdxml";
        File file = new File(filename);
        assertTrue("file '" + filename + "' does not exist", file.exists());
        Fuml.load(file);
        environment = Environment.getInstance();
        execute("TestIntegerFunctions");
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