package solutions;

public class binary_tree_pruning {
    public TreeNode pruneTree(TreeNode root) {
        return helper(root) ? root : null;
    }
    
    public boolean helper(TreeNode root) {
    	if(root == null) return false;
    	
    	boolean left = helper(root.left);
    	boolean right = helper(root.right);
    	if(!left) root.left = null;
    	if(!right) root.right = null;
    	
    	return left || right || root.val == 1;
    }
}
