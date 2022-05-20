package solutions;

public class unique_paths_ii {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;

		int[] dp = new int[obstacleGrid[0].length + 1];

		dp[obstacleGrid[0].length - 1] = 1;

		for(int i = obstacleGrid.length - 1; i >= 0; i--) {
			for(int j = obstacleGrid[i].length - 1; j >= 0; j--) {
				if( (i == obstacleGrid.length - 1 && j == obstacleGrid[i].length - 1)) continue;
				if(obstacleGrid[i][j] == 1 ){
					dp[j] = 0;
				} else {
					dp[j] += dp[j + 1];
				}
			}
			// System.out.println(Arrays.toString(dp));
		}

		return dp[0]; 
	}
}
