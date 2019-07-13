package com.LinkQuestion;

public class RemoveLastKthNode {

	public RemoveLastKthNode() {
		// TODO Auto-generated constructor stub
	}
	
	public static Node removeLastKthNode(Node head,int k) {
		if(head==null || k<1) {
			return head;
		}
		Node cur=head;
		while(cur!=null) {
			k--;
			cur=cur.next;
		}
		if(k==0){
			head=head.next;
		}
		if(k<0) {
			cur=head;
			while(++k!=0) {
				cur=cur.next;
			}
			cur.next=cur.next.next;
		}
		return head;
	}
	
	public static DoubleNode removeLastKthDoubleNode(DoubleNode head,int k) {
		if(head==null || k<1) {
			return head;
		}
		DoubleNode cur=head;
		while(cur!=null) {
			k--;
			cur=cur.next;
		}
		
		if(k==0) {
			head=head.next;
			head.pre=null;
		}
		if(k<0) {
			cur=head;
			while(++k!=0) {
				cur=cur.next;
			}
			cur.next=cur.next.next;
			cur.next.pre=cur;
		}
		
		return head;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//构建单链表
		Node head1=Node.getNode();
		
		//构建双链表
		DoubleNode head2=DoubleNode.getDoubleNode();
		
		PrintLink.print(head1);
		System.out.println();
		head1=removeLastKthNode(head1,2);
		PrintLink.print(head1);
		System.out.println();
		System.out.println("=================");
		
		PrintLink.print(head2);
		System.out.println();
		head2=removeLastKthDoubleNode(head2,2);
		PrintLink.print(head2);
		System.out.println();
		
		
	}

}
