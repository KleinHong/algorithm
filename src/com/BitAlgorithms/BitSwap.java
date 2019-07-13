package com.BitAlgorithms;

public class BitSwap {

	public BitSwap() {
		// TODO Auto-generated constructor stub
	}
	
	public static void bitSwap(int a,int b) {
		System.out.println(a);
		System.out.println(b);
		a=a^b;
		b=a^b;
		a=a^b;
		
		System.out.println(a);
		System.out.println(b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bitSwap(3, 5);
	}

}
