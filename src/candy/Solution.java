package candy;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 */

public class Solution {
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;

		int size = ratings.length;
		int[] candy = new int[size];
		candy[0] = 1;

		// scan from left to right
		for (int i = 1; i < size; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			} else {
				candy[i] = 1;
			}
		}

		int result = candy[size - 1];
		// scan from right to left
		for (int i = size - 2; i >= 0; i--) {
			int cur = 1;
			if (ratings[i] > ratings[i + 1]) {
				cur = candy[i + 1] + 1;
			}
			result += Math.max(cur, candy[i]);
			candy[i] = cur;
		}
		return result;
	}
}
