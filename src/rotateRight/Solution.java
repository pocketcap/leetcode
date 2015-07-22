package rotateRight;

public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;

		ListNode walker = head;
		ListNode runner = head;
		int idx = 0;
		while (runner != null && idx < k) {
			runner = runner.next;
			idx++;
		}

		if (runner == null) {
			k %= idx;
			runner = head;
			idx = 0;
			while (runner != null && idx < k) {
				runner = runner.next;
				idx++;
			}
		}

		while (runner.next != null) {
			walker = walker.next;
			runner = runner.next;
		}
		runner.next = head;
		ListNode newHead = walker.next;
		walker.next = null;
		return newHead;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}