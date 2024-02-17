package solutions;

import java.util.Arrays;

public class find_polygon_with_the_largest_perimeter {
    public long largestPerimeter(int[] nums) {
    	long ret = -1;
        Arrays.sort(nums);
        long curr = nums[0] + nums[1];
        for(int i = 2; i < nums.length; i++) {
        	if(curr > nums[i]) {
        		ret = curr + nums[i];
        	}
        	curr += nums[i];
        }
        return ret;
    }
}
