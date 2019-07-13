package com.LinkQuestion;

public class PrintLink {

	public PrintLink() {
		// TODO Auto-generated constructor stub
	}

	public static void print(Node head) {
		while(head!=null) {
			System.out.print(head.value +" ");
			head=head.next;
		}
	}
	
	public static void print(DoubleNode head) {
		while(head!=null) {
			System.out.print(head.value +" ");
			head=head.next;
		}
	}

}
