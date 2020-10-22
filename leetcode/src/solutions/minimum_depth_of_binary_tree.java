package solutions;

public class minimum_depth_of_binary_tree {
    public int minDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        
        
        if(root.left == root.right && root.left == null) return 1;
        
        if(root.left != null && root.right != null) return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        if(root.left != null) return minDepth(root.left) + 1;
        
        return minDepth(root.right) + 1;
    }
}
