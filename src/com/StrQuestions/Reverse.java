package com.StrQuestions;
/**
 * hzy£ºjdk1.8
 */

/**
 * @author ²ÐÔÂ
 * @descripition 
 * @ieda
 */
public class Reverse {
	
	public static String rotateWord1(String str) {
		if(str==null || str.length()<=1) {
			return str;
		}
		str=reverse(str);
		String[] strs=str.split(" ");
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<strs.length;i++) {
			if(i==strs.length-1) {
				sb.append(reverse(strs[i]));
			}
			else {
				sb.append(reverse(strs[i])+" ");
			}
		}
		return sb.toString();
	}

	private static String reverse(String str) {
		// TODO Auto-generated method stub
		char[] chas=str.toCharArray();
		int l=0;
		int r=chas.length-1;
		while(l<r) {
			swap(chas,l,r);
			l++;
			r--;
		}
		return new String(chas);
	}

	private static void swap(char[] chas, int l, int r) {
		// TODO Auto-generated method stub
		char tmp=chas[l];
		chas[l]=chas[r];
		chas[r]=tmp;
	}
	
	
	public static String rotateWord2(String str,int k) {
		if(str == null || str.equals("") || k>=str.length()
				) {
			return str;
		}
		String s1=reverse(str.substring(0, k));
		String s2=reverse(str.substring(k));
		str=s1+s2;
		return reverse(str);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="I'm a student.";
		System.out.println(rotateWord1(str));
		String str1="abc1234.";
		System.out.println(rotateWord2(str1,3));
		
	}

}
