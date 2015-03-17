package mergeSortedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 */

public class Solution {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.size() == 0)
			return null;

		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						if (a.val > b.val)
							return 1;
						else if (a.val == b.val)
							return 0;
						else
							return -1;
					}
				});

		// add first node of each list to the queue
		for (ListNode l : lists) {
			if (l != null) {
				q.add(l);
			}
		}

		ListNode head = new ListNode(0);
		ListNode p = head;

		while (q.size() > 0) {
			ListNode temp = q.poll();
			p.next = temp;

			if (temp.next != null)
				q.add(temp.next);

			p = p.next;
		}

		return head.next;
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