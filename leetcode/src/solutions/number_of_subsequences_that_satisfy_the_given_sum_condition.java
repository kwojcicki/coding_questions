package solutions;

import java.math.BigInteger;
import java.util.Arrays;

public class number_of_subsequences_that_satisfy_the_given_sum_condition {
    public int numSubseq(int[] nums, int target) {
    	BigInteger ret = BigInteger.ZERO;
        BigInteger mod = BigInteger.valueOf((long)Math.pow(10, 9) + 7);
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
        	if(nums[left] + nums[right] <= target) {
        		ret = ret.add(BigInteger.valueOf(2).
        				modPow(BigInteger.valueOf(right - left), mod)).
        				mod(mod);
        		left++;
        	} else {
        		right--;
        	}
        }
        
        return ret.intValue();
    }
}
