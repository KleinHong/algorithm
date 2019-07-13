/*
 * ��Ŀ��һ��ջһ��ѹ��1��2��3��4��5,Ҫ��ֻʹ��ԭջ����ʹ��
 * �������ݽṹ��ֻʹ�õݹ麯��ʵ��
 * ˼·��ʹ�������ݹ麯��ʵ�֣���һ���ݹ麯����ȡջ��ײ����ݣ�����һ���ݹ麯��
 * �������������
 */
package com.StackAndQueue;
import java.util.Stack;

public class ReverseStack {
	
	private Stack<Integer> s;

	public ReverseStack() {
		// TODO Auto-generated constructor stub
		this.s=new Stack<Integer>();
	}
	public void add(int num) {
		// TODO Auto-generated constructor stub
		s.add(num);
	}
	public int pop() {
		// TODO Auto-generated constructor stub
		if(s.isEmpty()) {
			throw  new RuntimeException("��ǰջΪ��");
		}
		else {
			return s.pop();
		}
	}
	
	private int getFirstNum() {
		int result = s.pop();
		if(s.isEmpty()) {
			return result;	
		}
		
		int last=getFirstNum();
		s.push(result);
		return last;
	}
	public void reverse() {
		if(s.isEmpty()) {
			return;
		}
		int i=getFirstNum();
		reverse();
		s.push(i);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseStack rs=new ReverseStack();
		rs.add(1);
		rs.add(2);
		rs.add(3);
		rs.add(4);
		rs.add(5);
		
		rs.reverse();
		
		while(!rs.s.isEmpty()) {
			System.out.print(rs.pop()+" ");
		}
	}

}
