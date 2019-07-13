package com.StrQuestions;
import java.util.LinkedList;

/**
 * hzy��jdk1.8
 */

/**
 * @author ����
 * @descripition �ṩ�����ַ���str��from��to��str�а���from���Ӵ��滻Ϊto�� ������from�Ӵ�ֻ�滻һ��to
 * @ieda ʹ�ö��м�¼from��str�г��ֵĿ�ʼ�±�ͽ����±ꣻ
 */
public class RepalceString {

	/**
	 * 
	 */
	public RepalceString() {
		// TODO Auto-generated constructor stub
	}

	public static String replace(String str, String from, String to) {
		if (str == null || from == null || str.equals("") || from.equals(""))
			return str;
		char[] chars = str.toCharArray();
		char[] charf = from.toCharArray();
		int len = charf.length;
		int index = 0;
		LinkedList<Integer> ls = new LinkedList<Integer>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == charf[index++]) {
				if (index == len) {
					ls.add(i - len + 1);
					ls.add(i);
					index = 0;
				}
			} else {
				index = 0;
			}
		}

		String cur = "";
		String res = "";
		int num = 0;
		if (ls.peekFirst() == 0) {
			res=to;
			ls.pollFirst();
			num=ls.pollFirst()+1;
		}
		return replaceNumnotequal0(num, ls, str, cur, res, to);

		
	}

	private static String replaceNumnotequal0(int num, LinkedList<Integer> ls, String str, String cur, String res,
			String to) {
		// TODO Auto-generated method stub
		while (!ls.isEmpty()) {
			if (num == ls.peekFirst()) {
				ls.pollFirst();
				num = ls.pollFirst() + 1;
			} else {
				cur = str.substring(num, ls.pollFirst());
				num = ls.pollFirst() + 1;
				res = res + cur + to;
			}

		}
		if (num <= str.length() - 1) {
			res = res + str.substring(num);
		}
		return res;
		
	}

	public static void main(String[] args) {
		String str = "abc123abcabc567abc";
		System.out.print(replace(str, "abc", "X"));
	}

}
