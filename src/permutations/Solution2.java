package permutations;

import java.util.ArrayList;

public class Solution2 {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permute(num, 0, result);
		return result;
	}

	public void permute(int[] num, int start,
			ArrayList<ArrayList<Integer>> result) {
		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		} else {
			for (int i = start; i < num.length; i++) {
				swap(num, start, i);
				permute(num, start + 1, result);
				swap(num, start, i);
			}
		}
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
