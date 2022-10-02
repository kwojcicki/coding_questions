package solutions;

public class number_of_dice_rolls_with_target_sum {
    public int numRollsToTarget(int n, int k, int target) {
    	long[] dp = new long[target];
        long mod = (long) (Math.pow(10, 9) + 7);
        for(int j = 0; j < dp.length && j < k; j++){
            dp[j] = 1;
        }
        
        for(int i = 1; i < n; i++) {
        	for(int j = dp.length - 1; j >= 0; j--) {
        		long sum = 0;
        		for(int t = 1; t <= k; t++) {
        			sum = j - t >= 0 ? (sum + dp[j - t] % mod) : sum;
        		}
        		dp[j] = sum % mod;
        	}
            // System.out.println(Arrays.toString(dp));
        }
        
        // for(long[] d: dp) {
        // 	System.out.println(Arrays.toString(d));
        // }
        
        return (int) (dp[dp.length - 1] % mod);
    }
}
