package org.modeldriven.fuml.test.validation;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.xml.bind.JAXBElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.test.FUMLTest;
import org.modeldriven.fuml.test.FUMLTestSetup;
import org.modeldriven.fuml.xmi.XmiNode;
import org.modeldriven.fuml.xmi.XmiReader;
import org.modeldriven.fuml.xmi.XmiValidationEventHandler;
import org.modeldriven.fuml.xmi.stream.StreamReader;
import org.modeldriven.fuml.xmi.validation.ErrorCode;
import org.modeldriven.fuml.xmi.validation.ErrorSeverity;
import org.modeldriven.fuml.xmi.validation.ValidationError;
import org.modeldriven.fuml.xmi.validation.ValidationErrorCollector;

import junit.framework.Test;

/**
 * 
 */
public class ValidateTestCase extends FUMLTest {
    private static Log log = LogFactory.getLog(ValidateTestCase.class);
    
    private static ValidationErrorCollector collector;
    
    public static Test suite() {
        return FUMLTestSetup.newTestSetup(ValidateTestCase.class);
    }
        
    public void setUp() throws Exception {
        if (collector == null)
            collector = validate("./test/uml/magicdraw/copier-validate.uml");
    }

    public void testDuplicateReference() throws Exception {
        log.info("testDuplicateReference");
        assertTrue("expected 1 duplicate-reference error", 
                collector.getErrorCount(ErrorCode.DUPLICATE_REFERENCE) == 1);
        log.info("done");
    }

    public void testInvalidReference() throws Exception {
        log.info("testInvalidReference");
        assertTrue("expected 1 invalid-reference error", 
                collector.getErrorCount(ErrorCode.INVALID_REFERENCE) == 1);
        log.info("testInvalidReference");
    }

    public void testUndefinedClass() throws Exception {
        log.info("testUndefinedClass");
        assertTrue("expected 1 undefined-class error", 
                collector.getErrorCount(ErrorCode.UNDEFINED_CLASS) == 1);
        log.info("testUndefinedClass");
    }

    public void testUndefinedProperty() throws Exception {
        log.info("testUndefinedProperty");
        assertTrue("expected 1 undefined-property error", 
                collector.getErrorCount(ErrorCode.UNDEFINED_PROPERTY) == 1);
        log.info("testUndefinedProperty");
    }

    public void testAbstractClass() throws Exception {
        log.info("testAbstractClass");
        int count = collector.getErrorCount(ErrorCode.ABSTRACT_CLASS_INSTANTIATION);
        assertTrue("expected 1 abstract class error not " + count, 
                count == 1);
        log.info("testAbstractClass");
    }
    
    private ValidationErrorCollector validate(String filename)
    {
        File file = new File(filename);
        assertTrue("file '" + filename + "' does not exist", file.exists());
        log.info("unmarshaling '" + file.getName() + "'");
        
        try {   
            StreamReader reader = new StreamReader();
            Collection coll = reader.read(new FileInputStream(file));  
            XmiNode root = (XmiNode)coll.iterator().next();
            
            ValidationErrorCollector errorCollector = new ValidationErrorCollector(root);
            errorCollector.validate();
            Iterator<ValidationError> errors = errorCollector.getErrors().iterator();
            while (errors.hasNext())
            {
                ValidationError error = errors.next();
                if (error.getSeverity().ordinal() == ErrorSeverity.FATAL.ordinal())
                {
                    log.error(error.getText());
                }
                else if (error.getSeverity().ordinal() == ErrorSeverity.WARN.ordinal())
                {
                    log.warn(error.getText());
                }
                else if (error.getSeverity().ordinal() == ErrorSeverity.INFO.ordinal())
                {
                    log.info(error.getText());
                }
                else
                {
                    log.info(error.getText());
                }
            }
            return errorCollector;
        }
        catch (Throwable t) {
        	log.error(t.getMessage(), t);
        	throw new RuntimeException(t);
        }    	
    }
    
}