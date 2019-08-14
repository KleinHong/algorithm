package com.recursive;

import java.util.Random;

public class ZhipaiBoyi {
	public static int win1(int[] arr) {
		if (arr == null || arr.length < 1) {
			return 0;
		}
		return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
	}
	//先拿的人去走一个过后就变成了后拿的，有两种方案俺，我们取其中最大的那个个
	private static int f(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		if(i==j) {
			return arr[i];
		}
		return Math.max(arr[i]+s(arr,i+1,j), arr[j]+s(arr,i,j-1));
	}
	//后拿的人拿走一个过后变成了先拿的，他要保证在在他之前拿到的那个人只能获得最小的值得
	private static int s(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		if(i==j) {
			return 0;
		}
		return Math.min(f(arr,i+1,j), f(arr, i, j-1));
	}
	
	public static int win2(int[] arr) {
		if (arr == null || arr.length < 1) {
			return 0;
		}
		int[][] f=new int[arr.length][arr.length];
		int[][] s=new int[arr.length][arr.length];
		for(int j=0;j<arr.length;j++) {
			f[j][j]=arr[j];
			for(int i=j-1;i>-1;i--) {
				f[i][j]=Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
				s[i][j]=Math.min(f[i+1][j], f[i][j-1]);
			}
		}
		return Math.max(f[0][arr.length-1], s[0][arr.length-1]);
	}
	
	public static void main(String[] args) {
		int len=30;
		int[] arr = new int[len];
		Random rm = new Random();
		for (int i = 0; i < len; i++) {
			arr[i] = rm.nextInt(1000) ;
		}
		long s1=System.currentTimeMillis();
		System.out.println(win1(arr));
		long e1=System.currentTimeMillis();
		System.out.println(e1-s1);
		
		long s2=System.currentTimeMillis();
		System.out.println(win2(arr));
		long e2=System.currentTimeMillis();
		System.out.println(e2-s2);
	}
}
