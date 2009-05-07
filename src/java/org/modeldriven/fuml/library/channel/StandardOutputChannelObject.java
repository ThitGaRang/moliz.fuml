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


package org.modeldriven.fuml.library.channel;

import fUML.Debug;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Library::ChannelImplementation::StandardOutputChannelObject</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link StandardOutputChannelObject#writeLine <em>writeLine</em>}</li>
 * <li>{@link StandardOutputChannelObject#getName <em>getName</em>}</li>
 * <li>{@link StandardOutputChannelObject#open <em>open</em>}</li>
 * <li>{@link StandardOutputChannelObject#close <em>close</em>}</li>
 * <li>{@link StandardOutputChannelObject#isOpen <em>isOpen</em>}</li>
 * <li>{@link StandardOutputChannelObject#write <em>write</em>}</li>
 * <li>{@link StandardOutputChannelObject#writeString <em>writeString</em>}</li>
 * <li>{@link StandardOutputChannelObject#writeNewLine <em>writeNewLine</em>}</li>
 * <li>{@link StandardOutputChannelObject#new_ <em>new_</em>}</li>
 * <li>{@link StandardOutputChannelObject#isFull <em>isFull</em>}</li>
 * <li>{@link StandardOutputChannelObject#opened <em>opened</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class StandardOutputChannelObject extends
        fUML.Library.ChannelImplementation.TextOutputChannelObject {

    // Attributes
    private boolean opened = true; // S.C. 11/20/2008 - set default to 'true'

    // Operations of the class
    /**
     * operation writeLine <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void writeLine(String value) {
        this.writeString(value);

    }

    /**
     * operation getName <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public String getName() {
        return "StandardOutput";

    }

    /**
     * operation open <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void open() {
        this.opened = true;

    }

    /**
     * operation close <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void close() {
        this.opened = false;

    }

    /**
     * operation isOpen <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public boolean isOpen() {
        return opened;

    }

    /**
     * operation write <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void write(fUML.Semantics.Classes.Kernel.Value value) {
        this.writeString(value.toString());
    }

    /**
     * operation writeString <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void writeString(String value) {
        if (this.isOpen()) {
            Debug.println(">>>>>>>> " + value);
        }

    }

    /**
     * operation writeNewLine <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void writeNewLine() {
        this.writeLine("");

    }

    /**
     * operation new_ <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Semantics.Classes.Kernel.Value new_() {
        return (fUML.Semantics.Classes.Kernel.Value) (new StandardOutputChannelObject());

    }

    /**
     * operation isFull <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public boolean isFull() {
        return false;
    }

} // StandardOutputChannelObject
