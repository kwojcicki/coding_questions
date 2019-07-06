package solutions;

public class convert_bst_to_greater_tree {
	
	static int sum = 0;
    public TreeNode convertBST(TreeNode root) {
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
