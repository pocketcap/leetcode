package isAnagram;

import java.util.Arrays;

public class Solution {
	public boolean isAnagram(String s, String t) {
		char[] s_chars = s.toCharArray();
		Arrays.sort(s_chars);
		String s_sorted = String.valueOf(s_chars);
		char[] t_chars = t.toCharArray();
		Arrays.sort(t_chars);
		String t_sorted = String.valueOf(t_chars);

		if (s_sorted.equals(t_sorted))
			return true;

		return false;
	}
}
