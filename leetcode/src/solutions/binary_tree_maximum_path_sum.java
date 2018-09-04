package solutions;

public class binary_tree_maximum_path_sum {
	
	int maxValue = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
		maxPathSumHelper(root);
		return maxValue;
	}
	
	private int maxPathSumHelper(TreeNode node) {
		if(node == null) {
			return 0;
		}
		
		int left = Math.max(0, maxPathSumHelper(node.left));
		int right = Math.max(0, maxPathSumHelper(node.right));
		
		maxValue = Math.max(maxValue, left + right + node.val);
		
		return Math.max(left, right) + node.val;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(-1);
		t1.left = t2;
		binary_tree_maximum_path_sum b = new binary_tree_maximum_path_sum();
		System.out.println(b.maxPathSum(t1));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}