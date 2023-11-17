package solutions;

import java.util.Arrays;

public class minimize_maximum_pair_sum_in_array {
    public int minPairSum(int[] nums) {
    	int min = Integer.MIN_VALUE;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length / 2; i++) {
        	min = Math.max(min, nums[i] + nums[nums.length - 1 - i]);
        }
        
        return min;
    }
}
