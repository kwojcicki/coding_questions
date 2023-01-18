package solutions;

public class maximum_sum_circular_subarray {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxSum = nums[0];
        int currMax = 0;
        int minSum = nums[0];
        int	currMin = 0;
        for(int i: nums) {
        	currMax = Math.max(currMax + i, i);
        	maxSum = Math.max(maxSum, currMax);
        	currMin = Math.min(currMin + i, i);
        	minSum = Math.min(currMin, minSum);
        	total += i;
        }
        
        return maxSum > 0 ?
        		Math.max(maxSum, total - minSum)
        		: maxSum;
    }
}
