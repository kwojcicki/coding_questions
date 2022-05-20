package solutions;

public class unique_paths_ii {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;
        
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        
        dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = 1;
        
        for(int i = obstacleGrid.length - 1; i >= 0; i--) {
        	for(int j = obstacleGrid[i].length - 1; j >= 0; j--) {
        		if(dp[i][j] != 0 || obstacleGrid[i][j] == 1) continue;
        		dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
        	}
        }
        
        return dp[0][0]; 
    }
}
