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

package fUML.Semantics.CommonBehaviors.Communications;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

import fUML.Syntax.*;
import fUML.Syntax.Classes.Kernel.*;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.*;
import fUML.Syntax.CommonBehaviors.Communications.*;

import fUML.Semantics.*;
import fUML.Semantics.Classes.Kernel.*;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.*;
import fUML.Semantics.Loci.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Semantics::CommonBehaviors::Communications::EventAccepter</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link EventAccepter#accept <em>accept</em>}</li>
 * <li>{@link EventAccepter#match <em>match</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public abstract class EventAccepter {

    // Attributes

    // Operations of the class
    /**
     * operation accept <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public abstract void accept(
            fUML.Semantics.CommonBehaviors.Communications.SignalInstance signalInstance);

    /**
     * operation match <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public abstract boolean match(
            fUML.Semantics.CommonBehaviors.Communications.SignalInstance signalInstance);
} // EventAccepter
