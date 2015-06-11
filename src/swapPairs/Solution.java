package swapPairs;

public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode p = h;

		while (p.next != null && p.next.next != null) {
			ListNode t1 = p; // track the node before the pair
			p = p.next;
			t1.next = p.next;

			ListNode t2 = p.next.next; // track the next node of the pair
			p.next.next = p;
			p.next = t2;
		}

		return h.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}