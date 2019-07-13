package com.StrQuestions;
/**
 * hzy：jdk1.8
 */

/**
 * @author 残月
 * @descripition 对字符串进行统计，如输入为aaabbcc，输出为a_3_b_2_c_2;
 * @ieda:直接进行遍历
 */
public class CountStringChar {

	/**
	 * 
	 */
	public CountStringChar() {
		// TODO Auto-generated constructor stub
	}

	public static String getCountString(String str) {
		if (str == null || str.equals("")) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();
		sb.append(chars[0]);
		int num = 1;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] != chars[i - 1]) {
				sb.append("_" + String.valueOf(num) + "_");
				num = 1;
				sb.append(chars[i]);
			} else {
				num++;
			}
		}
		return sb.append("_" + String.valueOf(num)).toString();
	}

	/*
	 * flag为true表示读取字符阶段，为flase表示读取统计数阶段； 在读取字符阶段判断是否遇到index下表所代表的字符
	 */
	public static char getCharAt(String cstr, int index) {
		if (cstr == null || cstr.equals(""))
			return 0;
		char[] charc = cstr.toCharArray();
		boolean flag = true;
		char ch = 0;
		int num = 0;
		int sum = 0;
		for (int i = 0; i < charc.length; i++) {
			if (charc[i] == '_') {
				flag = !flag;
			} else if (flag) {
				sum += num;
				if (sum > index) {
					return ch;
				}
				num = 0;
				ch = charc[i];
			} else {
				num = num * 10 + charc[i] - '0';
			}
		}
		return sum + num > index ? ch : 0;
	}

	public static String recover(String cstr) {
		if (cstr == null || cstr.equals(""))
			return cstr;
		char[] charc = cstr.toCharArray();
		boolean flag = true;
		char ch = 0;
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < charc.length; i++) {
			if (charc[i] == '_') {
				flag = !flag;
			} else if (flag) {
				if (ch != 0) {
					while (num-- != 0) {
						sb.append(ch);
					}
				
				}
				num=0;
				ch = charc[i];
			} else {
				num = num * 10 + charc[i] - '0';
			}
		}
		while (num-- != 0) {
			sb.append(ch);
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaabbccd";
		System.out.print(getCountString(str));
		System.out.println();
		System.out.print(getCharAt(getCountString(str), 6));
		System.out.println();
		System.out.print(recover(getCountString(str)));
	}

}
