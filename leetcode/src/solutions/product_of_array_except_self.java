package solutions;

public class product_of_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        
        int left = nums[0];
        ret[0] = 1;
        
        for(int i = 1; i < nums.length; i++) {
        	ret[i] = left;
        	left *= nums[i];
        }
        
        int right = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
        	ret[i] *= right;
        	right *= nums[i];
        }
        
        return ret;
    }
}
