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

package fUML.Syntax.Activities.CompleteStructuredActivities;

import java.util.ArrayList;

public class StructuredActivityNodeList extends
        ArrayList<fUML.Syntax.Activities.CompleteStructuredActivities.StructuredActivityNode> {
    public StructuredActivityNodeList() {
        super();
    }

    public StructuredActivityNode getValue(int i) {
        return (StructuredActivityNode) get(i);
    }

    public void addValue(StructuredActivityNode v) {
        add(v);
    }

    public void addValue(int i, StructuredActivityNode v) {
        add(i, v);
    }

    public void setValue(int i, StructuredActivityNode v) {
        set(i, v);
    }

    public void removeValue(int i) {
        remove(i);
    }
} // StructuredActivityNode
