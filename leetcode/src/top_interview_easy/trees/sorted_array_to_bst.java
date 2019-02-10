package top_interview_easy.trees;

public class sorted_array_to_bst {
    public TreeNode sortedArrayToBST(int[] nums) {
    	return sortedArrayToBST(nums,  0, nums.length);
    }
    
    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
    	if(left >= right) {
    		return null;
    	}
    	
    	int median = left + (right - left) / 2;
    	TreeNode root = new TreeNode(nums[median]);
    	root.left = sortedArrayToBST(nums, left, median);
    	root.right = sortedArrayToBST(nums, median + 1, right);
    	
    	return root;
    }
}
