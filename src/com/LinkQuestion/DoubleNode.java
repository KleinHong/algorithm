package com.LinkQuestion;

public class DoubleNode {

	public int value;
	DoubleNode pre;
	DoubleNode next;

	public DoubleNode(int value) {
		this.value = value;
	}
	
	public static DoubleNode getDoubleNode() {
		DoubleNode head=new DoubleNode(1);
		DoubleNode tmp=head;
		tmp.next=new DoubleNode(2);
		tmp.next.pre=tmp;
		tmp=tmp.next;
		tmp.next=new DoubleNode(3);
		tmp.next.pre=tmp;
		tmp=tmp.next;
		tmp.next=new DoubleNode(4);
		tmp.next.pre=tmp;
		tmp=tmp.next;
		tmp.next=new DoubleNode(5);
		tmp.next.pre=tmp;
		tmp=tmp.next;
		return head;
	}
}
