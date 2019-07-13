package com.OtherAlgorithms;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class Manacher {

	public static char[] manchacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[2 * charArr.length + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manchacherString(str);
		int[] pArr = new int[charArr.length];
		int pR = -1;
		int index = -1;
//		int[] res= {Integer.MIN_VALUE,0};
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - 1) : 1;// 获取i关于index对称的值，然后与pR-i的值比较大小，取小的那个值；若越界，当前字符回文串半径为1
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
					pArr[i]++;
				} else {
					break;
				}
			}
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			max = Math.max(max, pArr[i]);
//			if(max>res[0]) {
//				res[0]=max;
//				res[1]=i;
//			}
		}
		return max - 1;
	}

	public static String shortAdd(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char[] charArr = manchacherString(str);
		int[] pArr = new int[charArr.length];
		int pR = -1;
		int index = -1;
//		int[] res= {Integer.MIN_VALUE,0};
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - 1) : 1;// 获取i关于index对称的值，然后与pR-i的值比较大小，取小的那个值；若越界，当前字符回文串半径为1
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
					pArr[i]++;
				} else {
					break;
				}
			}
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			if (pR == charArr.length) {
				max = pArr[i];
				break;
			}
		}
		char[] res = new char[str.length() - max + 1];
		for (int i = 0; i != res.length; i++) {
			res[res.length - 1 - i] = charArr[i * 2 + 1];
		}
		return String.valueOf(res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc1234321c";
		System.out.println(maxLcpsLength(str));
		System.out.println(shortAdd(str));
	}

}
