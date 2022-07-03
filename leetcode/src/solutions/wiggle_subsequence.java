package solutions;

public class wiggle_subsequence {
	public int wiggleMaxLength(int[] nums) {
    	return Math.max(helper(nums, false), helper(nums, true));
    }
    
    public int helper(int[] nums, boolean starting) {
    	boolean down = starting;
        int wiggle = nums[0];
        int ret = 1;
        
        for(int i = 1; i < nums.length; i++) {
        	if(down) {
        		if(nums[i] < wiggle) {
        		 	ret++;
        		 	down = !down;
        		}
        	} else {
        		if(nums[i] > wiggle) {
        		 	ret++;
        		 	down = !down;
        		}
        	}
		 	wiggle = nums[i];
        }
        
        return ret;  
    }
}
