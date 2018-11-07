package com.lauer.app.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.lauer.app.enums.Operation;
import com.lauer.app.exceptions.CalculationException;
import com.lauer.app.uimodel.CalculatorInput;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceResultOutOfRangeTest extends CalculatorServiceTest {

	// ----------------------------------------------------------------------------------
	// Test calculation result out of range
	// ----------------------------------------------------------------------------------
	@Test(expected = CalculationException.class)
	public void testAddNumbers_calculation_outOfRange() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(Double.MAX_VALUE / 2, Double.MAX_VALUE / 2, Double.MAX_VALUE / 2),
				Operation.ADDITION);
	}

	@Test(expected = CalculationException.class)
	public void testSubtractNumbers_calculation_outOfRange() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE), Operation.SUBTRACTION);
	}

	@Test(expected = CalculationException.class)
	public void testMultiplyNumbers_calculation_outOfRange() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(Double.MAX_VALUE / 2, Double.MAX_VALUE / 2, Double.MAX_VALUE / 2),
				Operation.MULTIPLICATION);
	}

	@Test(expected = CalculationException.class)
	public void testDivideNumbers_calculation_outOfRange() throws Exception {
		when(env.getProperty(any(String.class))).thenReturn(ERROR);
		calculatorService.calculate(new CalculatorInput(Double.MAX_VALUE, 0.1), Operation.DIVISION);
	}
}
