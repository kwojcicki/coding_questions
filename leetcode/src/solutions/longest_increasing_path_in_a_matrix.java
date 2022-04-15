package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class longest_increasing_path_in_a_matrix {

	public int getMatrix(int x, int y, int[][] matrix) {
		if(!checkBounds(x, y, matrix)) return -1;

		return matrix[x][y];
	}
	

	public boolean checkBounds(int x, int y, int[][] matrix) {
		return !(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length);
	}

	public int longestIncreasingPath(int[][] matrix) {
		int[][] dp = new int[matrix.length][matrix[0].length];
		int[][] bigger = new int[matrix.length][matrix[0].length];

		Queue<Integer[]> q = new LinkedList<>();

		for(int x = 0; x < matrix.length; x++) {
			for(int y = 0; y < matrix[0].length; y++) {
				bigger[x][y] = (getMatrix(x - 1, y, matrix) > matrix[x][y] ? 1 : 0) +
						(getMatrix(x + 1, y, matrix) > matrix[x][y] ? 1 : 0) +
						(getMatrix(x, y + 1, matrix) > matrix[x][y] ? 1 : 0) +
						(getMatrix(x, y - 1, matrix) > matrix[x][y] ? 1 : 0);
			}
		}

		for(int x = 0; x < matrix.length; x++) {
			for(int y = 0; y < matrix[0].length; y++) {
				if(bigger[x][y] == 0) q.add(new Integer[] {x, y});
			}
		}

		while(!q.isEmpty()) {
			Integer[] n = q.poll();
			int x = n[0], y = n[1];
			// System.out.println(x + " " + y);

			dp[x][y] = Math.max(1, 1 + 
					Math.max( 
							getDp(x - 1, y, dp, matrix, matrix[x][y]), 
							Math.max( 
									getDp(x + 1, y, dp, matrix, matrix[x][y]),
									Math.max( 
											getDp(x, y - 1, dp, matrix, matrix[x][y]),
											getDp(x, y + 1, dp, matrix, matrix[x][y])))));

			add(x - 1, y, matrix, bigger, q, matrix[x][y]);
			add(x + 1, y, matrix, bigger, q, matrix[x][y]);
			add(x, y - 1, matrix, bigger, q, matrix[x][y]);
			add(x, y + 1, matrix, bigger, q, matrix[x][y]);
		}

		int max = 0;
		for(int[] i: dp) {
			// System.out.println(Arrays.toString(i));
			for(int n: i) {
				max = Math.max(n, max);
			}
		}

		return max;
	}

	private int getDp(int x, int y, int[][] dp, int[][] matrix, int j) {
		if(!checkBounds(x, y, matrix)) return -1;

		if(matrix[x][y] <= j) return -1;
		
		return dp[x][y];
	}


	private void add(int x, int y, int[][] matrix, int[][] bigger, Queue<Integer[]> q, int value) {
		if(checkBounds(x, y, matrix) && matrix[x][y] < value) {
			bigger[x][y] -= 1;
			if(bigger[x ][y] == 0) q.add(new Integer[] {x, y});
		}
	}
}
