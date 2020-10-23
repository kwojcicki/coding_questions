package solutions;

import java.util.Stack;

public class onethreetwo_pattern {
    public boolean find132pattern(int[] nums) {
        
    	if(nums.length < 3) {
    		return false;
    	}
    	
    	Stack<Integer> s = new Stack<>();
    	int[] min = new int[nums.length];
    	min[0] = nums[0];
    	for(int i = 1; i < nums.length; i++) {
    		min[i] = Math.min(min[i - 1], nums[i]);
    	}
    	
    	for(int i = nums.length - 1; i >= 0; i--) {
    		if(nums[i] > min[i]) {
    			while(!s.isEmpty() && s.peek() <= min[i]) {
    				s.pop();
    			}
    			
    			if(!s.isEmpty() && nums[i] > s.peek()) {
    				return true;
    			}
    			
    			s.add(nums[i]);
    		}
    	}
    	
    	
    	return false;
    }
}
