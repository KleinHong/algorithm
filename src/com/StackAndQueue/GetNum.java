/*
 * 题目：最大值减去最小值小于或等于num的子数组数量
 * 要求：数组长度为N，要求实现时间复杂度为O(n)的解法
 * 思路：采用两个队列进行辅助；其中一个队列maxl在每一次循环中队列头保存
 * 最大值的下标，另外一个队列minl队列头保存最小值的下标。并在计算该子数组
 * 是否符合要求前判断队列下标是否在当前子数组范围内。
 * 知识点：长度为N的数组连续子数组为（N+1）*N/2.0。
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
