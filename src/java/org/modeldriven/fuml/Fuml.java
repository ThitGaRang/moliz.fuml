/*
 * Copyright 2008 Lockheed Martin Corporation, except as stated in the file 
 * entitled Licensing-Information. All modifications copyright 2009 Data Access Technologies, Inc. Licensed under the Academic Free License 
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.environment.Environment;
import org.modeldriven.fuml.environment.ExecutionEnvironment;
import org.modeldriven.fuml.xmi.stream.StreamReader;

import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;

public class Fuml {
    private static Log log = LogFactory.getLog(Fuml.class);

    public Fuml(File file) {
        execute(file, null);
    }

    public Fuml(File file, String target) {
        execute(file, target);
    }

    public Fuml(String target) {
        execute(target);
    }

    public static void load(File file) {
        try {
            log.info("loading file, " + file.getName());
            StreamReader reader = new StreamReader();
            reader.addStreamNodeListener(new PackagedElementImport());
            reader.addStreamNodeListener(new ModelImport());
            reader.read(new FileInputStream(file));
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            throw new FumlException(t);
        }
    }

    private void execute(String target) {
        try {
            Environment environment = Environment.getInstance();
            Behavior behavior = environment.findBehavior(target);
            if (behavior == null)
                throw new FumlException("unknown behavior name, '" + target + "'");
            ExecutionEnvironment execution = new ExecutionEnvironment(environment);
            log.info("executing behavior: " + behavior.name);
            execution.execute(behavior);
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            throw new FumlException(t);
        }
    }

    private void execute(File file, String target) {
        try {
            log.info("loading file, " + file.getName());
            StreamReader reader = new StreamReader();
            reader.addStreamNodeListener(new PackagedElementImport());
            reader.addStreamNodeListener(new ModelImport());
            reader.read(new FileInputStream(file));

            Environment environment = Environment.getInstance();
            Behavior behavior = null;

            if (target != null) {
                behavior = environment.findBehavior(target);
                if (behavior == null)
                    throw new FumlException("unknown behavior name, '" + target + "'");
            } else {
                String[] names = environment.getBehaviorNames();
                if (names.length > 1)
                    throw new FumlException("ambiguous execution target - file '" + file.getName()
                            + "' contains " + String.valueOf(names.length)
                            + " behaviors to execute - please specify a behavior");
                else if (names.length == 0)
                    throw new FumlException("invalid execution target - file '" + file.getName()
                            + "' contains " + String.valueOf(names.length) + " behaviors");

                behavior = environment.findBehavior(names[0]);
                if (behavior == null)
                    throw new FumlException("unknown behavior name, '" + names[0] + "'");
            }
            ExecutionEnvironment execution = new ExecutionEnvironment(environment);
            log.info("executing behavior: " + behavior.name);
            execution.execute(behavior);
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            throw new FumlException(t);
        }
    }

    private static void printUsage() {
        log.info("====================================================================");
        log.info("USAGE: fuml <model-file> [<behavior-name> <behavior-name> <behavior-name> <...>]");
        log.info("====================================================================");
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            System.exit(1);
        }

        if (args.length == 1) {
            new Fuml(new File(args[0]), null);
        } else {
            Fuml.load(new File(args[0]));
            for (int i = 1; i < args.length; i++)
                new Fuml(args[i]);
        }
    }
}
