package containerWithMostWater;

public class Solution {
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int res = 0;
		while (left < right) {
			int curr = (right - left) * Math.min(height[left], height[right]);
			res = Math.max(res, curr);
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return res;
	}
}
