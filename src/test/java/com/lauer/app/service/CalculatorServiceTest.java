package com.lauer.app.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;

public class CalculatorServiceTest {

	@Mock
	protected Environment env;
	
	@InjectMocks
	protected CalculatorServiceImpl calculatorService;
	
	protected static final String ERROR = "error";
}
