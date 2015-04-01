package jumpGame;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 */

public class Solution {
	public boolean canJump(int[] A) {
		if (A.length <= 1)
			return true;

		int max = A[0];

		for (int i = 0; i < A.length; i++) {
			// if not enough to go the next
			if (max <= i && A[i] == 0)
				return false;

			// update max
			if (i + A[i] > max) {
				max = i + A[i];
			}

			// reach last index
			if (max >= A.length - 1)
				return true;
		}
		return false;
	}
}
