package org.modeldriven.fuml.test.model;



import java.io.File;
import java.io.FileInputStream;

import junit.framework.Test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.meta.MetaModel;
import org.modeldriven.fuml.test.FUMLTest;
import org.modeldriven.fuml.test.FUMLTestSetup;
import org.modeldriven.fuml.xmi.XmiValidationEventHandler;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralUnlimitedNatural;

import fUML.Library.ChannelImplementation.StandardOutputChannelObject;
import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Activities.ExtraStructuredActivities.ExpansionRegion;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityEdge;
import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;
import fUML.Syntax.Activities.IntermediateActivities.ObjectNode;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Classifier;
import fUML.Syntax.Classes.Kernel.DataType;
import fUML.Syntax.Classes.Kernel.Feature;
import fUML.Syntax.Classes.Kernel.LiteralInteger;
import fUML.Syntax.Classes.Kernel.Model;
import fUML.Syntax.Classes.Kernel.NamedElement;
import fUML.Syntax.Classes.Kernel.Parameter;
import fUML.Syntax.Classes.Kernel.TypedElement;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.OpaqueBehavior;

import org.modeldriven.fuml.meta.Property;


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
        MetaModel model = MetaModel.getInstance();
        log.info("returned an instance");
        
        //Object lock = new Object();
        //synchronized(lock) {
        //	lock.wait(300000);
        //}
        log.info("done");
    }
    
    public void testActivity() throws Exception {    
        Classifier activityClassifier = MetaModel.getInstance().findClassifier(Activity.class.getSimpleName());
        assertTrue("could not find class 'Activity'", 
        		activityClassifier != null);
       log.info("done");
    }

    public void testActivityEdge() throws Exception {    
        Classifier activityEdgeClassifier = MetaModel.getInstance().findClassifier(ActivityEdge.class.getSimpleName());
        assertTrue("could not find class 'ActivityEdge'", 
        		activityEdgeClassifier != null);
        Property isLeaf = MetaModel.getInstance().findAttribute((Class_)activityEdgeClassifier, "isLeaf");
        assertTrue("No ownedAttribute 'isLeaf' found for class 'Activity'", isLeaf != null);
        assertTrue("Expected singular ownedAttribute 'isLeaf' for class 'Activity'", 
                MetaModel.getInstance().isSingular((Class_) activityEdgeClassifier, isLeaf));
       log.info("done");
    }
    
    
    public void testOpaqueBehavior() throws Exception {    
        Classifier opaqueBehaviorClassifier = MetaModel.getInstance().findClassifier(OpaqueBehavior.class.getSimpleName());
        assertTrue("could not find class 'OpaqueBehavior'", opaqueBehaviorClassifier != null);
        Property visibility = MetaModel.getInstance().findAttribute((Class_)opaqueBehaviorClassifier, "visibility");
        assertTrue("No ownedAttribute 'visibility' found for class 'OpaqueBehavior'", visibility != null);
        log.info("done");
    }
    
    public void testOpaqueExpression() throws Exception {    
        Classifier opaqueExpressionClassifier = MetaModel.getInstance().findClassifier("OpaqueExpression");
        assertTrue("could not find class 'OpaqueExpression'", opaqueExpressionClassifier != null);
        Property visibility = MetaModel.getInstance().findAttribute((Class_)opaqueExpressionClassifier, "visibility");
        assertTrue("No ownedAttribute 'visibility' found for class 'OpaqueExpression'", visibility != null);
        log.info("done");
    }

    public void testParameter() throws Exception {    
        log.info("testParameter");
        Classifier parameter = MetaModel.getInstance().findClassifier(Parameter.class.getSimpleName());
        assertTrue("could not find class 'Parameter'", parameter != null);
        Property multiplicityElement = MetaModel.getInstance().findAttribute((Class_)parameter, "multiplicityElement");
        assertTrue("No ownedAttribute 'multiplicityElement' expected for class 'Parameter'", multiplicityElement == null);
        Property direction = MetaModel.getInstance().findAttribute((Class_)parameter, "direction");
        assertTrue("The ownedAttribute 'direction' expected for class 'Parameter'", direction != null);
        assertTrue("Expected 'Parameter.direction' as required", 
                MetaModel.getInstance().isRequired((Class_)parameter, direction));
        assertTrue("Expected default value for 'Parameter.direction'", 
                MetaModel.getInstance().hasAttributeDefaultValue(direction));
        
        log.info("done");
    }

    public void testCallBehaviorAction() throws Exception {    
        log.info("testCallBehaviorAction");
        Classifier actionClassifier = MetaModel.getInstance().findClassifier(CallBehaviorAction.class.getSimpleName());
        assertTrue("could not find classifier 'CallBehaviorAction'", actionClassifier != null);
        Property behavior = MetaModel.getInstance().findAttribute((Class_)actionClassifier, "behavior");
        assertTrue("No ownedAttribute 'behavior' found for class 'CallBehaviorAction'", behavior != null);
        assertTrue("Expected ownedAttribute 'behavior' as required for class 'CallBehaviorAction'", 
                MetaModel.getInstance().isRequired((Class_)actionClassifier, behavior));
        log.info("done");
    }

    public void testLiteralInteger() throws Exception {    
        log.info("testLiteralInteger");
        Classifier integerClassifier = MetaModel.getInstance().findClassifier(LiteralInteger.class.getSimpleName());
        assertTrue("could not find class for 'LiteralInteger'", integerClassifier != null);
        Property nameProp = MetaModel.getInstance().findAttribute((Class_)integerClassifier, "name");
        assertTrue("No ownedAttribute 'name' found for class 'LiteralInteger'", nameProp != null);
        Classifier nameType = MetaModel.getInstance().findType(nameProp);
        log.info("done");
    }

    public void testLiteralUnlimitedNatural() throws Exception {    
        log.info("testLiteralUnlimitedNatural");
        Classifier classifier = MetaModel.getInstance().findClassifier(LiteralUnlimitedNatural.class.getSimpleName());
        assertTrue("could not find class for 'LiteralUnlimitedNatural'", classifier != null);
        Property nameProp = MetaModel.getInstance().findAttribute((Class_)classifier, "name");
        assertTrue("No ownedAttribute 'name' found for class 'LiteralUnlimitedNatural'", nameProp != null);
        Classifier nameType = MetaModel.getInstance().findType(nameProp);
        assertTrue("LiteralUnlimitedNatural.name is not an instance of DataType", 
                nameType instanceof DataType);
        Property valueProp = MetaModel.getInstance().findAttribute((Class_)classifier, "value");
        assertTrue("No ownedAttribute 'value' found for class 'LiteralUnlimitedNatural'", valueProp != null);
        Classifier valueType = MetaModel.getInstance().findType(valueProp);
        assertNotNull("LiteralUnlimitedNatural.value is null", 
        		valueType);
        log.info("done");
    }    

    public void testModel() throws Exception {    
        log.info("testModel");
        Classifier modelClassifier = MetaModel.getInstance().findClassifier(Model.class.getSimpleName());
        assertTrue("could not find class for 'Model'", modelClassifier != null);
        //Property profileApplicationProp = Model.getInstance().findAttribute((Class_)modelClassifier, "profileApplication");
        //assertTrue("No ownedAttribute 'profileApplication' found for class 'Model'", profileApplicationProp != null);
        log.info("done");
    }

    public void testTypedElement() throws Exception {    
        log.info("testTypedElement");
        Classifier typedElementClassifier = MetaModel.getInstance().findClassifier(TypedElement.class.getSimpleName());
        assertTrue("could not find class for 'TypedElement'", typedElementClassifier != null);
        Property type = MetaModel.getInstance().findAttribute((Class_)typedElementClassifier, "type");
        assertTrue("No ownedAttribute 'type' found for class 'TypedElement'", type != null);
        log.info("done");
    }

    public void testNamedElement() throws Exception {    
        log.info("testTypedElement");
        Classifier namedElementClassifier = MetaModel.getInstance().findClassifier(NamedElement.class.getSimpleName());
        assertTrue("could not find class for 'NamedElement'", namedElementClassifier != null);
        Property name = MetaModel.getInstance().findAttribute((Class_)namedElementClassifier, "name");
        assertTrue("No ownedAttribute 'name' found for class 'NamedElement'", name != null);
        Property visibility = MetaModel.getInstance().findAttribute((Class_)namedElementClassifier, "visibility");
        assertTrue("No ownedAttribute 'visibility' found for class 'NamedElement'", visibility != null);
        log.info("done");
    }
    
    public void testFeature() throws Exception {    
        log.info("testFeature");
        Classifier featureClassifier = MetaModel.getInstance().findClassifier(Feature.class.getSimpleName());
        assertTrue("could not find class for 'Feature'", featureClassifier != null);
        Property isLeaf = MetaModel.getInstance().findAttribute((Class_)featureClassifier, "isLeaf");
        assertTrue("No ownedAttribute 'isLeaf' found for class 'Feature'", isLeaf != null);
        log.info("done");
    }
 
       
    
    public void testActivityParameterNode() throws Exception {    
        log.info("testActivityParameterNode");
        Classifier nodeClassifier = MetaModel.getInstance().findClassifier(ActivityParameterNode.class.getSimpleName());
        assertTrue("could not find class for 'ActivityParameterNode'", nodeClassifier != null);
        Property type = MetaModel.getInstance().findAttribute((Class_)nodeClassifier, "type");
        assertTrue("No ownedAttribute 'type' found for class 'ActivityParameterNode'", type != null);
        log.info("done");
    }
    
    public void testClass() throws Exception {    
        log.info("testClass");
        Classifier classifier = MetaModel.getInstance().findClassifier("Class");
        assertTrue("could not find class for 'Class'", classifier != null);
        Property isAbstract = MetaModel.getInstance().findAttribute((Class_)classifier, "isAbstract");
        assertTrue("No ownedAttribute 'isAbstract' found for class 'Class'", isAbstract != null);
        assertTrue("Expected 'Class.isAbstract' as singular ownedAttribute", 
                MetaModel.getInstance().isSingular((Class_) classifier, isAbstract));
        assertTrue("Expected 'Class.isAbstract' as required ownedAttribute", 
                MetaModel.getInstance().isRequired((Class_) classifier, isAbstract));
        assertTrue("Expected default value for 'Class.isAbstract'", 
                MetaModel.getInstance().hasAttributeDefaultValue(isAbstract));
        Property isLeaf = MetaModel.getInstance().findAttribute((Class_)classifier, "isLeaf");
        assertNull("Unexpected ownedAttribute 'isLeaf' found for class 'Class'", isLeaf);

        log.info("done");
    }

    public void testStandardOutputChannelObject() throws Exception {    
        log.info("v");
        Classifier classifier = MetaModel.getInstance().findClassifier(StandardOutputChannelObject.class.getSimpleName());
        assertTrue("could not find class for 'StandardOutputChannelObject'", classifier != null);
        log.info("done");
    }

    public void testObjectNode() throws Exception {    
        log.info("testObjectNode");
        Classifier objectNodeClassifier = MetaModel.getInstance().findClassifier(ObjectNode.class.getSimpleName());
        assertTrue("could not find classifier 'ObjectNode'", objectNodeClassifier != null);
        /*
        Property orderingProp = MetaModel.getInstance().findAttribute((Class_)objectNodeClassifier, "ordering");
        assertTrue("No ownedAttribute 'ordering' found for class 'ObjectNode'", orderingProp != null);
        assertTrue("Expected 'ObjectNode.ordering' as required property",
            MetaModel.getInstance().isRequired((Class_)objectNodeClassifier, orderingProp));
        String dflt = MetaModel.getInstance().getAttributeDefault(orderingProp);
        assertTrue("no default found for 'ObjectNode.ordering'", 
                dflt != null);
        assertTrue("expected 'FIFO' as default for 'ObjectNode.ordering'", 
                "FIFO".equals(dflt));
        */
                       

        log.info("done");
    }
    
    public void testExpansionRegion() throws Exception {    
        log.info("testExpansionRegion");
        Classifier expansionRegionClassifier = MetaModel.getInstance().findClassifier(ExpansionRegion.class.getSimpleName());
        assertTrue("could not find classifier 'ExpansionRegion'", expansionRegionClassifier != null);
        Property modeProp = MetaModel.getInstance().findAttribute((Class_)expansionRegionClassifier, "mode");
        assertTrue("No ownedAttribute 'mode' found for class 'ExpansionRegion'", modeProp != null);
        String dflt = MetaModel.getInstance().getAttributeDefault(modeProp);
        
        assertTrue("Expected default for 'mode' property for class 'ExpansionRegion'", 
                dflt != null);
        log.info("done");
    }
    
}