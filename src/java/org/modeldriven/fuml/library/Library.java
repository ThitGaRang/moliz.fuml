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
package org.modeldriven.fuml.library;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.ImportRegistry;
import org.modeldriven.fuml.ModelImport;
import org.modeldriven.fuml.PackagedElementImport;
import org.modeldriven.fuml.assembly.AssemblyException;
import org.modeldriven.fuml.config.FumlConfiguration;
import org.modeldriven.fuml.config.LibraryConfiguration;
import org.modeldriven.fuml.config.LibraryImport;
import org.modeldriven.fuml.environment.Environment;
import org.modeldriven.fuml.model.Model;
import org.modeldriven.fuml.model.uml2.UmlClassifier;
import org.modeldriven.fuml.xmi.stream.StreamReader;

import fUML.Library.LibraryClassImplementation.ImplementationObject;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.NamedElement;
import fUML.Syntax.Classes.Kernel.PackageableElement;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;

public class Library {

    private static Log log = LogFactory.getLog(Library.class);
    private static Library instance = null;
    private Map<String, NamedElement> elements = new HashMap<String, NamedElement>();
    
    private LibraryConfiguration config;
        
    private Library()
    {
        log.info("initializing...");
        config = FumlConfiguration.getInstance().getConfig().getLibraryConfiguration();
        Iterator<LibraryImport> libraryImports = config.getLibraryImport().iterator();
        while (libraryImports.hasNext())
        {
                load(libraryImports.next());
        }	        
    }
        
    public static Library getInstance()
        throws LibraryException
    {
        if (instance == null)
            initializeInstance();
        return instance;
    }
    
    private static synchronized void initializeInstance()
    {
        if (instance == null)
            instance = new Library();
    } 
    
    @SuppressWarnings("unchecked")
    private void load(LibraryImport libraryImport)
    {
        log.info("loading file, " + libraryImport.getName());
        InputStream stream = Library.class.getResourceAsStream(libraryImport.getName());
        if (stream == null)
            throw new LibraryException("cannot find resource '" + libraryImport.getName() + "'");
        
        LibraryImportRegistry importRegistry = new LibraryImportRegistry(libraryImport);        
        
        StreamReader reader = new StreamReader();
        
        // NOTE: incremental import (using PackagedElementImport below) currently breaks the package hierarchy
        // which is essential for library functions etc... which depend on
        // a "non-flat" name space for configuration lookup. Also we will need after all
        // an AssemblyContext map thing to store incremental references we don't necessarily
        // want in the wider environment, nor the library reference set. 
        //reader.addStreamNodeListener(new PackagedElementImport(importRegistry)); 
        
        reader.addStreamNodeListener(new LibraryModelImport(importRegistry));        
        reader.read(stream); 
    }
    
    public NamedElement lookup(String name) {
        return elements.get(name);    
    }
    
    class LibraryImportRegistry implements ImportRegistry {

        private Model metadata = Model.getInstance();
        private LibraryImport libraryImport;
        
        @SuppressWarnings("unused")
        private LibraryImportRegistry() {}
        public LibraryImportRegistry(LibraryImport libraryImport) {
             this.libraryImport = libraryImport;
        }
        
        public void register(String id, Element element) {
            String reference = libraryImport.getBaseURI() + libraryImport.getDelimiter() + id;
            if (element instanceof Behavior)
            {    
                Behavior behavior = (Behavior)element;
                String implObjectClassName = FumlConfiguration.getInstance().findExecutionClassName(behavior.name);
                log.info("registering behavior: " + behavior.name + "\t(" + reference + ") (Execution: " 
                        + String.valueOf(implObjectClassName) + ")"); 
                elements.put(reference, behavior);
            }
            else if (element instanceof NamedElement)
            {    
                NamedElement namedElement = (NamedElement)element;
                log.info("registering element: " + namedElement.name + "\t(" + reference + ")"); 
                elements.put(reference, namedElement);
            }
        }     
    }        
}
