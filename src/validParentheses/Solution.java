package validParentheses;

import java.util.*;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 */

public class Solution {
	public boolean isValid(String s) {
		HashMap<Character, Character> pare = new HashMap<Character, Character>();
		pare.put('(', ')');
		pare.put('[', ']');
		pare.put('{', '}');
		if (s.length() % 2 != 0 || s.length() == 0) {
			return false;
		}
		Stack<Character> curr = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (pare.containsKey(s.charAt(i)))
				curr.push(s.charAt(i));
			else {
				if (curr.isEmpty())
					return false;
				char temp = curr.pop();
				if (s.charAt(i) != pare.get(temp))
					return false;
			}
		}
		if (!curr.isEmpty())
			return false;
		return true;
	}
}
