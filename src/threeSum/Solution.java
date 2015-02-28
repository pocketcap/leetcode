package threeSum;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */

public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
		for (int i = 0; i < num.length - 2; i++) {
			int k = i + 1;
			int l = num.length - 1;
			while (k < l) {
				int sum = num[i] + num[k] + num[l];
				if (sum > 0) {
					l--;
				} else if (sum < 0) {
					k++;
				} else {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(num[i]);
					temp.add(num[k]);
					temp.add(num[l]);
					if (!result.contains(temp)) {
						result.add(temp);
					}
					k++;
				}
			}
		}
		return new ArrayList<ArrayList<Integer>>(result);
	}
}
