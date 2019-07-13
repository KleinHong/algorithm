package com.OtherAlgorithms;
/**
 * hzy：jdk1.8
 */

/**
 * @author 残月
 * @descripition
 * @ieda
 */
public class FindIndexOfMatchInStr {

	public static int[] getNextArr(char[] chas) {
		if (chas.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[chas.length];// next[i]代表以chas[i-1]为结尾不包括chas[0]开头的子字符串和以chas[0]开头的子字符串最大相同长度
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int pre = 0;
		while (pos < next.length) {
			if (chas[pos - 1] == chas[pre]) {
				next[pos++] = ++pre;//
			} else if (pre > 0) {
				pre = next[pre];
			} else {
				next[pos++] = 0;
			}
		}
		return next;

	}

	/**
	 * 
	 * @param str
	 * @param match
	 * @return
	 */
	public static int getIndexOfMatchInStr(String str, String match) {
		if (str == null || match == null || str.length() < match.length() || match.length() < 1) {
			return -1;
		}
		char[] sc = str.toCharArray();
		char[] mc = match.toCharArray();
		int si = 0;
		int mi = 0;
		int[] next = getNextArr(mc);
		while (si < sc.length && mi < mc.length) {
			if (sc[si] == mc[mi]) {
				si++;
				mi++;
			} else if (next[mi] == -1) {//str当前位置字符与match第一个字符不相同时str位置一次顺延
				si++;
			} else {
				mi = next[mi];          //kmp算法的精髓：当前字段不匹配时，寻找上一个相同字符串后面的字符位置，并将其赋值给mi，方便下一次查找，降低时间复杂度
			}
		}
		return mi == mc.length ? si - mi : -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abcdefrabdcef";
		String match="abdce";
		System.out.println(getIndexOfMatchInStr(str, match));
		

	}

}
