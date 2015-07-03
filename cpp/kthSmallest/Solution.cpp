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
	int kthSmallest(TreeNode* root, int k) {
		stack<TreeNode*> s;

		TreeNode *p = root;
		int result = 0;

		while (!s.empty() || p != nullptr) {
			if (p != nullptr) {
				s.push(p);
				p = p->left;
			} else {
				TreeNode *t = s.top();
				s.pop();
				k--;
				if (k == 0)
					result = t->val;
				p = t->right;
			}
		}
		return result;
	}
};
