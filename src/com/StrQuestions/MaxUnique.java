package com.StrQuestions;

import java.util.Arrays;

public class MaxUnique {
	public static String getMaxUniqueSubStr(String str) {
		if(str==null || str.equals("")) {
			return "";
		}
		char[] chas=str.toCharArray();
		int[] map=new int[256];
		Arrays.fill(map, -1);
		int len=0;
		int end=0;
		int pre=-1;//表示在以chas[i-1]为结尾的最长子串的最开始位置的前一位
		int cur=0;
		for(int i=0;i<chas.length;i++) {
			pre=Math.max(pre, map[chas[i]]);  //重复字符在pre之前不需要考虑，只考虑最右边的值
			cur=i-pre;
			if(cur>len) {
				len=cur;
				end=i;
			}
			map[chas[i]]=i;
		}
		
		return str.substring(end-len+1,end+1);
	}
	
	public static void main(String[] args) {
		System.out.println(getMaxUniqueSubStr("aabcb"));
	}
}
