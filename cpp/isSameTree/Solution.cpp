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
	bool isSameTree(TreeNode* p, TreeNode * q) {
		queue<TreeNode*> q1;
		queue<TreeNode*> q2;

		q1.push(p);
		q2.push(q);

		while (!q1.empty() && !q2.empty()) {
			TreeNode* n1 = q1.front();
			TreeNode* n2 = q2.front();
			q1.pop();
			q2.pop();

			if (n1 == nullptr && n2 == nullptr)
				continue;
			if (n1 == nullptr || n2 == nullptr)
				return false;

			if (n1->val != n2->val)
				return false;

			q1.push(n1->left);
			q1.push(n1->right);
			q2.push(n2->left);
			q2.push(n2->right);
		}
		return q1.empty() && q2.empty();
	}
};
