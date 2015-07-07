class Solution {
public:
	vector<vector<int>> combinationSum3(int k, int n) {
		vector<vector<int>> result;
		vector<int> temp;
		findCombSum(1, k, n, temp, result);
		return result;
	}

	void findCombSum(int start, int k, int n, vector<int> &temp,
			vector<vector<int>> &result) {
		if (!k && !n) {
			result.push_back(temp);
			return;
		} else if (k < 0) {
			return;
		}

		for (int i = start; i < 10; i++) {
			temp.push_back(i);
			findCombSum(i + 1, k - 1, n - i, temp, result);
			temp.pop_back();
		}
	}
};
