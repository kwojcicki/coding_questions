package solutions;

public class longest_nice_subarray {
    public int longestNiceSubarray(int[] nums) {
    	int ret = 1;
    	int curr = 0;
    	int left = 0, right = 0;
    	
    	while(right < nums.length) {
    		while(left < nums.length && (curr & nums[right]) > 0) {
    			curr -= nums[left++];
    		}
    		curr += nums[right];
            // System.out.println(curr + " " + left + " " + right);
    		ret = Math.max(ret, right - left + 1);
            right++;
    	}
    	
        return ret;
    }
}
