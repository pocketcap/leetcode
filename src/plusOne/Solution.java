package plusOne;

public class Solution {
	public int[] plusOne(int[] digits) {
		int len = digits.length;
		boolean flag = true; // flag if the digit needs to be changed

		for (int i = len - 1; i >= 0; i--) {
			if (flag) {
				if (digits[i] == 9)
					digits[i] = 0;
				else {
					digits[i] = digits[i] + 1;
					flag = false;
				}

				if (i == 0 && digits[i] == 0) {
					int[] y = new int[len + 1];
					y[0] = 1;
					for (int j = 1; j <= len; j++) {
						y[j] = digits[j - 1];
					}
					digits = y;
				}
			}
		}
		return digits;
	}
}
