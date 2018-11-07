package com.lauer.app.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.lauer.app.enums.Operation;
import com.lauer.app.uimodel.CalculatorInput;
import com.lauer.test.util.CalculatorTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceParametersOutOfRangeTest extends CalculatorServiceTest {

	// ----------------------------------------------------------------------------------
	// Test input parameters are out of range
	// ----------------------------------------------------------------------------------
	@Test(expected = IllegalArgumentException.class)
	public void testAddNumbers_outOfRange_firstNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(Double.POSITIVE_INFINITY, CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3),
				Operation.ADDITION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddNumbers_outOfRange_secondNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(CalculatorTestUtils.NUM1, Double.POSITIVE_INFINITY, CalculatorTestUtils.NUM3),
				Operation.ADDITION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddNumbers_outOfRange_thirdNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(CalculatorTestUtils.NUM1, CalculatorTestUtils.NUM2, Double.POSITIVE_INFINITY),
				Operation.ADDITION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSubtractNumbers_outOfRange_firstNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(Double.POSITIVE_INFINITY, CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3),
				Operation.SUBTRACTION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSubtractNumbers_outOfRange_secondNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(CalculatorTestUtils.NUM1, Double.POSITIVE_INFINITY, CalculatorTestUtils.NUM3),
				Operation.SUBTRACTION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSubtractNumbers_outOfRange_thirdNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(CalculatorTestUtils.NUM1, CalculatorTestUtils.NUM2, Double.POSITIVE_INFINITY),
				Operation.SUBTRACTION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMultiplyNumbers_outOfRange_firstNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(Double.POSITIVE_INFINITY, CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3),
				Operation.MULTIPLICATION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMultiplyNumbers_outOfRange_secondNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(CalculatorTestUtils.NUM1, Double.POSITIVE_INFINITY, CalculatorTestUtils.NUM3),
				Operation.MULTIPLICATION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMultiplyNumbers_outOfRange_thirdNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(CalculatorTestUtils.NUM1, CalculatorTestUtils.NUM2, Double.POSITIVE_INFINITY),
				Operation.MULTIPLICATION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDivideNumbers_outOfRange_firstNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(Double.POSITIVE_INFINITY, CalculatorTestUtils.NUM2), Operation.DIVISION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDivideNumbers_outOfRange_secondNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(CalculatorTestUtils.NUM1, Double.POSITIVE_INFINITY), Operation.DIVISION);
	}
}
