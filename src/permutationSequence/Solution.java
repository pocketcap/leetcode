package permutationSequence;

import java.util.ArrayList;

public class Solution {
	public String getPermutation(int n, int k) {
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);
		}
		k--;

		int mod = 1;
		for (int i = 1; i <= n; i++) {
			mod = mod * i;
		}

		String result = "";
		for (int i = 0; i < n; i++) {
			mod = mod / (n - i);
			int currIndex = k / mod;
			k = k % mod;

			result += numberList.get(currIndex);
			numberList.remove(currIndex);
		}
		return result;
	}
}
