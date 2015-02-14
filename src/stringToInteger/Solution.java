package stringToInteger;

public class Solution {
	public int atoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		str = str.trim();
		double result = 0;
		char flag = '+';
		int i = 0;
		if (str.charAt(i) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(i) == '+')
			i++;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = str.charAt(i) - '0' + result * 10;
			i++;
		}
		if (flag == '-') {
			result *= -1;
		}
		if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return (int) result;
	}
}
