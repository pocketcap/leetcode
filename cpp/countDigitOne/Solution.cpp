/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * reference: https://leetcode.com/discuss/44281/4-lines-o-log-n-c-java-python
 */

class Solution {
public:
	int countDigitOne(int n) {
		int ones = 0;
		for (long long m = 1; m <= n; m *= 10) {
			int a = n / m, b = n % m;
			ones += (a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
		}
		return ones;
	}
};
