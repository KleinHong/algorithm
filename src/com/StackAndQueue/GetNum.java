/*
 * ��Ŀ�����ֵ��ȥ��СֵС�ڻ����num������������
 * Ҫ�����鳤��ΪN��Ҫ��ʵ��ʱ�临�Ӷ�ΪO(n)�Ľⷨ
 * ˼·�������������н��и���������һ������maxl��ÿһ��ѭ���ж���ͷ����
 * ���ֵ���±꣬����һ������minl����ͷ������Сֵ���±ꡣ���ڼ����������
 * �Ƿ����Ҫ��ǰ�ж϶����±��Ƿ��ڵ�ǰ�����鷶Χ�ڡ�
 * ֪ʶ�㣺����ΪN����������������Ϊ��N+1��*N/2.0��
 * 
 */
package com.StackAndQueue;
import java.util.LinkedList;

public class GetNum {

	public GetNum() {
		// TODO Auto-generated constructor stub
	}
	
	public int getNum(int[] arr, int num) {
		if(arr==null || arr.length==0) {
			return 0;
		}
		LinkedList<Integer> maxl=new LinkedList<>();
		LinkedList<Integer> minl=new LinkedList<>();
		int i=0;
		int res=0;
		while(i<arr.length) {
			int j=i;
			while(j<arr.length) {
				while(!maxl.isEmpty() && arr[j]>=arr[maxl.peekLast()]) {
					maxl.pollLast();
				}
				maxl.addLast(j);
				while(!minl.isEmpty() && arr[j]<=arr[minl.peekLast()]) {
					minl.pollLast();
				}
				minl.addLast(j);
				
				if(arr[maxl.peekFirst()]-arr[minl.peekFirst()]>num) {
					break;
				}
				j++;
			}
			
			if(maxl.peek()==i) {
				maxl.pollFirst();
			}
			if(minl.peekFirst()==i) {
				minl.pollFirst();
			}
			res+=j-i;
			i++;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {3,6,5};
		GetNum g=new GetNum();
		System.out.print(g.getNum(nums, 0));
		

	}

}
