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
	vector<int> rightSideView(TreeNode* root) {
		vector<int> v;
		doRightSideView(root, 0, v);
		return v;
	}

	void doRightSideView(TreeNode *root, int depth, vector<int> &v) {
		if (!root)
			return;
		if (v.size() < depth + 1)
			v.resize(depth + 1);
		v[depth] = root->val;
		doRightSideView(root->left, depth + 1, v);
		doRightSideView(root->right, depth + 1, v);
	}
};
