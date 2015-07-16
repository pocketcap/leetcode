package nextPermutation;

/*
 * reference: http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html
 */

public class Solution {
	public void nextPermutation(int[] nums) {
		int i = 0;
		int j = 0;
		// from right to left, find the first one that is not in ascending trend
		for (i = nums.length - 2; i >= 0; i--) {
			if (nums[i] >= nums[i + 1])
				continue;
			// from right to left, find the first one that is larger than
			// nums[i]
			for (j = nums.length - 1; j > i; j--) {
				if (nums[j] > nums[i])
					break;
			}
			break;
		}

		// if i is found, swap the numbers on the position i and j
		if (i >= 0) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}

		// reverse the numbers which are on the right of i
		int start = i + 1;
		int end = nums.length - 1;
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
