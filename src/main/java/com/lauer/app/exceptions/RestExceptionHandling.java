package com.lauer.app.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lauer.app.enums.CalculatorResponseStatus;
import com.lauer.app.uimodel.ApiResponse;

/**
 * Global exception handling
 * 
 * @author lauer
 *
 */
@ControllerAdvice
public class RestExceptionHandling extends ResponseEntityExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(RestExceptionHandling.class);

	@ExceptionHandler(CalculationException.class)
	protected ResponseEntity<Object> handleConflict(CalculationException ex, WebRequest request) {
		return errorResponse(ex, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		return errorResponse(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		return errorResponse(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return errorResponse(ex, status);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		return errorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<Object> errorResponse(Exception ex, HttpStatus status) {

		// log the error
		log.error(ex.getMessage(), ex);

		// Create appropriate response
		ApiResponse apiResponse = ApiResponse.createResponse(CalculatorResponseStatus.ERROR).message(ex.getMessage());
		return new ResponseEntity<>(apiResponse, status);
	}
}