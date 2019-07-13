package com.LinkQuestion;

public class PrintCommonPart {

	public PrintCommonPart() {
		// TODO Auto-generated constructor stub
	}
	
	public void printCommonPart(Node head1,Node head2) {
		System.out.print("链表公共部分：");
		while(head1!=null && head2!=null) {
			if(head1.value<head2.value) {
				head1=head1.next;
			}
			else if(head1.value>head2.value) {
				head2=head2.next;
			}
			else {
				System.out.print(head1.value+"->");
				head1=head1.next;
				head2=head2.next;
			}
			
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1=new Node(1);
		Node tem1=head1;
		tem1.next=new Node(3);
		tem1=tem1.next;
		tem1.next=new Node(5);
		tem1=tem1.next;
		tem1.next=new Node(6);
		tem1=tem1.next;
		tem1.next=new Node(7);
		tem1=tem1.next;
		tem1.next=new Node(8);
		tem1=tem1.next;
		tem1.next=new Node(9);
		tem1=tem1.next;
		
		Node head2=new Node(2);
		Node tem2=head2;
		tem2.next=new Node(4);
		tem2=tem2.next;
		tem2.next=new Node(5);
		tem2=tem2.next;
		tem2.next=new Node(6);
		tem2=tem2.next;
		tem2.next=new Node(7);
		tem2=tem2.next;
		tem2.next=new Node(8);
		tem2=tem2.next;
		
		PrintCommonPart pcr=new PrintCommonPart();
		pcr.printCommonPart(head1, head2);
		
		
//		int max=Integer.MAX_VALUE;
//		System.out.print(max+1);
		
	}

}
