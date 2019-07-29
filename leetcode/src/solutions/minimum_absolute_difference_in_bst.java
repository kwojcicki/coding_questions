package solutions;

public class minimum_absolute_difference_in_bst {
	// in order traversal
	
    public int getMinimumDifference(TreeNode root) {
    	return getMin(root);
    }
    
    public static int getMin(TreeNode node) {
    	if(node == null) {
    		return Integer.MAX_VALUE;
    	}
    	
    	TreeNode leftMost = node.left;
    	while(leftMost != null && leftMost.right != null) leftMost = leftMost.right;
    	
    	TreeNode rightMost = node.right;
    	while(rightMost != null && rightMost.left != null) rightMost = rightMost.left;
    	
    	int left = getMin(node.left);
    	int right = getMin(node.right);
    	
    	int ret = left;
    	ret = Math.min(ret, right);
    	
    	if(leftMost != null) {
    		ret = Math.min(ret, Math.abs(leftMost.val - node.val));
    	}
    	
    	if(rightMost != null) {
    		ret = Math.min(ret, Math.abs(rightMost.val - node.val));
    	}
    	
    	return ret;
    }
}
