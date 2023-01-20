package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class non_decreasing_subsequences {
	 public List<List<Integer>> findSubsequences(int[] nums) {
	        Set<List<Integer>> set = new HashSet<>();
	        
	        for(int i = 0; i < nums.length - 1; i++) {
	        	List<Integer> tmp = new ArrayList<>();
	        	tmp.add(nums[i]);
	        	recurse(i + 1, nums, tmp, set);
	        }
	        
	        List<List<Integer>> ret = new ArrayList<>();
	        set.forEach(i -> ret.add(i));
	        return ret;
	    }
	    
	    public void recurse(int i, int[] nums, List<Integer> tmp, Set<List<Integer>> ret) {
	    	if(tmp.size() >= 2) {
	    		ret.add(new ArrayList<>(tmp));
	    	}
	    	
	    	for(int j = i; j < nums.length; j++) {
	    		if(nums[j] >= tmp.get(tmp.size() - 1)) {
	    			tmp.add(nums[j]);
	    			recurse(j + 1, nums, tmp, ret);
	    			tmp.remove(tmp.size() - 1);
	    		}
	    	}
	    }
}
