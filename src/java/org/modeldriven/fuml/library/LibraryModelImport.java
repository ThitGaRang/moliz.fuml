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

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.AbsractImport;
import org.modeldriven.fuml.FumlException;
import org.modeldriven.fuml.Import;
import org.modeldriven.fuml.ImportRegistry;
import org.modeldriven.fuml.assembly.AssemblerResultsProfile;
import org.modeldriven.fuml.assembly.ElementGraphAssembler;
import org.modeldriven.fuml.environment.Environment;
import org.modeldriven.fuml.meta.MetaModel;
import org.modeldriven.fuml.xmi.stream.StreamNodeEvent;
import org.modeldriven.fuml.xmi.validation.ErrorSeverity;
import org.modeldriven.fuml.xmi.validation.ValidationError;
import org.modeldriven.fuml.xmi.validation.ValidationErrorCollector;

import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.DataType;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.NamedElement;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.FunctionBehavior;
import fUML.Syntax.CommonBehaviors.Communications.Signal;

public class LibraryModelImport extends AbsractImport implements Import {

    private static Log log = LogFactory.getLog(LibraryModelImport.class);

    public LibraryModelImport() {
    }

    public LibraryModelImport(ImportRegistry registry) {
        super(registry);
    }

    protected AssemblerResultsProfile createProfile() {
        MetaModel model = MetaModel.getInstance();
        return new AssemblerResultsProfile(new Class_[] {
                (Class_) model
                        .getClassifier(fUML.Syntax.Classes.Kernel.Model.class.getSimpleName()),
                (Class_) model.getClassifier(Activity.class.getSimpleName()),
                (Class_) model.getClassifier(FunctionBehavior.class.getSimpleName()),
                (Class_) model.getClassifier(fUML.Syntax.Classes.Kernel.Package.class
                        .getSimpleName()),
                (Class_) model.getClassifier("Class"), // fUML name is 'Class_'
                // (Class_)model.getClassifier(Operation.class.getSimpleName()),
                // // don't see why operations and properties should ever be
                // externally referencable from a lib
                // (Class_)model.getClassifier(Property.class.getSimpleName()),
                (Class_) model.getClassifier(DataType.class.getSimpleName()),
                (Class_) model.getClassifier(Signal.class.getSimpleName()), });
    }

    /**
     * StreamEventListener implementation
     */
    public String[] getElementNames() {
        return new String[] { 
        	"Model", // the model root for a UML artifact
        	"Package" // the model root for an XMI artifact
        };
    }

    public void nodeCreated(StreamNodeEvent event) {
        // not interested
    }

    public void nodeCompleted(StreamNodeEvent event) {

        if (event.getParent() != null)
            if (!event.getParent().getLocalName().equals("XMI"))
                return;

        if (!event.getSource().getContext().getUmlNamespace().getNamespaceURI().equals(
                event.getSource().getNamespaceURI()))
            return; // not in UML namespace

        if (log.isDebugEnabled())
            log.debug("validating: " + event.getSource().getXmiType() + "("
                    + event.getSource().getXmiId() + ")");

        ValidationErrorCollector errorCollector = new ValidationErrorCollector(event.getSource());
        errorCollector.setValidateExternalReferences(false);
        errorCollector.validate();

        int count = errorCollector.getErrorCount();
        if (count == 0) // valid
        {
            ElementGraphAssembler assembler = new ElementGraphAssembler(event.getSource(),
                    getProfile(), false);

            Iterator<String> ids = assembler.getResultsXmiIds().iterator();
            while (ids.hasNext()) {
                String id = ids.next();
                Element element = assembler.lookupResult(id);
                if (element instanceof NamedElement)
                    if (log.isDebugEnabled())
                        log.debug("loading element: " + ((NamedElement) element).name + " (" + id
                                + ")");
                    else if (log.isDebugEnabled())
                        log.debug("loading element: (" + id + ")");

                if (this.importRegistry != null)
                    this.importRegistry.register(id, element);
                else
                    Environment.getInstance().add(id, element);
            }
            assembler.clear();
        } else {
            Iterator<ValidationError> errors = errorCollector.getErrors().iterator();
            while (errors.hasNext()) {
                ValidationError error = errors.next();
                if (error.getSeverity().ordinal() == ErrorSeverity.FATAL.ordinal())
                    log.error(error.getText());
                else if (error.getSeverity().ordinal() == ErrorSeverity.WARN.ordinal())
                    log.warn(error.getText());
                else if (error.getSeverity().ordinal() == ErrorSeverity.INFO.ordinal())
                    log.info(error.getText());
                else
                    log.error(error.getText());
            }
            if (errorCollector.getErrorCount(ErrorSeverity.FATAL) > 0)
                throw new FumlException("fatal validation errors encountered");
        }
    }

}
