package generateParentheses;

import java.util.ArrayList;

public class Solution {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		String temp = "";
		generatePare(n, 0, 0, temp, result);
		return result;
	}

	public void generatePare(int n, int open, int close, String temp,
			ArrayList<String> result) {
		// open parenthesis large or equal to close parenthesis
		if (open < close)
			return;
		// equal
		if (open == n && close == n) {
			result.add(temp);
			return;
		}
		// need to add more close parenthesis
		if (open == n) {
			generatePare(n, open, close + 1, temp+")", result);
			return;
		}

		generatePare(n, open + 1, close, temp+"(", result);
		generatePare(n, open, close + 1, temp+")", result);
	}
}
