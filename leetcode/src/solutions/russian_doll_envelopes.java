package solutions;

import java.util.Arrays;

public class russian_doll_envelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
        	return a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]);
        });
        
        int[] dp = new int[envelopes.length];
        int len = 0;
        for(int[] e: envelopes) {
        	int index = Arrays.binarySearch(dp, 0, len, e[1]);
        	if(index < 0) {
        		index = -(index + 1);
        	}
        	dp[index] = e[1];
        	len += index == len ? 1 : 0;
        }
        
        return len;
    }
	// TLE
    public int maxEnvelopes1(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
        	return Integer.compare(a[0], b[0]);
        });
        
        int[] dp = new int[envelopes.length];
        int ret = 0;
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < dp.length; i++) {
        	for(int j = i - 1; j >= 0; j--) {
        		if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        		}
        	}
            ret = Math.max(ret, dp[i]);
        }
        
        return ret;
    }
}
