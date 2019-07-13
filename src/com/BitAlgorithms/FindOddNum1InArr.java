package com.BitAlgorithms;
/**
 * hzy：jdk1.8
 */

/**
 * @author 残月
 * @descripition 在一个数组中有有一个数出现奇数次，其他数都出现偶数次
 * @ieda 其他数出现偶数次，进行与或运算结果为0，出现奇数次进行与或运算结果就是这个数本身
 */
public class FindOddNum1InArr {

	/**
	 * @param args
	 */
	//数组中只有一个数出现奇数次，其他数均为偶数次
	public static void printOddNum1(int[] arr) {
		int res=0;
		for(int n:arr) {
			res^=n;
		}
		System.out.println(res);
	}
	
	public static void printOddNum2(int[] arr) {
		int o1=0,o2=0;
		for(int n:arr) {
			o1^=n;//实际上是两个出现奇数次数异或结果
		}
		int tmp=o1&(~o1+1);//保留o1最右边的1所在位数代表的数
		for(int n:arr) {
			if((n&tmp)!=0) {
				o2^=n;
			}
		}
		
//		System.out.println(o2+" "+(o1^o2));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1= {1,1,2,2,3,3,4};
		int[] arr2= {1,1,2,2,3,4,};
		printOddNum1(arr1);
		printOddNum2(arr2);
	}

}
