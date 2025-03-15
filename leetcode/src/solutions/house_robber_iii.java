package solutions;

public class house_robber_iii {
	public int rob(TreeNode root) {
        int[] ret = robHelper(root);
        
        return Math.max(ret[0], ret[1]);
    }
    
    public int[] robHelper(TreeNode root) {
    	if(root == null) return new int[] { 0, 0 };
    	
    	int[] left = robHelper(root.left);
    	int[] right = robHelper(root.right);

        // take, don't take
        int[] ret = new int[] { 
            root.val + left[1] + right[1], 
            Math.max(left[0], left[1]) + Math.max(right[0], right[1])
        };
        // System.out.println(root.val + " " + ret[0] + " " + ret[1]);
    	return ret;
    }
}
