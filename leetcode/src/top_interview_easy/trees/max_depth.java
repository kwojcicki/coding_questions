package top_interview_easy.trees;

public class max_depth {
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}