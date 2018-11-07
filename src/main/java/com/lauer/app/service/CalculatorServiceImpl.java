package com.lauer.app.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.lauer.app.enums.Operation;
import com.lauer.app.exceptions.CalculationException;
import com.lauer.app.uimodel.CalculatorInput;
import com.lauer.app.uimodel.CalculatorResult;

@Component
public class CalculatorServiceImpl implements CalculatorService {

	private static final Logger log = LoggerFactory.getLogger(CalculatorServiceImpl.class);

	@Autowired
	private Environment env;

	@Override
	@Cacheable(value = "results", sync = true, key = "#input.id")
	public CalculatorResult calculate(CalculatorInput input, Operation operation) throws CalculationException {

		if (operation == null) {
			String errorMessage = Operation.class.getName() + StringUtils.SPACE + env.getProperty("error.mandatory.field.operation");
			log.error(errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}

		// Check mandatory values
		validateInput(input);

		// Execute the calculation
		double calculationResult = 0;
		Double num1 = input.getNum1();
		Double num2 = input.getNum2();
		Double num3 = input.getNum3();

		switch (operation) {

		case ADDITION:
			log.info("Executing add calculation");
			calculationResult = num1.doubleValue() + num2.doubleValue() + (num3 != null ? num3.doubleValue() : 0);
			break;
		case SUBTRACTION:
			log.info("Executing subtract calculation");
			calculationResult = num1.doubleValue() - num2.doubleValue() - (num3 != null ? num3.doubleValue() : 0);
			break;
		case MULTIPLICATION:
			log.info("Executing multiply calculation");
			calculationResult = num1.doubleValue() * num2.doubleValue() * (num3 != null ? num3.doubleValue() : 1);
			break;
		case DIVISION:
			log.info("Executing divide calculation");
			calculationResult = num1.doubleValue() / num2.doubleValue();
			break;
		default:
			String errorMessage = env.getProperty("error.invalid.operation") + operation.name();
			log.error(errorMessage);
			throw new IllegalArgumentException(env.getProperty("error.invalid.operation") + operation.name());
		}

		// Verify the calculation result value
		checkCalculationResult(calculationResult);

		// Create calculator result
		log.info("Calculation executed successfully");
		CalculatorResult result = new CalculatorResult(calculationResult);
		result.addValues(num1, num2, num3);
		result.setOperation(operation);
		return result;
	}

	@Override
	@CacheEvict(value = "results", allEntries = true)
	public void clearCache() {
		log.info("All values have been removed from the cache!!!");
	}

	/**
	 * Checks that mandatory values are not null. If any is null,
	 * IllegalArgumentException is thrown.
	 */
	private void validateInput(CalculatorInput input) {

		log.info("Validating input parameters");

		Double num1 = input.getNum1();
		Double num2 = input.getNum2();
		Double num3 = input.getNum3();

		if (num1 == null || num2 == null) {
			String errorMessage = env.getProperty("error.mandatory.values.missing");
			log.error(errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}

		if (Double.isInfinite(num1) || Double.isInfinite(num2)) {
			String errorMessage = env.getProperty("error.out.ofrange.parameters");
			log.error(errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}

		if (num3 != null && Double.isInfinite(num3)) {
			String errorMessage = env.getProperty("error.out.ofrange.parameters");
			log.error(errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}
	}

	/**
	 * Check that the calculation result is not out of range
	 */
	private void checkCalculationResult(double calculationResult) throws CalculationException {

		log.info("Validating the calculation result");

		if (Double.isInfinite(calculationResult)) {
			String errorMessage = env.getProperty("error.out.ofrange.result");
			log.error(errorMessage);
			throw new CalculationException(errorMessage);
		}
	}
}
