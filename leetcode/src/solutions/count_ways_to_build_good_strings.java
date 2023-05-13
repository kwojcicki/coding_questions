package solutions;

public class count_ways_to_build_good_strings {
    public int countGoodStrings(int low, int high, int zero, int one) {
    	long[] dp = new long[high + 1];
        long ret = 0;
        dp[0] = 1;
        
        for(int i = 1; i <= high; i++) {
        	if(i - zero >= 0) dp[i] = dp[i - zero];
        	if(i - one >= 0) dp[i] = (long)((dp[i] + dp[i - one]) % (Math.pow(10, 9) + 7));
        }
        
        for(int i = low; i <= high; i++) {
        	ret = (long) ((ret + dp[i]) % (Math.pow(10, 9) + 7));
        }
        
        return (int) (ret % (Math.pow(10, 9) + 7));
    }
}
