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

import org.modeldriven.fuml.FumlException;

public class ModelException extends FumlException {
	
	public ModelException(Throwable t) {
		super(t);
	}
    public ModelException(String msg) {
        super(msg);
    }

}
