package solutions;

public class max_area_of_island {

    public int maxAreaOfIsland(int[][] grid) {
        int ret = 0;
        
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[i].length; j++) {
        		ret = Math.max(ret, helper(i, j, grid));
        	}
        }
        
        return ret;
    }
    
    public int helper(int i, int j, int[][] grid) {
    	if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length
    			|| grid[i][j] == 0) {
    		return 0;
    	}
    	
    	grid[i][j] = 0;
    	return helper(i + 1, j, grid)
    			+ helper(i - 1, j, grid)
    			+ helper(i, j + 1, grid)
    			+ helper(i, j - 1, grid) + 1;
    }
}
