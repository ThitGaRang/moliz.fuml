package org.modeldriven.fuml.assembly;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.xmi.stream.StreamNode;

import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.Package;

/**
 * Hack profile assemble adapter as stopgap measure until profiles are
 * accommodated in fUML subset, or accommodated in some other way.
 */
public class ProfileAdapter implements AssemblyAdapter {

    private static Log log = LogFactory.getLog(ProfileAdapter.class);

    public Element assemble(StreamNode profileNode) {

        Package pkg = new Package();
        return pkg;
    }

}
