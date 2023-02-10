package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class as_far_from_land_as_possible {
    public int maxDistance(int[][] grid) {
    	int ret = 0;
        int[][] dirs = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] == 1) {
        			for(int[] d: dirs) {
            			q.add(new int[] {i + d[0], j + d[1]});
        			}
        		}
        	}
        }
        
        while(!q.isEmpty()) {
        	ret++;
        	for(int i = q.size() - 1; i >= 0; i--) {
        		int[] n = q.poll();
        		if(n[0] < 0 || n[1] < 0 || n[0] >= grid.length || n[1] >= grid.length || grid[n[0]][n[1]] == 1) continue;
                grid[n[0]][n[1]] = 1;
        		for(int[] d: dirs) {
        			q.add(new int[] {n[0] + d[0], n[1] + d[1]});
        		}
        	}
        }
        
        return ret == 1 ? -1 : ret - 1;
    }
}
