
public class Solution21 {



	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; 
	      }
	 }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode(0);
        ListNode tem=l3;
        
        while(l1!=null && l2!=null) {
        	if(l1.val<l2.val) {
        		tem.next=l1;
        		l1=l1.next;
        	}
        	else {
        		tem.next=l2;
        		l2=l2.next;
        	}
        	tem=tem.next;
        }
        tem.next=(l1==null)?l2:l1; 
        return l3.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution21 a=new Solution21();
		ListNode l1=a.new ListNode(1),c1=l1;
		ListNode l2=a.new ListNode(1),c2=l2;
		c1=c1.next;
		c1=a.new ListNode(2);
		c1=c1.next;
		c1=a.new ListNode(4);
		
		c2=c2.next;
		c2=a.new ListNode(3);
		c2=c2.next;
		c2=a.new ListNode(4);
		System.out.print(a.mergeTwoLists(l1, l2).val);
	}
	  }

