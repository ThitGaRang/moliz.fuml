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


package org.modeldriven.fuml.library.pipe;

import org.modeldriven.fuml.library.channel.OutputChannelObject;


/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Library::PipeImplementation::PipeOutputChannelObject</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link PipeOutputChannelObject#write <em>write</em>}</li>
 * <li>{@link PipeOutputChannelObject#isFull <em>isFull</em>}</li>
 * <li>{@link PipeOutputChannelObject#PipeOutputChannelObject <em>
 * PipeOutputChannelObject</em>}</li>
 * <li>{@link PipeOutputChannelObject#getName <em>getName</em>}</li>
 * <li>{@link PipeOutputChannelObject#open <em>open</em>}</li>
 * <li>{@link PipeOutputChannelObject#close <em>close</em>}</li>
 * <li>{@link PipeOutputChannelObject#isOpen <em>isOpen</em>}</li>
 * <li>{@link PipeOutputChannelObject#otherEnd <em>otherEnd</em>}</li>
 * <li>{@link PipeOutputChannelObject#opened <em>opened</em>}</li>
 * <li>{@link PipeOutputChannelObject#name <em>name</em>}</li>
 * </ul>
 * </p>
 * 
 */

public class PipeOutputChannelObject extends OutputChannelObject {

    // Attributes
    private PipeInputChannelObject otherEnd = null;
    private boolean opened = false;
    private String name = new String();

    // Operations of the class
    /**
     * operation write <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * 
     */

    public void write(fUML.Semantics.Classes.Kernel.Value value) {
        if (this.isOpen()) {
            this.otherEnd.receive(value);
        }

    }

    /**
     * operation isFull <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * 
     */

    public boolean isFull() {
        return false;

    }

    /**
     * operation PipeOutputChannelObject <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * 
     */

    public PipeOutputChannelObject(String name, PipeInputChannelObject otherEnd) {
		this.name = name;
		this.otherEnd = otherEnd;
		this.opened = true;

    }

    /**
     * operation getName <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * 
     */

    public String getName() {
        return name;
    }

    /**
     * operation open <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * 
     */

    public void open() {
        opened = true;

    }

    /**
     * operation close <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * 
     */

    public void close() {
        opened = false;
    }

    /**
     * operation isOpen <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * 
     */

    public boolean isOpen() {
        return opened;

    }

} // PipeOutputChannelObject
