package isUgly;

public class Solution {
	public boolean isUgly(int num) {
		if (num == 0)
			return false;
		if (num == 1)
			return true;

		return isUgly(num, 2) || isUgly(num, 3) || isUgly(num, 5);
	}

	public boolean isUgly(int num, int n) {
		return num % n == 0 ? isUgly(num / n) : false;
	}
}
