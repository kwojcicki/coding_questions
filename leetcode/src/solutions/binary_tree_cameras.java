package solutions;

public class binary_tree_cameras {
	
	boolean secondHas = false;
	int cameras = 0;
    public int minCameraCover(TreeNode root) {
        if(root.left == null && root.right == null) return 1;
    	helper(root, 0);
        return cameras + (!secondHas ? 1 : 0);
    }
    
    public int helper(TreeNode root, int level) {
    	if(root == null) {
    		return Integer.MIN_VALUE;
    	}
    	
    	if(root.left == null && root.right == null) {
    		return 0;
    	}
    	
    	int left = helper(root.left, level + 1);
    	int right = helper(root.right, level + 1);
    	
    	if(left == 0 || right == 0) {
    		cameras++;
            // System.out.println(level);
        	if(level == 1 || level == 0) {
        		secondHas = true;
        	}
    		return 2;
    	} else {
    		// return Math.min(left, right) - 1;
            return Math.max(left, right) - 1;
    	}
    }
}
