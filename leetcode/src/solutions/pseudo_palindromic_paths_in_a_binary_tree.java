package solutions;

public class pseudo_palindromic_paths_in_a_binary_tree {
	public int pseudoPalindromicPaths (TreeNode root) {
		return helper(root, new boolean[10], 0);
	}

	public int helper(TreeNode root, boolean[] odds, int odd) {
		if(root == null) return 0;

		if(root.left == null && root.right == null) {
			if(odds[root.val]) { 
				odd--;
			} else {
				odd++;
			}
			return odd <= 1 ? 1 : 0;
		}

		if(odds[root.val]) { 
			odd--;
			odds[root.val] = false;
		} else {
			odd++;
			odds[root.val] = true;
		}

		int ret = helper(root.left, odds, odd) + helper(root.right, odds, odd);

		odds[root.val] = !odds[root.val];

		return ret;
	}
}
