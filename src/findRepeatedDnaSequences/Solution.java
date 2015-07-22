package findRepeatedDnaSequences;

import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();

		int len = s.length();
		if (len < 10)
			return result;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('T', 1);
		map.put('C', 2);
		map.put('G', 3);

		HashSet<Integer> temp = new HashSet<Integer>();
		HashSet<Integer> added = new HashSet<Integer>();

		int hash = 0;
		for (int i = 0; i < len; i++) {
			hash = (hash << 2) + map.get(s.charAt(i));
			if (i >= 9) {
				hash = hash & (1 << 20) - 1;
				if (temp.contains(hash) && !added.contains(hash)) {
					result.add(s.substring(i - 9, i + 1));
					added.add(hash);
				} else {
					temp.add(hash);
				}
			}
		}
		return result;
	}
}
