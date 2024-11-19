package solutions;

public class maximum_sum_of_distinct_subarrays_with_length_k {
    public long maximumSubarraySum(int[] nums, int k) {
    	long sum = 0;
        int dups = 0;
        int[] duplicates = new int[100_000 + 1];
        
        for(int i = 0; i < k; i++) {
        	if(++duplicates[nums[i]] == 2) dups++;
        	sum += nums[i];
        }
        
        long ret = dups == 0 ? sum : 0;
        
        for(int i = 0; i < nums.length - k; i++) {
        	if(--duplicates[nums[i]] == 1) dups--;
        	sum -= nums[i];
        	if(++duplicates[nums[i + k]] == 2) dups++;
        	sum += nums[i + k];
            // System.out.println(i + " " + dups + " " + sum);
        	if(dups == 0) ret = Math.max(ret, sum);
        }
        
        return ret;
    }
}
