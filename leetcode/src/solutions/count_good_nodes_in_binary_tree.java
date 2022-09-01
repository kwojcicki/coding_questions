package solutions;

public class count_good_nodes_in_binary_tree {
	public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }
    
    public int helper(TreeNode root, int maxSoFar) {
    	if(root == null) return 0;
    	return helper(root.left, Math.max(root.val, maxSoFar))
    			+ helper(root.right, Math.max(root.val, maxSoFar))
    			+ (root.val >= maxSoFar ? 1 : 0);
    }
}
