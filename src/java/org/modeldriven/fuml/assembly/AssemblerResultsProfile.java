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
package org.modeldriven.fuml.assembly;

import org.modeldriven.fuml.model.uml2.UmlClass;
import org.modeldriven.fuml.model.uml2.UmlClassifier;

public class AssemblerResultsProfile {
    
    private UmlClass[] resultsClasses;
    
    @SuppressWarnings("unused")
    private AssemblerResultsProfile() {}
    
    public AssemblerResultsProfile(UmlClass[] resultsClasses) {
        this.resultsClasses = resultsClasses;
    }
    
    public boolean isResultClass(UmlClassifier c)
    {
        for (int i = 0; i < resultsClasses.length; i++)
            if (resultsClasses[i].getName().equals(c.getName()))
                return true;
        return false;
    }
    
}
