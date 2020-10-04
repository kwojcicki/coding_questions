package solutions;

public class flatten_binary_tree_to_linked_list {
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        root.right = recurse(root.left, root.right);
        root.left = null;
        
    }
    
    public TreeNode recurse(TreeNode left, TreeNode right) {
    	if(left == null && right == null) return null;
    	
    	if(left == null) {
    		right.right = recurse(right.left, right.right);
    		right.left = null;
    		return right;
    	}
    	
    	
    	left.right = recurse(left.left, left.right);
    	left.left = null;
    	TreeNode temp = left;
    	while(left.right != null) {
    		left = left.right;
    	}
    	
    	left.right = recurse(null, right);
    	
    	return temp;
    	
    }
}
