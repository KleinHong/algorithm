package com.BitAlgorithms;
/*
 * 使用方法统计二进制数中1的个数
 */


public class Count1 {
	//当31位上是1是需要循环31次
	public static int count1(int n) {
		int res=0;
		while(n!=0) {
			res+=n&1;
			n>>>=1;
		}
		return res;
	}
// 消除最右边的1，有多少个1循环多少次
	public static int count2(int n) {
		int res=0;
		while(n!=0) {
			n&=(n-1);
			res++;
		}
		return res;
	}
	
	public static int count3(int n) {
		int res=0;
		while(n!=0) {
			n-=n&(~n+1);//获取最右边的1所在的位置所代表的数，通过减法消除
			res++;
		}
		return res;
	}
}
