package project_euler;

public class q15 {

	/**
	 *
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.


How many such routes are there through a 20×20 grid?
	 */
	public static void main(String[] args) {

		int i = 20;
		int j = 20;
		long[][] seen = new long[i + 1][j + 1];
		seen[0][0] = 1;
		
		
		
		System.out.println(recurse(i, j, seen));
	}
	
	public static long recurse(int i, int j, long[][] seen) {
		
		if(i == 0 && j == 0) {
			return 1;
		}
		
		if(i < 0 || j < 0) {
			return 0;
		}
		
		long routes = 0;
		if(i - 1 >= 0 && seen[i - 1][j] > 0) {
			routes += seen[i - 1][j];
		} else {
			routes += recurse(i - 1, j, seen);
		}
		
		if(j - 1 >= 0 && seen[i][j - 1] > 0) {
			routes += seen[i][j - 1];
		} else {
			routes += recurse(i, j - 1, seen);
		}
		
		seen[i][j] = routes;
		
		return routes;
	}
}
