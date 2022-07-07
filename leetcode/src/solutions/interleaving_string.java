package solutions;

import java.util.HashSet;
import java.util.Set;

public class interleaving_string {

	public boolean isInterleave(String s1, String s2, String s3) {

		if(s1.length() + s2.length() != s3.length()) return false;

		boolean[] dp = new boolean[s2.length() + 1];
		dp[dp.length - 1] = true;

		for(int i = s1.length(); i >= 0; i--) {
			for(int j = dp.length - 1; j >= 0; j--) {
				boolean tmp = false;
				
                if(i == s1.length() && j == dp.length - 1) tmp = true;
                
				if(i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
					tmp |= dp[j];
				}
				
				if(j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
					tmp |= dp[j + 1];
				}
				
				dp[j] = tmp;
			}
		}

		return dp[0];
	}
	
	public boolean isInterleave1(String s1, String s2, String s3) {

		if(s1.length() + s2.length() != s3.length()) return false;

		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		dp[dp.length - 1][dp[0].length - 1] = true;

		for(int i = dp.length - 1; i >= 0; i--) {
			for(int j = dp[i].length - 1; j >= 0; j--) {
				if(i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
					dp[i][j] |= dp[i + 1][j];
				}

				if(j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
					dp[i][j] |= dp[i][j + 1];
				}
			}
		}

		return dp[0][0];
	}

	Set<Integer> seen = new HashSet<>();
	public boolean isInterleave2(String s1, String s2, String s3) {

		if(s1.length() + s2.length() != s3.length()) return false;

		return helper(s1, s2, s3, 0, 0, 0);
	}

	public boolean helper(String s1, String s2, String s3, 
			int i1,
			int i2,
			int i3) {

		if(i3 == s3.length() && i1 == s1.length()) return true;

		if(seen.contains(i1 + i2 * 1000)) return false;

		boolean ret = helper2(s1, s2, s3, i1, i2, i3)
				|| helper2(s2, s1, s3, i2, i1, i3);

		if(!ret) seen.add(i1 + i2 * 1000);

		return ret;
	}

	public boolean helper2(String s1, String s2, String s3, 
			int i1,
			int i2,
			int i3) {

		int tI3 = i3;
		while(tI3 < s3.length() && 
				i1 < s1.length() && 
				s3.charAt(tI3) == s1.charAt(i1)) {
			tI3++;
			i1++;
		}

		for(int i = tI3; i > i3; i--) {
			if(helper(s1, s2, s3, i1 - (tI3 - i), i2, i)) {
				return true;
			}
		}

		return false;
	}
}
