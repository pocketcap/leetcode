package fourSum;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 */

public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

		Arrays.sort(num);
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();

		for (int i = 0; i < num.length - 3; i++) {
			for (int j = i + 1; j < num.length - 2; j++) {
				int k = j + 1;
				int l = num.length - 1;

				while (k < l) {
					int sum = num[i] + num[j] + num[k] + num[l];

					if (sum > target) {
						l--;
					} else if (sum < target) {
						k++;
					} else {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[k]);
						temp.add(num[l]);
						if (!result.contains(temp)) {
							result.add(temp);
						}
						k++;
					}
				}
			}
		}
		return new ArrayList<ArrayList<Integer>>(result);
	}
}
