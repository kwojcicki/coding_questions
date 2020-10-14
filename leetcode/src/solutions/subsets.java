package solutions;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        
        helper(ret, new ArrayList<>(), nums, 0);
        
        return ret;
    }
    
    public void helper(List<List<Integer>> ret, List<Integer> curr, int[] nums, int index) {
    	if(index == nums.length) {
    		ret.add(new ArrayList<>(curr));
    		return;
    	}
    	
    	helper(ret, curr, nums, index + 1);
    	curr.add(nums[index]);
    	helper(ret, curr, nums, index + 1);
    	curr.remove(curr.size() - 1);
    }
}
