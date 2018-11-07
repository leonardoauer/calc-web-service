package com.lauer.app.exceptions;

/**
 * Exception used for calculation errors, as overflow.
 * 
 * @author lauer
 *
 */
public class CalculationException extends Exception {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	public CalculationException(String errorMessage) {
		super(errorMessage);
	}
}
