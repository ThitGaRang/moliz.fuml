package org.modeldriven.fuml.test;



import java.io.File;
import java.io.FileInputStream;

import junit.framework.Test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.model.Model;
import org.modeldriven.fuml.model.ModelDataBinding;
import org.modeldriven.fuml.xmi.BindingXmiReader;
import org.modeldriven.fuml.xmi.XmiValidationEventHandler;
import org.modeldriven.fuml.model.uml2.UmlClass;
import org.modeldriven.fuml.model.uml2.UmlClassifier;
import org.modeldriven.fuml.model.uml2.UmlDataType;
import org.modeldriven.fuml.model.uml2.UmlProperty;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralUnlimitedNatural;

import fUML.Library.ChannelImplementation.StandardOutputChannelObject;
import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.LiteralInteger;
import fUML.Syntax.Classes.Kernel.Parameter;
import fUML.Syntax.Classes.Kernel.TypedElement;

/**
 * 
 */
public class ModelTestCase extends FUMLTest {
    private static Log log = LogFactory.getLog(ModelTestCase.class);
    
    public static Test suite() {
        return FUMLTestSetup.newTestSetup(ModelTestCase.class);
    }
    
    public void setUp() throws Exception {
    }

    public void testCreateModel() throws Exception {
        log.info("testCreateModel");
        Model model = Model.getInstance();
        log.info("done");
    }
    
    public void testActivity() throws Exception {    
        assertTrue("could not find class 'Activity'", 
                Model.getInstance().findClassifier(Activity.class.getSimpleName()) != null);
        log.info("done");
    }
    
    public void testOpaqueExpression() throws Exception {    
        assertTrue("could not find class 'OpaqueExpression'", 
                Model.getInstance().findClassifier("OpaqueBehavior") != null);
        log.info("done");
    }
    
    public void testParameter() throws Exception {    
        log.info("testParameter");
        UmlClassifier paramClassifier = Model.getInstance().findClassifier(Parameter.class.getSimpleName());
        assertTrue("could not find class 'Parameter'", paramClassifier != null);
        UmlProperty prop = Model.getInstance().findAttribute((UmlClass)paramClassifier, "multiplicityElement");
        assertTrue("No ownedAttribute 'multiplicityElement' expected for class 'Parameter'", prop == null);
        log.info("done");
    }

    public void testCallBehaviorAction() throws Exception {    
        log.info("testCallBehaviorAction");
        UmlClassifier actionClassifier = Model.getInstance().findClassifier(CallBehaviorAction.class.getSimpleName());
        UmlProperty behavior = Model.getInstance().findAttribute((UmlClass)actionClassifier, "behavior");
        assertTrue("No ownedAttribute 'behavior' found for class 'CallBehaviorAction'", behavior != null);
        assertTrue("Expected ownedAttribute 'behavior' as required for class 'CallBehaviorAction'", 
                Model.getInstance().isRequired((UmlClass)actionClassifier, behavior));
        log.info("done");
    }

    public void testLiteralInteger() throws Exception {    
        log.info("testLiteralInteger");
        UmlClassifier integerClassifier = Model.getInstance().findClassifier(LiteralInteger.class.getSimpleName());
        assertTrue("could not find class for 'LiteralInteger'", integerClassifier != null);
        UmlProperty nameProp = Model.getInstance().findAttribute((UmlClass)integerClassifier, "name");
        assertTrue("No ownedAttribute 'name' found for class 'LiteralInteger'", nameProp != null);
        UmlClassifier nameType = Model.getInstance().findType(nameProp);
        log.info("done");
    }

    public void testLiteralUnlimitedNatural() throws Exception {    
        log.info("testLiteralUnlimitedNatural");
        UmlClassifier classifier = Model.getInstance().findClassifier(LiteralUnlimitedNatural.class.getSimpleName());
        assertTrue("could not find class for 'LiteralUnlimitedNatural'", classifier != null);
        UmlProperty nameProp = Model.getInstance().findAttribute((UmlClass)classifier, "name");
        assertTrue("No ownedAttribute 'name' found for class 'LiteralUnlimitedNatural'", nameProp != null);
        UmlClassifier nameType = Model.getInstance().findType(nameProp);
        assertTrue("LiteralUnlimitedNatural.name is not an instance of UmlDataType", 
                nameType instanceof UmlDataType);
        UmlProperty valueProp = Model.getInstance().findAttribute((UmlClass)classifier, "value");
        assertTrue("No ownedAttribute 'value' found for class 'LiteralUnlimitedNatural'", valueProp != null);
        UmlClassifier valueType = Model.getInstance().findType(valueProp);
        assertTrue("LiteralUnlimitedNatural.value is not an instance of UmlClass", 
                valueType instanceof UmlClass);
        log.info("done");
    }    

    public void testModel() throws Exception {    
        log.info("testModel");
        UmlClassifier modelClassifier = Model.getInstance().findClassifier("Model");
        assertTrue("could not find class for 'Model'", modelClassifier != null);
        UmlProperty profileApplicationProp = Model.getInstance().findAttribute((UmlClass)modelClassifier, "profileApplication");
        assertTrue("No ownedAttribute 'profileApplication' found for class 'Package'", profileApplicationProp != null);
        log.info("done");
    }

    public void testTypedElement() throws Exception {    
        log.info("testTypedElement");
        UmlClassifier typedElementClassifier = Model.getInstance().findClassifier(TypedElement.class.getSimpleName());
        assertTrue("could not find class for 'TypedElement'", typedElementClassifier != null);
        UmlProperty type = Model.getInstance().findAttribute((UmlClass)typedElementClassifier, "type");
        assertTrue("No ownedAttribute 'type' found for class 'TypedElement'", type != null);
        log.info("done");
    }
        
    public void testActivityParameterNode() throws Exception {    
        log.info("testActivityParameterNode");
        UmlClassifier nodeClassifier = Model.getInstance().findClassifier(ActivityParameterNode.class.getSimpleName());
        assertTrue("could not find class for 'ActivityParameterNode'", nodeClassifier != null);
        UmlProperty type = Model.getInstance().findAttribute((UmlClass)nodeClassifier, "type");
        assertTrue("No ownedAttribute 'type' found for class 'ActivityParameterNode'", type != null);
        log.info("done");
    }
    
    public void testClass() throws Exception {    
        log.info("testActivityParameterNode");
        UmlClassifier classifier = Model.getInstance().findClassifier("Class");
        assertTrue("could not find class for 'Class'", classifier != null);
        UmlProperty type = Model.getInstance().findAttribute((UmlClass)classifier, "isLeaf");
        assertTrue("No ownedAttribute 'isLeaf' found for class 'Class'", type != null);
        log.info("done");
    }

    public void testStandardOutputChannelObject() throws Exception {    
        log.info("v");
        UmlClassifier classifier = Model.getInstance().findClassifier(StandardOutputChannelObject.class.getSimpleName());
        assertTrue("could not find class for 'StandardOutputChannelObject'", classifier != null);
        log.info("done");
    }
    
}