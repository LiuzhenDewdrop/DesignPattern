package com.liuzhen.test001;

import com.liuzhen.test001.Operation.Operation;

/**
 * 简单工厂
 */
public class Test {

	public static void main(String[] args) {
		Operation operation = OperationFactory.createOperation("+");
		operation.setNumberA(1.354);
		operation.setNumberB(2.456);
		double result = operation.getResult();
		System.out.println(result);
	}
}
