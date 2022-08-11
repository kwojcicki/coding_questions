package solutions;

public class validate_binary_search_tree {
	public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean valid(TreeNode root, long min, long max) {
    	if(root == null) return true;
    	if(root.val < min || root.val > max) return false;
    	return valid(root.left, min, ((long)root.val) - 1) && 
    			valid(root.right, ((long)root.val) + 1, max);
    }
    
    Integer prev = null;
    public boolean isValidBST1(TreeNode root) {
        return valid(root);
    }
    
    public boolean valid(TreeNode root) {
    	if(root == null) return true;
        if(!valid(root.right)) return false;
    	if(prev != null && prev <= root.val) return false;
        prev = root.val;
        return valid(root.left);
    }
}
