package solutions;

import java.util.HashMap;
import java.util.Map;

public class subarray_sum_equals_k {
	
	
	
    public int subarraySum3(int[] nums, int k) {
        int left = 0, right = 0, curr = 0, ret = 0;
        
        while(right < nums.length - 1 && left < nums.length - 1) {
        	if(curr == k) {
        		ret++;
        	}
        	
        	if(curr < k) {
        		right++;
        		curr += nums[right];
        	} else {
        		curr -= nums[left];
        		left++;
        	}
        }
        
        return ret;
    }
	
	
	
	
	
	
	
	
	
	
	
	public int subarraySum2(int[] nums, int k) {
		int count = 0;
		int sum = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			count += map.getOrDefault(sum - k, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		
		return count;
	}
	
	public int subarraySum1(int[] nums, int k) {
		int[] sums = new int[nums.length + 1];
		
		for(int i = 0; i < nums.length; i++) {
			sums[i + 1] = sums[i + 1] + nums[i];
		}
		
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(sums[j] - sums[i] == k) count++; 
			}
		}
		
		return count;
	}
	
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
