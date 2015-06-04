package largestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public String largestNumber(int[] nums) {
		String[] NUM = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			NUM[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(NUM, new Comparator<String>() {
			public int compare(String left, String right) {
				String leftRight = left + right;
				String rightLeft = right + left;
				return rightLeft.compareTo(leftRight);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < NUM.length; i++) {
			sb.append(NUM[i]);
		}
		java.math.BigInteger result = new java.math.BigInteger(sb.toString());
		return result.toString();
	}
}
