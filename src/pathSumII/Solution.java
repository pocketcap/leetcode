package pathSumII;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;

		List<Integer> temp = new ArrayList<Integer>();
		temp.add(root.val);
		dfs(root, sum - root.val, result, temp);
		return result;
	}

	public void dfs(TreeNode t, int sum, ArrayList<List<Integer>> result,
			List<Integer> temp) {
		if (t.left == null && t.right == null && sum == 0) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.addAll(temp);
			result.add(l);
		}

		// search path of left node
		if (t.left != null) {
			temp.add(t.left.val);
			dfs(t.left, sum - t.left.val, result, temp);
			temp.remove(temp.size() - 1);
		}

		// search path of right node
		if (t.right != null) {
			temp.add(t.right.val);
			dfs(t.right, sum - t.right.val, result, temp);
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