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
package org.modeldriven.fuml;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.assembly.AssemblerResultsProfile;
import org.modeldriven.fuml.assembly.ElementGraphAssembler;
import org.modeldriven.fuml.environment.AmbiguousExecutionTargetException;
import org.modeldriven.fuml.environment.Environment;
import org.modeldriven.fuml.environment.ExecutionEnvironment;
import org.modeldriven.fuml.environment.InvalidExecutionTargetException;
import org.modeldriven.fuml.model.Model;
import org.modeldriven.fuml.model.uml2.UmlClass;
import org.modeldriven.fuml.xmi.stream.StreamNodeEvent;
import org.modeldriven.fuml.xmi.stream.StreamNodeListener;
import org.modeldriven.fuml.xmi.stream.StreamReader;
import org.modeldriven.fuml.xmi.validation.ErrorCode;
import org.modeldriven.fuml.xmi.validation.ErrorSeverity;
import org.modeldriven.fuml.xmi.validation.ValidationError;
import org.modeldriven.fuml.xmi.validation.ValidationErrorCollector;
import org.modeldriven.fuml.xmi.XmiNode;
import org.modeldriven.fuml.xmi.XmiChildFinder;
import org.modeldriven.fuml.xmi.XmiNodeVisitor;
import org.modeldriven.fuml.xmi.XmiNodeVisitorStatus;


import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.NamedElement;
import fUML.Syntax.Classes.Kernel.Operation;
import fUML.Syntax.Classes.Kernel.Property;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.FunctionBehavior;

public class FUML {
    private static Log log = LogFactory.getLog(FUML.class);

    public FUML(File file)
    {
        execute(file, null);
    }
    
    public FUML(File file, String target)
    {
        execute(file, target);
    }

    public FUML(String target)
    {
        execute(target);
    }
    
    public static void load(File file)
    {
        try {            
            log.info("loading file, " + file.getName());
            StreamReader reader = new StreamReader();
            reader.addStreamNodeListener(new PackagedElementImport());
            reader.addStreamNodeListener(new ModelImport());
            reader.read(new FileInputStream(file));  
        }
        catch (Throwable t) {
            log.error(t.getMessage(), t);
            throw new FumlException(t);
        }
    }   

    private void execute(String target)
    {
        try {            
            Environment environment = Environment.getInstance();
            Behavior behavior = environment.findBehavior(target);
            if (behavior == null)
                throw new FumlException("unknown behavior name, '" + target + "'");
            ExecutionEnvironment execution = new ExecutionEnvironment(environment);
            log.info("executing behavior: " + behavior.name);
            execution.execute(behavior);
        }
        catch (Throwable t) {
            log.error(t.getMessage(), t);
            throw new FumlException(t);
        }
    }
    
    private void execute(File file, String target)
    {
        try {
            log.info("loading file, " + file.getName());
            StreamReader reader = new StreamReader();
            reader.addStreamNodeListener(new PackagedElementImport());
            reader.addStreamNodeListener(new ModelImport());
            reader.read(new FileInputStream(file));  
            
            Environment environment = Environment.getInstance();
            Behavior behavior = null;
            
            if (target != null)
            {    
                behavior = environment.findBehavior(target);
                if (behavior == null)
                    throw new FumlException("unknown behavior name, '" + target + "'");
            }
            else
            {
                String[] names = environment.getBehaviorNames();
                if (names.length > 1)
                    throw new FumlException("ambiguous execution target - file '"
                            + file.getName() + "' contains " 
                            + String.valueOf(names.length) 
                            + " behaviors to execute - please specify a behavior");   
                else if (names.length == 0)
                    throw new FumlException("invalid execution target - file '"
                            + file.getName() + "' contains " 
                            + String.valueOf(names.length) + " behaviors");
                
                behavior = environment.findBehavior(names[0]);
                if (behavior == null)
                    throw new FumlException("unknown behavior name, '" + names[0] + "'");
            }
            ExecutionEnvironment execution = new ExecutionEnvironment(environment);
            log.info("executing behavior: " + behavior.name);
            execution.execute(behavior);
        }
        catch (Throwable t) {
            log.error(t.getMessage(), t);
            throw new FumlException(t);
        }
    }
    
    private static void printUsage()
    {
    	log.info("====================================================================");
    	log.info("USAGE: fuml <model-file> [<behavior-name> <behavior-name> <behavior-name> <...>]");
    	log.info("====================================================================");
    }
        
    public static void main(String[] args)
    {
    	if (args.length == 0)
    	{
    		printUsage();
    	    System.exit(1);
    	}
    	
    	if (args.length == 1)
    	{
    		new FUML(new File(args[0]), null);    		
    	}
    	else
    	{	
    	    FUML.load(new File(args[0]));
    	    for (int i = 1; i < args.length; i++)
    	        new FUML(args[i]);	
    	}
    }
}
