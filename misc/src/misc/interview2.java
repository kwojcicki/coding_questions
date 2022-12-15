package misc;

import java.util.Arrays;

public class interview2 {

	public static void main(String[] args) {
		int[][] A = new int[][] {
			new int[] {4, 2, 4},
			new int[] {0, 3, 1},
			new int[] {3, 7, 9},
		};

		System.out.println(longestSequence(A));

		A = new int[][] {
			new int[] {1, 6, 2},
			new int[] {8, 3, 7},
			new int[] {4, 9, 5},
		};

		System.out.println(longestSequence(A));
		
		A = new int[][] {
			new int[] {8, 2, 4},
			new int[] {0, 6, 1},
			new int[] {3, 7, 9},
		};

		System.out.println(longestSequence(A));
	}


	public static int longestSequence(int[][] grid) {
		int max = 0;
		boolean[][] visited;

		// find longest sequence from each starting position and get max
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				visited = new boolean[grid.length][grid[0].length];
				max = Math.max(max, traverse(grid, i, j, visited));
			}
		}

		return max;
	}

	/**
	 * returns a deep copy of 2d boolean array
	 * @param in
	 * @return
	 */
	public static boolean[][] deepCopy(boolean[][] in){
		return Arrays.stream(in).map(i -> i.clone()).toArray(i -> in.clone());
	}

	/**
	 * traverses all possible paths from a point i,j in A and with a specified
	 * visited
	 * @param A
	 * @param i
	 * @param j
	 * @param visited
	 * @return
	 */
	public static int traverse(int[][] A, int i, int j, boolean[][] visited) {
		int max = 0;
		visited[i][j] = true;

		// possible directions from point i,j including diagnols
		int[][] directions = new int[][] {
			new int[] {1, 0}, 
			new int[] {0, 1}, 
			new int[] {-1, 0}, 
			new int[] {0, -1}, 
			new int[] {-1,-1}, 
			new int[] {-1,1},
			new int[] {1,-1}, 
			new int[] {1,1},
		};

		for(int[] direction: directions) {
			if(possible(A, i + direction[0], j + direction[1], visited, A[i][j])) {
				max = Math.max(max, traverse(A, i + direction[0], j + direction[1], deepCopy(visited)));
			}
		}

		// longest subsequence is the longest subsequence of neighbours + the current element
		return max + 1;
	}

	/**
	 * checks if i,j is a valid location given the curr element
	 * rules for determining if valid
	 * 	in bounds, not visited and diff > 3
	 * @param A
	 * @param i
	 * @param j
	 * @param visited
	 * @param curr
	 * @return
	 */
	public static boolean possible(int[][] A, int i, int j, boolean[][] visited, int curr) {
		return i >= 0 && i < A.length && j >= 0 && j < A[i].length && !visited[i][j] && Math.abs(A[i][j] - curr) > 3;
	}

}
