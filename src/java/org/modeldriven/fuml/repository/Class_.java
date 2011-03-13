package org.modeldriven.fuml.repository;


public interface Class_ extends Classifier {

	public fUML.Syntax.Classes.Kernel.Class_ getDelegate(); 
	    
	public Property getProperty(String name);
	public Property findProperty(String name);
    public Property[] getProperties();
    
    
} // Class_
