package singleNumberIII;

/**
 * reference: https://leetcode.com/discuss/52757/16ms-c-solution
 * 
 */

public class Solution {
	public int[] singleNumber(int[] nums) {
		int[] res = new int[2];

		if (nums == null || nums.length == 0)
			return res;

		int xXorY = 0;
		for (int i : nums) {
			xXorY ^= i;
		}

		// get the number which contains a single one bit
		int lowestOneBit = xXorY & (~(xXorY - 1));

		// XOR all the numbers
		int x = 0;
		for (int i : nums) {
			if ((i & lowestOneBit) > 0)
				x ^= i;
		}

		int y = xXorY ^ x;

		res[0] = x;
		res[1] = y;
		return res;
	}
}
