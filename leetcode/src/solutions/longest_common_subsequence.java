package solutions;

public class longest_common_subsequence {
	public int longestCommonSubsequence(String text1, String text2) {
		int[] dp = new int[text2.length() + 1];
		int prev = 0;
		
		for(int i = 0; i < text1.length(); i++) {
            prev = 0;
			for(int j = 1; j < dp.length; j++) {
				int t = dp[j];
				if(text1.charAt(i) == text2.charAt(j - 1)) {
					dp[j] = 1 + prev;
				} else {
					dp[j] = Math.max(dp[j - 1], dp[j]);
				}
				prev = t;
			}
			// System.out.println(Arrays.toString(dp[i]));
		}

		return dp[dp.length - 1];
	}
}
