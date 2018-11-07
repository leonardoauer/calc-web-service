package com.lauer.app.uimodel;

public class CalculatorInput {

	private String id;
	private Double num1;
	private Double num2;
	private Double num3;
	
	public CalculatorInput(Double num1, Double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public CalculatorInput(Double num1, Double num2, Double num3) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getNum1() {
		return num1;
	}

	public void setNum1(Double num1) {
		this.num1 = num1;
	}

	public Double getNum2() {
		return num2;
	}

	public void setNum2(Double num2) {
		this.num2 = num2;
	}

	public Double getNum3() {
		return num3;
	}

	public void setNum3(Double num3) {
		this.num3 = num3;
	}
}
