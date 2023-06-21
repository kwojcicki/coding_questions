package solutions;

public class minimum_cost_to_make_array_equal {
    public long minCost(int[] nums, int[] cost) {
    	long left = 100_000_000L;
        long right = 1L;
        for(int i: nums) {
        	left = Math.min(left, i);
        	right = Math.max(right, i);
        }
        
        long ret = 0;
        while(left < right) {
        	long mid1 = (left + right) / 2;
        	long mid2 = mid1 + 1;
        	long cost1 = 0, cost2 = 0;
        	for(int i = 0; i < nums.length; i++) {
        		cost1 += Math.abs(nums[i] - mid1) * cost[i];
        		cost2 += Math.abs(nums[i] - mid2) * cost[i];
        	}
        	ret = Math.min(cost1, cost2);
        	if(cost1 < cost2) {
        		right = mid1;
        	} else {
        		left = mid2;
        	}
        }
        
        return ret;
    }
}
