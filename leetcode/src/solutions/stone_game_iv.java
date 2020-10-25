package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class stone_game_iv {
    
	public boolean winnerSquareGame(int n) {
		boolean[] dp = new boolean[n + 1];
        
		dp[0] = false;
		dp[1] = true;
		
		for(int i = 2; i <= n; i++) {
			
			for(int j = 1; j * j <= i; j++) {
				
				if(i - j * j >= 0 && !dp[i - j * j]) {
					dp[i] = true;
                    break;
				}
				
			}
			
		}
		
		
		return dp[n];
	}
	
	
	Map<Integer, Boolean> map = new HashMap<>();
    public boolean winnerSquareGame1(int n) {
        map.put(0, false);
        map.put(1, true);
        return dfs(n);
    }
    
    public boolean dfs (int remain) {
    	if(map.containsKey(remain)) {
    		return map.get(remain);
    	}
    	
    	int max = (int)Math.sqrt(remain);
    	for(int i = 1; i <= max; i++) {
    		
    		if(!dfs(remain - i * i)) {
    			map.put(remain, true);
    			return true;
    		}
    		
    	}
    	
    	map.put(remain, false);
    	return false;
    }
}
