/*
 * 题目：一个栈一次压入1、2、3、4、5,要求只使用原栈，不使用
 * 其他数据结构，只使用递归函数实现
 * 思路：使用两个递归函数实现，第一个递归函数获取栈最底层数据，另外一个递归函数
 * 进行逆序操作。
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
			throw  new RuntimeException("当前栈为空");
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
