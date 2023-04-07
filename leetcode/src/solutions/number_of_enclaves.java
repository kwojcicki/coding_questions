package solutions;

public class number_of_enclaves {
	public int numEnclaves(int[][] grid) {
        int ret = 0;
        
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] == 0) continue;
        		int t = dfs(i, j, grid);
        		if(t == -1) continue;
        		ret += t;
        	}
        }
        
        return ret;
    }
    
    public int dfs(int i, int j, int[][] grid) {
    	if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return -1;
    	
    	if(grid[i][j] == 0) return 0;
    	grid[i][j] = 0;
    	int ans1 = dfs(i + 1, j, grid);
    	int ans2 = dfs(i - 1, j, grid);
    	int ans3 = dfs(i, j + 1, grid);
    	int ans4 = dfs(i, j - 1, grid);
    	
    	if(ans1 == -1 || ans2 == -1 || ans3 == -1 || ans4 == -1) return -1;
    	return ans1 + ans2 + ans3 + ans4 + 1;
    }
}
