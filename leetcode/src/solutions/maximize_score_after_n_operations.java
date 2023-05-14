package solutions;

public class maximize_score_after_n_operations {

	public int dfs(int[] n, int operation, int maxOperations, int mask, int[] dp) {
		if(operation > maxOperations) return 0;

		if(dp[mask] == 0) {
			for(int i = 0; i < n.length; i++) {
				for(int j = i + 1; j < n.length; j++) {
					int newMask = (1 << i) + (1 << j);
					if((mask & newMask) == 0) {
						dp[mask] = Math.max(dp[mask], 
								gcd(n[i], n[j]) * operation +
								dfs(n, operation + 1, maxOperations, mask | newMask, dp));
					}
				}
			}
		}

		return dp[mask];
	}

	public int maxScore(int[] nums) {
		return dfs(nums, 1, nums.length / 2, 0, new int[(int) Math.pow(2, nums.length)]);
	}

	public int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b); 
	}
}
