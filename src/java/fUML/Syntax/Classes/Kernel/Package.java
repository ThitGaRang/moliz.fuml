



/*
 * Initial version copyright 2008 Lockheed Martin Corporation, except  
 * as stated in the file entitled Licensing-Information. 
 * 
 * All modifications copyright 2009 Data Access Technologies, Inc.
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php), except as stated 
 * in the file entitled Licensing-Information. 
 *
 * Contributors:
 *   MDS - initial API and implementation
 *
 */

package fUML.Syntax.Classes.Kernel;

import fUML.utility.MexSystem;
import fUML.Debug;
import UMLPrimitiveTypes.intList;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fUML::Syntax::Classes::Kernel::Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link Package#addPackageElement <em>addPackageElement</em>}</li>
	 	 *   <li>{@link Package#packageElement <em>packageElement</em>}</li>
	 * </ul>
 * </p>
 *
 * @generated
 */

public   class Package    extends fUML.Syntax.Classes.Kernel.Namespace    {
    
	// Attributes
	public   fUML.Syntax.Classes.Kernel.PackageableElementList packageElement = new fUML.Syntax.Classes.Kernel.PackageableElementList();
    
	// Operations of the class
  /**
   * operation addPackageElement
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */
	public      void addPackageElement(fUML.Syntax.Classes.Kernel.PackageableElement packageElement)   {
super.addOwnedMember(packageElement);
this.packageElement.addValue(packageElement);
	  } // addPackageElement

} //Package
