struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};

class BSTIterator {
public:
	BSTIterator(TreeNode *root) {
		while (root != NULL) {
			stack.push(root);
			root = root->left;
		}
	}

	/** @return whether we have a next smallest number */
	bool hasNext() {
		return (!stack.empty());
	}

	/** @return the next smallest number */
	int next() {
		TreeNode *current = stack.top();
		TreeNode *return_current = current;
		stack.pop();
		current = current->right;
		while (current != NULL) {
			stack.push(current);
			current = current->left;
		}
		return return_current->val;
	}
private:
	std::stack<TreeNode*> stack;
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */
