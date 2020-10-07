package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class rotting_oranges {
    public int orangesRotting(int[][] grid) {
        int max = 0;
        
        max = bfs(grid);
        
        for(int[] r: grid) {
        	for(int c: r) {
        		if(c == 1) return -1;
        	}
        }
        
        return max;
    }
    
    public int bfs(int[][] grid) {
    	
    	Queue<Integer[]> q = new LinkedList<>();
    	
        for(int r = 0; r < grid.length; r++) {
        	for(int c = 0; c < grid[r].length; c++) {
        		if(grid[r][c] == 2) {
        			q.add(new Integer[] {r, c});
        		}
        	}
        }
    	
    	int lvl = -1;
    	int r, c;
    	while(!q.isEmpty()) {
    		lvl++;
    		for(int i = q.size() - 1; i >= 0; i--) {
    			
    			Integer[] rotten = q.poll();
    			r = rotten[0];
    			c = rotten[1];
    			
    			if(r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] == 0) continue;
    			
    			grid[r][c] = 0;
    			q.add(new Integer[] {r + 1, c});
    			q.add(new Integer[] {r - 1, c});
    			q.add(new Integer[] {r, c + 1});
    			q.add(new Integer[] {r, c - 1});
    			
    		}
    	}
    	
    	return lvl;
    }
}
