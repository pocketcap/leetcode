package binaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * reference:
 * http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-
 * binary-tree-postorder-traversal-in-java/
 */

public class Solution {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		TreeNode prev = null;
		while (!stack.empty()) {
			TreeNode curr = stack.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null)
					stack.push(curr.left);
				else if (curr.right != null)
					stack.push(curr.right);
				else {
					stack.pop();
					res.add(curr.val);
				}
			} else if (curr.left == prev) {
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					res.add(curr.val);
				}
			} else if (curr.right == prev) {
				stack.pop();
				res.add(curr.val);
			}
			prev = curr;
		}
		return res;
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