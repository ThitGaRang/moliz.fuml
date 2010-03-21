
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Debug {
	
    private static Log log = LogFactory.getLog(Debug.class);

	public static void println(String message) {
		if (message.length()>=7 && message.substring(0,7).equals("[event]")) {
			System.out.println(message);
		} else {
			log.debug(message);
		}
	} // println

} // Debug
