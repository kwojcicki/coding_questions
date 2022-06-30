package solutions;

import java.util.Arrays;

public class minimum_moves_to_equal_array_elements_ii {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
    	int a = nums[nums.length / 2]; 
        // System.out.println(a);
        int ret = 0;
        for(int n: nums) {
        	ret += Math.abs(n - a);
        }
        
        return ret;
    }
}
