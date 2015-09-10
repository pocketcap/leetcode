package firstBadVersion;

public class Solution {
	public int firstBadVersion(int n) {
		if (n == 0)
			return 0;

		return searchBad(1, n);
	}

	public int searchBad(int start, int end) {
		int mid = start + (end - start) / 2;

		if (isBadVersion(start))
			return start;

		if (isBadVersion(mid)) {
			return searchBad(start, mid);
		} else {
			return searchBad(mid + 1, end);
		}

	}

	public boolean isBadVersion(int version) {
		return true;
	}
}