package com.lauer.app.uimodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.lauer.app.enums.Operation;

/**
 * Object used to save the result of the operation, the values used for the
 * operation and the type of operation executed.
 * 
 * @author lauer
 *
 */
public class CalculatorResult implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private Operation operation;
	private List<Double> values;
	private double result;

	public CalculatorResult(double result) {
		this.result = result;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public List<Double> getValues() {
		return values;
	}

	public void setValues(List<Double> values) {
		this.values = values;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public void addValues(Double... nums) {
		
		if(ArrayUtils.isEmpty(nums)) {
			this.values = Collections.emptyList();
			return;
		}

		this.values = new ArrayList<>();
		for (Double num : nums) {

			if (num != null) {
				this.values.add(num);
			}
		}
	}
}
