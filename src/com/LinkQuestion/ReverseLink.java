package com.LinkQuestion;

public class ReverseLink {

	public ReverseLink() {
		// TODO Auto-generated constructor stub
	}
	
	public static Node reverseLink(Node head) {
		if(head==null || head.next==null) {
			return head;
		}
		Node next=null;
		Node pre=null;
		while(head!=null) {
			next=head.next;
			head.next=pre;
			pre=head;
			head=next;
		}
		return pre;
		
	}
	
	public static DoubleNode reverseLink(DoubleNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		DoubleNode next=null;
		DoubleNode pre=null;
		while(head!=null) {
			next=head.next;
			head.next=pre;
			head.pre=next;
			pre=head;
			head=next;
			
		}
		return pre;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Node head1=Node.getNode();
//		DoubleNode head2=DoubleNode.getDoubleNode();
//		PrintLink.print(head1);
//		System.out.println();
//		PrintLink.print(head2);
//		System.out.println();
//		head1=reverseLink(head1);
//		head2=reverseLink(head2);
//		PrintLink.print(head1);
//		System.out.println();
//		PrintLink.print(head2);
		
		
//		char[] a= {'1','0','0','1','f','t'};
//		a[1]=32;
//		a[2]=32;
//		System.out.print(String.valueOf(a).replaceAll(" ", ""));
		
		String a="abcd1";
		String b="cdab";
		System.out.print((b+b).contains(a));

	}

}
