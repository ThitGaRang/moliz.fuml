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
package org.modeldriven.fuml.model;


public class MissingRequiredPropertyException extends ModelException {
	
    private static final long serialVersionUID = 1L;
    
    public MissingRequiredPropertyException(Throwable t) {
		super(t);
	}
    public MissingRequiredPropertyException(String msg) {
        super(msg);
    }

}
