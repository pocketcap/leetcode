package mergeSortLinkedList;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 */

public class Solution {
	public static ListNode mergeSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		int len = 0;
		ListNode p = head;
		while (p != null) {
			len++;
			p = p.next;
		}
		int mid = len / 2;
		ListNode p2 = head;
		ListNode l = head, r = null;
		int count = 0;
		while (p2 != null) {
			count++;
			ListNode next = p2.next;
			if (count == mid) {
				p2.next = null;
				r = next;
			}
			p2 = next;
		}

		ListNode left = mergeSortList(l);
		ListNode right = mergeSortList(r);
		return merge(left, right);
	}

	public static ListNode merge(ListNode l, ListNode r) {
		ListNode p1 = l;
		ListNode p2 = r;
		ListNode fakeHead = new ListNode(100);
		ListNode pNew = fakeHead;

		while (p1 != null || p2 != null) {
			if (p1 == null) {
				pNew.next = new ListNode(p2.val);
				p2 = p2.next;
				pNew = pNew.next;
			} else if (p2 == null) {
				pNew.next = new ListNode(p1.val);
				p1 = p1.next;
				pNew = pNew.next;
			} else {
				if (p1.val < p2.val) {
					pNew.next = new ListNode(p1.val);
					p1 = p1.next;
					pNew = pNew.next;
				} else if (p1.val == p2.val) {
					pNew.next = new ListNode(p1.val);
					pNew.next.next = new ListNode(p2.val);
					pNew = pNew.next.next;
					p1 = p1.next;
					p2 = p2.next;
				} else {
					pNew.next = new ListNode(p2.val);
					p2 = p2.next;
					pNew = pNew.next;
				}
			}
		}
		return fakeHead.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);

		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		n1 = mergeSortList(n1);

		printList(n1);
	}

	public static void printList(ListNode x) {
		if (x != null) {
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}

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