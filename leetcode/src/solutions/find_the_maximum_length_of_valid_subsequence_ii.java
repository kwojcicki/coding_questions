package solutions;

import java.util.Arrays;

public class find_the_maximum_length_of_valid_subsequence_ii {
	public int maximumLength(int[] nums, int k) {
		int ret = 1;

		int[][] dp = new int[nums.length][k];
		Arrays.fill(dp[0], 1);

		for(int i = 1; i < nums.length; i++) {
			Arrays.fill(dp[i], 1);
			int n = nums[i];
			for(int j = 0; j < i; j++) {
				int other = nums[j];

				int bucket = (other + n) % k;
				dp[i][bucket] = Math.max(dp[i][bucket], 1 + dp[j][bucket]);

				ret = Math.max(ret, dp[i][bucket]);
			}
		}

		return ret;
	}
}
