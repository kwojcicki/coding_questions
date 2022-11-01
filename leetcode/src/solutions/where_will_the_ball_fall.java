package solutions;

public class where_will_the_ball_fall {
	public int[] findBall(int[][] grid) {
		int[] ret = new int[grid[0].length];

		for(int i = 0; i < ret.length; i++) {
			ret[i] = simulate(0, i, grid);
		}

		return ret;
	}

	public int simulate(int r, int c, int[][] grid) {
		if(c < 0 || c >= grid[0].length) return -1; 
		if(r == grid.length) {
			return c;
		}

		if(grid[r][c] == 1) {
			if(c + 1 >= grid[0].length || grid[r][c + 1] != 1) {
				return -1;
			}

			return simulate(r + 1, c + 1, grid);
		}

		if(c - 1 < 0 || grid[r][c - 1] != -1) {
			return -1;
		}

		return  simulate(r + 1, c - 1, grid);
	}
}
