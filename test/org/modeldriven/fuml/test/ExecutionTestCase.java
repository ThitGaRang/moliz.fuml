package org.modeldriven.fuml.test;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.FUML;
import org.modeldriven.fuml.environment.Environment;
import org.modeldriven.fuml.environment.ExecutionEnvironment;
import org.modeldriven.fuml.xmi.XmiDataBinding;
import org.modeldriven.fuml.xmi.XmiReader;

import fUML.Syntax.Activities.IntermediateActivities.Activity;

import junit.framework.Test;

/**
 * 
 */
public class ExecutionTestCase extends FUMLTest {
    private static Log log = LogFactory.getLog(ExecutionTestCase.class);
    
    public static Test suite() {
        return FUMLTestSetup.newTestSetup(ExecutionTestCase.class);
    }
    
    public void setUp() throws Exception {
    }
    
    public void testCopierExecution() throws Exception {
        log.info("testCopierExecution");
        String filename = "./test/xmi/copier.xmi";
        File file = new File(filename);
        assertTrue("file '" + filename + "' does not exist", file.exists());
        FUML fuml = new FUML(file);
        log.info("done");
    }    

    public void testCopierMagicDrawExecution() throws Exception {
        log.info("testCopierMagicDrawExecution");
        String filename = "./test/uml/magicdraw/copier-v2.x.uml";
        File file = new File(filename);
        assertTrue("file '" + filename + "' does not exist", file.exists());
        FUML fuml = new FUML(file);
        log.info("done");
    }    
      
    public void testCopierCallerExecution() throws Exception {
        log.info("testCopierCallerExecution");
        String filename = "./test/xmi/copier-caller.xmi";
        File file = new File(filename);
        assertTrue("file '" + filename + "' does not exist", file.exists());
        FUML fuml = new FUML(file, "CopierCaller");
        log.info("done");
    }
    

    public void testForkJoinExecution() throws Exception {
        log.info("testForkJoinExecution");
        String filename = "./test/xmi/fork-join.xmi";
        File file = new File(filename);
        assertTrue("file '" + filename + "' does not exist", file.exists());
        FUML fuml = new FUML(file, "ForkJoin");
        log.info("done");
    }    


}