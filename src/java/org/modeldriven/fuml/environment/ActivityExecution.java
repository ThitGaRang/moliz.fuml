/*
 * Copyright 2009 Data Access Technologies, Inc., except
 * as stated in the file entitled Licensing-Information.
 * Licensed under the Academic Free License version 3.0
 * (http://www.opensource.org/licenses/afl-3.0.php), except as stated
 * in the file entitled Licensing-Information.
 *
 * Contributors:
 *   MDS - initial API and implementation
 *
 */

package org.modeldriven.fuml.environment;

import java.util.Iterator;

import fUML.utility.MexSystem;
import fUML.Debug;

import fUML.Syntax.Classes.Kernel.Comment;
import fUML.Syntax.Activities.IntermediateActivities.Activity;

import org.modeldriven.fuml.FumlException;
import org.modeldriven.fuml.assembly.ElementStubAssembler;

public class ActivityExecution extends fUML.Semantics.Activities.IntermediateActivities.ActivityExecution {

    public void execute() {
        Activity activity = (Activity) (this.getTypes().getValue(0));
        if (activity.ownedComment != null && activity.ownedComment.size() > 0
                && ElementStubAssembler.STUB_TOKEN.equals(activity.ownedComment.get(0).body)) {
            Debug.println("[execute] invalid activity encountered: " + activity.name
                    + " - see below error(s)");
            Iterator<Comment> comments = activity.ownedComment.iterator();
            comments.next(); // skip the "stub" comment
            while (comments.hasNext())
                Debug.println("[execute] error: " + comments.next().body);
            throw new FumlException("cannot execute invalid activity '" + activity.name
                    + "' - see above errors");
        }
        super.execute();
    } // execute

} // ActivityExecution
