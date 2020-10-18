package solutions;

import java.util.Arrays;

public class best_time_to_buy_and_sell_stock_iv {
    public int maxProfit(int k, int[] prices) {
        int max = 0;
        
        if(prices == null || prices.length == 0 || k == 0) return max;
        if(2 * k > prices.length) {
            int result = 0;
            for(int i = 0; i < prices.length - 1; i++){
                if(prices[i + 1] > prices[i]){
                    result += prices[i + 1] - prices[i];
                }
            }
            return result;
        }
        
        int[][][] dp = new int[prices.length][k + 1][2];
        
        for(int i = 0; i < prices.length; i++) {
        	for(int j = 0; j <= k; j++) {
        		Arrays.fill(dp[i][j], -1000000);	
        	}
        }
        
        // day, number of transactions done, holding stock
        dp[0][0][0] = 0;
        dp[0][1][1] = - prices[0];
        
        
        for(int i = 1; i < prices.length; i++) {
        	for(int j = 0; j <= k; j++) {
        		dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
        		if(j > 0) {
        			dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
        		}
        	}
        }
        
        for(int j = 0; j <= k; j++) {
        	max = Math.max(max, dp[prices.length - 1][j][0]);
        }
        
        return max;
    }
}
