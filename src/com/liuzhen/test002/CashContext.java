package com.liuzhen.test002;

import com.liuzhen.test002.cash.CashSuper;
import com.liuzhen.test002.cash.son.CashNormal;
import com.liuzhen.test002.cash.son.CashRebate;
import com.liuzhen.test002.cash.son.CashReturn;

public class CashContext {

	private CashSuper cs;
	
	public CashContext(int type) {
		switch (type) {
		case 0:
			cs = new CashNormal();
			break;
		case 1:
			cs = new CashRebate(0.8);
			break;
		case 2:
			cs = new CashReturn(300, 100);
			break;
		}
	}
	
	public double getResult(double money) {
		return cs.acceptCash(money);
	}
}
