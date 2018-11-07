package com.lauer.app.service;

import com.lauer.app.enums.Operation;
import com.lauer.app.exceptions.CalculationException;
import com.lauer.app.uimodel.CalculatorInput;
import com.lauer.app.uimodel.CalculatorResult;

/**
 * Interface to create a simple calculator where results are cached.
 * 
 * @author lauer
 *
 */
public interface CalculatorService {

	/**
	 * 
	 * @param input
	 *            The input values for the operation
	 * @param operation
	 *            The operation type
	 * @return The result of the operation
	 * @throws CalculationException
	 */
	CalculatorResult calculate(CalculatorInput input, Operation operation) throws CalculationException;

	/**
	 * Removes all stored results from the cache
	 */
	void clearCache();
}
