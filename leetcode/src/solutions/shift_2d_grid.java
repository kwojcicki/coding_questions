package solutions;

import java.util.ArrayList;
import java.util.List;

public class shift_2d_grid {

	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		List<List<Integer>> ret = new ArrayList<>();

		k = k % (grid.length * grid[0].length);

		for(int i = 0; i < grid.length * grid[0].length; i++) {
			int toGet = k > i ? grid.length * grid[0].length - (k - i) : i - k;

			int col = i / grid[0].length;

			if(ret.size() <= col) ret.add(new ArrayList<>());

			ret.get(col).add(grid[toGet / grid[0].length][toGet % grid[0].length]);
		}

		return ret;
	}
}
