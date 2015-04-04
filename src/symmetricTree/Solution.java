package symmetricTree;

public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		else if (left == null || right == null)
			return false;

		if (left.val != right.val)
			return false;

		if (!isSymmetric(left.right, right.left))
			return false;
		if (!isSymmetric(left.left, right.right))
			return false;

		return true;
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