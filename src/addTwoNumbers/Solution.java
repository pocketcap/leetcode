package addTwoNumbers;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 */

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode curr = result;
		int carry = 0;
		int v1, v2;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				v1 = 0;
			} else {
				v1 = l1.val;
				l1 = l1.next;
			}
			if (l2 == null) {
				v2 = 0;
			} else {
				v2 = l2.val;
				l2 = l2.next;
			}
			int s = v1 + v2 + carry;
			carry = s / 10;
			ListNode e = new ListNode(s % 10);
			curr.next = e;
			curr = e;
		}
		if (carry > 0) {
			ListNode e = new ListNode(carry);
			curr.next = e;
		}
		return result.next;
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