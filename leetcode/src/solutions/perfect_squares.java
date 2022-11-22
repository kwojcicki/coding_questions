package solutions;

import java.util.Arrays;

public class perfect_squares {
	public int numSquares(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 100000);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++){
            for(int j = (int)Math.sqrt(i); j >= 1; j--){
               dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
