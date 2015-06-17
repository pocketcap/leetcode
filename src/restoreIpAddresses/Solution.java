package restoreIpAddresses;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		ArrayList<String> t = new ArrayList<String>();
		dfs(result, s, 0, t);
		return result;
	}

	public void dfs(List<String> result, String s, int start,
			ArrayList<String> t) {
		// already get 4 numbers, but s left
		if (t.size() >= 4 && start != s.length())
			return;

		if ((t.size() + s.length() - start) < 4)
			return;

		// t's size is 4 and no remaining part that is not consumed
		if (t.size() == 4 && start == s.length()) {
			StringBuilder sb = new StringBuilder();
			for (String a : t) {
				sb.append(a + ".");
			}
			sb.setLength(sb.length() - 1);
			result.add(sb.toString());
			return;
		}

		for (int i = 1; i <= 3; i++) {
			// make sure the index is within the boundary
			if (start + i > s.length())
				break;

			// ignore 0X, 00X case;
			if (i > 1 && s.charAt(start) == '0')
				break;

			String sub = s.substring(start, start + i);

			// make sure each number <= 255
			if (Integer.valueOf(sub) > 255)
				break;

			t.add(sub);
			dfs(result, s, start + i, t);
			t.remove(t.size() - 1);
		}
	}
}
