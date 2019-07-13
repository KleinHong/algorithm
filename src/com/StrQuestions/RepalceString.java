package com.StrQuestions;
import java.util.LinkedList;

/**
 * hzy：jdk1.8
 */

/**
 * @author 残月
 * @descripition 提供三个字符串str、from、to将str中包含from的子串替换为to， 连续的from子串只替换一个to
 * @ieda 使用队列记录from在str中出现的开始下标和结束下标；
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
