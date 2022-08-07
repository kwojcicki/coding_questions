package solutions;

import java.util.Arrays;

public class count_vowels_permutation {
	public int countVowelPermutation(int n) {
		long[] dp = new long[5];
		Arrays.fill(dp, 1);
		long mod = (long) (Math.pow(10, 9) + 7);
		
		for(int iter = 2; iter < n + 1; iter++) {
			long a = (dp[4] + dp[2] + dp[1]) % mod;
			long e = (dp[2] + dp[0]) % mod;;
			long i = (dp[3] + dp[1]) % mod;
			long o = dp[2];
			long u = (dp[3] + dp[2]) % mod;
			dp[0] = a; // a
			dp[1] = e; // e
			dp[2] = i; // i
			dp[3] = o; // o
			dp[4] = u; // u
		}

		return (int) ((dp[0] + dp[1] + dp[2] + dp[3] + dp[4]) % mod);
	}
}
