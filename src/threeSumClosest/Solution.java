package threeSumClosest;

import java.util.*;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers.
 */

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int result = Integer.MAX_VALUE;
		int minDist = Integer.MAX_VALUE;
		for (int i = 0; i < num.length - 2; i++) {
			int k = i + 1;
			int l = num.length - 1;
			while (k < l) {
				int curr = num[i] + num[k] + num[l];
				int dist = Math.abs(curr - target);
				if (dist < minDist) {
					minDist = dist;
					result = curr;
				}
				if (curr > target)
					l--;
				else
					k++;
			}
		}
		return result;
	}
}
