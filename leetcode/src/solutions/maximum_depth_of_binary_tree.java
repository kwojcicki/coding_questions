package solutions;

public class maximum_depth_of_binary_tree {
    public int maxDepth(TreeNode root) {
        return recurse(root);
    }
    
    public int recurse(TreeNode root) {
    	if(root == null)
    		return 0;
    	
    	return Math.max(recurse(root.left), recurse(root.right)) + 1;
    }
}
