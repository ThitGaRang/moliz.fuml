package org.modeldriven.fuml.meta;

import fUML.Syntax.Classes.Kernel.ValueSpecification;


public class Property extends fUML.Syntax.Classes.Kernel.Property {

    private ValueSpecification defaultValue;

	public ValueSpecification getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(ValueSpecification defaultValue) {
		this.defaultValue = defaultValue;
	}


} // Property
