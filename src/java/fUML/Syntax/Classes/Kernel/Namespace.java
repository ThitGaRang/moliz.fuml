



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
 * An implementation of the model object '<em><b>fUML::Syntax::Classes::Kernel::Namespace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 	 *   <li>{@link Namespace#addOwnedMember <em>addOwnedMember</em>}</li>
	 *   <li>{@link Namespace#addMember <em>addMember</em>}</li>
	 	 *   <li>{@link Namespace#member <em>member</em>}</li>
	 *   <li>{@link Namespace#ownedMember <em>ownedMember</em>}</li>
	 * </ul>
 * </p>
 *
 * @generated
 */

public  abstract class Namespace    extends fUML.Syntax.Classes.Kernel.PackageableElement    {
    
	// Attributes
	public   fUML.Syntax.Classes.Kernel.NamedElementList member = new fUML.Syntax.Classes.Kernel.NamedElementList();
	public   fUML.Syntax.Classes.Kernel.NamedElementList ownedMember = new fUML.Syntax.Classes.Kernel.NamedElementList();
    
	// Operations of the class
  /**
   * operation addOwnedMember
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */
	protected      void addOwnedMember(fUML.Syntax.Classes.Kernel.NamedElement ownedMember)   {
this.addOwnedElement(ownedMember);

this.ownedMember.addValue(ownedMember);
ownedMember.namespace = this;

this.addMember(ownedMember);
	  } // addOwnedMember

  /**
   * operation addMember
   * <!-- begin-user-doc -->
   		   * <!-- end-user-doc -->
   * @generated
   */
	protected      void addMember(fUML.Syntax.Classes.Kernel.NamedElement member)   {
// Note: This operation should not be used for owned members. The operation addOwnedMember should be used instead.

// Debug.println("[addMember] member is a " + member.getClass().getName() + "; name = " + member.name);

this.member.addValue(member);

	  } // addMember

} //Namespace
