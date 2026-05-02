package solutions;

import java.util.stream.IntStream;

public class rotated_digits {
    public int rotatedDigits(int N) {
    	// dp
        return (int)IntStream.range(1, N + 1).filter(i -> {
        	String is = Integer.toString(i);
        	if((is.contains("2") || 
        			is.contains("5") ||
        			is.contains("6") ||
        			is.contains("9")) && 
        			!is.contains("3")&& 
        			!is.contains("4")&& 
        			!is.contains("7")) {
        		return true;
        	}
        	return false;
        }).count();
    }

    
    public int rotatedDigits1(int n) {
        if(n < 2) return 0;
        else if(n < 5) return 1;
        else if(n < 6) return 2;
        else if(n < 9) return 3;
       int[] dp = new int[n + 1];
       int ret = 4;

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[5] = 2;
        dp[6] = 2;
        dp[8] = 1;
        dp[9] = 2;
        for(int i = 10; i <= n; i++){
            int left = dp[i / 10]; int right = dp[i % 10];
            if(left == 1 && right == 1) dp[i] = 1;
            else if(left >= 1 && right >= 1) { ret++; dp[i] = 2; }
            else dp[i] = 0;
        }

       return ret;
    }
}
