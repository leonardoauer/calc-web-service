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
public class CalculatorServiceInputParametersNotNullTest extends CalculatorServiceTest {

	// ----------------------------------------------------------------------------------
	// Test Input parameters are not null
	// ----------------------------------------------------------------------------------
	@Test(expected = IllegalArgumentException.class)
	public void testAddNumbers_throwException_firstNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(null, CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3), Operation.ADDITION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddNumbers_throwException_secondNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(CalculatorTestUtils.NUM1, null, CalculatorTestUtils.NUM3), Operation.ADDITION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSubtractNumbers_throwException_firstNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(null, CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3), Operation.SUBTRACTION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSubtractNumbers_throwException_secondNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(CalculatorTestUtils.NUM1, null, CalculatorTestUtils.NUM3), Operation.SUBTRACTION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMultiplyNumbers_throwException_firstNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(null, CalculatorTestUtils.NUM2, CalculatorTestUtils.NUM3),
				Operation.MULTIPLICATION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMultiplyNumbers_throwException_secondNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(CalculatorTestUtils.NUM1, null, CalculatorTestUtils.NUM3),
				Operation.MULTIPLICATION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDivideNumbers_throwException_firstNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(null, CalculatorTestUtils.NUM2), Operation.DIVISION);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDivideNumbers_throwException_secondNumber() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(CalculatorTestUtils.NUM1, null), Operation.DIVISION);
	}
}
