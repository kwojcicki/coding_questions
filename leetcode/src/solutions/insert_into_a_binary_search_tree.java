package solutions;

public class insert_into_a_binary_search_tree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        
        recurse(root, new TreeNode(val));
        
        return root;
    }
    
    public void recurse(TreeNode root, TreeNode insert) {
    	
    	if(insert.val > root.val) {
    		
    		if(root.right == null) {
    			root.right = insert;
    			return;
    		}
    		
    		recurse(root.right, insert);
    		
    	} else {
    		
    		if(root.left == null) {
    			root.left = insert;
    			return;
    		}
    		
    		recurse(root.left, insert);
    		
    	}
    }
}
