package com.lauer.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.lauer.app.enums.Operation;
import com.lauer.app.exceptions.CalculationException;
import com.lauer.app.uimodel.CalculatorInput;
import com.lauer.app.uimodel.CalculatorResult;
import com.lauer.test.util.CalculatorTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceSimpleOperationsTest extends CalculatorServiceTest {

	private static final double DELTA = 0.01;
	private CalculatorInput inputWith2Numbers;
	private CalculatorInput inputWith3Numbers;

	@Before
	public void setUp() {
		inputWith2Numbers = new CalculatorInput(CalculatorTestUtils.NUM1, CalculatorTestUtils.NUM2);
		inputWith3Numbers = new CalculatorInput(CalculatorTestUtils.NUM1, CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3);
	}

	// ----------------------------------------------------------------------------------
	// Test simple operations
	// ----------------------------------------------------------------------------------
	@Test
	public void testAddNumbers() throws Exception {
		CalculatorResult result = calculatorService.calculate(inputWith3Numbers, Operation.ADDITION);
		assertEquals(24.8, result.getResult(), DELTA);

		result = calculatorService.calculate(inputWith2Numbers, Operation.ADDITION);
		assertEquals(-5.19, result.getResult(), DELTA);
	}

	@Test
	public void testSubtractNumbers() throws Exception {
		CalculatorResult result = calculatorService.calculate(inputWith3Numbers, Operation.SUBTRACTION);
		assertEquals(-3.80, result.getResult(), DELTA);

		result = calculatorService.calculate(inputWith2Numbers, Operation.SUBTRACTION);
		assertEquals(26.2, result.getResult(), DELTA);
	}

	@Test
	public void testMultiplyNumbers() throws Exception {
		CalculatorResult result = calculatorService.calculate(inputWith3Numbers, Operation.MULTIPLICATION);
		assertEquals(-4945.5, result.getResult(), DELTA);

		result = calculatorService.calculate(inputWith2Numbers, Operation.MULTIPLICATION);
		assertEquals(-164.85, result.getResult(), DELTA);
	}

	@Test
	public void testDivideNumbers() throws Exception {
		CalculatorResult result = calculatorService.calculate(inputWith2Numbers, Operation.DIVISION);
		assertEquals(-0.66, result.getResult(), DELTA);
	}

	@Test(expected = CalculationException.class)
	public void testDivideNumbers_division_byzero() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(Double.MAX_VALUE, 0.0), Operation.DIVISION);
	}
}

