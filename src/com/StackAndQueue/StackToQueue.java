/*
 * ��Ŀ:ʹ������ջʵ�ֶ���pop��poll��add����
 * ע��㣺����poll����popǰ�������жϴ��β��Ԫ�ص�ջ�Ƿ�Ϊ�գ�
 * ���жϴ��ͷԪ�ص�ջ�Ƿ�Ϊ�գ���Ϊʹ��&&����ʱ����ǰ���ж�����
 * ������ʱ����ֱ�ӵ��º�����ж�����ֱ�����������³�������쳣��
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
			throw new RuntimeException("��ǰ����Ϊ��");
		} else if(s_head.isEmpty()){

			while (!s_tail.isEmpty()) {
				s_head.push(s_tail.pop());
			}
		}
		return s_head.pop();

	}

	public int peek(){
		if (s_tail.isEmpty() && s_head.isEmpty() ) {
			throw new RuntimeException("��ǰ����Ϊ��");
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
