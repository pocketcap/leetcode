package permutationsII;

import java.util.ArrayList;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 */

public class Solution {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permuteUnique(num, 0, result);
		return result;
	}

	public void permuteUnique(int[] num, int start,
			ArrayList<ArrayList<Integer>> result) {
		if (start >= num.length) {
			ArrayList<Integer> temp = convertArrayToList(num);
			result.add(temp);
		} else {
			for (int i = start; i < num.length; i++) {
				if (containDuplicate(num, start, i)) {
					swap(num, start, i);
					permuteUnique(num, start + 1, result);
					swap(num, start, i);
				}
			}
		}
	}

	public boolean containDuplicate(int[] num, int start, int end) {
		for (int i = start; i <= end - 1; i++) {
			if (num[i] == num[end]) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			item.add(num[i]);
		}
		return item;
	}

	public void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
