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
		int pre=-1;//��ʾ����chas[i-1]Ϊ��β����Ӵ����ʼλ�õ�ǰһλ
		int cur=0;
		for(int i=0;i<chas.length;i++) {
			pre=Math.max(pre, map[chas[i]]);  //�ظ��ַ���pre֮ǰ����Ҫ���ǣ�ֻ�������ұߵ�ֵ
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
