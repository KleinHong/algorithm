package com.BitAlgorithms;
/*
 * ʹ�÷���ͳ�ƶ���������1�ĸ���
 */


public class Count1 {
	//��31λ����1����Ҫѭ��31��
	public static int count1(int n) {
		int res=0;
		while(n!=0) {
			res+=n&1;
			n>>>=1;
		}
		return res;
	}
// �������ұߵ�1���ж��ٸ�1ѭ�����ٴ�
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
			n-=n&(~n+1);//��ȡ���ұߵ�1���ڵ�λ�������������ͨ����������
			res++;
		}
		return res;
	}
}
