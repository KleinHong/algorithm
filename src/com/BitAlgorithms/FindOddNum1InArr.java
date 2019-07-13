package com.BitAlgorithms;
/**
 * hzy��jdk1.8
 */

/**
 * @author ����
 * @descripition ��һ������������һ�������������Σ�������������ż����
 * @ieda ����������ż���Σ��������������Ϊ0�����������ν�������������������������
 */
public class FindOddNum1InArr {

	/**
	 * @param args
	 */
	//������ֻ��һ�������������Σ���������Ϊż����
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
			o1^=n;//ʵ���������������������������
		}
		int tmp=o1&(~o1+1);//����o1���ұߵ�1����λ���������
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
