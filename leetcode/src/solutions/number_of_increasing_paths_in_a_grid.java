package solutions;

import java.util.Arrays;

public class number_of_increasing_paths_in_a_grid {
	int mod = (int)(1e9 + 7);
    public int countPaths(int[][] grid) {
    	int[][] dp = new int[grid.length][grid[0].length];
    	
    	for(int[] i: dp) {
    		Arrays.fill(i, -1);
    	}
    	
    	int ret = 0;
    	for(int i = 0; i < grid.length; i++) {
    		for(int j = 0; j < grid[0].length; j++) {
    			ret = (ret + helper(grid, dp, i, j, -1)) % mod;
    		}
    	}
    	
    	return ret;
    }
    
    public int helper(int[][] grid, int[][] dp, int i, int j, int prev) {
    	if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] <= prev) {
    		return 0;
    	}
    	
    	if(dp[i][j] != -1) return dp[i][j];
    	
    	int ret = 0;
    	
    	int a = helper(grid, dp, i + 1, j, grid[i][j]);
    	int b = helper(grid, dp, i - 1, j, grid[i][j]);
    	int c = helper(grid, dp, i, j + 1, grid[i][j]);
    	int d = helper(grid, dp, i, j - 1, grid[i][j]);
    	ret = (1 + a + b + c + d) % mod;
    	dp[i][j] = ret;
    	return ret;
    }
}
