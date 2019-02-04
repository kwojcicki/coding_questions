package top_interview_medium.dp;

public class jump_game {
    public boolean canJump(int[] nums) {
        boolean[] possible = new boolean[nums.length];
        possible[nums.length - 1] = true;
        
        for(int i = nums.length - 2; i >= 0; i--) {
        	for(int j = 0; j <= nums[i]; j++) {
        		if(i + j < nums.length) possible[i] |= possible[i + j];        		
        	}
        }
        
        return possible[0];
    }
}
