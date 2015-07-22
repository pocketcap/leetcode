package reverseKGroup;

public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1)
			return head;
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode pre = h;
		int i = 0;
		while (head != null) {
			i++;
			if (i % k == 0) {
				pre = reverse(pre, head.next);
				head = pre.next;
			} else {
				head = head.next;
			}
		}
		return h.next;
	}

	// reverse a linked list between pre and next exclusively
	public ListNode reverse(ListNode pre, ListNode next) {
		ListNode last = pre.next;
		ListNode cur = last.next;
		while (cur != next) {
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = last.next;
		}
		return last;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}