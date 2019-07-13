package com.OtherAlgorithms;
/**
 * hzy£ºjdk1.8
 */

/**
 * @author ²ÐÔÂ
 * @descripition 
 * @ieda
 */
public class Gcd {
	
	public static int gcd(int m,int n) {
		return n==0?m:gcd(n,m%n);
	}
	
	public static int gcd3(int a,int b,int c) {
		int temp=gcd(a,b);
		return gcd(temp,c);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(5,8));
		System.out.println(gcd3(12,9,24));
		
	}

}
