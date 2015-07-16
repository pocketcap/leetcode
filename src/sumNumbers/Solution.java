package sumNumbers;

public class Solution {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		return dfs(root, 0);
	}

	public int dfs(TreeNode node, int num) {
		if (node == null)
			return 0;

		num = num * 10 + node.val;

		// leaf
		if (node.left == null && node.right == null) {
			return num;
		}

		// left subtree+ right subtree
		return dfs(node.left, num) + dfs(node.right, num);
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