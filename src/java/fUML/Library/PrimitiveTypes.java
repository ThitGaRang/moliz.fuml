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

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Library::PrimitiveTypes</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link PrimitiveTypes#PrimitiveTypes <em>PrimitiveTypes</em>}</li>
 * <li>{@link PrimitiveTypes#createBuiltInType <em>createBuiltInType</em>}</li>
 * <li>{@link PrimitiveTypes#Boolean <em>Boolean</em>}</li>
 * <li>{@link PrimitiveTypes#String <em>String</em>}</li>
 * <li>{@link PrimitiveTypes#Integer <em>Integer</em>}</li>
 * <li>{@link PrimitiveTypes#UnlimitedNatural <em>UnlimitedNatural</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class PrimitiveTypes {

    // Attributes
    public fUML.Syntax.Classes.Kernel.PrimitiveType Boolean = new fUML.Syntax.Classes.Kernel.PrimitiveType();
    public fUML.Syntax.Classes.Kernel.PrimitiveType String = new fUML.Syntax.Classes.Kernel.PrimitiveType();
    public fUML.Syntax.Classes.Kernel.PrimitiveType Integer = new fUML.Syntax.Classes.Kernel.PrimitiveType();
    public fUML.Syntax.Classes.Kernel.PrimitiveType UnlimitedNatural = new fUML.Syntax.Classes.Kernel.PrimitiveType();

    // Operations of the class
    /**
     * operation PrimitiveTypes <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public PrimitiveTypes(fUML.Semantics.Loci.ExecutionFactory factory) {
        this.Boolean = this.createBuiltInType("Boolean", factory);
        this.String = this.createBuiltInType("String", factory);
        this.Integer = this.createBuiltInType("Integer", factory);
        this.UnlimitedNatural = this.createBuiltInType("UnlimitedNatural", factory);

    }

    /**
     * operation createBuiltInType <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */

    public fUML.Syntax.Classes.Kernel.PrimitiveType createBuiltInType(String name,
            fUML.Semantics.Loci.ExecutionFactory factory) {
        fUML.Syntax.Classes.Kernel.PrimitiveType type = new fUML.Syntax.Classes.Kernel.PrimitiveType();
        type.name = name;
        factory.addBuiltInType(type);

        return type;

    }

} // PrimitiveTypes
