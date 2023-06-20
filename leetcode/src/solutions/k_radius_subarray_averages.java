package solutions;

import java.util.Arrays;

public class k_radius_subarray_averages {
    public int[] getAverages(int[] nums, int k) {

        int[] ret = new int[nums.length];
        Arrays.fill(ret, -1);
        
        if(k * 2 + 1 > nums.length) return ret;
        
        long sum = 0;
        for(int i = 0; i < k * 2; i++) {
        	sum += nums[i];
        }
        
        for(int i = k; i <= nums.length - 1 - k; i++) {
            // System.out.println((i - k) + " " + i + " " + (i + k));
            sum += nums[i + k];
        	ret[i] = (int) (sum / (k * 2 + 1));
        	sum -= nums[i - k];
        }
        
        return ret;
    }
}
