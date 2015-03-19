package minDepthBT;

import java.util.LinkedList;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 */

public class Solution {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> counts = new LinkedList<Integer>();

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
				return count;
		}
		return 0;
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