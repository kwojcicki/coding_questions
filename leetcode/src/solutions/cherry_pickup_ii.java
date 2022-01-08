package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cherry_pickup_ii {

	public int cherryPickup(int[][] grid) {
		int [][][] memo = new int[grid.length][grid[0].length][grid[0].length];

		for(int i = 0; i < memo.length; i++)
			for(int j = 0; j < memo[0].length; j++)
				for(int k = 0; k < memo[0].length; k++)
					memo[i][j][k] = -1;

		return dp(grid, 0, 0, grid[0].length - 1, memo);
	}

	public int dp(int[][] grid, int row, int col1, int col2, int[][][] memo) {
		if(row >= grid.length || col1 < 0 || col1 >= grid[0].length 
				|| col2 < 0 || col2 >= grid[0].length) {
			return 0;
		}
		
		if(memo[row][col1][col2] != -1) {
			return memo[row][col1][col2];
		}
		
		int ret = col1 == col2 ? grid[row][col1] : grid[row][col1] + grid[row][col2];
		int max = 0;
		
		if(row + 1 < grid.length) {
			for(int i = -1; i <= 1; i++) {			
				for(int j = -1; j <= 1; j++) {
					max = Math.max(max, dp(grid, row + 1, col1 + i, col2 + j, memo));
				}
			}	
		}
		
		memo[row][col1][col2] = ret + max;
		
		return ret + max;
	}

	public int cherryPickup1(int[][] grid) {
		return dp(grid, Arrays.asList(0, 0, 0, grid[0].length - 1), 
				new HashMap<List<Integer>, Integer>());
	}

	public int dp(int[][] grid, List<Integer> pos, Map<List<Integer>, Integer> memo) {
		int row1 = pos.get(0), col1 = pos.get(1), row2 = pos.get(2), col2 = pos.get(3);

		if(row1 < 0 || row1 >= grid.length || 
				col1 < 0 || col1 >= grid[0].length || 
				row2 < 0 || row2 >= grid.length || 
				col2 < 0 || col2 >= grid[0].length) {
			return 0;
		}

		if(memo.containsKey(pos)) {
			return memo.get(pos);
		}

		int ret = 0;
		if(grid[row1][col1] > 0) {
			ret += grid[row1][col1];
			grid[row1][col1] = -grid[row1][col1];
		}

		if(grid[row2][col2] > 0) {
			ret += grid[row2][col2];
			grid[row2][col2] = -grid[row2][col2];
		}

		int[][] directions = new int[][] {{1, -1}, {1, 0}, {1, 1} };
		int max = 0;

		for(int[] d1: directions) {
			for(int[] d2: directions) {
				max = Math.max(max, dp(grid, Arrays.asList(row1 + d1[0], col1 + d1[1],
						row2 + d2[0], col2 + d2[1]), memo));
			}
		}

		if(grid[row1][col1] < 0) {
			grid[row1][col1] = -grid[row1][col1];
		}

		if(grid[row2][col2] < 0) {
			grid[row2][col2] = -grid[row2][col2];
		}

		memo.put(new ArrayList<>(pos), max + ret);

		return max + ret;
	}

	// TLE
	public int cherryPickup2(int[][] grid) {
		return helper(grid, 0, 0, 0, grid[0].length - 1);
	}

	public int helper(int[][] grid, int row1, int col1, int row2, int col2) {
		if(row1 < 0 || row1 >= grid.length || 
				col1 < 0 || col1 >= grid[0].length || 
				row2 < 0 || row2 >= grid.length || 
				col2 < 0 || col2 >= grid[0].length) {
			return 0;
		}

		int ret = 0;
		if(grid[row1][col1] > 0) {
			ret += grid[row1][col1];
			grid[row1][col1] = -grid[row1][col1];
		}

		if(grid[row2][col2] > 0) {
			ret += grid[row2][col2];
			grid[row2][col2] = -grid[row2][col2];
		}

		int[][] directions = new int[][] {{1, -1}, {1, 0}, {1, 1} };
		int max = 0;

		for(int[] d1: directions) {
			for(int[] d2: directions) {
				max = Math.max(max, helper(grid, row1 + d1[0], col1 + d1[1],
						row2 + d2[0], col2 + d2[1]));
			}
		}

		if(grid[row1][col1] < 0) {
			grid[row1][col1] = -grid[row1][col1];
		}

		if(grid[row2][col2] < 0) {
			grid[row2][col2] = -grid[row2][col2];
		}

		return max + ret;
	}
}
