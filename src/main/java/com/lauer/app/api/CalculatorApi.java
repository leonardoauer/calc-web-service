package com.lauer.app.api;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lauer.app.enums.CalculatorResponseStatus;
import com.lauer.app.enums.Operation;
import com.lauer.app.exceptions.CalculationException;
import com.lauer.app.service.CalculatorService;
import com.lauer.app.uimodel.ApiResponse;
import com.lauer.app.uimodel.CalculatorInput;
import com.lauer.app.uimodel.CalculatorResult;

@RestController
@RequestMapping("/calculator")
public class CalculatorApi {

	private static final Logger log = LoggerFactory.getLogger(CalculatorApi.class);

	@Autowired
	private CalculatorService calculatorService;

	@Autowired
	private Environment env;

	@RequestMapping(value = { "/add/{num1}/{num2}", "/add/{num1}/{num2}/{num3}" }, method = RequestMethod.GET)
	public CalculatorResult addNumbers(@PathVariable Double num1, @PathVariable Double num2, @PathVariable(required = false) Double num3,
			HttpServletRequest request) throws CalculationException {

		log.info("Endpoint to add numbers called");

		CalculatorInput calculatorInput = new CalculatorInput(num1, num2, num3);
		calculatorInput.setId(request.getRequestURI());

		return calculatorService.calculate(calculatorInput, Operation.ADDITION);
	}

	@RequestMapping(value = { "/subtract/{num1}/{num2}", "/subtract/{num1}/{num2}/{num3}" }, method = RequestMethod.GET)
	public CalculatorResult subtractNumbers(@PathVariable Double num1, @PathVariable Double num2,
			@PathVariable(required = false) Double num3, HttpServletRequest request) throws CalculationException {

		log.info("Endpoint to subtract numbers called");

		CalculatorInput calculatorInput = new CalculatorInput(num1, num2, num3);
		calculatorInput.setId(request.getRequestURI());

		return calculatorService.calculate(calculatorInput, Operation.SUBTRACTION);
	}

	@RequestMapping(value = { "/multiply/{num1}/{num2}", "/multiply/{num1}/{num2}/{num3}" }, method = RequestMethod.GET)
	public CalculatorResult multiplyNumbers(@PathVariable Double num1, @PathVariable Double num2,
			@PathVariable(required = false) Double num3, HttpServletRequest request) throws CalculationException {

		log.info("Endpoint to multiply numbers called");

		CalculatorInput calculatorInput = new CalculatorInput(num1, num2, num3);
		calculatorInput.setId(request.getRequestURI());

		return calculatorService.calculate(calculatorInput, Operation.MULTIPLICATION);
	}

	@RequestMapping(value = "/divide/{num1}/{num2}", method = RequestMethod.GET)
	public CalculatorResult divideNumbers(@PathVariable Double num1, @PathVariable Double num2, HttpServletRequest request)
			throws CalculationException {

		log.info("Endpoint to divide numbers called");

		CalculatorInput calculatorInput = new CalculatorInput(num1, num2);
		calculatorInput.setId(request.getRequestURI());

		return calculatorService.calculate(calculatorInput, Operation.DIVISION);
	}

	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public ApiResponse clearCache() {

		// Clear the cache
		log.info("Endpoint to clear the cache called");
		calculatorService.clearCache();

		// Create success message
		String message = env.getProperty("clear.cache.message");
		return ApiResponse.createResponse(CalculatorResponseStatus.SUCCESS).message(message);
	}
}
