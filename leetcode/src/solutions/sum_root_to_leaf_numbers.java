package solutions;

public class sum_root_to_leaf_numbers {
	public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int curr){
        if(root == null) return 0;
        if(root.left ==  null && root.right == null){
            return curr * 10 + root.val;
        }

        return helper(root.left, curr * 10 + root.val) + helper(root.right, curr * 10 + root.val);
    }
}
