package letterCombinations;

import java.util.*;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 */

public class Solution {
	String[] keypad = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno",
			"pqrs", "tuv", "wxyz" };
	ArrayList<String> res = new ArrayList<String>();
	char[] curr, digit;

	public List<String> letterCombinations(String digits) {
		if(digits == null || digits.length() == 0)
			return res;
		curr = new char[digits.length()];
		digit = digits.toCharArray();
		solve(0);
		return res;
	}

	public void solve(int step) {
		if (step == curr.length) {
			res.add(new String(curr));
			return;
		}
		String currStep = keypad[digit[step] - '0'];
		for (int i = 0; i < currStep.length(); i++) {
			curr[step] = currStep.charAt(i);
			solve(step + 1);
		}
	}
}
