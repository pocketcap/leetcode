package binaryTreePaths;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if (root == null)
			return result;
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(root.val);
		dfs(root, result, temp);
		return result;
	}

	public void dfs(TreeNode t, List<String> result, List<Integer> temp) {
		if (t.left == null && t.right == null) {
			StringBuilder s = new StringBuilder();
			for (Integer i : temp) {
				s.append(String.valueOf(i) + "->");
			}
			result.add(s.substring(0, s.length() - 2));
		}

		if (t.left != null) {
			temp.add(t.left.val);
			dfs(t.left, result, temp);
			temp.remove(temp.size() - 1);
		}

		if (t.right != null) {
			temp.add(t.right.val);
			dfs(t.right, result, temp);
			temp.remove(temp.size() - 1);
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