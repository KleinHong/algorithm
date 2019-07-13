

public class Solution24 {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}
    public ListNode reverseKGroup(ListNode head, int k) {

    	//判断是否链表长度不足k
    	ListNode tempt=head;
    	for(int i=0;i<k;i++) {
    		if(tempt==null)
    			return head;
    		tempt=tempt.next;
    	}
    	
    	//进行k长翻转链表
    	ListNode tail=null;
    	ListNode first=head;
    	ListNode second=head.next;
    	for(int j=0;j<k;j++) {
    		tail=second.next;
    		second.next=first;
    		first=second;
    		second=tail;
    	}
    	head.next=reverseKGroup(second,k);//此处的head织带第一次循环前的链表头结点
    	
        return first;
        
    }
	
    public ListNode swapPairs(ListNode head) {
        ListNode dummyhead=new ListNode(-1);
        dummyhead.next=head; 
        ListNode p=dummyhead;
        //持续交换相邻节点
        while(p.next!=null && p.next.next!=null) {
        	 ListNode pfirst=p.next;
        	 ListNode psecond=p.next.next;
        	 ListNode temp=psecond.next;
        	 p.next=psecond;
        	 psecond.next=pfirst;
        	 pfirst.next=temp;
        	 p=pfirst;        	        	
        }        
        return  dummyhead.next;
    }
}
