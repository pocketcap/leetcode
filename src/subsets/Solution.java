package subsets;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		if (nums == null)
			return null;

		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

			for (List<Integer> a : result) {
				temp.add(new ArrayList<Integer>(a));
			}
			for (List<Integer> a : temp) {
				a.add(nums[i]);
			}

			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(nums[i]);
			temp.add(single);
			result.addAll(temp);
		}
		// add empty set
		result.add(new ArrayList<Integer>());

		return result;
	}
}
