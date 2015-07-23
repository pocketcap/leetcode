package zigzagLevelOrder;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null)
			return result;

		Stack<TreeNode> currLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();

		currLevel.push(root);
		boolean normalOrder = true;

		while (!currLevel.empty()) {
			ArrayList<Integer> currLevelResult = new ArrayList<Integer>();
			while (!currLevel.empty()) {
				TreeNode node = currLevel.pop();
				currLevelResult.add(node.val);
				if (normalOrder) {
					if (node.left != null)
						nextLevel.push(node.left);
					if (node.right != null)
						nextLevel.push(node.right);
				} else {
					if (node.right != null)
						nextLevel.push(node.right);
					if (node.left != null)
						nextLevel.push(node.left);
				}
			}
			result.add(currLevelResult);
			currLevel = nextLevel;
			nextLevel = new Stack<TreeNode>();
			normalOrder = !normalOrder;
		}
		return result;
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