package solutions;

import java.util.Arrays;

public class minimum_difficulty_of_a_job_schedule {
	public int minDifficulty(int[] jobDifficulty, int d) {
		if(d > jobDifficulty.length) return -1;

		int[][] dp = new int[jobDifficulty.length][d];
		for(int[] d1: dp) {
			Arrays.fill(d1, -2);
		}

		return helper(0, d - 1, jobDifficulty, dp);
	}

	public int helper(int i, int d, int[] jobs, int[][] dp) {
		if(i == jobs.length && d < 0) return 0;
		if(d < 0) return -1;
		if(i >= jobs.length) return -1;
		// if(d < 0) return 0;
		// if(i >= jobs.length) return -1;
		// if(jobs.length - i - d < 0) return -1;
		// System.out.println(i + " " + d + " " + jobs.length);
		if(dp[i][d] != -2) return dp[i][d];

		int max = -1;
		int ret = Integer.MAX_VALUE;

		for(int j = i; j < jobs.length; j++) {
			max = Math.max(max, jobs[j]);
			int tmp = helper(j + 1, d - 1, jobs, dp);
			if(tmp == -1) continue;
			ret = Math.min(ret, max + tmp);
		}

		if(ret == Integer.MAX_VALUE) ret = -1;
		dp[i][d] = ret;
		return ret;
	}
}
