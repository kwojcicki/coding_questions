package top_interview_medium.others;

public class maximum_binary_tree {
	
	public static void main(String[] args) {
		new maximum_binary_tree().constructMaximumBinaryTree(new int[] {3,2,1,6,0,5});
	}
	
    public TreeNode constructMaximumBinaryTree(int[] nums) {
    	return recurse(nums, 0, nums.length - 1);
    }
    
    public TreeNode recurse(int[] nums, int i, int l) {
    	if(i > l) {
    		return null;
    	}
    	int maxPos = max(nums, i, l);
    	System.out.println(i + " " + l + " " + maxPos);
    	if(maxPos == -1) {
    		return null;
    	}
        TreeNode r = new TreeNode(nums[max(nums, i, l)]);
        
        r.left = recurse(nums, i, maxPos - 1);
        r.right = recurse(nums, maxPos + 1, l);
        return r;
    }
    
    public int max(int[] nums, int i, int l) {
    	int maxPos = -1;
    	int max = -1;
    	for(;i <= l; i++) {
    		if(nums[i] > max) {
    			maxPos = i;
    			max = nums[i];
    		}
    	}
    	
    	return maxPos;
    }
}
