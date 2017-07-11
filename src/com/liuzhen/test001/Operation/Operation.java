package com.liuzhen.test001.Operation;

public abstract class Operation {

	protected double numberA;
	protected double numberB;
	
	public abstract double getResult();

	public double getNumberA() {
		return numberA;
	}

	public void setNumberA(double numberA) {
		this.numberA = numberA;
	}

	public double getNumberB() {
		return numberB;
	}

	public void setNumberB(double numberB) {
		this.numberB = numberB;
	}
}
