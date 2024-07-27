package solutions;

import java.util.Arrays;

public class minimum_cost_to_convert_string_i {

	// Floyd–Warshall algorithm
	// https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
	public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
		long minimumCost = 0;

		long[][] dp = new long[26][26];
		for(long[] d: dp) Arrays.fill(d, (long)Integer.MAX_VALUE);
		for(int i = 0; i < original.length; i++) {
			dp[original[i] - 'a'][changed[i] - 'a'] = 
					Math.min(cost[i], dp[original[i] - 'a'][changed[i] - 'a']);
		}
		for(int i = 0; i < 26; i++) dp[i][i] = 0;

		for(int k = 0; k < 26; k++) {
			for(int i = 0; i < 26; i++) {
				for(int j = 0; j < 26; j++) {
					if(dp[i][j] > dp[i][k] + dp[k][j]) {
						dp[i][j] = dp[i][k] + dp[k][j];
					}
				}
			}
		}

		char[] cs = source.toCharArray();
		char[] ts = target.toCharArray();
		for(int i = 0; i < cs.length; i++) {
			int c = cs[i] - 'a', t = ts[i] - 'a';
			if(c == t) continue;
			else if(dp[c][t] == (long)Integer.MAX_VALUE) return -1;
			minimumCost += dp[c][t];
		}

		return minimumCost;
	}
}
