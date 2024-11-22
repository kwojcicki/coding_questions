package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class flip_columns_for_maximum_number_of_equal_rows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
    	int ret = 0;
        int[] flipped = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
        	int same = 1;
        	for(int j = 0; j < matrix[i].length; j++) flipped[j] = 1 - matrix[i][j];
        	for(int k = i + 1; k < matrix.length; k++) {
        		if(Arrays.equals(matrix[i], matrix[k]) || 
        				Arrays.equals(flipped, matrix[k])) same++;
        	}
        	ret = Math.max(ret, same);
        }
        
        return ret; 
    }
}
