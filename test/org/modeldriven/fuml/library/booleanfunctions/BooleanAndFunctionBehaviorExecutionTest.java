/*
 * Copyright (c) 2008 Lockheed Martin Corporation.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Public License v1.0
 * which accompanies this distribution, and is available at
 * 
 *
 * Contributors:
 *   MDS - initial API and implementation
 *
 */

package org.modeldriven.fuml.library.booleanfunctions;

import org.modeldriven.fuml.library.LibraryTestSetup;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;
import junit.framework.TestCase;

public class BooleanAndFunctionBehaviorExecutionTest extends TestCase {
	
	ParameterValueList inputParameters;
	ParameterValueList outputParameters;

	/**
	 * Set up the ParameterValueLists to simulate the fUML system before calling
	 * the doBody() method on the library classes.
	 */
	@Override
	public void setUp() {
		LibraryTestSetup libraryTestSetup = new LibraryTestSetup();
		inputParameters = libraryTestSetup.setupInputParameterList();
		outputParameters = libraryTestSetup.setupOutputParameterList();
	}
	
	/**
	 * Tests the doBody() method in the BooleanAndFunctionBehaviorExecution
	 * 
	 * @throws Exception
	 */
	public void testDoBody_true_true() throws Exception {
		BooleanConversion.insertTwoBooleansIntoParameterValueList(true, true, inputParameters);
		BooleanAndFunctionBehaviorExecution obj = new BooleanAndFunctionBehaviorExecution();
		obj.doBody(inputParameters, outputParameters);
		assertEquals(true, BooleanConversion.extractBooleanFromParameterValueList(outputParameters));
	}	

	/**
	 * Tests the doBody() method in the BooleanAndFunctionBehaviorExecution
	 * 
	 * @throws Exception
	 */
	public void testDoBody_true_false() throws Exception {
		BooleanConversion.insertTwoBooleansIntoParameterValueList(true, false, inputParameters);
		BooleanAndFunctionBehaviorExecution obj = new BooleanAndFunctionBehaviorExecution();
		obj.doBody(inputParameters, outputParameters);
		assertEquals(false, BooleanConversion.extractBooleanFromParameterValueList(outputParameters));
	}	
	
	/**
	 * Tests the doBody() method in the BooleanAndFunctionBehaviorExecution
	 * 
	 * @throws Exception
	 */
	public void testDoBody_false_true() throws Exception {
		BooleanConversion.insertTwoBooleansIntoParameterValueList(false, true, inputParameters);
		BooleanAndFunctionBehaviorExecution obj = new BooleanAndFunctionBehaviorExecution();
		obj.doBody(inputParameters, outputParameters);
		assertEquals(false, BooleanConversion.extractBooleanFromParameterValueList(outputParameters));
	}	
	
	/**
	 * Tests the doBody() method in the BooleanAndFunctionBehaviorExecution
	 * 
	 * @throws Exception
	 */
	public void testDoBody_false_false() throws Exception {
		BooleanConversion.insertTwoBooleansIntoParameterValueList(false, false, inputParameters);
		BooleanAndFunctionBehaviorExecution obj = new BooleanAndFunctionBehaviorExecution();
		obj.doBody(inputParameters, outputParameters);
		assertEquals(false, BooleanConversion.extractBooleanFromParameterValueList(outputParameters));
	}
	
	/**
	 * Tests the new_() method in the BooleanAndFunctionBehaviorExecution
	 * class
	 * 
	 * @throws Exception
	 */
	public void testNew_() throws Exception {
		BooleanAndFunctionBehaviorExecution obj = new BooleanAndFunctionBehaviorExecution();
		BooleanAndFunctionBehaviorExecution newobj = (BooleanAndFunctionBehaviorExecution) obj.new_();
		assertNotSame(obj, newobj);
	}	
}
