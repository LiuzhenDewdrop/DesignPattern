package com.liuzhen.test001.Operation.son;

import com.liuzhen.test001.Operation.Operation;

public class OperationDiv extends Operation{

	@Override
	public double getResult() {
		double result = 0;
		if (numberB == 0) {
			try {
				throw new Exception("除数不能为0");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			result = numberA / numberB;
		}
		return result;
	}
}
