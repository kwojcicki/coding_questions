package solutions;

public class rotate_array {
    public void rotate(int[] nums, int k) {
    	if(nums == null || nums.length == 0 || nums.length == k) {
    		return;
    	}
    	
    	reverse(nums, 0, nums.length - 1);
    	reverse(nums, 0, (k - 1) % nums.length);
    	reverse(nums, k % nums.length, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
    	while(start < end) {
    		int temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
            start++;
            end--;
    	}
    }
}
