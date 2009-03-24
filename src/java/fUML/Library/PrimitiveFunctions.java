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

package fUML.Library;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;

import fUML.Syntax.Classes.Kernel.*;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Library::PrimitiveFunctions</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link PrimitiveFunctions#createBinaryOperator <em>createBinaryOperator
 * </em>}</li>
 * <li>{@link PrimitiveFunctions#createUnaryOperator <em>createUnaryOperator
 * </em>}</li>
 * <li>{@link PrimitiveFunctions#createPrimitiveFunction <em>
 * createPrimitiveFunction</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public abstract class PrimitiveFunctions extends fUML.Library.PrimitiveBehaviors {

    // Attributes

    // Operations of the class
    /**
     * operation createBinaryOperator <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */

    protected fUML.Syntax.CommonBehaviors.BasicBehaviors.FunctionBehavior createBinaryOperator(
            String name, fUML.Syntax.Classes.Kernel.Classifier type,
            fUML.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution implementation,
            fUML.Semantics.Loci.ExecutionFactory factory) {
        // Create a binary operator for the given type.

        ParameterList parameters = new ParameterList();
        parameters.addValue(this.createInputParameter("first", type, 1, 1));
        parameters.addValue(this.createInputParameter("second", type, 1, 1));
        parameters.addValue(this.createReturnParameter(type, 1, 1));

        return this.createPrimitiveFunction(name, parameters, implementation, factory);

    }

    public fUML.Syntax.CommonBehaviors.BasicBehaviors.FunctionBehavior createBinaryOperator(
            FunctionBehavior function, String name, 
            fUML.Syntax.Classes.Kernel.Classifier type,
            fUML.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution implementation,
            fUML.Semantics.Loci.ExecutionFactory factory) {
        // Create a binary operator for the given type.

        ParameterList parameters = new ParameterList();
        parameters.addValue(this.createInputParameter("first", type, 1, 1));
        parameters.addValue(this.createInputParameter("second", type, 1, 1));
        parameters.addValue(this.createReturnParameter(type, 1, 1));

        return this.createPrimitiveFunction(function, name, parameters, implementation, factory);

    }
    
    /**
     * operation createUnaryOperator <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */

    protected fUML.Syntax.CommonBehaviors.BasicBehaviors.FunctionBehavior createUnaryOperator(
            String name, fUML.Syntax.Classes.Kernel.Classifier type,
            fUML.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution implementation,
            fUML.Semantics.Loci.ExecutionFactory factory) {
        // Create a unary operator for the given type.

        ParameterList parameters = new ParameterList();
        parameters.addValue(this.createInputParameter("argument", type, 1, 1));
        parameters.addValue(this.createReturnParameter(type, 1, 1));

        return this.createPrimitiveFunction(name, parameters, implementation, factory);

    }

    /**
     * operation createPrimitiveFunction <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */

    protected fUML.Syntax.CommonBehaviors.BasicBehaviors.FunctionBehavior createPrimitiveFunction(
            String name, fUML.Syntax.Classes.Kernel.ParameterList parameters,
            fUML.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution implementation,
            fUML.Semantics.Loci.ExecutionFactory factory) {
        // Create a primitive function behavior and add its implementation to
        // the given locus.

        return (FunctionBehavior) (this.addPrimitiveBehavior(name, parameters,
                new FunctionBehavior(), implementation, factory));

    }

    protected fUML.Syntax.CommonBehaviors.BasicBehaviors.FunctionBehavior createPrimitiveFunction(
            FunctionBehavior function, String name, 
            fUML.Syntax.Classes.Kernel.ParameterList parameters,
            fUML.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution implementation,
            fUML.Semantics.Loci.ExecutionFactory factory) {
        // Create a primitive function behavior and add its implementation to
        // the given locus.

        return (FunctionBehavior) (this.addPrimitiveBehavior(name, parameters,
                function, implementation, factory));
    }
    
} // PrimitiveFunctions
