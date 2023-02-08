package solutions;

import java.util.Arrays;

public class jump_game_ii {
    public int jump(int[] nums) {
    	int ret = 0;
    	int farthest = 0;
    	int nextFarthest = 0;
    	
    	for(int i = 0; i < nums.length - 1; i++) {
    		nextFarthest = Math.max(nextFarthest, i + nums[i]);
    		if(i == farthest) {
    			farthest  = nextFarthest;
    			ret++;
    		}
    	}
    	
    	return ret;
    }
    
    public int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < dp.length; i++){
            for(int j = 1; j <= nums[i] && i + j < dp.length; j++){
                dp[i + j] = Math.min(dp[i + j], 1 + dp[i]);
            }
        }

        return dp[nums.length - 1];
    }
}
