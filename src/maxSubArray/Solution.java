package maxSubArray;

public class Solution {
	public int maxSubArray(int[] A) {
		int sum = A[0];
		int newSum = A[0];
		for (int i = 1; i < A.length; i++) {
			newSum = Math.max(A[i], newSum + A[i]);
			sum = Math.max(sum, newSum);
		}
		return sum;
	}
}
