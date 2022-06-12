package solutions;

import java.util.HashSet;
import java.util.Set;

public class maximum_erasure_value {
	
	public int maximumUniqueSubarray(int[] nums) {
        int ret = 0;
        boolean[] seen = new boolean[10 * 10 * 10 * 10 + 4];
        
        int accum = 0;
        int left = 0;
        for(int i = 0; i < nums.length; i++) {
        	while(seen[nums[i]]) {
        		accum -= nums[left];
        		seen[nums[left]] = false;
        		left++;
        	}
        	seen[nums[i]] = true;
        	accum += nums[i];
        	ret = Math.max(ret, accum);
        }
        
        return ret;
    }
	
    public int maximumUniqueSubarray1(int[] nums) {
        int ret = 0;
        Set<Integer> seen = new HashSet<>();
        
        int accum = 0;
        int left = 0;
        for(int i = 0; i < nums.length; i++) {
        	while(seen.contains(nums[i])) {
        		accum -= nums[left];
        		seen.remove(nums[left]);
        		left++;
        	}
        	seen.add(nums[i]);
        	accum += nums[i];
        	ret = Math.max(ret, accum);
        }
        
        return ret;
    }
}
