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
package org.modeldriven.fuml.library;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.ImportRegistry;
import org.modeldriven.fuml.config.FumlConfiguration;
import org.modeldriven.fuml.config.LibraryConfiguration;
import org.modeldriven.fuml.config.LibraryImport;
import org.modeldriven.fuml.meta.MetaModel;
import org.modeldriven.fuml.xmi.stream.StreamReader;

import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.NamedElement;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;

public class Library {

    private static Log log = LogFactory.getLog(Library.class);
    private static Library instance = null;
    private Map<String, NamedElement> elements = new HashMap<String, NamedElement>();

    private LibraryConfiguration config;

    private Library() {
        log.info("initializing...");
        config = FumlConfiguration.getInstance().getConfig().getLibraryConfiguration();
        Iterator<LibraryImport> libraryImports = config.getLibraryImport().iterator();
        while (libraryImports.hasNext()) {
            load(libraryImports.next());
        }
    }

    public static Library getInstance() throws LibraryException {
        if (instance == null)
            initializeInstance();
        return instance;
    }

    private static synchronized void initializeInstance() {
        if (instance == null)
            instance = new Library();
    }

    @SuppressWarnings("unchecked")
    private void load(LibraryImport libraryImport) {
        log.info("loading file, " + libraryImport.getName());
        InputStream stream = Library.class.getResourceAsStream(libraryImport.getName());
        if (stream == null)
            throw new LibraryException("cannot find resource '" + libraryImport.getName() + "'");

        LibraryImportRegistry importRegistry = new LibraryImportRegistry(libraryImport);

        StreamReader reader = new StreamReader();

        // NOTE: incremental import (using PackagedElementImport below)
        // currently breaks the package hierarchy
        // which is essential for library functions etc... which depend on
        // a "non-flat" name space for configuration lookup. Also we will need
        // after all
        // an AssemblyContext map thing to store incremental references we don't
        // necessarily
        // want in the wider environment, nor the library reference set.
        // reader.addStreamNodeListener(new
        // PackagedElementImport(importRegistry));

        reader.addStreamNodeListener(new LibraryModelImport(importRegistry));
        reader.read(stream);
    }

    public NamedElement lookup(String name) {
        return elements.get(name);
    }

    class LibraryImportRegistry implements ImportRegistry {

        private MetaModel metadata = MetaModel.getInstance();
        private LibraryImport libraryImport;

        @SuppressWarnings("unused")
        private LibraryImportRegistry() {
        }

        public LibraryImportRegistry(LibraryImport libraryImport) {
            this.libraryImport = libraryImport;
        }

        public void register(String id, Element element) {
            String reference = libraryImport.getBaseURI() + libraryImport.getDelimiter() + id;
            if (elements.get(reference) != null)
            	throw new LibraryException("duplicate reference, '" + reference + "'");
            if (element instanceof Behavior) {
                Behavior behavior = (Behavior) element;
                String implObjectClassName = FumlConfiguration.getInstance().findExecutionClassName(behavior.qualifiedName);
                if (implObjectClassName == null)
                {
                	if (behavior.getXmiId() == null)
                	{
                		//FIXME - WTF is this happening?
                	}
                	log.error("found no execution class for behavior ("
                			+ behavior.getClass().getSimpleName() + ") ("
                			+ id + ") '"
                			+ behavior.qualifiedName 
                			+ "' - could not register behavior - ignoring");
                }
                else
                    log.debug("registering behavior: " + behavior.qualifiedName + "\t(" + reference
                        + ") (Execution: " + String.valueOf(implObjectClassName) + ")");
                elements.put(reference, behavior);
            } else if (element instanceof NamedElement) {
                NamedElement namedElement = (NamedElement) element;
                log.debug("registering element: " + namedElement.name + "\t(" + reference + ")");
                elements.put(reference, namedElement);
            }
        }
    }
}
