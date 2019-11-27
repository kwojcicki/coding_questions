package solutions;

public class sum_of_root_to_leaf_binary_numbers {
	public int sumRootToLeaf(TreeNode root) {
		return sumRootToLeaf(root, "");
	}

	public int sumRootToLeaf(TreeNode root, String s) {
		if(root == null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			return Integer.parseInt(s + root.val, 2);
		}

		return sumRootToLeaf(root.left, s + root.val) + sumRootToLeaf(root.right, s + root.val);
	}
}
