package solutions;

public class diameter_of_binary_tree {
	int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
    	helper(root);
        return max;
    }
    
    public int helper(TreeNode root) {
    	if(root == null) return 0;
    	
    	int left = helper(root.left);
    	int right = helper(root.right);
    	
    	max = Math.max(max, left + right);
    	return 1 + Math.max(left, right);
    }
    
    public int diameterOfBinaryTree1(TreeNode root) {
        return recurse(root)[0];
    }
    
    public int[] recurse(TreeNode root) {
    	if(root == null) {
    		return new int[] {0, 0}; // max path, longest path
    	}
    	
    	int[] left = recurse(root.left);
    	int[] right = recurse(root.right);
        
    	return new int[] {
    			Math.max(left[0], Math.max(right[0], left[1] + right[1])),
    			Math.max(left[1], right[1]) + 1
    	};
    }
}
