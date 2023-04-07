package solutions;

public class number_of_closed_islands {
	public int closedIsland(int[][] grid) {
		int ret = 0;

		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 0 && dfs(i, j,  grid)) {
					ret++;
					// System.out.println(i + " " + j);
				}
			}
		}

		return ret;
	}

	public boolean dfs(int i, int j, int[][] grid) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return false;

		if(grid[i][j] == 1) return true;

		grid[i][j] = 1;
		boolean ans1 = dfs(i + 1, j, grid);
		boolean ans2 = dfs(i - 1, j, grid);
		boolean ans3 = dfs(i, j - 1, grid);
		boolean ans4 = dfs(i, j + 1, grid);

		return ans1 && ans2 && ans3 && ans4;
	}
}
