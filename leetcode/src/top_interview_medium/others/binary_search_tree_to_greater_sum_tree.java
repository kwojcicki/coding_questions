package top_interview_medium.others;

public class binary_search_tree_to_greater_sum_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int value = 0;
	
	public TreeNode bstToGst(TreeNode root) {
		
		if(root == null) {
			return root;
		}
		
		if(root.right != null) {
			bstToGst(root.right);
		}
		
		value += root.val;
		root.val = value;
		
		if(root.left != null) {
			bstToGst(root.left);
		}
		
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
