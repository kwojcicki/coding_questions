package solutions;

public class sum_of_left_leaves {
    public int sumOfLeftLeaves(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	
    	return sum(root.left, true) + sum(root.right, false);
    }
    
    public int sum(TreeNode node, boolean flag) {
    	if(node == null) {
    		return 0;
    	}
    	
    	if(flag && node.left == null && node.right == null) {
    		return node.val;
    	}
    	
    	return sum(node.left, true) + sum(node.right, false);
    }
}
