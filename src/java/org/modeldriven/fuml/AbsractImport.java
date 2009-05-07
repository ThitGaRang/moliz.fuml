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
package org.modeldriven.fuml;

import org.modeldriven.fuml.assembly.AssemblerResultsProfile;

public abstract class AbsractImport {
   
    protected ImportRegistry importRegistry;
    private AssemblerResultsProfile profile;
    
    public AbsractImport() { 
        profile = createProfile();
    }

    public AbsractImport(ImportRegistry registry) {
        this();
        this.importRegistry = registry;
    }
    
    protected abstract AssemblerResultsProfile createProfile();
    
    protected AssemblerResultsProfile getProfile()
    {
        return profile;
    }

}
