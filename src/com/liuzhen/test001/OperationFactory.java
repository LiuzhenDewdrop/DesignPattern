package com.liuzhen.test001;

import com.liuzhen.test001.Operation.Operation;
import com.liuzhen.test001.Operation.son.OperationAdd;
import com.liuzhen.test001.Operation.son.OperationDiv;
import com.liuzhen.test001.Operation.son.OperationMul;
import com.liuzhen.test001.Operation.son.OperationSub;

public class OperationFactory {

	public static Operation createOperation(String operate) {
		if (operate == null) {
			return null;
		}
		Operation operation = null;
		if (operate.equals("+")) {
			operation = new OperationAdd();
		} else if (operate.equals("-")) {
			operation = new OperationSub();
		} else if (operate.equals("*")) {
			operation = new OperationMul();
		} else if (operate.equals("/")) {
			operation = new OperationDiv();
		}
		return operation;
	}
}
