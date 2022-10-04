package solutions;

public class path_sum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }
    
    public boolean helper(TreeNode root, int targetSum, int curr) {
    	if(root == null) return false;
    	curr += root.val;
    	if(root.left == null && root.right == null) return targetSum == curr;
    	return helper(root.left, targetSum, curr) 
    			|| helper(root.right, targetSum, curr);
    }
}
