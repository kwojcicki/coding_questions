package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class shortest_path_in_binary_matrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir = new int[][] { 
        	{1, 0}, {0, 1}, {1, 1}, {-1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}
        };
        
    	if(grid == null || grid.length <= 0 || grid[0].length <= 0) {
    		return -1;
    	}
    	
    	if(grid[grid.length - 1][grid[0].length -1 ] != 0) {
    		return -1;
    	}
    	// System.out.println("start");
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[]{0, 0});
    	int lvl = 1;
    	while(!q.isEmpty()) {
    		for(int i = q.size(); i > 0; i--) {
    			int[] pos = q.poll();
    			if(!valid(pos, grid)) continue;
    			if(grid[pos[0]][pos[1]] != 0) continue;
                grid[pos[0]][pos[1]] = 1;
    			// System.out.println(pos[0] + " " + pos[1]); 
    			if(pos[0] == grid.length - 1 && pos[1] == grid[0].length - 1) {
    				return lvl;
    			}
    			
    			for(int[] d: dir) {
    				q.add(new int[]{ pos[0] + d[0], pos[1] + d[1]});
    			}
    		}
    		lvl++;
    	}
    	
    	return -1;
    }
    
    public boolean valid(int[] pos, int[][] graph) {
    	return !(pos[0] < 0 || pos[1] < 0 || pos[0] >= graph.length || pos[1] >= graph[0].length);
    }
}
