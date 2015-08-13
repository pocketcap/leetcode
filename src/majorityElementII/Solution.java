package majorityElementII;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		Integer n1 = null, n2 = null;
		int c1 = 0, c2 = 0;

		for (int i : nums) {
			if (n1 != null && i == n1)
				c1++;
			else if (n2 != null && i == n2)
				c2++;
			else if (c1 == 0) {
				n1 = i;
				c1 = 1;
			} else if (c2 == 0) {
				n2 = i;
				c2 = 1;
			} else {
				c1--;
				c2--;
			}
		}

		c1 = c2 = 0;

		for (int i : nums) {
			if (i == n1)
				c1++;
			else if (i == n2)
				c2++;
		}

		if (c1 > nums.length / 3)
			result.add(n1);

		if (c2 > nums.length / 3)
			result.add(n2);

		return result;
	}
}
