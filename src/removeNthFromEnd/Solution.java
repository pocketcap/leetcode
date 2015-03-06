package removeNthFromEnd;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode res = new ListNode(0);
		res.next = head;
		ListNode first = res;
		ListNode second = res;
		for (int i = 0; i <= n; i++) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return res.next;
	}
}
