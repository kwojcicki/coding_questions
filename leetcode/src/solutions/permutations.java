package solutions;

import java.util.ArrayList;
import java.util.List;

public class permutations {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	recurse(nums, 0, ret);
    	
    	return ret;
    }
    
    public static void recurse(int[] nums, int index, List<List<Integer>> ret) {
    	if(index == nums.length) {
    		
    		List<Integer> r = new ArrayList<Integer>();
    		for(int a: nums) r.add(a);
    		ret.add(r);
    		return;
    	}
    	
    	for(int i = index; i < nums.length; i++) {
    		int temp = nums[i];
    		nums[i] = nums[index];
    		nums[index] = temp;
    		recurse(nums, index+1, ret);
    		temp = nums[i];
    		nums[i] = nums[index];
    		nums[index] = temp;
    	}
    	
    }
}
