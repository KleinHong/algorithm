/*
 * 题目:使用两个栈实现队列pop、poll、add功能
 * 注意点：进行poll或者pop前必须先判断存放尾部元素的栈是否为空；
 * 在判断存放头元素的栈是否为空，因为使用&&操作时，当前面判断条件
 * 不满足时，会直接导致后面的判断条件直接跳过，导致程序输出异常。
 * 
 */
package com.StackAndQueue;
import java.util.Stack;

public class StackToQueue {
	private Stack<Integer> s_tail;
	private Stack<Integer> s_head;

	public StackToQueue() {
		this.s_tail = new Stack<>();
		this.s_head = new Stack<>();
	}

	public void add(int num) {
			s_tail.push(num);
	}

	public int poll() {
		if (s_tail.isEmpty() && s_head.isEmpty()) {
			throw new RuntimeException("当前队列为空");
		} else if(s_head.isEmpty()){

			while (!s_tail.isEmpty()) {
				s_head.push(s_tail.pop());
			}
		}
		return s_head.pop();

	}

	public int peek(){
		if (s_tail.isEmpty() && s_head.isEmpty() ) {
			throw new RuntimeException("当前队列为空");
		} else if(s_head.isEmpty()){

			while (!s_tail.isEmpty()) {
				s_head.push(s_tail.pop());
			}
		}
		return s_head.peek();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackToQueue stq = new StackToQueue();
		stq.add(1);
		stq.add(3);
		stq.add(2);
		stq.add(5);
		stq.add(6);

		System.out.print(stq.peek() + " ");
		System.out.println(stq.poll());
		System.out.print(stq.peek() + " ");
		System.out.println(stq.poll());
		System.out.print(stq.peek() + " ");
		System.out.println(stq.poll());
		System.out.print(stq.peek() + " ");
		System.out.println(stq.poll());
		System.out.print(stq.peek() + " ");
		System.out.println(stq.poll());
		System.out.print(stq.peek() + " ");
		System.out.println(stq.poll());

	}

}
