/*
 * 题目：求最大子矩阵的大小

 * 要求：给定一个整型数组，其中的值都是0或1，求其中全是1的子矩阵的最大
 * 区域大小
 * 思路：按行数从小到大开始遍历，使用height[]数据计算该行该列之前全1个数
 * 然后计算height数组能包围的最大面积。可以使用数据结构栈进行辅助计算。
 * 
 */
package com.StackAndQueue;
import java.util.Stack;

public class GetMaxMatrix {

	public GetMaxMatrix() {
		// TODO Auto-generated constructor stub
	}
	
	public int getMaxMatrix(int[][] mr) {
		int row=mr.length;
		int col=mr[0].length;
		if(mr==null || row==0 || col==0) {
			return 0;
		}
		int[] height=new int[col];
		int max=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				height[j]=mr[i][j]==1?(++height[j]):0;
			}
			max=Math.max(max, getMaxArea(height));			
		}
		
		return max;	
	}
	
	public int getMaxArea(int[] height) {
		int max=0;
		Stack<Integer> s=new Stack<>();
		for(int i=0;i<height.length;i++) {
			while(!s.isEmpty() && height[i]<=height[s.peek()]) {
				int j=s.pop();
				int k=s.size()==0?-1:s.peek();
				max=Math.max(max, height[j]*(i-k-1));
			}
			s.push(i);	
		}
		
		while(!s.isEmpty()) {
			int j=s.pop();
			int k=s.isEmpty()?-1:s.peek();
			max=Math.max(max, height[j]*(height.length-k-1));
		}
		
		return max;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height= {3,2,3,0};
		int[][] height1= {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
		GetMaxMatrix g=new GetMaxMatrix();
		System.out.print(g.getMaxMatrix(height1));
		System.out.println();
		System.out.print(g.getMaxArea(height));
	}

}
