package com.liuzhen.test001.Operation.son;

import com.liuzhen.test001.Operation.Operation;

public class OperationSub extends Operation{

	@Override
	public double getResult() {
		double result = numberA - numberB; 
		return result;
	}
}
