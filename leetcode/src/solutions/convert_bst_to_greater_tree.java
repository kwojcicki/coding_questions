package solutions;

public class convert_bst_to_greater_tree {
	
    int curr = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    
    public void helper(TreeNode root){
        if(root == null) return;
        
        helper(root.right);
        
        curr += root.val;
        root.val = curr;
        
        helper(root.left);
    }
	
	static int sum = 0;
    public TreeNode convertBST1(TreeNode root) {
    	sum = 0;
    	recurse(root);
    	return root;
    }
    
    public static void recurse(TreeNode node) {
    	if(node == null) {
    		return;
    	}
    	
    	recurse(node.right);
    	
    	node.val += sum;
    	sum = node.val;
    	
    	recurse(node.left);
    	
    	return;
    }
}
