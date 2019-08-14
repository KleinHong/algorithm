package com.recursive;

import java.util.HashMap;
import java.util.Random;

public class MaxLenSubsequence {
	public static int getArr(int[] arr) {
		if (arr == null || arr.length < 1) {
			return 0;
		}
		int max=1;
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
				if(map.containsKey(arr[i]-1)) {
					max=Math.max(max, merge(map,arr[i]-1,arr[i]));
				}
				if(map.containsKey(arr[i]+1)) {
					max=Math.max(max, merge(map,arr[i],arr[i]+1));
				}
				
			}
		}
		int min=Integer.MAX_VALUE;
		for(int c:arr) {
			if(map.get(c)==max && min>=c) {
				min=c;
			}
		}
		for(int i=0;i<max;i++) {
			System.out.print((min++) +" ");
		}
		System.out.println();
		return max;
	}

	private static int merge(HashMap<Integer, Integer> map, int less, int more) {
		// TODO Auto-generated method stub
		//��ȡ�������п�ʼ��ֵleft
		int left=less-map.get(less)+1;
		//��ȡ�������н�����ֵright��
		int right=more+map.get(more)-1;
		int len=right-left+1;
		//��¼left��right�������е���󳤶�
		//ÿ����map�����Ԫ��ʱ����������������������Ԫ����
		map.put(left,len);
		map.put(right,len);
		return len;
	}

	public static void main(String[] args) {
//		int len = 5;
//		int[] arr = new int[len];
//		Random rm = new Random();
//		for (int i = 0; i < len; i++) {
//			arr[i] = rm.nextInt(1000);
//		}
		int[] arr= {100,4,200,1,3,2};
		System.out.println(getArr(arr));
	}
}
