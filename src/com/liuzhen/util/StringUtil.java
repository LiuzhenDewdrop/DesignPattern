package com.liuzhen.util;

public class StringUtil {

	/**
	 * 判断字符串是否是数字
	 * @param str	待判定字符串
	 * @param type	判定类型
	 * <pre>
	 * type=0:	所有标准正负数
	 * type=1:	小数部分可能以0结尾的正负数
	 * type=2:	所有标准整数
	 * type=3:	所有标准非负数
	 * type=4:	所有标准非负整数
	 * type=5:	可能以0作为开头或结尾的所有正负数
	 * </pre>
	 */
	public static boolean isNumber(String str, int type) {
		switch (type) {
		case 0:
			return str.matches("^[+-]?(0|[1-9]\\d*)(\\.\\d*[1-9])?$");
		case 1:
			return str.matches("^[+-]?(0|[1-9]\\d*)(\\.\\d*)?$");
		case 2:
			return str.matches("^[+-]?(0|[1-9]\\d*)$");
		case 3:
			return str.matches("^[+]?(0|[1-9]\\d*)(\\.\\d*[1-9])?$");
		case 4:
			return str.matches("^[+]?(0|[1-9]\\d*)$");
		case 5:
			return str.matches("^[+-]?\\d+(\\.\\d*)?$");
		default:
			return str.matches("^[+-]?(0|[1-9]\\d*)(\\.\\d*[1-9])?$");
		}
	}
	
	public static boolean isNaN(String str, int type) {
		return !isNumber(str, type);
	}
}
