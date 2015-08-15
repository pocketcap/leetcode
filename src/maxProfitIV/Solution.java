package maxProfitIV;

public class Solution {
	public int maxProfit(int k, int[] prices) {
		int len = prices.length;

		if (len < 2 || k <= 0)
			return 0;

		int[][] local = new int[len][k + 1];
		int[][] global = new int[len][k + 1];

		for (int i = 1; i < len; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = 1; j <= k; j++) {
				local[i][j] = Math.max(local[i - 1][j] + diff,
						global[i - 1][j - 1] + Math.max(diff, 0));
				global[i][j] = Math.max(global[i - 1][j], local[i][j]);
			}
		}
		return global[len - 1][k];
	}
}
