package solutions;

import java.util.Arrays;

public class partition_equal_subset_sum {
    public boolean canPartition(int[] nums) {
    	int sum = Arrays.stream(nums).reduce(0, (a,b) -> a + b);
    	if(sum % 2 == 1) return false;
    	boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
    	for(int i: nums) {
    	    // System.out.println(Arrays.toString(dp));
    		for(int j = dp.length - 1 - i; j >= 0; j--) {
    			if(!dp[j]) continue;
    			dp[j + i] = true;
    		}
    	}
    	// System.out.println(Arrays.toString(dp));
        return dp[sum / 2];
    }
}
