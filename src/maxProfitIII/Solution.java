package maxProfitIII;

public class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;

		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		// from left to right
		left[0] = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		// from right to left
		right[prices.length - 1] = 0;
		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], max - prices[i]);
			max = Math.max(max, prices[i]);
		}

		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, left[i] + right[i]);
		}

		return profit;
	}
}
