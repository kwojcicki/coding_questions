package solutions;

public class flatten_binary_tree_to_linked_list {
	
	TreeNode prev = null;
	public void flatten(TreeNode root) {
		if(root == null) return;
		flatten(root.right);
		flatten(root.left);
        root.right = prev;
		root.left = null;
		prev = root;
	}
	
    public void flatten1(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        
        if(root.left == null) {
        	flatten(root.right);
        	return;
        }
        
        flatten(root.left);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) {
        	root = root.right;
        }
        root.right = tmp;
        flatten(tmp);
    }
	
    public void flatten2(TreeNode root) {
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
