package solutions;

public class arithmetic_slices {
	public int numberOfArithmeticSlices(int[] nums) {
    	if(nums == null || nums.length < 3) return 0;
    	int curr = 0;
    	int ret = 0;
    	
    	for(int i = 2; i < nums.length; i++) {
    		if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
    			curr += 1;
    			ret += curr;
    		} else {
    			curr = 0;
    		}
    	}
    	
    	return ret;
    }
	
    public int numberOfArithmeticSlices1(int[] nums) {
    	if(nums == null || nums.length < 3) return 0;
    	int[] dp = new int[nums.length];
    	int ret = 0;
    	for(int i = 2; i < dp.length; i++) {
    		if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
    			dp[i] = dp[i - 1] + 1;
    		}
    		ret += dp[i];
    	}
    	
    	return ret;
    }
    
    public int numberOfArithmeticSlices2(int[] nums) {
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
