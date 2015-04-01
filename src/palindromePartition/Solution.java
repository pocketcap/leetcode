package palindromePartition;

import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		if (s == null || s.length() == 0)
			return result;

		int length = s.length();
		int[][] table = new int[length][length];

		// l is length, i is index of left boundary, j is index of right
		// boundary
		for (int l = 1; l <= length; l++) {
			for (int i = 0; i < length; i++) {
				int j = i + l - 1;
				if (j > length - 1)
					break;
				if (s.charAt(i) == s.charAt(j)) {
					if (l == 1 || l == 2)
						table[i][j] = 1;
					else
						table[i][j] = table[i + 1][j - 1];
				} else {
					table[i][j] = 0;
				}
			}
		}
		ArrayList<String> temp = new ArrayList<String>();
		dfs(s, 0, table, result, temp);
		return result;
	}

	public void dfs(String s, int start, int[][] table,
			ArrayList<ArrayList<String>> result, ArrayList<String> temp) {
		if (start == s.length()) {
			ArrayList<String> tmp = new ArrayList<String>(temp);
			result.add(tmp);
			return;
		}
		for (int i = start; i <= s.length() - 1; i++) {
			if (table[start][i] == 1) {
				temp.add(s.substring(start, i + 1));
				dfs(s, i + 1, table, result, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
