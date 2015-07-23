package isNumber;

// reference: https://leetcodenotes.wordpress.com/2013/11/23/leetcode-valid-number/

public class Solution {
	public boolean isNumber(String s) {
		if (s == null)
			return false;
		s = s.trim();

		if (s.length() > 0 && (s.charAt(s.length() - 1) == 'e'))
			return false;

		String[] t = s.split("e");
		if (t.length == 0 || t.length > 2)
			return false;

		boolean res = valid(t[0], false);
		if (t.length > 1)
			res = res && valid(t[1], true);
		return res;
	}

	public boolean valid(String s, boolean hasDot) {

		if (s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-'))
			s = s.substring(1);

		if (s.length() == 0 || s.equals("."))
			return false;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.') {
				if (hasDot)
					return false;
				hasDot = true;
			} else if (s.charAt(i) < '0' || s.charAt(i) > '9')
				return false;
		}
		return true;
	}
}
