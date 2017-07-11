package com.liuzhen.test002.cash.son;

import com.liuzhen.test002.cash.CashSuper;

public class CashNormal extends CashSuper{

	@Override
	public double acceptCash(double money) {
		return money;
	}
}
