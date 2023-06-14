package solutions;

public class minimum_absolute_difference_in_bst {
	int prev = -1;
    int ret = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return ret;
    }

    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(prev != -1) ret = Math.min(ret, Math.abs(prev - root.val));
        prev = root.val;
        helper(root.right);
    }
}
