package getIntersectionNode;

public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int len1 = 0;
		int len2 = 0;
		ListNode p1 = headA;
		ListNode p2 = headB;
		if (p1 == null || p2 == null)
			return null;

		while (p1 != null) {
			len1++;
			p1 = p1.next;
		}
		while (p2 != null) {
			len2++;
			p2 = p2.next;
		}
		int offset = 0;
		p1 = headA;
		p2 = headB;

		if (len1 > len2) {
			offset = len1 - len2;
			int i = 0;
			while (i < offset) {
				p1 = p1.next;
				i++;
			}
		} else {
			offset = len2 - len1;
			int i = 0;
			while (i < offset) {
				p2 = p2.next;
				i++;
			}
		}
		while (p1 != null && p2 != null) {
			if (p1.val == p2.val)
				return p1;
			else {
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		return null;
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