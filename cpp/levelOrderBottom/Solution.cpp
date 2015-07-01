struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};

class Solution {
public:
	vector<vector<int>> levelOrderBottom(TreeNode* root) {
		vector<vector<int>> result;

		if (root == NULL)
			return result;

		queue<TreeNode*> nodeQ;
		nodeQ.push(root);
		int nextLevelCnt = 0, currentLevelCnt = 1;
		vector<int> layer;
		int visitedCnt = 0;
		while (!nodeQ.empty()) {
			TreeNode* node = nodeQ.front();
			nodeQ.pop();
			visitedCnt++;
			layer.push_back(node->val);

			if (node->left != NULL) {
				nodeQ.push(node->left);
				nextLevelCnt++;
			}

			if (node->right != NULL) {
				nodeQ.push(node->right);
				nextLevelCnt++;
			}

			if (visitedCnt == currentLevelCnt) {
				visitedCnt = 0;
				currentLevelCnt = nextLevelCnt;
				nextLevelCnt = 0;
				result.push_back(layer);
				layer.clear();
			}

		}

		vector<vector<int>> res;
		while (!result.empty()) {
			res.push_back(result.back());
			result.pop_back();
		}

		return res;
	}
};
