package flattenBinaryTreeToLinkedList;

import java.util.Stack;

public class Solution {
	public void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.empty()) {
			if (p.right != null) {
				stack.push(p.right);
			}

			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.empty()) {
				TreeNode temp = stack.pop();
				p.right = temp;
			}
			p = p.right;
		}
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
