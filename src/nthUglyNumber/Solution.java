package nthUglyNumber;

import java.util.ArrayList;

public class Solution {
	public int nthUglyNumber(int n) {
		int[] result = new int[n];
		result[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0;
		int f2 = 2, f3 = 3, f5 = 5;

		for (int i = 1; i < n; i++) {
			int min = Math.min(Math.min(f2, f3), f5);
			result[i] = min;

			if (f2 == min) {
				i2++;
				f2 = 2 * result[i2];
			}
			if (f3 == min) {
				i3++;
				f3 = 3 * result[i3];
			}
			if (f5 == min) {
				i5++;
				f5 = 5 * result[i5];
			}
		}
		return result[n - 1];
	}
}
