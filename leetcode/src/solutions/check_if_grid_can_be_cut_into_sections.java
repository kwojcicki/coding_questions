package solutions;

import java.util.Arrays;

public class check_if_grid_can_be_cut_into_sections {
	public boolean checkValidCuts(int n, int[][] rectangles) {
		int found = 0;

		// vertical line sweep
		Arrays.sort(rectangles, (a,b) -> a[1] == b[1] ? a[3] - b[3] : a[1] - b[1]);
		int y = -1;
		for(int[] rectangle: rectangles) {
			if(y <= rectangle[1]) found++;
			if(found == 3) return true;
			y = Math.max(y, rectangle[3]);
			// System.out.println(Arrays.toString(rectangle) + " " + y + " " + found);
		}

		// System.out.println("Horizontal");
		// horizontal line sweep
		found = 0;
		Arrays.sort(rectangles, (a,b) -> a[0] == b[0] ? a[2] - b[2] : a[0] - b[0]);
		int x = -1;
		for(int[] rectangle: rectangles) {
			if(x <= rectangle[0]) found++;
			if(found == 3) return true;
			x = Math.max(x, rectangle[2]);
		}

		return false;
	}
}
