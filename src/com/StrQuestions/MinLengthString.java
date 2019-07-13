package com.StrQuestions;
import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

/**
 * hzy£ºjdk1.8
 */

/**
 * @author ²ÐÔÂ
 * @descripition 
 * @ieda
 */
public class MinLengthString {
	public static int minLengthStr(String str1,String str2) {
		if(str1==null || str2==null || str1.length()<str2.length()) {
			return 0;
		}
		char[] chas1=str1.toCharArray();
		char[] chas2=str2.toCharArray();
		int[] map=new int[256];
		Arrays.fill(map, 0);
		for(char c:chas2) {
			map[c]++;
		}
		int left=0;
		int right=0;
		int match=chas2.length;
		int minLength=Integer.MAX_VALUE;
		while(right<chas1.length) {
			map[chas1[right]]--;
			if(map[chas1[right]]>=0) {
				match--;
			}
			if(match==0) {
				while(map[chas1[left]]<0) {
					map[chas1[left++]]++;
				}
				minLength=Math.min(minLength, right-left+1);
				System.out.println(str1.substring(left,right+1));
				
				match++;
				map[chas1[left++]]++;
			}
			right++;
		}
		return minLength==Integer.MIN_VALUE?0:minLength;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="abcdeace";
		String str2="ae";
		System.out.println(minLengthStr(str1, str2));
		
		

	}

}
