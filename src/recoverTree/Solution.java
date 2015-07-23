package recoverTree;

public class Solution {
	TreeNode pre;
	TreeNode first;
	TreeNode second;

	public void recoverTree(TreeNode root) {
		pre = null;
		first = null;
		second = null;
		inorder(root);
		if (first != null && second != null) {
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
		}
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;

		inorder(root.left);
		if (pre == null)
			pre = root;
		else {
			if (pre.val > root.val) {
				if (first == null)
					first = pre;
				second = root;
			}
			pre = root;
		}
		inorder(root.right);
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