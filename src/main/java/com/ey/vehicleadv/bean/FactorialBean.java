package com.ey.vehicleadv.bean;
	public class FactorialBean {
	private int number;
	private int factorialOfNumber;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getFactorialOfNumber() {
		return factorialOfNumber;
	}
	public void setFactorialOfNumber(int factorialOfNumber) {
		this.factorialOfNumber = factorialOfNumber;
	}
	public FactorialBean(int number, int factorialOfNumber) {
		super();
		this.number = number;
		this.factorialOfNumber = factorialOfNumber;
	}
	public FactorialBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
