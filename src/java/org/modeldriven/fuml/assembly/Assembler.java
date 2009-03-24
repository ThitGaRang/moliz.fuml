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
package org.modeldriven.fuml.assembly;

import java.util.Map;

public interface Assembler {
    public void assembleElementClass();
    public void assemleFeatures();
    public void assembleReferenceFeatures();
    public void associateElement(ElementAssembler other);
}
