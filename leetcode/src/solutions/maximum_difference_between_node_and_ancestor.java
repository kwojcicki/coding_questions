package solutions;

public class maximum_difference_between_node_and_ancestor {
    public int maxAncestorDiff(TreeNode root) {
    	if(root == null) return 0;
    	return helper(root, root.val, root.val);
    }
    
    public int helper(TreeNode root, int min, int max) {
    	if(root == null) {
    		return 0;
    	}
    	
    	int ret = 0;
    	
    	ret = Math.max(ret, Math.abs(root.val - min));
    	ret = Math.max(ret, Math.abs(root.val - max));
    	
    	if(root.left != null) {
    		ret = Math.max(ret, Math.abs(root.left.val - min));
    		ret = Math.max(ret, Math.abs(root.left.val - max));
    		ret = Math.max(ret, helper(root.left, Math.min(min, root.val), Math.max(max, root.val)));
    	}
    	
    	if(root.right != null) {
    		ret = Math.max(ret, Math.abs(root.right.val - min));
    		ret = Math.max(ret, Math.abs(root.right.val - max));
    		ret = Math.max(ret, helper(root.right, Math.min(min, root.val), Math.max(max, root.val)));
    	}
    	
    	return ret;
    }
}
