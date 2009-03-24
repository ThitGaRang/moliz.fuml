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


package org.modeldriven.fuml.library.channel;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

import fUML.Semantics.Classes.Kernel.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Library::ChannelImplementation::InputChannelObject</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link InputChannelObject#hasMore <em>hasMore</em>}</li>
 * <li>{@link InputChannelObject#read <em>read</em>}</li>
 * <li>{@link InputChannelObject#execute <em>execute</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public abstract class InputChannelObject extends fUML.Library.ChannelImplementation.ChannelObject {

    // Attributes

    // Operations of the class
    /**
     * operation hasMore <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public abstract boolean hasMore();

    /**
     * operation read <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public abstract fUML.Semantics.Classes.Kernel.Value read();

    /**
     * operation execute <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public void execute(fUML.Library.LibraryClassImplementation.OperationExecution execution) {
        String name = execution.getOperationName();

        if (name.equals("hasMore")) {
            BooleanValue hasMoreValue = new BooleanValue();
            hasMoreValue.value = this.hasMore();
            execution.setParameterValue("result", hasMoreValue);
        } else if (name.equals("read")) {
            execution.setParameterValue("value", this.read());
        } else {
            super.execute(execution);
        }

    }

} // InputChannelObject
