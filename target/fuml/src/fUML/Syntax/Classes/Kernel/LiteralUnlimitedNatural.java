
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

import fUML.Debug;
import UMLPrimitiveTypes.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>fUML::Syntax::Classes::Kernel::LiteralUnlimitedNatural</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link LiteralUnlimitedNatural#setValue <em>setValue</em>}</li>
 * <li>{@link LiteralUnlimitedNatural#setValue <em>setValue</em>}</li>
 * <li>{@link LiteralUnlimitedNatural#value <em>value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */

public class LiteralUnlimitedNatural extends
		fUML.Syntax.Classes.Kernel.LiteralSpecification {

	public UnlimitedNatural value = new UnlimitedNatural(0);

	/**
	 * operation setValue <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValue(UnlimitedNatural value) {
		this.value = value;
	} // setValue

	/**
	 * operation setValue <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValue(int value) {
		this.setValue(new UnlimitedNatural(value));
	} // setValue

} // LiteralUnlimitedNatural
