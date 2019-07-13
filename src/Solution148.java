

public class Solution148 {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head, slow = head, fast = head;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		return merge(sortList(head), sortList(slow));
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		// TODO Auto-generated method stub
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = null;
		if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		ListNode cur = head;

		while (l1 != null || l2 != null) {
			while (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					cur.next = l1;
					l1 = l1.next;
				} else {
					cur.next = l2;
					l2 = l2.next;
				}
				cur = cur.next;
			}

			while (l1 != null) {
				cur.next = l1;
				cur=cur.next;
				l1=l1.next;
				
			}
			while (l2 != null) {
				cur.next = l2;
				cur=cur.next;
				l2=l2.next;
			}
		}
		return head;

	}

}
