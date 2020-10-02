package solutions;

public class diameter_of_binary_tree {
    public int diameterOfBinaryTree(TreeNode root) {
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
