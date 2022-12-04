package solutions;

import java.util.Arrays;

public class minimum_average_difference {
    public int minimumAverageDifference(int[] nums) {
    	if(nums.length == 1) return 0;
        long ret = Integer.MAX_VALUE;
    	int retIdx = 0;
        long sum = 0;
        for(int i: nums) sum += i;
        long left = 0;
        
        for(int i = 0; i < nums.length - 1; i++) {
        	left += nums[i];
        	sum -= nums[i];
        	long t = Math.abs(left / (i + 1) - sum / (nums.length - i - 1));
        	if(t < ret) {
        		ret = t;
        		retIdx = i;
        	}
            // System.out.println(left + " " + sum + " " + ret + " " + t);
        }
        
        left += nums[nums.length - 1];
        long t = (left / nums.length);
        if(t < ret) {
        	return nums.length - 1;
        }
        // System.out.println(t + " " + left + " " + ret);
        return retIdx;
    }
}
