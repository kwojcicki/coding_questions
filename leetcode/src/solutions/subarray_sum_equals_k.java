package solutions;

public class subarray_sum_equals_k {
    public int subarraySum(int[] nums, int k) {
        
    	int[] sums = new int[nums.length];
    	int count = 0;
    	
    	for(int i = 0; i < nums.length; i++) {
    		
    		for(int j = 0; j <= i; j++) {
    			sums[j] += nums[i];
    			if(sums[j] == k) count++;
    		}
    		
    	}
    	
    	return count;
    }
}
