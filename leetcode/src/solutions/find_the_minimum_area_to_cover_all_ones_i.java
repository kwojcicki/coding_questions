package solutions;

public class find_the_minimum_area_to_cover_all_ones_i {
    public int minimumArea(int[][] grid) {
        int left = grid[0].length, right = 0, top = grid.length, bottom = 0;
        
        for(int row = 0; row < grid.length; row++) {
        	for(int col  = 0; col < grid[row].length; col++) {
        		if(grid[row][col] == 1) {
        			left = Math.min(left, col);
        			right = Math.max(right, col);
        			
        			top = Math.min(top, row);
        			bottom = Math.max(bottom, row);
        		}
        	}
        }
        
        // System.out.println(right + " " + left);
        // System.out.println(bottom + " " + top);
        return (right - left + 1) * (bottom - top + 1);
    }
}
