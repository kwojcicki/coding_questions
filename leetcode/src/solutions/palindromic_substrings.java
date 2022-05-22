package solutions;

public class palindromic_substrings {
	public int countSubstrings(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];

		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j <= i; j++) {
				dp[i][j] = true;
			}
		}

		int ret = s.length();

		for(int i = s.length() - 2; i >= 0; i--) {
			for(int j = s.length() - 1; j >= i + 1; j--) {
				boolean ans = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
				dp[i][j] = ans;
				ret += ans ? 1 : 0;
			}
		}

		return ret;  
	}
}
