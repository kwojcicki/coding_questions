package solutions;

import java.util.HashSet;
import java.util.Set;

public class contains_duplicate_ii {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
        	if(set.contains(nums[i])) return true;
        	if(set.size() == k) set.remove(nums[i - k]);
        	set.add(nums[i]);
        }
        
    	
    	return false;
    }
}
