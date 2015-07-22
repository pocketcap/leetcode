package connect;

public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;

		TreeLinkNode lastHead = root; // previous level's head
		TreeLinkNode lastCurrent = null; // previous level's pointer
		TreeLinkNode currentHead = null; // current level's head
		TreeLinkNode current = null; // current level's pointer

		while (lastHead != null) {
			lastCurrent = lastHead;

			while (lastCurrent != null) {
				if (currentHead == null) {
					currentHead = lastCurrent.left;
					current = lastCurrent.left;
				} else {
					current.next = lastCurrent.left;
					current = current.next;
				}

				if (currentHead != null) {
					current.next = lastCurrent.right;
					current = current.next;
				}

				lastCurrent = lastCurrent.next;
			}
			lastHead = currentHead;
			currentHead = null;
		}
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}