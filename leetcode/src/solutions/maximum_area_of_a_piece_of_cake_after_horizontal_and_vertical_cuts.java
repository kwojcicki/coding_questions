package solutions;

import java.util.Arrays;

public class maximum_area_of_a_piece_of_cake_after_horizontal_and_vertical_cuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    	Arrays.sort(horizontalCuts);
    	Arrays.sort(verticalCuts);
        long maxH = helper(horizontalCuts, h);
        long maxW = helper(verticalCuts, w);
        return (int) ((maxW * maxH) % (long)(Math.pow(10, 9) + 7));
    }
    
    public int helper(int[] arr, int max) {
    	int ret = 0;
    	int curr = 0;
    	
    	for(int a: arr) {
    		ret = Math.max(ret, a - curr);
    		curr = a;
    	}
    	
    	return Math.max(ret, max - curr);
    }
}
