package sortedListToBST;

public class Solution {
	static ListNode h;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);

	}

	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}

	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
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

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}