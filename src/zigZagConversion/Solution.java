package zigZagConversion;

public class Solution {
	public String convert(String s, int nRows) {
		if (nRows <= 1)
			return s;
		String result = "";
		for (int i = 0; i < nRows; i++) {
			for (int j = 0, index = i; index < s.length(); j++, index = i + j
					* (2 * nRows - 2)) {
				result += s.charAt(index);
				if (i != 0 && i != nRows - 1) {
					if (index + 2 * nRows - 2 - 2 * i < s.length()) {
						result += s.charAt(index + 2 * nRows - 2 - 2 * i);
					}
				}
			}
		}
		return result;
	}
}
