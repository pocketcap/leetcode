package maxBTPathSum;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 */

public class Solution {
	int max;

	public int maxPathSum(TreeNode root) {
		max = (root == null) ? 0 : root.val;
		findMax(root);
		return max;
	}

	public int findMax(TreeNode node) {
		if (node == null)
			return 0;
		int left = Math.max(findMax(node.left), 0);
		int right = Math.max(findMax(node.right), 0);
		max = Math.max(node.val + left + right, max);
		return node.val + Math.max(left, right);
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
