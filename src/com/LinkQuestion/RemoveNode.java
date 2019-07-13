package com.LinkQuestion;

public class RemoveNode {

	public RemoveNode() {
		// TODO Auto-generated constructor stub
	}

	public static Node removeNode(Node head) {
		if (head == null) {
			return head;
		}

		if (head.next.next == null) {
			return head.next;
		}
		Node fast = head.next.next;
		Node slow = head;
		if (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		slow.next = slow.next.next;
		return head;
	}

	public static Node removeNode(Node head, int a, int b) {
		if (head == null || a < 1 || a < 1) {
			return head;
		}
		int n = 0;
		Node cur = head;
		while (cur != null) {
			n++;
			cur = cur.next;
		}

		n = (int) Math.ceil((double) (a * n) / (double) b);

		if (n == 1) {
			return head.next;
		}
		if (n > 1) {
			cur = head;
			while (--n != 1) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
	}

	public static void print(Node head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 构建单链表
		Node head1 = Node.getNode();
//				
		head1 = removeNode(head1, 4, 5);
		print(head1);

	}

}
