package com.BitAlgorithms;
/**
 * hzy��jdk1.8
 */

/**
 * @author ����
 * @descripition �����καȽϷ���a��b�бȽϴ����,������ʹ��if��==�ȷ���
 * @ieda 1�����м���������ݷ����жϷ����ĸ�ֵ�����ܻ��������IntegerMax-IntegerMIN
 * 		 2�����ж��������ķ��ţ�����Ϊ�����Ǹ�����������������ͬ���������ţ����м������㣬�������
 */
public class GetMaxByBit {

	/**
	 * 
	 */
	public GetMaxByBit() {
		// TODO Auto-generated constructor stub
	}
	//�������
	public static int flip(int a) {
		return a^1;
	}
	//�ж�����������1����������0������
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
		int difab=sa^sb;//Ϊ0����ͬ�ţ�cû�������Ϊ1������ţ�c�������
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
