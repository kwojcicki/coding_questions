package solutions;

import java.util.Arrays;

public class palindromic_substrings {
	public int countSubstrings(String s) {
		boolean[] dp = new boolean[s.length()];
		Arrays.fill(dp, true);

		int ret = s.length();

		for(int i = s.length() - 2; i >= 0; i--) {
			for(int j = s.length() - 1; j >= i + 1; j--) {
				boolean ans = dp[j - 1] && s.charAt(i) == s.charAt(j);
				dp[j] = ans;
				ret += ans ? 1 : 0;
			}
		}

		return ret;  
	}
}
