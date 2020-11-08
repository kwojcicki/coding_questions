package solutions;

public class binary_tree_tilt {
    public int findTilt(TreeNode root) {
        return helper(root)[0];
    }
    
    public int[] helper(TreeNode root) {
    	if(root == null) {
    		return new int[] {0, 0}; // nodes val, nodes sum
    	}
    	
    	int[] l = helper(root.left);
    	int[] r = helper(root.right);
    	
    	return new int[] { Math.abs(l[1] - r[1]) + l[0] + r[0], l[1] + r[1] + root.val };
    }
}
