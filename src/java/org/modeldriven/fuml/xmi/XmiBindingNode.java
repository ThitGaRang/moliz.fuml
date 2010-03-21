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

package org.modeldriven.fuml.xmi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * The class serves and the superclass for all JAXB generated classes used for XMI 
 * processing. It encapsulates a Java reflection-based traversal algorithm allowing 
 * visitor clients to receive events for any attached node regardless of its binding-node 
 * subclass. The traversal algorithm bypasses JAXB generated "generic" JAXBElement nodes, 
 * shielding the visitor client from these uninteresting container objects.  
 * 
 * @author Scott Cinnamond
 */
public class XmiBindingNode {

	private static Log log = LogFactory.getLog(XmiBindingNode.class);

	private static Class[] emptyTypes = new Class[0];
	private static Object[] emptyArgs = new Object[0];
	
	public void accept(XmiBindingNodeVisitor visitor)
	{
		if (log.isDebugEnabled())
			log.debug(this.getClass().getSimpleName());
		acceptBreadthFirst(visitor);
	}
	
    public void acceptDepthFirst(XmiBindingNodeVisitor visitor)
    {
    	try {
            accept(visitor, this, null, null, this, true, new HashMap(), 0);
    	}
    	catch (NoSuchMethodException e) {
    		throw new XmiException(e);
    	}
    	catch (InvocationTargetException e) {
    		throw new XmiException(e);
    	}
    	catch (IllegalAccessException e) {
    		throw new XmiException(e);
    	}
    }

    public void acceptBreadthFirst(XmiBindingNodeVisitor visitor)
    {
        try {
            accept(visitor, this, null, null, this, false, new HashMap(), 0);
        }
        catch (NoSuchMethodException e) {
            throw new XmiException(e);
        }
        catch (InvocationTargetException e) {
            throw new XmiException(e);
        }
        catch (IllegalAccessException e) {
            throw new XmiException(e);
        }
    }
    
    private void accept(XmiBindingNodeVisitor visitor, XmiBindingNode target, 
    		XmiBindingNode source, String sourceKey, 
    		XmiBindingNode root, boolean depthFirst, 
    		Map visited, int level)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        if (log.isDebugEnabled())
            log.debug("accept: " + target.getClass().getName());
        
        if (visited.get(target) == null)
            visited.put(target, target);
        else
        {   
            if (log.isDebugEnabled())
                log.debug("ignoring, " + target.getClass().getName());
            return;
        }    
        
        if (!depthFirst)
            visitor.begin(target, source, sourceKey, level);
        else
            visitor.end(target, source, sourceKey, level);
        
        Method[] methods = target.getClass().getMethods();
		for (int i = 0; i < methods.length; i++)
		{
		    Method method = methods[i];
            if (method.getParameterTypes().length > 0)
                continue; // we only want getters

            if (isCollection(method.getReturnType()))
            {						
                if (log.isDebugEnabled())
                    log.debug("processing method: " + method.getName());
    				
    			Collection coll = (Collection)method.invoke(target, emptyArgs);
    						
    			Iterator iterator = (Iterator)coll.iterator();
    			while (iterator.hasNext())
    			{
    				Object obj = iterator.next();
    				XmiBindingNode child = this.findChild(obj);
                    if (child != null && !child.equals(root))
                        accept(visitor, child, target, 
                            method.getName(), root, depthFirst, visited, level++);
    		    }
            }
            else if (isXmiVisitableObject(method.getReturnType()))
            {
                if (log.isDebugEnabled())
                    log.debug("processing method: " + method.getName());
                XmiBindingNode child = (XmiBindingNode)method.invoke(target, emptyArgs);
                if (child != null && !child.equals(root))
                    accept(visitor, child, target, 
                        method.getName(), root, depthFirst, visited, level++);                
            }
		}
    	
        if (depthFirst)
            visitor.begin(target, source, sourceKey, level);
        else
            visitor.end(target, source, sourceKey, level);
    }
    
    private XmiBindingNode findChild(Object obj)
    {
    	XmiBindingNode child = null;
        if (obj instanceof XmiBindingNode)
        {    
            child = (XmiBindingNode)obj;
        }
        else if (obj instanceof JAXBElement)
        {    
            Object elemObj = ((JAXBElement)obj).getValue();
            if (elemObj instanceof XmiBindingNode)
                child = (XmiBindingNode)elemObj;
            else
            	if (log.isDebugEnabled())
                    log.warn("ignoring node instance, " 
                        + elemObj.getClass().getName());
        }
        else if (obj instanceof org.apache.xerces.dom.ElementNSImpl) 
        {    
            if (log.isDebugEnabled())
                log.debug("ignoring class " + obj.getClass().getName());
        }
        else if (obj instanceof java.lang.String) 
        {    
            if (log.isDebugEnabled())
            {    
                log.debug("ignoring class " + obj.getClass().getName());
                log.debug("ignoring value: " + String.valueOf(obj));
            }
        }
        else
            throw new XmiException("unexpected class, " + 
                    obj.getClass().getName()); 
        return child;       
    }
    
    private boolean isCollection(Class c)
    {
        return java.util.Collection.class.isAssignableFrom(c);
    }

    private boolean isXmiVisitableObject(Class c)
    {
        return XmiBindingNode.class.isAssignableFrom(c);
    }     
}







