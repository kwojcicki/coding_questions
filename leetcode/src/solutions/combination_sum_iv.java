package solutions;

import java.util.Arrays;

public class combination_sum_iv {
	
	public int helper(int[] nums, int target, int[] map) {
		
		if(map[target] != -1) return map[target];
		
		int count = 0;
		for(int i: nums) {
			if(target - i >= 0) count += helper(nums, target - i, map);
		}
		
		map[target] = count;
		return count;
	}
	
    public int combinationSum4(int[] nums, int target) {
    	int[] map = new int[target + 1];
    	Arrays.fill(map, -1);
    	map[0] = 1;
    	return helper(nums, target, map);
    }
    
    public int combinationSum4_1(int[] nums, int target) {
    	
        if(target == 0) return 1;
        if(target < 0) return 0;
        
        int count = 0;
        for(int i: nums) {
        	count += combinationSum4(nums, target - i);
        }
        
        return count;
    }
}
