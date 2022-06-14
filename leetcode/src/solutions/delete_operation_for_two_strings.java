package solutions;

public class delete_operation_for_two_strings {

	public int minDistance(String word1, String word2) {
		int[] dp = new int[word2.length() + 1];

		int prev = 0;

		for(int row = 0; row < word1.length(); row++) {
			prev = 0;
			for(int col = 1; col < dp.length; col++) {
				int tmpPrev = dp[col];
				if(word1.charAt(row) == word2.charAt(col - 1)) {
					dp[col] = 1 + prev;
				} else {
					dp[col] = Math.max(dp[col], dp[col - 1]);
				}
				prev = tmpPrev;
			}
			// System.out.println(Arrays.toString(dp));
		}

		return (word1.length() - dp[dp.length - 1]) + (word2.length() - dp[dp.length - 1]);
	}
}
