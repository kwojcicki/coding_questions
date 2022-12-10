package solutions;

public class maximum_product_of_splitted_binary_tree {
	long max;
    public int maxProduct(TreeNode root) {
        long sum = sum(root);
        helper(root, sum);
        return (int) (max % (1E9 + 7));
    }
    
    public long sum(TreeNode root) {
    	if(root == null) return 0;
    	return root.val + sum(root.left) + sum(root.right);
    }
    
    public long helper(TreeNode root, long sum) {
    	if(root == null) return 0;
    	
    	long left = helper(root.left, sum);
    	long right = helper(root.right, sum);
    	long s = left + right + root.val;
    	max = Math.max(max, (sum - s) * s);
    	return s;
    }
}
