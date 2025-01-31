package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class making_a_large_island {
	
	public int paint(int i , int j, int[][] grid, int p) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length
         || grid[i][j] != 1) return 0;
		grid[i][j] = p;
		return 1 + paint(i + 1, j, grid, p)
			+ paint(i - 1, j, grid, p)
			+ paint(i, j + 1, grid, p)
			+ paint(i, j - 1, grid, p);
	}
	
	public int get(int i, int j, int[][] grid, List<Integer> sizes) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) return 0;
		
		return grid[i][j];
	}
	
    public int largestIsland(int[][] grid) {
        List<Integer> sizes = new ArrayList<>();
        sizes.add(0); sizes.add(0);
        
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] == 1) {
        			sizes.add(paint(i, j, grid, sizes.size()));
        		}
        	}
        }
        
        int ret = sizes.get(sizes.size() - 1);

        for(int i = 0; i < grid.length; i++) {
                // System.out.println(Arrays.toString(grid[i]));
        	for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 0) {
					Set<Integer> islands = new HashSet<>();
					islands.add(get(i + 1, j, grid, sizes));
					islands.add(get(i - 1, j, grid, sizes));
					islands.add(get(i, j + 1, grid, sizes));
					islands.add(get(i, j - 1, grid, sizes));
                    ret = Math.max(ret, 1 + islands.stream()
                    .mapToInt(island -> sizes.get(island)).sum());
				}
        	}
        }
        
        return ret;
    }
}
