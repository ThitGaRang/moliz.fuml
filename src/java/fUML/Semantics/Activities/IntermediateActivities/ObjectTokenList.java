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

package fUML.Semantics.Activities.IntermediateActivities;

import java.util.ArrayList;

public class ObjectTokenList extends
        ArrayList<fUML.Semantics.Activities.IntermediateActivities.ObjectToken> {
    public ObjectTokenList() {
        super();
    }

    public ObjectToken getValue(int i) {
        return (ObjectToken) get(i);
    }

    public void addValue(ObjectToken v) {
        add(v);
    }

    public void addValue(int i, ObjectToken v) {
        add(i, v);
    }

    public void setValue(int i, ObjectToken v) {
        set(i, v);
    }

    public void removeValue(int i) {
        remove(i);
    }
} // ObjectToken
