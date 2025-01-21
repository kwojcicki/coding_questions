package solutions;

public class grid_game {
    public long gridGame(int[][] grid) {
    	long sumTop = 0;
    	for(int i: grid[0]) sumTop += (long) i;
    	long leftToRightTop = 0;
    	long leftToRightBottom = 0;
    	long ret = Long.MAX_VALUE;
    	
    	for(int i = 0; i < grid[0].length; i++) {
    		
    		leftToRightTop += (long) grid[0][i];
    		
    		// System.out.println(i  + " " + leftToRightTop + " " + leftToRightBottom + " " + 
    		//		rightToLeftBottom);
    		
            ret = Math.min(ret, Math.max(sumTop - leftToRightTop,
                    leftToRightBottom));
           // System.out.println(max + " " + ret);
    		
    		leftToRightBottom += (long) grid[1][i];
    	}
    	
    	return ret;
    }
}
