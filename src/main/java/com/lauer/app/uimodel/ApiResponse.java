package com.lauer.app.uimodel;

import com.lauer.app.enums.CalculatorResponseStatus;

/**
 * Object used to send informative messages to the end user
 * 
 * @author lauer
 *
 */
public class ApiResponse {

	private CalculatorResponseStatus status;
	private String message;

	private ApiResponse(CalculatorResponseStatus status) {
		this.status = status;
	}

	public static ApiResponse createResponse(CalculatorResponseStatus status) {
		return new ApiResponse(status);
	}

	public ApiResponse message(String message) {
		this.message = message;
		return this;
	}

	public CalculatorResponseStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}
