class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution86 {
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return head;
		}
		ListNode low = null;
		ListNode high = null;
		ListNode lowTail = null;
		ListNode highTail = null;
		ListNode next;

		while (head != null) {
			next = head.next;
			if (head.val < x) {
				if (lowTail == null) {
					low = head;
					lowTail = head;
				} else {
					lowTail.next = head;
					lowTail = lowTail.next;
				}
			} else {
				if (highTail == null) {
					high = head;
					highTail = head;
				} else {
					highTail.next = head;
					highTail = highTail.next;
				}
			}
			head = next;
		}
		if (low == null) {
			highTail.next = null;
			return high;
		} else {
			lowTail.next = high;
			if (highTail != null) {
				highTail.next = null;
			}
			return low;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode cur = head;
		cur.next = new ListNode(4);
		cur = cur.next;
		cur.next = new ListNode(3);
		cur = cur.next;
		cur.next = new ListNode(2);
		cur = cur.next;
		cur.next = new ListNode(5);
		cur = cur.next;
		cur.next = new ListNode(2);

		Solution86 s86 = new Solution86();
		head = s86.partition(head, 3);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
}
