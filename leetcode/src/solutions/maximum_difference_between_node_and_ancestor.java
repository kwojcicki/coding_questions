package solutions;

public class maximum_difference_between_node_and_ancestor {
	public int maxAncestorDiff1(TreeNode root) {
		if(root == null) return 0;
		return helper(root, root.val, root.val);
	}

	public int helper(TreeNode root, int min, int max) {
		if(root == null) {
			return 0;
		}

		int ret = 0;

		ret = Math.max(ret, Math.abs(root.val - min));
		ret = Math.max(ret, Math.abs(root.val - max));

		if(root.left != null) {
			ret = Math.max(ret, helper(root.left, Math.min(min, root.val), Math.max(max, root.val)));
		}

		if(root.right != null) {
			ret = Math.max(ret, helper(root.right, Math.min(min, root.val), Math.max(max, root.val)));
		}

		return ret;
	}

	int maxSoFar = 0;
	public int maxAncestorDiff(TreeNode root) {
		helper1(root, new Integer[2]);
		return maxSoFar;
	}
	public void helper1(TreeNode root, Integer[] input) {
		if(root == null) {
			input[0] = null;
			input[1] = null;
			return;
		}

        int max = root.val;
        int min = root.val;
        
		helper1(root.left, input);
        max = Math.max(input[0] == null ? root.val : input[0], max);
        min = Math.min(input[1] == null ? root.val : input[1], min);

		maxSoFar = Math.max(maxSoFar, Math.max(
				Math.abs((input[0] == null ? root.val : input[0]) - root.val), 
				Math.abs((input[1] == null ? root.val : input[1]) - root.val)));
        
		helper1(root.right, input);
        max = Math.max(input[0] == null ? root.val : input[0], max);
        min = Math.min(input[1] == null ? root.val : input[1], min);
        
		maxSoFar = Math.max(maxSoFar, Math.max(
				Math.abs((input[0] == null ? root.val : input[0]) - root.val), 
				Math.abs((input[1] == null ? root.val : input[1]) - root.val)));

		input[0] = max;
        input[1] = min;
	}
}
