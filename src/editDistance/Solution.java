package editDistance;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 */

public class Solution {
	public int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();

		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

		// iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char w1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char w2 = word2.charAt(j);

				// if last two chars equal
				if (w1 == w2)
					dp[i + 1][j + 1] = dp[i][j];
				else {
					int insert = dp[i + 1][j] + 1;
					int delete = dp[i][j + 1] + 1;
					int replace = dp[i][j] + 1;
					int min = insert > delete ? delete : insert;
					min = min > replace ? replace : min;
					dp[i + 1][j + 1] = min;
				}
			}
		}
		return dp[len1][len2];
	}
}
