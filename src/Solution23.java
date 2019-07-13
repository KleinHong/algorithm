import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Solution23 {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}
	//最小堆法合并多链表
//    public ListNode mergeKLists(ListNode[] lists) {
//        if ( lists == null || lists.length == 0 ){
//            return null;
//        }
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
//        for (ListNode list : lists) {
//            if (list != null) {
//                queue.add(list);
//            }
//        }
//        ListNode res = new ListNode(0);
//        ListNode tail = null;
//        ListNode peek = queue.peek();
//        while (peek != null) {
//            if (tail == null){
//                res.next = peek;
//                tail = peek;
//            }else {
//                tail.next = peek;
//                tail = tail.next;
//            }
//            ListNode next = peek.next;
//            queue.poll();
//            if (next != null) {
//                queue.add(next);
//            }
//            peek = queue.peek();
//        }
//        return res.next;
//    }
	//归并法合并多链表
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length<=0) return null;
		int l=0,r=lists.length-1;
		return mergeLists(lists,l,r);
	}
	public ListNode mergeLists(ListNode[] lists,int begin,int end) {
		if(begin>end) return null;
		if(begin==end) return lists[begin];
		int mid=(begin+end)/2;
		ListNode l1=mergeLists(lists,begin,mid);
		ListNode l2=mergeLists(lists,mid+1,end);
		ListNode mer=merge(l1,l2);
		return mer;				
	}
	public ListNode merge(ListNode l1,ListNode l2) {
	ListNode head=new ListNode(0);
	ListNode l0=head;
	while(l1!=null && l2!=null){
		if(l1.val<l2.val) {
			l0.next=l1;
			l1=l1.next;				
		}
		else {
			l0.next=l2;
			l2=l2.next;
		}
		l0=l0.next;
	}
	if(l1!=null) {
		l0.next=l1;//链表操作一定要注意next
	}
	if(l2!=null) {
		l0.next=l2;
	}
	return head.next;
}
	//分治法解决链表合并问题
//	public ListNode mergeKLists(ListNode[] lists) {
//		int r=lists.length;	
//		ListNode l1=new ListNode(-1);		
//		if(lists.length<=0) return l1.next;
//		while(r>1) {  //使用分治法将时间复杂度降低为mlogn
//			int mid=(r+1)/2;
//			for(int i=0;i<r/2;i++) {
//				lists[i]=mergeList(lists[i],lists[i+mid]);
//			}
//			r=mid;
//		}
//		return lists[0];
//	}
//
//	
//	public ListNode mergeList(ListNode l1,ListNode l2) {
//		ListNode head=new ListNode(0);
//		ListNode l0=head;
//		while(l1!=null && l2!=null){
//			if(l1.val<l2.val) {
//				l0.next=l1;
//				l1=l1.next;				
//			}
//			else {
//				l0.next=l2;
//				l2=l2.next;
//			}
//			l0=l0.next;
//		}
//		if(l1!=null) {
//			l0.next=l1;//链表操作一定要注意next
//		}
//		if(l2!=null) {
//			l0.next=l2;
//		}
//		return head.next;
//	}

    public void getListNode(ListNode head) {
    	//head=head.next;
    	while(head!=null) {
    		System.out.print(head.val+" ");
    		head=head.next;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution23 s = new Solution23();
		ListNode l1=s.new ListNode(-1);
		ListNode l2=s.new ListNode(-1);
		ListNode bt1=l1;
		ListNode bt2=l2;
		Scanner in=new Scanner(System.in);
		for(int i=0;i<3;i++) {
			int temp=in.nextInt();
			bt1.next=s.new ListNode(temp);
			bt1=bt1.next;
		}
		for(int i=0;i<3;i++) {
			int temp=in.nextInt();
			bt2.next=s.new ListNode(temp);
			bt2=bt2.next;
		}
		ListNode[] lists= {l1.next,l2.next};
		s.getListNode(s.mergeKLists(lists));
//		
//		
//
//		s.getListNode(lists[0]);

	}
}
