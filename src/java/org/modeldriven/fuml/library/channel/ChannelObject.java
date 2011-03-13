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

import org.modeldriven.fuml.library.libraryclass.ImplementationObject;
import org.modeldriven.fuml.library.libraryclass.OperationExecution;

import fUML.Semantics.Classes.Kernel.BooleanValue;
import fUML.Semantics.Classes.Kernel.StringValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Library::ChannelImplementation::ChannelObject</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link ChannelObject#getName <em>getName</em>}</li>
 * <li>{@link ChannelObject#open <em>open</em>}</li>
 * <li>{@link ChannelObject#close <em>close</em>}</li>
 * <li>{@link ChannelObject#isOpen <em>isOpen</em>}</li>
 * <li>{@link ChannelObject#execute <em>execute</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public abstract class ChannelObject extends ImplementationObject {

    // Attributes

    // Operations of the class
    /**
     * operation getName <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public abstract String getName();

    /**
     * operation open <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public abstract void open();

    /**
     * operation close <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public abstract void close();

    /**
     * operation isOpen <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public abstract boolean isOpen();

    /**
     * operation execute <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void execute(OperationExecution execution) {
        String name = execution.getOperationName();

        if (name.equals("getName")) {
            StringValue nameValue = new StringValue();
            nameValue.value = this.getName();
            execution.setParameterValue("result", nameValue);
        } else if (name.equals("open")) {
            this.open();
        } else if (name.equals("close")) {
            this.close();
        } else if (name.equals("isOpen")) {
            BooleanValue isOpenValue = new BooleanValue();
            isOpenValue.value = this.isOpen();
            execution.setParameterValue("result", isOpenValue);
        }

    }

} // ChannelObject
