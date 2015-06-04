package findMinII;

public class Solution {
	public int findMin(int[] nums) {
		return findMin(nums, 0, nums.length - 1);
	}

	public int findMin(int[] nums, int left, int right) {
		if (left == right)
			return nums[left];
		if (right - left == 1)
			return Math.min(nums[left], nums[right]);

		int middle = left + (right - left) / 2;

		if (nums[right] > nums[left])
			return nums[left];
		else if (nums[right] == nums[left])
			return findMin(nums, left + 1, right);
		else if (nums[left] <= nums[middle])
			return findMin(nums, middle, right);
		else
			return findMin(nums, left, middle);
	}
}
