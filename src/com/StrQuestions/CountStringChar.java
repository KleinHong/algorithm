package com.StrQuestions;
/**
 * hzy��jdk1.8
 */

/**
 * @author ����
 * @descripition ���ַ�������ͳ�ƣ�������Ϊaaabbcc�����Ϊa_3_b_2_c_2;
 * @ieda:ֱ�ӽ��б���
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
	 * flagΪtrue��ʾ��ȡ�ַ��׶Σ�Ϊflase��ʾ��ȡͳ�����׶Σ� �ڶ�ȡ�ַ��׶��ж��Ƿ�����index�±���������ַ�
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
