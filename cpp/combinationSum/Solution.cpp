class Solution {
public:
	vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
		vector<vector<int>> result;
		vector<int> temp;
		if (candidates.empty())
			return result;
		sort(candidates.begin(), candidates.end());
		findCombSum(candidates, 0, target, temp, result);
		return result;
	}

	void findCombSum(vector<int> &candidates, int start, int target,
			vector<int> &temp, vector<vector<int>> &result) {
		if (target == 0) {
			result.push_back(temp);
			return;
		}

		for (int i = start; i < candidates.size(); i++) {
			if (i > start && candidates[i] == candidates[i - 1])
				continue;
			if (candidates[i] <= target) {
				temp.push_back(candidates[i]);
				findCombSum(candidates, i, target - candidates[i], temp,
						result);
				temp.pop_back();
			}
		}
	}
};
