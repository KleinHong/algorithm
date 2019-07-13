/*
 * goal：求解栈中剩余元素中最小的那个数
 * method:使用两个栈实现，其中一个栈正常存放元素，另外一个
 * 存放当前栈中最小的元素，每次pop或push操作时，对两个栈同时操作
 * time：O(1)
 */
package com.StackAndQueue;

import java.util.EmptyStackException;
import java.util.Stack;

public class GetMinNumOfStack {

	private Stack<Integer> stack;
	private Stack<Integer> getMinStack;

	public GetMinNumOfStack() {
		this.stack = new Stack<>();
		this.getMinStack = new Stack<>();
	}

	public void push(int num) {
		if (getMinStack.isEmpty()) {
			getMinStack.push(num);
		} else {
			if (getMinStack.peek() > num) {
				getMinStack.push(num);
			} else {
				getMinStack.push(getMinStack.peek());
			}
		}
		stack.push(num);

	}

	public void pop() {
		try {
			getMinStack.pop();
			stack.pop();
		} catch (EmptyStackException e) {
			System.out.print("当前栈是空栈");
		}
	}

	public int getMin() throws EmptyStackException{
			return getMinStack.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetMinNumOfStack gmns = new GetMinNumOfStack();
		gmns.push(3);
		gmns.push(2);
		gmns.push(3);
		gmns.push(4);
		gmns.push(1);
		gmns.push(5);

		System.out.println(gmns.getMin());
		gmns.pop();
		System.out.println(gmns.getMin());
		gmns.pop();
		System.out.println(gmns.getMin());
		gmns.pop();
		System.out.println(gmns.getMin());
		gmns.pop();
		System.out.println(gmns.getMin());
		gmns.pop();
		System.out.println(gmns.getMin());
		gmns.pop();


	}

}
