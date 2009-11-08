/*
 * Copyright 2008 Lockheed Martin Corporation, except as stated in the file
 * entitled Licensing-Information.
 *
 * All modifications copyright 2009 Data Access Technologies, Inc.
 *
 * Licensed under the Academic Free License
 * version 3.0 (http://www.opensource.org/licenses/afl-3.0.php), except as stated
 * in the file entitled Licensing-Information.
 *
 * Contributors:
 *   MDS - initial API and implementation
 *
 */
package org.modeldriven.fuml.environment;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.NamedElement;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;
import fUML.Test.TestEnvironment;

public class Environment extends TestEnvironment {
    private static Environment instance = null;
    private Map<String, NamedElement> elementNameMap = new HashMap<String, NamedElement>();
    private Map<String, Element> elementIdMap = new HashMap<String, Element>();

    private Environment() {

		this.locus.setFactory(new ExecutionFactory());  // Uses local subclass for ExecutionFactory

		this.locus.factory
				.setStrategy(new fUML.Semantics.Classes.Kernel.RedefinitionBasedDispatchStrategy());
		this.locus.factory
				.setStrategy(new fUML.Semantics.CommonBehaviors.Communications.FIFOGetNextEventStrategy());
		this.locus.factory.setStrategy(new fUML.Semantics.Loci.FirstChoiceStrategy());
/*
		this.primitiveTypes = new fUML.Library.PrimitiveTypes(this.locus.factory);
		this.addElement(this.primitiveTypes.Boolean);
		this.addElement(this.primitiveTypes.Integer);
		this.addElement(this.primitiveTypes.String);
		this.addElement(this.primitiveTypes.UnlimitedNatural);
*/
	}

    public static Environment getInstance()
    {
        if (instance == null)
            initializeInstance();
        return instance;
    }

    private static synchronized void initializeInstance()
    {
        if (instance == null)
            instance = new Environment();
    }

    public void add(NamedElement element)
    {
        elementNameMap.put(element.name, element);
    }

    public void add(String id, Element element)
    {
        if (element instanceof NamedElement)
        {
            NamedElement namedElement = (NamedElement)element;
            elementNameMap.put(namedElement.name, namedElement);
        }
        elementIdMap.put(id, element);
    }

    public Behavior findBehavior(String name)
    {
        return (Behavior)elementNameMap.get(name); // FIXME: HACK
    }

    public Element findElementById(String id)
    {
        return elementIdMap.get(id);
    }

    public int getBehaviorCount()
    {
        int result = 0;
        Iterator<String> keys = elementNameMap.keySet().iterator();
        while (keys.hasNext())
        {
            Element element = elementNameMap.get(keys.next());
            if (element instanceof Behavior)
                result++;
        }
        return result;
    }

    public String[] getBehaviorNames()
    {
        List<String> list = new ArrayList<String>();
        Iterator<String> keys = elementNameMap.keySet().iterator();
        while (keys.hasNext())
        {
            Element element = elementNameMap.get(keys.next());
            if (element instanceof Behavior)
                list.add(((Behavior)element).name);
        }
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }

}
