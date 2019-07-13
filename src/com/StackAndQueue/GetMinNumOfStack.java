/*
 * goal�����ջ��ʣ��Ԫ������С���Ǹ���
 * method:ʹ������ջʵ�֣�����һ��ջ�������Ԫ�أ�����һ��
 * ��ŵ�ǰջ����С��Ԫ�أ�ÿ��pop��push����ʱ��������ջͬʱ����
 * time��O(1)
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
			System.out.print("��ǰջ�ǿ�ջ");
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
