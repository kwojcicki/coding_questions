package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class shortest_bridge {
    public int shortestBridge(int[][] grid) {

        Queue<int[]> isl1 = new LinkedList<>();
    	Queue<int[]> q = new LinkedList<>();
    	int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    	
			outerloop:
    	for(int i = 0; i < grid.length; i++) {
    		for(int j = 0; j < grid.length; j++) {
    			if(grid[i][j] == 1)  {
    				isl1.add(new int[] {i, j});
    	    	grid[i][j] = 2;
    				q.add(new int[] {i, j});
    				break outerloop;
    			}
    		}
    	}
    	
    	while(!isl1.isEmpty()) {
    		int[] n = isl1.poll();
    		for(int [] d: dir) {
    			int newI = n[0] + d[0];
    			int newY = n[1] + d[1];
    			if(newI >= 0 && newI < grid.length && 
    					newY >= 0 && newY < grid.length && 
    					grid[newI][newY] == 1) {
    				grid[newI][newY] = 2;
    				q.add(new int[] {newI, newY});
    				isl1.add(new int[] {newI, newY});
    			}
    		}
    	}
    	
    	int count = 0;
    	while(!q.isEmpty()) {
    		for(int size = q.size(); size > 0; size--) {
    			int[] n= q.poll();
    			
    			for(int [] d: dir) {
        			int newI = n[0] + d[0];
        			int newY = n[1] + d[1];
        			if(newI >= 0 && newI < grid.length && 
        					newY >= 0 && newY < grid.length && 
        					grid[newI][newY] == 0) {
        				grid[newI][newY] = 2;
        				q.add(new int[] {newI, newY});
        			} else if(newI >= 0 && newI < grid.length && 
        					newY >= 0 && newY < grid.length && 
        					grid[newI][newY] == 1) {
        				return count;
        			} 
        		}
    		}
    		count++;
    	}
    	
    	return count;
    }
}
