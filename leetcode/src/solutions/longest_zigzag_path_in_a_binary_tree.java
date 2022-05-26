package solutions;

public class longest_zigzag_path_in_a_binary_tree {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        helper(root);
        return max - 1;
    }
    
    public int[] helper(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        max = Math.max(max, Math.max(right[0], left[1]) + 1);
        return new int[]{ 1 + left[1], 1 + right[0] };
    }
}
