package detectCycle;

/**
 * 
 * reference:
 * http://fisherlei.blogspot.com/2013/11/leetcode-linked-list-cycle-ii
 * -solution.html
 */

public class Solution {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;

			if (fast != null)
				fast = fast.next;

			if (slow == fast)
				break;
		}

		if (fast == null)
			return null;

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}