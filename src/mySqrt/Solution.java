package mySqrt;

public class Solution {
	public int mySqrt(int x) {
		if (x < 0)
			return -1;
		if (x == 0)
			return 0;
		long l = 1;
		long r = x / 2 + 1;
		while (l <= r) {
			long m = (l + r) / 2;
			if (m * m == x)
				return (int) m;
			if (m * m < x)
				l = m + 1;
			else
				r = m - 1;
		}
		return (int) r;
	}
}
