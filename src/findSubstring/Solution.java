package findSubstring;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.length == 0)
			return result;

		// frequency of words
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String w : words) {
			if (map.containsKey(w))
				map.put(w, map.get(w) + 1);
			else
				map.put(w, 1);
		}

		int n = words.length, m = words[0].length(), l = s.length();
		int i = 0;
		while (l - i >= m * n) {
			HashMap<String, Integer> temp = new HashMap<String, Integer>(map);
			for (int j = 0; j < n; j++) {
				String tempStr = s.substring(i + j * m, i + (j + 1) * m);
				if (temp.containsKey(tempStr)) {
					if (temp.get(tempStr) == 1)
						temp.remove(tempStr);
					else
						temp.put(tempStr, temp.get(tempStr) - 1);
				} else
					break;
			}
			if (temp.size() == 0)
				result.add(i);
			i++;
		}
		return result;
	}
}
