package com.BitAlgorithms;
import javax.management.RuntimeErrorException;

/**
 * hzy：jdk1.8
 */

/**
 * @author 残月
 * @descripition 仅使用位运算实现加减乘除，不需要考虑数据溢出
 * @ieda
 */
public class Bityunsuan {
	
	public static int add(int m,int n) {
		int tmp=0;
		while(n!=0) {
			tmp=m;
			m=m^n;
			n=(n&tmp)<<1;
		}
		return m;
	}
	
	public static int minus(int m,int n) {
		return add(m,negNum(n));
	}
	private static int negNum(int n) {
		// TODO Auto-generated method stub
		return add(~n,1);
	}
	
	public static int multi(int m,int n) {
		int res=0;
		while(n!=0) {
			if((n&1)==1) {
				res=add(res,m);
			}
			m<<=1;
			n>>>=1;
		}
		return res;
	}
	
	//不适用int最小数，因为最小数的绝对值不能转换成正数
	public static  int div(int m,int n) {
		if(n==0) {
			return Integer.MAX_VALUE;
		}
		int res=0;
		boolean sign=isNeg(m)==isNeg(n);
		int x=isNeg(m)?m:minus(0,m);
		int y=isNeg(n)?n:minus(0,n);
		for(int i=31;i>-1;i=minus(i,1)) {
			if((x>>i)>=y) {
				res|=(1<<i);
				x=minus(x,y<<i);
			}
		}
		return sign?res:multi(res, -1);
		
		
	}
	
//	public static  int div(int m,int n) {
//		int x=isNeg(m)?negNum(m):m;
//		int y=isNeg(n)?negNum(n):n;
//		int res=0;
//		for(int i=31;i>-1;i=minus(i,1)) {
//			if((x>>i)>=y) {
//				res|=(1<<i);
//				x=minus(x,y<<i);
//			}
//		}
//		return isNeg(m)^isNeg(n)?negNum(res):res;
//		
//	}

	private static boolean isNeg(int m) {
		// TODO Auto-generated method stub
		return m>0;
	}
	
	
	public static int divide(int m,int n) {
		if(n==0) {
			throw new RuntimeException("除数为0");
		}
		if(m==Integer.MIN_VALUE && n==Integer.MIN_VALUE) {
			return 1;
		}else if(m==Integer.MIN_VALUE){
			int res=div(add(m,1),n);
			return add(res,div(minus(m,multi(n, res)),n));
		}else if(n==Integer.MIN_VALUE) {
			return 0;
		}else {
			return div(m,n);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(add(9, 5));
		System.out.println(minus(9,5));
		System.out.println(multi(-9,-5));
		System.out.println(div(9, Integer.MIN_VALUE));
		System.out.println(divide(Integer.MIN_VALUE,9));
	}

}
