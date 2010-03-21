/*
 * Initial version copyright 2008 Lockheed Martin Corporation, except
 * as stated in the file entitled Licensing-Information.
 *
 * All modifications copyright 2009 Data Access Technologies, Inc.
 *
 * All modifications copyright 2009 Data Access Technologies, Inc. Licensed under the Academic Free License version 3.0
 * (http://www.opensource.org/licenses/afl-3.0.php), except as stated
 * in the file entitled Licensing-Information.
 *
 * Contributors:
 *   MDS - initial API and implementation
 *
 */
package org.modeldriven.fuml;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.assembly.AssemblerResultsProfile;
import org.modeldriven.fuml.assembly.ElementGraphAssembler;
import org.modeldriven.fuml.assembly.ElementStubAssembler;
import org.modeldriven.fuml.environment.Environment;
import org.modeldriven.fuml.model.Model;
import org.modeldriven.fuml.model.uml2.UmlClass;
import org.modeldriven.fuml.xmi.XmiChildFinder;
import org.modeldriven.fuml.xmi.stream.StreamNodeEvent;
import org.modeldriven.fuml.xmi.validation.ErrorCode;
import org.modeldriven.fuml.xmi.validation.ErrorSeverity;
import org.modeldriven.fuml.xmi.validation.ValidationError;
import org.modeldriven.fuml.xmi.validation.ValidationErrorCollector;

import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Classes.Kernel.Association;
import fUML.Syntax.Classes.Kernel.DataType;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.NamedElement;
import fUML.Syntax.Classes.Kernel.Operation;
import fUML.Syntax.Classes.Kernel.Property;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.FunctionBehavior;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.OpaqueBehavior;
import fUML.Syntax.CommonBehaviors.Communications.Signal;
import fUML.Syntax.CommonBehaviors.Communications.SignalEvent;

public class PackagedElementImport extends AbsractImport implements Import {

    private static Log log = LogFactory.getLog(PackagedElementImport.class);

    public PackagedElementImport() {
    }

    public PackagedElementImport(ImportRegistry registry) {
        super(registry);
    }

    protected AssemblerResultsProfile createProfile()
    {
        Model model = Model.getInstance();
        return new AssemblerResultsProfile(
            new UmlClass[] {
                (UmlClass)model.getClassifier(Activity.class.getSimpleName()),
                (UmlClass)model.getClassifier(fUML.Syntax.Classes.Kernel.Package.class.getSimpleName()),
                (UmlClass)model.getClassifier(Association.class.getSimpleName()),
                (UmlClass)model.getClassifier("Class"), // fUML name is 'Class_'
                (UmlClass)model.getClassifier(Operation.class.getSimpleName()),
                (UmlClass)model.getClassifier(Property.class.getSimpleName()),
                (UmlClass)model.getClassifier(DataType.class.getSimpleName()),
                (UmlClass)model.getClassifier(Signal.class.getSimpleName()),
                (UmlClass)model.getClassifier(SignalEvent.class.getSimpleName()),
                (UmlClass)model.getClassifier(OpaqueBehavior.class.getSimpleName()),
                (UmlClass)model.getClassifier(FunctionBehavior.class.getSimpleName()),
            });
    }

    public String[] getElementNames()
    {
        return new String[] {
                "packagedElement"
        };
    }

    public void nodeCreated(StreamNodeEvent event) {
        // not interested
    }

    public void nodeCompleted(StreamNodeEvent event) {

        XmiChildFinder childFinder = new XmiChildFinder(
                event.getSource().getLocalName());
        event.getSource().accept(childFinder);
        if (childFinder.getResult() != null)
            return; // has a descendant with our local name. We want "atomic" packaged elements
        // FIXME: make finder namespace aware

        if (!event.getSource().getContext().getUmlNamespace().getNamespaceURI().equals(
                event.getSource().getNamespaceURI()))
            return; // not in UML namespace

        if (log.isDebugEnabled())
            log.debug("validating: "
                + event.getSource().getXmiType() + "("
                + event.getSource().getXmiId() + ")");

        ValidationErrorCollector errorCollector = new ValidationErrorCollector(
                event.getSource());
        errorCollector.validate();

        int count = errorCollector.getErrorCount();
        if (count == 0) // valid
        {
            ElementGraphAssembler assembler =
                new ElementGraphAssembler(event.getSource(), getProfile());

            Iterator<String> ids = assembler.getResultsXmiIds().iterator();
            while (ids.hasNext())
            {
                String id = ids.next();
                Element element = assembler.lookupResult(id);
                if (element instanceof NamedElement)
                    if (log.isDebugEnabled())
                        log.debug("loading: " + ((NamedElement)element).name
                            + " (" + id + ")");
                else
                    if (log.isDebugEnabled())
                        log.debug("loading: (" + id + ")");

                if (this.importRegistry != null)
                    this.importRegistry.register(id, element);
                else
                    Environment.getInstance().add(id, element);
            }
            assembler.clear();

            if (event.getParent() != null)
                if (!event.getParent().removeChild(event.getSource()))
                    log.warn("could not remove assembled node: "
                        + event.getSource().getXmiType() + " ("
                        + event.getSource().getXmiId() + ")");
        }
        else
        {
            // assume internal (and external?) invalid reference errors, are to
            // be resolved in a later traversal over the data. For errors other than these
            // we create a stub element such that we can still reference it.
            int internalCount = errorCollector.getErrorCount(ErrorCode.INVALID_REFERENCE);
            if (count > internalCount) // invalid
            {
                if (log.isDebugEnabled())
                    log.debug("found invalid node: "
                        + event.getSource().getXmiType() + " ("
                        + event.getSource().getXmiId() + ")");

                ElementStubAssembler assembler =
                    new ElementStubAssembler(event.getSource());

                Iterator<ValidationError> errors = errorCollector.getErrors().iterator();
                while (errors.hasNext())
                {
                    ValidationError error = errors.next();
                    if (error.getSeverity().ordinal() == ErrorSeverity.FATAL.ordinal())
                        log.error(error.getText());
                    else if (error.getSeverity().ordinal() == ErrorSeverity.WARN.ordinal())
                        log.warn(error.getText());
                    else if (error.getSeverity().ordinal() == ErrorSeverity.INFO.ordinal())
                        log.info(error.getText());
                    else
                        log.error(error.getText());

                    assembler.addErrorText(error.getText());
                }
                if (this.importRegistry != null)
                    this.importRegistry.register(assembler.getResultId(),
                            assembler.getResult());
                else
                    Environment.getInstance().add(assembler.getResultId(),
                            assembler.getResult());

                String type = event.getSource().getXmiType();
                if (type == null)
                    type = "Element";
                if (assembler.getResult() instanceof NamedElement)
                    log.warn("imported invalid "
                        + type + " ("
                        + event.getSource().getXmiId() + ") '"
                        + ((NamedElement)assembler.getResult()).name
                        + "' as non-executable \"stub\" element");
                else
                    log.warn("imported invalid "
                            + type + " ("
                            + event.getSource().getXmiId()
                            + ") as non-executable \"stub\" element");

                if (event.getParent() != null)
                    if (!event.getParent().removeChild(event.getSource()))
                        log.warn("could not remove assembled node: "
                            + event.getSource().getXmiType() + " ("
                            + event.getSource().getXmiId() + ")");
            }
            else // unresolved references
                if (log.isDebugEnabled())
                    log.debug("found node with unresolved references: "
                        + event.getSource().getXmiType() + " ("
                        + event.getSource().getXmiId() + ")");
        }
    }
}
