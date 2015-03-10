package rotateArray;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 */
public class Solution {
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		if (nums == null || k < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] arr, int left, int right) {
		if (arr == null || arr.length == 1)
			return;
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}
