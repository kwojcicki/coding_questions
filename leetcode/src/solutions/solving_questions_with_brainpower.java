package solutions;

public class solving_questions_with_brainpower {
	public long mostPoints(int[][] questions) {
		long[] dp = new long[questions.length];
		dp[questions.length - 1] = questions[questions.length - 1][0];
		
		for(int i = questions.length - 2; i >= 0; i--) {
			dp[i] = questions[i][0] + (i + questions[i][1] + 1 >= dp.length ? 0 : dp[i + questions[i][1] + 1]);
			dp[i] = Math.max(dp[i], dp[i + 1]);
		}

		return dp[0];
	}
}
