package buildTree;

public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int preStart = 0;
		int preEnd = preorder.length - 1;
		int inStart = 0;
		int inEnd = inorder.length - 1;

		return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
	}

	public TreeNode construct(int[] preorder, int preStart, int preEnd,
			int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd)
			return null;

		int val = preorder[preStart];
		TreeNode p = new TreeNode(val);

		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (val == inorder[i]) {
				k = i;
				break;
			}
		}

		p.left = construct(preorder, preStart + 1, preStart + k - inStart,
				inorder, inStart, k - 1);
		p.right = construct(preorder, preStart + 1 + k - inStart, preEnd,
				inorder, k + 1, inEnd);

		return p;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}