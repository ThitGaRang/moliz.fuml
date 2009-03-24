package org.modeldriven.fuml.test;



import java.io.File;

import junit.framework.Test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.FUML;
import org.modeldriven.fuml.environment.Environment;
import org.modeldriven.fuml.environment.ExecutionEnvironment;
import org.modeldriven.fuml.library.Library;

import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;

/**
 * 
 */
public class LibraryTestCase extends FUMLTest {
    private static Log log = LogFactory.getLog(LibraryTestCase.class);
    
    
    public static Test suite() {
        return FUMLTestSetup.newTestSetup(LibraryTestCase.class);
    }
    
    public void setUp() throws Exception {
    }
    
    public void testLoadLibraries() throws Exception {
        Library.getInstance();
        log.info("done");
    }

    
    private void execute(String activityName)
    {
        Behavior behavior = Environment.getInstance().findBehavior(activityName);
        log.info("executing activity: " + behavior.name);
        ExecutionEnvironment execution = new ExecutionEnvironment(Environment.getInstance());
        execution.execute(behavior);
    }
    
}