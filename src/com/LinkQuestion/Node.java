package com.LinkQuestion;

public class Node {
	public int value;

	public Node next;

	public Node(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public static Node getNode() {
		Node head=new Node(1);
		Node tmp=head;
		tmp.next=new Node(2);
		tmp=tmp.next;
		tmp.next=new Node(3);
		tmp=tmp.next;
		tmp.next=new Node(4);
		tmp=tmp.next;
		tmp.next=new Node(5);
		tmp=tmp.next;
		
		return head;
	}

}
