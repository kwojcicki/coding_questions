package solutions;

public class add_one_row_to_tree {
	public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
        	return new TreeNode(val, root, null);
        }
        
        helper(root, val, depth - 1);
        return root;
    }
    
    public void helper(TreeNode root, int val, int depth) {
        // System.out.println(depth);
        if(root == null) return;
    	if(depth == 1) {
    		root.left = new TreeNode(val, root.left, null);
    		root.right = new TreeNode(val, null, root.right);
    		return;
    	}
    	
    	helper(root.left, val, depth - 1);
    	helper(root.right, val, depth - 1);
    }
}
