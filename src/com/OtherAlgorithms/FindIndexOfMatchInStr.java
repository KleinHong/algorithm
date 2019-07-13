package com.OtherAlgorithms;
/**
 * hzy��jdk1.8
 */

/**
 * @author ����
 * @descripition
 * @ieda
 */
public class FindIndexOfMatchInStr {

	public static int[] getNextArr(char[] chas) {
		if (chas.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[chas.length];// next[i]������chas[i-1]Ϊ��β������chas[0]��ͷ�����ַ�������chas[0]��ͷ�����ַ��������ͬ����
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
			} else if (next[mi] == -1) {//str��ǰλ���ַ���match��һ���ַ�����ͬʱstrλ��һ��˳��
				si++;
			} else {
				mi = next[mi];          //kmp�㷨�ľ��裺��ǰ�ֶβ�ƥ��ʱ��Ѱ����һ����ͬ�ַ���������ַ�λ�ã������丳ֵ��mi��������һ�β��ң�����ʱ�临�Ӷ�
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
