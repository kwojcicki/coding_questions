package solutions;

import java.util.Random;

public class random_pick_index {
	
	private int[] nums;
	private Random random = new Random();
	
    public void Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int count = 0;
        int ret = -1;
        for(int i = 0; i < nums.length; i++) {
        	
        	if(nums[i] != target) continue;
        	count++;
        	if(random.nextInt(count) == 0) {
        		ret = i;
        	}
        	
        }
        
        return ret;
    }
}
