
public class arithmetic_slices {
    public int numberOfArithmeticSlices(int[] nums) {
    	int ret = 0;
    	
    	if(nums == null || nums.length < 3) {
    		return ret;
    	}
    	
    	int diff = nums[2] - nums[1];
    	
    	for(int i = 0; i < nums.length - 2; i++) {
    		diff = nums[i + 1] - nums[i];
    		for(int j = i + 2; j < nums.length; j++) {
    			if(nums[j] - nums[j - 1] != diff) {
    				break;
    			}
    			ret++;
    		}
    	}
    	
    	return ret;
    }
}
