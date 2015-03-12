package wordBreakII;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 */

public class Solution {
	public List<String> wordBreak(String s, Set<String> dict) {
		List<String>[] t = new ArrayList[s.length() + 1];
		t[0] = new ArrayList<String>();

		for (int i = 0; i < s.length(); i++) {
			if (t[i] == null)
				continue;
			for (String word : dict) {
				int len = word.length();
				int end = i + len;
				if (end > s.length())
					continue;
				if (s.substring(i, end).equals(word)) {
					if (t[end] == null)
						t[end] = new ArrayList<String>();
					t[end].add(word);
				}
			}
		}

		List<String> res = new LinkedList<String>();
		if (t[s.length()] == null)
			return res;
		ArrayList<String> temp = new ArrayList<String>();
		dfs(t, s.length(), res, temp);
		return res;
	}

	public void dfs(List<String> t[], int end, List<String> res,
			ArrayList<String> temp) {
		if (end <= 0) {
			String path = temp.get(temp.size() - 1);
			for (int i = temp.size() - 2; i >= 0; i--) {
				path += " " + temp.get(i);
			}
			res.add(path);
			return;
		}

		for (String word : t[end]) {
			temp.add(word);
			dfs(t, end - word.length(), res, temp);
			temp.remove(temp.size() - 1);
		}
	}
}
