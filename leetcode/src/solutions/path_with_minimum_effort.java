package solutions;

import java.util.Arrays;

public class path_with_minimum_effort {
	public int minimumEffortPath(int[][] heights) {
		int high = 0;
		
		for(int[] i: heights)
			for(int j: i)
				high = Math.max(j, high);
		
		int low = 0;
		
		while(low <= high) {
            // System.out.println(low + " " + high);
			int mid = (high + low) / 2;
			boolean[][] visited = new boolean[heights.length][heights[0].length];
			for(int i = 0; i < heights.length; i++) Arrays.fill(visited[i], false);
			
			if(possible(heights, visited, mid, 0, 0, heights[0][0])) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
            // System.out.println(low + "-" + high);
		}
		
		return low;
	}

	public boolean possible(int[][] heights, boolean[][] visited, int threshold, int x, int y, int last) {
		if(x < 0 || y < 0 || x >= visited.length || y >= visited[0].length) return false;
        
		if(visited[x][y] || Math.abs(heights[x][y] - last) > threshold) return false;

		if(x == visited.length - 1 && y == visited[0].length - 1) return true;

		visited[x][y] = true;
		
		return possible(heights, visited, threshold, x + 1, y, heights[x][y]) || 
				possible(heights, visited, threshold, x - 1, y, heights[x][y]) ||
				possible(heights, visited, threshold, x, y + 1, heights[x][y]) ||
				possible(heights, visited, threshold, x, y - 1, heights[x][y]);
	}
}
