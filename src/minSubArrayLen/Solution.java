package minSubArrayLen;

public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int result = nums.length;
		int i = 0;
		int sum = nums[0];

		for (int j = 0; j < nums.length;) {
			if (i == j) {
				if (nums[i] >= s)
					return 1;
				else {
					j++;
					if (j < nums.length) {
						sum = sum + nums[j];
					} else {
						return result;
					}
				}
			} else {
				if (sum >= s) {
					result = Math.min(j - i + 1, result);
					sum = sum - nums[i];
					i++;
				} else {
					j++;
					if (j < nums.length)
						sum = sum + nums[j];
					else {
						if (i == 0)
							return 0;
						else
							return result;
					}
				}
			}
		}
		return result;
	}
}
