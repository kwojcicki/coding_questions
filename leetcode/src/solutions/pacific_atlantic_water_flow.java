package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pacific_atlantic_water_flow {
	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
List<List<Integer>> ret = new ArrayList<>();
        
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return ret;

		boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
		boolean[][] pacific = new boolean[matrix.length][matrix[0].length];

		Queue<int[]> q = new LinkedList<>();
		for(int c = 0; c < matrix[0].length; c++) q.add(new int[] {matrix.length - 1, c});
		for(int r = 0; r < matrix.length; r++) q.add(new int[] {r, matrix[0].length - 1});
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int r = point[0];
			int c = point[1];

			if(matrix[r][c] < 0) continue;

			atlantic[r][c] = true;

			if(r + 1 < matrix.length && matrix[r + 1][c] >= 0 && matrix[r+1][c] >= matrix[r][c]) {
				q.add(new int[] {r + 1, c});
			}

			if(r - 1 >= 0 && matrix[r - 1][c] >= 0 && matrix[r - 1][c] >= matrix[r][c]) {
				q.add(new int[] {r - 1, c});
			}

			if(c + 1 < matrix[r].length && matrix[r][c + 1] >= 0 && matrix[r][c + 1] >= matrix[r][c]) {
				q.add(new int[] {r, c + 1});
			}

			if(c - 1 >= 0 && matrix[r][c - 1] >= 0 && matrix[r][c - 1] >= matrix[r][c]) {
				q.add(new int[] {r, c - 1});
			}

			matrix[r][c] = -matrix[r][c];
            
            if(matrix[r][c] == 0) matrix[r][c] = Integer.MIN_VALUE;
		}

		for(int r = 0; r < matrix.length; r++) {
			for(int c = 0; c < matrix[r].length; c++) {
                if(matrix[r][c] == Integer.MIN_VALUE) matrix[r][c] = 0;
				if(matrix[r][c] < 0) matrix[r][c] = Math.abs(matrix[r][c]);
			}
		}
		
		q = new LinkedList<>();
		for(int c = 0; c < matrix[0].length; c++) q.add(new int[] {0, c});
		for(int r = 0; r < matrix.length; r++) q.add(new int[] {r, 0});
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int r = point[0];
			int c = point[1];

			if(matrix[r][c] < 0) continue;

			pacific[r][c] = true;

			if(r + 1 < matrix.length && matrix[r + 1][c] >= 0 && matrix[r+1][c] >= matrix[r][c]) {
				q.add(new int[] {r + 1, c});
			}

			if(r - 1 >= 0 && matrix[r - 1][c] >= 0 && matrix[r - 1][c] >= matrix[r][c]) {
				q.add(new int[] {r - 1, c});
			}

			if(c + 1 < matrix[r].length && matrix[r][c + 1] >= 0 && matrix[r][c + 1] >= matrix[r][c]) {
				q.add(new int[] {r, c + 1});
			}

			if(c - 1 >= 0 && matrix[r][c - 1] >= 0 && matrix[r][c - 1] >= matrix[r][c]) {
				q.add(new int[] {r, c - 1});
			}

			matrix[r][c] = -matrix[r][c];
            
            if(matrix[r][c] == 0) matrix[r][c] = Integer.MIN_VALUE;
		}
		
		for(int r = 0; r < matrix.length; r++) {
			for(int c = 0; c < matrix[r].length; c++) {
				if(pacific[r][c] && atlantic[r][c]) {
					ret.add(Arrays.asList(new Integer[] {r, c}));
				}
			}
		}

		return ret;
	}
}
