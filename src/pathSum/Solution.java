package pathSum;

import java.util.LinkedList;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 */

public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> values = new LinkedList<Integer>();

		nodes.add(root);
		values.add(root.val);

		while (!nodes.isEmpty()) {
			TreeNode curr = nodes.poll();
			int currSum = values.poll();

			if ((curr.left == null) && (curr.right == null) && (currSum == sum)) {
				return true;
			}
			if (curr.left != null) {
				nodes.add(curr.left);
				values.add(currSum + curr.left.val);
			}
			if (curr.right != null) {
				nodes.add(curr.right);
				values.add(currSum + curr.right.val);
			}
		}

		return false;
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