package solutions;

import java.util.Arrays;

public class decode_ways {
	
	public int numDecodings(String s) {
		int dp1 = 1, dp2 = 0;
		int n = s.length();
		char[] c = s.toCharArray();
		for(int i = n - 1; i >= 0; i--) {
			int sum = c[i] == '0' ? 0 : dp1;
			if(i + 1 <= c.length - 1 && (
	    			c[i] == '1' || (c[i] == '2' &&  c[i + 1] < '7') 
	    			)) {
				sum += dp2;
			}
			
			dp2 = dp1;
			dp1 = sum;
		}
		
		return dp1;
    }
	
	public int numDecodings1(String s) {
		int[] dp = new int[s.length() + 1];
		Arrays.fill(dp, 0);
        dp[dp.length - 1] = 1;
        helper(s.toCharArray(), 0, dp);
        return Math.max(dp[0], 0);
    }
    
    public void helper(char[] c, int i, int[] dp) {
    	if(c.length == i) return;
        if(c[i] == '0') return;
        if(dp[i] != 0) return;
        
    	if(i + 1 <= c.length - 1 && (
    			c[i] == '1' || (c[i] == '2' &&  c[i + 1] < '7') 
    			)) {
    		helper(c, i + 1, dp);
    		helper(c, i + 2, dp);
    		dp[i] = dp[i + 1] + dp[i + 2];
    	} else {
    		helper(c, i + 1, dp);
    		dp[i] = dp[i + 1];
    	}
    }
}
