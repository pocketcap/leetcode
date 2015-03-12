package divideTwoInteger;

/**
 * Divide two integers without using multiplication, division and mod operator.
 */

public class Solution {
	public int divide(int dividend, int divisor) {
		long p = Math.abs((long) dividend);
		long q = Math.abs((long) divisor);
		int res = 0;
		while (p >= q) {
			int counter = 0;
			while (p >= (q << counter)) {
				counter++;
			}
			res += 1 << (counter - 1);
			p -= q << (counter - 1);
		}
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
			return res;
		else
			return -res;
	}
}
