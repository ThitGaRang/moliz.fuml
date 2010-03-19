package org.modeldriven.fuml.meta.merge;



public interface PackageGraphVisitor {
    public void visit(PackageGraphNode target, PackageGraphNode source);

}
