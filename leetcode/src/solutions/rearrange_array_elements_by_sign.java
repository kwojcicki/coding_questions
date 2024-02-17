package solutions;

public class rearrange_array_elements_by_sign {
    public int[] rearrangeArray(int[] nums) {
    	int[] ret = new int[nums.length];
    	
    	int pos = 0, neg = 1;
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] > 0) {
    			ret[pos] = nums[i];
    			pos += 2;
    		} else {
    			ret[neg] = nums[i];
    			neg += 2;
    		}
    	}
    	
        return ret;
    }
}
