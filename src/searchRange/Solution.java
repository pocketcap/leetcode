package searchRange;

public class Solution {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		int startIndex = 0;
		int endIndex = nums.length - 1;
		int mid = -1;
		Boolean foundTarget = false;

		if (nums.length > 0) {
			while (startIndex <= endIndex) {
				mid = (startIndex + endIndex) / 2;

				if (target == nums[mid]) {
					foundTarget = true;
					break;
				}

				if (target < nums[mid])
					endIndex = mid - 1;
				else if (target > nums[mid])
					startIndex = mid + 1;
			}

			if (foundTarget) {
				startIndex = mid;
				endIndex = mid;

				while ((startIndex - 1) >= 0
						&& (nums[startIndex - 1] == target))
					startIndex--;

				while ((endIndex + 1) <= nums.length - 1
						&& (nums[endIndex + 1] == target))
					endIndex++;

				result[0] = startIndex;
				result[1] = endIndex;
			} else {
				result[0] = -1;
				result[1] = -1;
			}
		}

		return result;
	}
}
