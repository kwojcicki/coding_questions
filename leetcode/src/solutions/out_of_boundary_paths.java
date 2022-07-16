package solutions;

import java.util.Arrays;

public class out_of_boundary_paths {
	int mod = (int) (Math.pow(10, 9) + 7);

	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		long ret = 0;
		long[][][] dp = new long[m][n][maxMove + 1];

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		for(int i = 1; i <= maxMove; i++) {
			ret = (ret + helper(m, n, i, startRow, startColumn, dp)) % mod;
		}

		return (int) ret;
	}

	private long helper(int m, int n, int move, int r, int c, long[][][] dp) {

		if(move < 0) return 0;

		if(r < 0 || c < 0 || r >= m || c >= n) {
			return move == 0 ? 1 : 0;
		}

		if(dp[r][c][move] != -1) return dp[r][c][move];

		long ret = helper(m , n, move - 1, r + 1, c, dp) + 
				helper(m , n, move - 1, r - 1, c, dp) +
				helper(m , n, move - 1, r, c - 1, dp) +
				helper(m , n, move - 1, r, c + 1, dp);

		dp[r][c][move] = ret % mod;

		return ret;
	}
}
