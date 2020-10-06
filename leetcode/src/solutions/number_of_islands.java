package solutions;

public class number_of_islands {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int r = 0; r < grid.length; r++) {
        	for(int c = 0; c < grid[r].length; c++) {
        		if(grid[r][c] == '1') {
        			count++;
        			convert(grid, r, c);
        		}
        	}
        }
        
        return count;
    }
    
    public void convert(char[][] grid, int r, int c) {
    	if(r < 0 || r >= grid.length || c < 0 || c >= grid[r].length) return;
    	
        if(grid[r][c] == '0') return;
        
    	grid[r][c] = '0';
    	
    	convert(grid, r + 1, c);
    	convert(grid, r - 1, c);
    	convert(grid, r, c + 1);
    	convert(grid, r, c - 1);
    }
}
