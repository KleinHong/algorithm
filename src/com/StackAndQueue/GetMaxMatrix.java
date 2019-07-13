/*
 * ��Ŀ��������Ӿ���Ĵ�С

 * Ҫ�󣺸���һ���������飬���е�ֵ����0��1��������ȫ��1���Ӿ�������
 * �����С
 * ˼·����������С����ʼ������ʹ��height[]���ݼ�����и���֮ǰȫ1����
 * Ȼ�����height�����ܰ�Χ��������������ʹ�����ݽṹջ���и������㡣
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
