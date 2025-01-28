package solutions;

public class maximum_number_of_fish_in_a_grid {
    public int findMaxFish(int[][] grid) {
        int ret = 0;
        
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		ret = Math.max(ret, dfs(i, j, grid));
        	}
        }
        
        return ret;
    }
    
    public int dfs(int i, int j, int[][] grid) {
    	if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
    	if(grid[i][j] <= 0) return 0;
    	int ret = grid[i][j];
    	grid[i][j] = 0;
    	
    	return ret + dfs(i + 1, j, grid)
	    	+ dfs(i - 1, j, grid) 
	    	+ dfs(i, j + 1, grid) 
	    	+ dfs(i, j - 1, grid);
    }
}
