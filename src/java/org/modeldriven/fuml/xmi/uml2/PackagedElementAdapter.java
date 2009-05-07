/*
 * Copyright 2008 Lockheed Martin Corporation, except as stated in the file 
 * entitled Licensing-Information. All modifications copyright 2009 Data Access Technologies, Inc. Licensed under the Academic Free License 
 * version 3.0 (http://www.opensource.org/licenses/afl-3.0.php), except as stated 
 * in the file entitled Licensing-Information. 
 *
 * Contributors:
 *   MDS - initial API and implementation
 *
 */
package org.modeldriven.fuml.xmi.uml2;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.model.uml2.UmlActivity;
import org.modeldriven.fuml.model.uml2.UmlPackageableElementAssociationEnd;

public class PackagedElementAdapter  extends XmlAdapter<UmlPackageableElementAssociationEnd, UmlActivity> {
	
    private static Log log = LogFactory.getLog(PackagedElementAdapter.class);

    public UmlActivity unmarshal(UmlPackageableElementAssociationEnd elem){ 
    	    	
        UmlActivity result = null;
        QName type = elem.getTypeAttribute();
        if ("uml".equals(type.getPrefix()))
        {
            if ("Activity".equals(type.getLocalPart()))	
            {
                UmlActivity activity = new UmlActivity();
            	activity.setId(elem.getId());
            	result = activity;
            	
            	//activity.getRedefinedBehaviorOrSpecificationOrOwnedParameter().addAll(elem.getOwnedParameter());
            }
            else
                throw new IllegalArgumentException("WTF?,  " + type.getLocalPart());
        }
        else
        	throw new IllegalArgumentException("WTF?,  " + type.getPrefix());
    	log.info("unmarshal: " + String.valueOf(result));
    	
    	return result;
    }
     
    public UmlPackageableElementAssociationEnd marshal(UmlActivity activity){
    	log.info("marshal: " + String.valueOf(activity));
    	UmlPackageableElementAssociationEnd result = new UmlPackageableElementAssociationEnd();
    	result.setId(activity.getId());
    	result.setTypeAttribute(new QName("uml", "Activity"));    	
    	return result;
    }
}
