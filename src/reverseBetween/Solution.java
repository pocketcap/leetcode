package reverseBetween;

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;

		ListNode prev = null; // track (m-1)th node
		ListNode first = null; // mth
		ListNode second = null; // (n+1)th

		int i = 0;
		ListNode p = head;
		while (p != null) {
			i++;
			if (i == m - 1) {
				prev = p;
			}
			if (i == m) {
				first = p;
			}
			if (i == n) {
				second = p.next;
				p.next = null;
			}
			p = p.next;
		}

		if (first == null)
			return head;

		// reverse list[m, n]
		ListNode p1 = first;
		ListNode p2 = p1.next;
		p1.next = second;
		while (p1 != null && p2 != null) {
			ListNode t = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = t;
		}
		if (prev == null)
			return p1;
		else
			prev.next = p1;

		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}