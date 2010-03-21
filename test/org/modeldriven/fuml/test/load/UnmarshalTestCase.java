package org.modeldriven.fuml.test.load;



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
import org.modeldriven.fuml.test.FUMLTest;
import org.modeldriven.fuml.test.FUMLTestSetup;
import org.modeldriven.fuml.xmi.BindingXmiReader;
import org.modeldriven.fuml.xmi.XmiDataBinding;
import org.modeldriven.fuml.xmi.XmiReader;
import org.modeldriven.fuml.xmi.XmiValidationEventHandler;

import junit.framework.Test;

/**
 * 
 */
public class UnmarshalTestCase extends FUMLTest {
    private static Log log = LogFactory.getLog(UnmarshalTestCase.class);
    
    public static Test suite() {
        return FUMLTestSetup.newTestSetup(UnmarshalTestCase.class);
    }
    
    public void setUp() throws Exception {
    }
    
    public void testCopierUnmarshal() throws Exception {
        log.info("testCopierUnmarshal");
        unmarshal("./test/xmi/copier.xmi");
        log.info("done");
    }
    
    /*

    public void testCopierCallerUnmarshal() throws Exception {
        log.info("testCopierCallerUnmarshal");
        unmarshal("./test/xmi/copier-caller.xmi");
        log.info("done");
    }

    public void testSimpleDecisionUnmarshal() throws Exception {
        log.info("testSimpleDecisionUnmarshal");
        unmarshal("./test/xmi/simple-decision.xmi");
        log.info("done");
    }

    public void testForkJoinUnmarshal() throws Exception {
        log.info("testForkJoinUnmarshal");
        unmarshal("./test/xmi/fork-join.xmi");
        log.info("done");
    }    

    public void testDecisionJoinUnmarshal() throws Exception {
        log.info("testDecisionJoinUnmarshal");
        unmarshal("./test/xmi/decision-join.xmi");
        log.info("done");
    }

    public void testForkMergeUnmarshal() throws Exception {
        log.info("testForkMergeUnmarshal");
        unmarshal("./test/xmi/fork-merge.xmi");
        log.info("done");
    }
    
    public void testForkMergeDataUnmarshal() throws Exception {
        log.info("testForkMergeDataUnmarshal");
        unmarshal("./test/xmi/fork-merge-data.xmi");
        log.info("done");
    }
*/
    
    private void unmarshal(String filename)
    {
        File file = new File(filename);
        assertTrue("file '" + filename + "' does not exist", file.exists());
        log.info("unmarshaling '" + file.getName() + "'");
        
        try {   
            FileInputStream is = new FileInputStream(file);  
            BindingXmiReader reader = new BindingXmiReader(new XmiDataBinding(
                    new XmiValidationEventHandler()));
        	reader.read(is);
        	int errorCount = reader.getValidationEventHandler().getErrorCount();
        	this.assertTrue("found " + String.valueOf(errorCount) + " validation errors",
        			errorCount == 0);        		
        }
        catch (Throwable t) {
        	log.error(t.getMessage(), t);
        	throw new RuntimeException(t);
        }    	
    }
    
}