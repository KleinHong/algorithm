/*
 * ��Ŀ����ʹ��һ����ջ�ͱ���������һ����ջ��������
 * Ҫ���ջ�׵�ջ����С����ʼ����
 */
package com.StackAndQueue;
import java.util.Stack;

public class SortStackByStack {

	public SortStackByStack(Stack<Integer> s) {
		// TODO Auto-generated constructor stub
		Stack<Integer> help=new Stack<Integer>();
		
		while(!s.isEmpty()){
			int cur=s.pop();
			if(help.isEmpty() || cur<=help.peek()) {
				help.add(cur);
			}
			else {
				while( !help.isEmpty() && cur>help.peek()) {
					s.push(help.pop());
				}
				help.add(cur);
			}
		}
		
		while(!help.isEmpty()) {
			s.push(help.pop());
		}
		
		while(!s.isEmpty()) {
			System.out.print(s.pop()+" ");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s1=new Stack<Integer>();
		for(int j=20;j>0;j--) {
			s1.push(j);
		}
		SortStackByStack a=new SortStackByStack(s1);
	}
	
}
