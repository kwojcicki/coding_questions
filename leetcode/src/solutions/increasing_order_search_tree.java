package solutions;

public class increasing_order_search_tree {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return root;
        return helper(root, null);
    }
    
    public TreeNode helper(TreeNode root, TreeNode parent) {
        if(root == null) return parent;
        
        if(root.left == null && root.right == null) {
            root.right = parent;
            return root;
        }
        
    	root.right = helper(root.right, parent);
        if(root.right == null) root.right = parent;
    	
    	TreeNode ret = helper(root.left, root);
    	root.left = null;
    	return ret;
    }
}
