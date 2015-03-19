package maxDepthBT;

import java.util.LinkedList;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 */

public class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> counts = new LinkedList<Integer>();
		int maxDepth = 0;

		nodes.add(root);
		counts.add(1);
		while (!nodes.isEmpty()) {
			TreeNode curr = nodes.remove();
			int count = counts.remove();

			if (curr.left != null) {
				nodes.add(curr.left);
				counts.add(count + 1);
			}

			if (curr.right != null) {
				nodes.add(curr.right);
				counts.add(count + 1);
			}

			if ((curr.left == null) && (curr.right == null))
				maxDepth = Math.max(count, maxDepth);
		}
		return maxDepth;
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