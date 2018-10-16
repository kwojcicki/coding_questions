package misc;

import java.util.Arrays;

public class interview2 {

	public static void main(String[] args) {
		int[][] A = new int[][] {
			new int[] {1, 2, 3, 4},
			new int[] {1, 2, -10, 4},
			new int[] {1, -1, 3, 4},
			new int[] {1, 2, 3, 4},
		};
		
		
		
		int max = 0;
		boolean[][] visited = new boolean[A.length][A[0].length];
		
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[i].length; j++) {
				System.out.println("starting");
				max = Math.max(max, traverse(A, i, j, visited));
			}
		}
		
		System.out.println(max);
	}
	
	public static boolean[][] deepCopy(boolean[][] in){
		return Arrays.stream(in).map(i -> i.clone()).toArray(i -> in.clone());
	}
	
	public static int traverse(int[][] A, int i, int j, boolean[][] visited) {
		int max = 0;
		visited[i][j] = true;
		
		if(possible(A, i + 1, j, visited)) {
			max = Math.max(max, traverse(A, i + 1, j, deepCopy(visited)));
		}
		if(possible(A, i - 1, j, visited)) {
			max = Math.max(max, traverse(A, i - 1, j, deepCopy(visited)));
		}
		if(possible(A, i, j + 1, visited)) {
			max = Math.max(max, traverse(A, i, j + 1, deepCopy(visited)));
		}
		if(possible(A, i, j - 1, visited)) {
			max = Math.max(max, traverse(A, i, j - 1, deepCopy(visited)));
		}
		
		//System.out.println(max);
		return max + A[i][j];
	}
	
	public static boolean possible(int[][] A, int i, int j, boolean[][] visited) {
		return i >= 0 && i < A.length && j >= 0 && j < A[i].length && !visited[i][j];
	}
	
}
