package com.liuzhen.util;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class SWTUtil {

	public static void alertMsg(Shell shell,String msg) {
		MessageBox alertBox = new MessageBox(shell);
		alertBox.setMessage(msg);
		alertBox.setText("信息");
		alertBox.open();
	}
}
