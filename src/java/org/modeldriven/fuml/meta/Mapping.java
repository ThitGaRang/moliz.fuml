package org.modeldriven.fuml.meta;

import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Classifier;
import fUML.Syntax.Classes.Kernel.Enumeration;
import fUML.Syntax.Classes.Kernel.EnumerationLiteral;
import fUML.Syntax.Classes.Kernel.Package;
import fUML.Syntax.Classes.Kernel.PrimitiveType;

import org.modeldriven.fuml.meta.Property;

public interface Mapping {

	public void mapPackage(Package p, String currentPackageName, MetaDataDocument artifact);
	public void mapPackageMerge(Package p, String sourcePackageXmiId);
	public void mapClass(Class_ c, String currentPackageName, MetaDataDocument artifact);
	public void mapProperty(Class_ c, Property p, MetaDataDocument artifact);
	public void mapPrimitiveType(PrimitiveType t, String currentPackageName, MetaDataDocument artifact);
	public void mapEnumeration(Enumeration e, String currentPackageName);
	public void mapEnumerationLiteral(EnumerationLiteral literal, String currentPackageName);
	
	public Object get(String id);
	public Object find(String id);
	public Classifier getClassifierByName(String name);
	public Classifier getClassifierByQualifiedName(String qualifiedName);
	public Package getPackageByQualifiedName(String qualifiedName);

}
