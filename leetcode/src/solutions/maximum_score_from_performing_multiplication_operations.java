package solutions;

public class maximum_score_from_performing_multiplication_operations {
	public int maximumScore(int[] nums, int[] multipliers) {
		Integer[][] dp = new Integer[multipliers.length + 1][multipliers.length + 1];
		helper(dp, 0, 0, nums, multipliers, multipliers.length);
		return dp[0][0];
	}

	public void helper(Integer[][] dp, int left, int right, int[] nums, int[] m, int ops) {
		if(ops == 0) { dp[left][right] = 0; return; }
		if(dp[left][right] != null) return;

		helper(dp, left + 1, right, nums, m, ops - 1);
		helper(dp, left, right + 1, nums, m, ops - 1);

		dp[left][right] = Math.max(
				dp[left + 1][right] + nums[left] * m[m.length - ops], 
				dp[left][right + 1] + nums[nums.length - right - 1] * m[m.length - ops]
				);
	}
}
