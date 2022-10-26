package solutions;

import java.util.HashMap;
import java.util.Map;

public class continuous_subarray_sum {
    public boolean checkSubarraySum(int[] nums, int k) {
    	Map<Integer, Integer> map  = new HashMap<>();
        map.put(0, -1);
        int curr = 0;
        
        for(int i = 0; i < nums.length; i++) {
        	int n = nums[i];
        	curr += n;
        	
        	int idx = map.getOrDefault(curr % k, -2);
            // System.out.println(idx + " " + i + " " + curr + " " + (curr % k));
        	if(idx >= -1 && idx + 1 < i) return true;
        	
        	map.putIfAbsent(curr % k, i);
        }
        
        return false;
    }
}
