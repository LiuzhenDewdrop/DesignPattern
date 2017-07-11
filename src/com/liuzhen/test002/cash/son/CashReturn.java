package com.liuzhen.test002.cash.son;

import com.liuzhen.test002.cash.CashSuper;

public class CashReturn extends CashSuper{

	private double level;
	private double back;
	
	public CashReturn(double level, double back) {
		this.level = level;
		this.back = back;
	}
	
	@Override
	public double acceptCash(double money) {
		return money - (int)(money/ level) * back;
	}
}
