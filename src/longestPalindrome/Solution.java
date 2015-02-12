package longestPalindrome;

import java.util.Arrays;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * reference: http://www.felix021.com/blog/read.php?2040
 */

public class Solution {
	public String longestPalindrome(String s) {
		String ps = preProcess(s);
		int n = ps.length();
		int[] p = new int[n];
		Arrays.fill(p, 0);
		int id = 0, mx = 0;
		char[] str = ps.toCharArray();
		for (int i = 1; i < n - 1; i++) {
			p[i] = (mx > i) ? Math.min(p[2 * id - i], mx - i) : 0;
			while (str[i + p[i] + 1] == str[i - p[i] - 1]) {
				p[i]++;

			}

			if (i + p[i] > mx) {
				mx = i + p[i];
				id = i;
			}
		}
		// Find the middle of the longest Palindrome
		int ix = 0;
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			if (p[i] > tmp) {
				tmp = p[i];
				ix = i;
			}
		}

		// Return longest Palindrome
		return ps.substring(ix - p[ix], ix + p[ix]).replace("#", "")
				.replace("^", "").replace("$", "");
	}

	public String preProcess(String s) {
		int n = s.length();
		if (n == 0)
			return "^$";
		String ret = "^";
		for (int i = 0; i < n; i++) {
			ret += "#" + s.charAt(i);
		}
		ret += "#$";
		return ret;
	}

	public static void main(String[] args) {
		String test = "aba";
		Solution slt = new Solution();
		System.out.println(slt.longestPalindrome(test));
	}
}
