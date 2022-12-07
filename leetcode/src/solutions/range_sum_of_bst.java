package solutions;

public class range_sum_of_bst {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return root == null ? 
        	0 : 
        	(root.val >= low && root.val <= high ? root.val : 0) + 
        		rangeSumBST(root.left, low, high) + 
        		rangeSumBST(root.right, low, high);
    }
}
