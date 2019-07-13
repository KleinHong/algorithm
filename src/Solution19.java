import java.util.Scanner;

public class Solution19 {
	
	  public class ListNode {
		     int val;
		      ListNode next;
		      public ListNode(int x) { val = x; }
		 }
		
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode bt=new ListNode(-1);
    	bt.next=head;
    	ListNode q=bt,s=bt;
    	if(head==null) return bt;
    	for(int i=0;i<=n;i++) {
    		q=q.next;
    	}
    	while(q!=null) {
    		q=q.next;
    		s=s.next;    		
    	}
    	s.next=s.next.next;
    	return bt.next;       
    }
    
    public void getListNode(ListNode head) {
    	//head=head.next;
    	while(head!=null) {
    		System.out.print(head.val+" ");
    		head=head.next;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution19 s=new Solution19();
		ListNode head=s.new ListNode(-1);
		ListNode bt=head;
		Scanner in=new Scanner(System.in);
		for(int i=0;i<5;i++) {
			int temp=in.nextInt();
			bt.next=s.new ListNode(temp);
			bt=bt.next;
		}
		in.close();
		ListNode ln=s.removeNthFromEnd(head.next, 1);
		s.getListNode(ln);
	}

}
