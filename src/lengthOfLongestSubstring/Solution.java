package lengthOfLongestSubstring;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 */

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		char[] str = s.toCharArray();
		int left = 0;
		int right = 0;
		int maxLen = 0;
		boolean[] seen = new boolean[256]; // mark whether a character is
											// repeated
		while (right < s.length()) {
			// character marked before
			if (seen[str[right]]) {
				maxLen = Math.max(right - left, maxLen);
				while (str[left] != str[right]) {
					seen[str[left]] = false;
					left++;
				}
				right++;
				left++;
			} else {
				seen[str[right]] = true;
				right++;
			}
		}
		maxLen = Math.max(maxLen, s.length() - left);
		return maxLen;
	}
}
