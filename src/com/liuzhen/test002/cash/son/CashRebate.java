package com.liuzhen.test002.cash.son;

import com.liuzhen.test002.cash.CashSuper;

public class CashRebate extends CashSuper{

	public CashRebate(double rebate) {
		this.rebate = rebate;
	}
	
	private double rebate = 1.0;
	
	@Override
	public double acceptCash(double money) {
		return money * rebate;
	}
}
