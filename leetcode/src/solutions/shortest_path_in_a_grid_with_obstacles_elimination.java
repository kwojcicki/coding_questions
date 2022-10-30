package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class shortest_path_in_a_grid_with_obstacles_elimination {
    
    public int shortestPath(int[][] grid, int k) {
    	
    	boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {0, 0, 0});
    	
    	int ret = 0;
    	while(!q.isEmpty()) {
    		for(int i = q.size() - 1; i >= 0; i--) {
    			int[] n = q.poll();
    			
    			if(n[0] < 0 || n[0] >= grid.length ||
    					n[1] < 0 || n[1] >= grid[0].length ||
    					n[2] > k) continue;
    			
    			if(n[0] == grid.length - 1 && n[1] == grid[0].length - 1)
    				return ret;
    			
    			if(visited[n[0]][n[1]][n[2]]) {
    				continue;
    			}
    			
    			visited[n[0]][n[1]][n[2]] = true;
    			
    			if(grid[n[0]][n[1]] == 1 && n[2] == k) continue;
    			
    			if(grid[n[0]][n[1]] == 1) {
    				q.add(new int[] {n[0] + 1, n[1], n[2] + 1});
    				q.add(new int[] {n[0] - 1, n[1], n[2] + 1});
    				q.add(new int[] {n[0], n[1] + 1, n[2] + 1});
    				q.add(new int[] {n[0], n[1] - 1, n[2] + 1});
    			} else {
    				q.add(new int[] {n[0] + 1, n[1], n[2]});
    				q.add(new int[] {n[0] - 1, n[1], n[2]});
    				q.add(new int[] {n[0], n[1] + 1, n[2]});
    				q.add(new int[] {n[0], n[1] - 1, n[2]});
    			}
    		}
    		ret++;
    	}
    	
    	return -1;
    }
    
}
