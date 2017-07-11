package com.liuzhen.test002;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.liuzhen.util.SWTUtil;
import com.liuzhen.util.StringUtil;

/**
 * 策略模式
 */
public class Test {
	
	private Display display;
	private Shell shell;
	private Button setBtn;
	private Button resetBtn;
	private Text text1;
	private Text text2;
	private Text text3;
	private Text text4;
	private Text text5;
	private Text text6;
	private Text text7;
	private Text text8;
	private double total = 0;
	private Combo combo;
	private static String[] options = {"无活动", "打8折", "满300减100"};
	
	public Test() {

		display = new Display();
		// 基本对话框
		shell = new Shell(display,SWT.DIALOG_TRIM);
		shell.setText("商场收银系统");		// 标题
		shell.setSize(300,400);			// 尺寸
		
		text1 = new Text(shell, SWT.READ_ONLY);
		text1.setText("单价:");
		text1.setLocation(30,30);
		text1.setSize(70, 20);
		text2 = new Text(shell, SWT.READ_ONLY);
		text2.setText("数量:");
		text2.setLocation(30,80);
		text2.setSize(70, 20);
		text3 = new Text(shell, SWT.READ_ONLY);
		text3.setText("计算方式:");
		text3.setLocation(30,130);
		text3.setSize(70, 20);
		text7 = new Text(shell, SWT.READ_ONLY);
		text7.setText("总计:");
		text7.setLocation(30,300);
		text7.setSize(70, 20);
		text4 = new Text(shell, SWT.BORDER);
		text4.setLocation(100,30);
		text4.setSize(100, 20);
		text5 = new Text(shell, SWT.BORDER);
		text5.setLocation(100,80);
		text5.setSize(100, 20);
		text6 = new Text(shell,SWT.MULTI|SWT.BORDER|SWT.V_SCROLL|SWT.WRAP);
		text6.setLocation(30,170);
		text6.setSize(240, 100);
		text8 = new Text(shell, SWT.READ_ONLY);
		text8.setText(total + "");
		text8.setLocation(100,300);
		text8.setSize(150, 50);
		text8.setFont(new Font(display,"微软雅黑", 20, SWT.NORMAL));
		
		combo = new Combo(shell, SWT.DROP_DOWN|SWT.READ_ONLY);
		combo.setLocation(100, 130);
		combo.setSize(100, 20);
		combo.setItems(options);
		combo.select(0);
		
		setBtn = new Button(shell, SWT.PUSH);
		setBtn.setText("确定");
		setBtn.setSize(40, 20);
		setBtn.setLocation(220, 30);
		setBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String str4 = text4.getText();
				if (str4 == null || str4.equals("")) {
					SWTUtil.alertMsg(shell, "输入错误, “单价”不能为空");
					text4.forceFocus();
					return ;
				}
				if (StringUtil.isNaN(str4, 3)) {
					SWTUtil.alertMsg(shell, "输入错误, “单价”应为数字");
					text4.setText("");
					text4.forceFocus();
					return ;
				}
				String str5 = text5.getText();
				if (str5 == null || str5.equals("")) {
					SWTUtil.alertMsg(shell, "输入错误, “数量”不能为空");
					text5.forceFocus();
					return ;
				}
				if (StringUtil.isNaN(str5, 4)) {
					SWTUtil.alertMsg(shell, "输入错误, “数量”应为正整数");
					text5.setText("");
					text5.forceFocus();
					return ;
				}
				int num4 = Integer.parseInt(str4);
				int num5 = Integer.parseInt(str5);
				CashContext cs = new CashContext(combo.getSelectionIndex());
				double result = cs.getResult(num4 * num5);
				total += result;
				text6.setText(text6.getText() + "单价: " + num4 + " 数量: " + num5 + " " + combo.getText() + " 合计: " + result + "\n");
				text8.setText(total + "");
			}
		});
		resetBtn = new Button(shell, SWT.PUSH);
		resetBtn.setText("重置");
		resetBtn.setSize(40, 20);
		resetBtn.setLocation(220, 80);
		resetBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				total = 0.0;
				text4.setText("");
				text5.setText("");
				text6.setText("");
				text8.setText(total + "");
				combo.deselectAll();
			}
		});
		
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		System.out.println("closed");
		display.dispose();
	}
	
	public static void main(String[] args) {
		new Test();
		System.exit(0);
	}
}
