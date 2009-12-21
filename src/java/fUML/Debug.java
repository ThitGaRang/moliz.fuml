
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

package fUML;

/**
 * An implementation of the model object '
 * <em><b>fUML::Debug</b></em>'.
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link Debug#println <em>println</em>}</li>
 * </ul>
 * </p>
 * 
 */

public class Debug {

	/**
	 * operation println
	 * 
	 */
	public static void println(String message) {
		System.out.println(message);
	} // println

} // Debug
