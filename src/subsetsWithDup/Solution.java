package subsetsWithDup;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if (nums == null)
			return null;

		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<List<Integer>> prev = new ArrayList<List<Integer>>();

		for (int i = nums.length - 1; i >= 0; i--) {
			// get existing sets
			if (i == nums.length - 1 || nums[i] != nums[i + 1]
					|| prev.size() == 0) {
				prev = new ArrayList<List<Integer>>();
				for (List<Integer> a : result) {
					prev.add(new ArrayList<Integer>(a));
				}
			}

			// add current number to each element of the set
			for (List<Integer> a : prev) {
				a.add(0, nums[i]);
			}

			// add each single number as a set, only if current element is
			// different with previous
			if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
				ArrayList<Integer> a = new ArrayList<Integer>();
				a.add(nums[i]);
				prev.add(a);
			}

			// add all set created in this iteration
			for (List<Integer> temp : prev) {
				result.add(new ArrayList<Integer>(temp));
			}
		}
		// add empty set
		result.add(new ArrayList<Integer>());

		return result;
	}
}
