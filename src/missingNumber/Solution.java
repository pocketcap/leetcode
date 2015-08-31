package missingNumber;

public class Solution {
	public int missingNumber(int[] nums) {
		int l = nums.length;
		int sum = l * (l + 1) / 2;
		for (int i = 0; i < nums.length; i++) {
			sum -= nums[i];
		}
		return sum;
	}
}
