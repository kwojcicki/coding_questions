package solutions;

public class unique_paths_iii {
	public int uniquePathsIII(int[][] grid) {

		int zeroes = 1;
		for(int[] a: grid) {
			for(int b: a) {
				if(b == 0) zeroes++;
			}
		}
        
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[row].length; col++) {
				if(grid[row][col] == 1) {
					return count(grid, row, col, zeroes, true);
				}
			}
		}

		return -1;
	}

	public int count(int[][] grid, int row, int col, int zeroes, boolean starting) {
		if(row < 0 || row >= grid.length ||
				col < 0 || col >= grid[row].length) return 0;

		if(grid[row][col] == -1) return 0;

		if(grid[row][col] == 2) {
			if(zeroes == 0) return 1;
			else return 0;
		}
        
        if(!starting && grid[row][col] == 1) return 0;

		grid[row][col] = -1;

		int ret = count(grid, row + 1, col, zeroes - 1, false) + 
				count(grid, row - 1, col, zeroes - 1, false) +
				count(grid, row, col + 1, zeroes - 1, false) +
				count(grid, row, col - 1, zeroes - 1, false);


		grid[row][col] = 0;

		return ret;
	}
}
