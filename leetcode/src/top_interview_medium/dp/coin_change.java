package top_interview_medium.dp;

public class coin_change {
    public int coinChange(int[] coins, int amount) {
        int[] required = new int[amount + 1];
        
        for(int i = 1; i <= amount; i++) {
        	required[i] = Integer.MAX_VALUE;
        	for(int j = 0; j < coins.length; j++) {
        		if(i - coins[j] >= 0 && required[i - coins[j]] != Integer.MAX_VALUE) required[i] = Math.min(required[i], required[i - coins[j]] + 1);
        	}
        }
        
        if(required[amount] == Integer.MAX_VALUE) {
        	return -1;
        }
        
        return required[amount];
    }
}
