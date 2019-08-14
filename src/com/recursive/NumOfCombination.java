package com.recursive;

import java.util.Random;

public class NumOfCombination {
	public static int nums1(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] ch = str.toCharArray();
		return process(ch, 0);
	}

	private static int process(char[] ch, int i) {
		// TODO Auto-generated method stub
		if (i == ch.length) {
			return 1;
		}
		if (ch[i] == '0') {
			return 0;
		}
		int res = process(ch, i + 1);
		if (i + 1 < ch.length && (ch[i] - '0') * 10 + ch[i + 1] - '0' < 27) {
			res += process(ch, i + 2);
		}
		return res;
	}

	public static int nums2(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] ch = str.toCharArray();
		int cur = ch[ch.length - 1] == '0' ? 0 : 1;
		int next = 1;
		int tmp = 0;
		for (int i = ch.length - 2; i > -1; i--) {
			if (ch[i] == '0') {
				next = cur;
				cur = 0;
			} else {
				tmp = cur;
				if ((ch[i] - '0') * 10 + ch[i + 1] - '0' < 27) {
					cur += next;
				}
				next = tmp;
			}
			
		}
		return cur;
	}

	public static void main(String[] args) {
//		StringBuilder sb = new StringBuilder();
//		Random rand = new Random();
//		for (int i = 0; i < 20; i++) {
//			sb.append(rand.nextInt(2));
//		}
		String str = "10110101011101111011101110111111110111101111011101010111011110111111011110111011111011";
		System.out.println(str);
		long s1=System.currentTimeMillis();
		System.out.println(nums1(str));
		long e1=System.currentTimeMillis();
		System.out.println(e1-s1);
		
		long s2=System.currentTimeMillis();
		System.out.println(nums2(str));
		long e2=System.currentTimeMillis();
		System.out.println(e2-s2);
		
		
	}
}
