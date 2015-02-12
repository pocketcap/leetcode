package reverseInteger;

public class Solution {
	public int reverse(int x) {
		long result = 0;
		int number = Math.abs(x);
		int lastDigit = 0;
		while (number > 0) {
			lastDigit = number - number / 10 * 10;
			result = result * 10 + lastDigit;
			number /= 10;
		}
		if (x < 0)
			result = -1 * result;
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) result;
	}
}
