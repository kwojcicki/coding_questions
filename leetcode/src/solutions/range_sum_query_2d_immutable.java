package solutions;

public class range_sum_query_2d_immutable {
	class NumMatrix {
		int[][] dp;
		public NumMatrix(int[][] matrix) {
			dp = new int[matrix.length + 1][matrix[0].length + 1];

			dp[1][1] = matrix[0][0];
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
					dp[i + 1][j + 1] = matrix[i][j]
							- dp[i][j] 
									+ dp[i + 1][j]
											+ dp[i][j + 1];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int ret = 0;
			ret = dp[row2 + 1][col2 + 1]
					+ dp[row1][col1]
							- dp[row2 + 1][col1]
									- dp[row1][col2 + 1];
			return ret;
		}
	}
}
