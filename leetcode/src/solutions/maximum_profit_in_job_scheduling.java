package solutions;

import java.util.Arrays;

public class maximum_profit_in_job_scheduling {
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int[][] jobs = new int[startTime.length][3];

		for(int i = 0; i < startTime.length; i++) {
			jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
		}

		Arrays.sort(jobs, (a,b) -> {
			if(a[0] == b[0]) {
				return Integer.compare(a[1], b[1]);
			}

			return Integer.compare(a[0], b[0]);
		});
		//System.out.println(Arrays.toString(jobs));
		int[] dp = new int[jobs.length + 1];
		int maxSoFar = 0;
		for(int i = startTime.length - 1; i >= 0; i--) {
			int j = i + 1;
			for(; j < startTime.length; j++) {
				if(jobs[i][1] > jobs[j][0]) continue;
				break;
			}
			//System.out.println(i + " " + j);
			dp[i] = Math.max(maxSoFar, jobs[i][2] + dp[j]);
			maxSoFar = Math.max(dp[i], maxSoFar);
		}
		//System.out.println(Arrays.toString(dp));
		return dp[0];
	}
}
