package maxProduct;

public class Solution {
	public int maxProduct(int[] A) {
		if (A == null || A.length == 0)
			return 0;

		int maxLocal = A[0];
		int minLocal = A[0];
		int max = A[0];

		for (int i = 1; i < A.length; i++) {
			int tempMax = maxLocal;
			maxLocal = Math.max(Math.max(A[i], A[i] * maxLocal), A[i]
					* minLocal);
			minLocal = Math
					.min(Math.min(A[i], A[i] * tempMax), A[i] * minLocal);
			max = Math.max(maxLocal, max);
		}
		return max;
	}
}
