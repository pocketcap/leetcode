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
	TreeNode* invertTree(TreeNode* root) {
		queue<TreeNode*> q;
		if (root != nullptr)
			q.push(root);

		while (!q.empty()) {
			TreeNode *p = q.front();
			q.pop();
			if (p->left != NULL)
				q.push(p->left);
			if (p->right != NULL)
				q.push(p->right);

			TreeNode *temp = p->left;
			p->left = p->right;
			p->right = temp;
		}
		return root;
	}
};
