package com.BitAlgorithms;
/**
 * hzy：jdk1.8
 */

/**
 * @author 残月
 * @descripition 不用任何比较返回a、b中比较大的数,即不能使用if、==等符号
 * @ieda 1、进行减法运算根据符号判断返回哪个值，可能会有溢出如IntegerMax-IntegerMIN
 * 		 2、先判断两个数的符号，返回为正的那个数，若两数符号相同，保留符号，进行减法运算，不会溢出
 */
public class GetMaxByBit {

	/**
	 * 
	 */
	public GetMaxByBit() {
		// TODO Auto-generated constructor stub
	}
	//做异或处理
	public static int flip(int a) {
		return a^1;
	}
	//判断数字正负，1代表正数，0代表负数
	public static int getSign(int a) {
		return flip((a>>31)&1);
	}
	public static int getMax1(int a,int b) {
		int c=a-b;
		int sign1=getSign(c);
		int sign2=flip(sign1);
		return sign1*a+sign2*b;
	}
	
	public static int getMax2(int a,int b) {
		int sa=getSign(a);
		int sb=getSign(b);
		int c=a-b;
		int sc=getSign(c);
		int difab=sa^sb;//为0代表同号，c没有溢出，为1代表异号，c可能溢出
		int samesb=flip(difab);
		int returnA=difab*sa+samesb*sc;
		int returnB=flip(returnA);
		return a*returnA+b*returnB;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMax1(Integer.MAX_VALUE, Integer.MIN_VALUE));
		System.out.println(getMax2(Integer.MAX_VALUE, Integer.MIN_VALUE));

	}

}
