package solutions;

import java.util.ArrayList;
import java.util.List;

public class subsets {
	
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        recurse(nums, 0, ret, new ArrayList<>());
        return ret;
    }
	
	public void recurse(int[] nums, int index, List<List<Integer>> ret, List<Integer> list) {
		if(index == nums.length) {
			ret.add(new ArrayList<>(list));
			return;
		}
		
		list.add(nums[index]);
		recurse(nums, index + 1, ret, list);
		list.remove(list.size() - 1);
		recurse(nums, index + 1, ret, list);
	}
	
    public List<List<Integer>> subsets1(int[] nums) {
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
