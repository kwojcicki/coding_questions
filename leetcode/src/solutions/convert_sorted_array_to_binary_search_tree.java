package solutions;

public class convert_sorted_array_to_binary_search_tree {
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(0, nums.length - 1, nums);
	}

	public TreeNode helper(int start, int end, int[] nums) {
		if(end > start) return null;
		int mid = (end - start) / 2 + start;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(start, mid - 1, nums);
		root.right = helper(mid + 1, end, nums);
		return root;
	}
}
