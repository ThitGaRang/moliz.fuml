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

package org.modeldriven.fuml.xmi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This abstract class is an XmiReference implementation serving as a 
 * superclass for classes holding reference data and related information 
 * found within XML elements. For more information on XMI references see 
 * the XmiReference interface documentation.
 * 
 * @author Scott Cinnamond
 */
public abstract class XmiReferenceElement implements XmiReference {

    private static Log log = LogFactory.getLog(XmiReferenceElement.class);
	protected XmiNode node;
	protected List<String> ids = new ArrayList<String>();
	
	@SuppressWarnings("unused")
	private XmiReferenceElement() {}
	
	public XmiReferenceElement(XmiNode node) {
		this.node = node;	
	}
	
	public String getLocalName() {
		return this.node.getLocalName();
	}
	
    public int getLineNumber() {
        return node.getLineNumber();	
    }
    
    public int getColumnNumber() {
        return node.getColumnNumber();	
    }

	public int getReferenceCount() {
		return ids.size();
	}
	
    public Iterator<String> getXmiIds() {
    	return ids.iterator();
    }
	
}
