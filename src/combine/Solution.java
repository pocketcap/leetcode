package combine;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

		if (n <= 0 || n < k)
			return result;

		ArrayList<Integer> item = new ArrayList<Integer>();
		dfs(n, k, 1, item, result);
		return result;
	}

	private void dfs(int n, int k, int start, ArrayList<Integer> item,
			ArrayList<List<Integer>> res) {
		if (item.size() == k) {
			res.add(new ArrayList<Integer>(item));
			return;
		}

		for (int i = start; i <= n; i++) {
			item.add(i);
			dfs(n, k, i + 1, item, res);
			item.remove(item.size() - 1);
		}
	}
}
