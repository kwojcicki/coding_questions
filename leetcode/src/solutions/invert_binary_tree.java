package solutions;

public class invert_binary_tree {
    public TreeNode invertTree(TreeNode root) {
        
    	if(root == null) {
    		return root;
    	}
    	
    	TreeNode newLeft = invertTree(root.right);
    	TreeNode newRight = invertTree(root.left);
    	
    	root.left = newLeft;
    	root.right = newRight;
    	
    	return root;
    }
}
