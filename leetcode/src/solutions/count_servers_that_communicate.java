package solutions;

public class count_servers_that_communicate {
    public int countServers(int[][] grid) {
        int[] xs = new int[grid[0].length];
        int[] ys = new int[grid.length];
        int count = 0;
        
        for(int y = 0; y < grid.length; y++) {
        	for(int x = 0; x < grid[y].length; x++) {
        		xs[x] += grid[y][x];
        		ys[y] += grid[y][x];
        	}
        }
        
        for(int y = 0; y < grid.length; y++) {
        	for(int x = 0; x < grid[y].length; x++) {
        		if(grid[y][x] == 1 && (xs[x] > 1 || ys[y] > 1)) {
        			count += 1;
        		}
        	}
        }
        
        
        return count;
    }
}
