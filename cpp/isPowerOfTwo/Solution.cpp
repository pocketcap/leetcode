class Solution {
public:
	bool isPowerOfTwo(int n) {
		long num = 1;
		while (num <= n) {
			if (num == n)
				return true;
			num = num << 1;
		}
		return false;
	}
};
