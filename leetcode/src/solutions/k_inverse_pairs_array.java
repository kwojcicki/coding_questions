package solutions;

public class k_inverse_pairs_array {
	public int kInversePairs(int n, int k) {
		int mod = (int) (Math.pow(10, 9) + 7);

		long[][] dp = new long[n + 1][k + 1];
		dp[1][0] = 1;

		for(int i = 2; i < dp.length; i++) {
			dp[i][0] = 1;
			long curr = 1;
			for(int j = 1; j < dp[i].length; j++) {
				curr += dp[i - 1][j];
				if(j - i >= 0) curr -= dp[i - 1][j - i];
				dp[i][j] = (curr + mod) % mod;
			}
		}

		// for(long[] i: dp){
			//     System.out.println(Arrays.toString(i));
			// }

		return (int) (dp[n][k] % mod);
	}
}
