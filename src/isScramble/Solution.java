package isScramble;

import java.util.Arrays;

// reference: http://www.cnblogs.com/yuzhangcmu/p/4189152.html

public class Solution {
	public boolean isScramble(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;

		int len1 = s1.length();
		int len2 = s2.length();

		if (len1 != len2)
			return false;

		return rec(s1, s2);
	}

	public boolean rec(String s1, String s2) {
		int len = s1.length();

		if (len == 1) {
			return s1.equals(s2);
		}

		// sort to speed up
		char[] s1ch = s1.toCharArray();
		Arrays.sort(s1ch);
		String s1Sort = new String(s1ch);

		char[] s2ch = s2.toCharArray();
		Arrays.sort(s2ch);
		String s2Sort = new String(s2ch);

		if (!s1Sort.equals(s2Sort))
			return false;

		for (int i = 1; i < len; i++) {
			if (rec(s1.substring(0, i), s2.substring(0, i))
					&& rec(s1.substring(i, len), s2.substring(i, len)))
				return true;

			if (rec(s1.substring(0, i), s2.substring(len - i, len))
					&& rec(s1.substring(i, len), s2.substring(0, len - i)))
				return true;
		}

		return false;
	}
}
