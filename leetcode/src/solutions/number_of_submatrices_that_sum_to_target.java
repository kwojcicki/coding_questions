package solutions;

import java.util.HashMap;
import java.util.Map;

public class number_of_submatrices_that_sum_to_target {
	public int numSubmatrixSumTarget(int[][] matrix, int target) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 1; j < matrix[i].length; j++) {
				matrix[i][j] += matrix[i][j - 1];
			}
		}
		
		int ret = 0;
		for(int c1 = 0; c1 < matrix[0].length; c1++) {
			for(int c2 = c1; c2 < matrix[0].length; c2++) {
				Map<Integer, Integer> m = new HashMap<>();
				m.put(0, 1);
				int curr = 0;
				for(int r = 0; r < matrix.length; r++) {
					curr += matrix[r][c2] - (c1 > 0 ? matrix[r][c1 - 1] : 0);
					ret += m.getOrDefault(curr - target, 0);
					m.put(curr, m.getOrDefault(curr, 0) + 1);
				}
			}
		}
		
		return ret;
	}
	
	public int numSubmatrixSumTarget1(int[][] matrix, int target) {
        int ret = 0;
        
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[i].length; j++) {
        		if(i > 0) matrix[i][j] += matrix[i - 1][j];
        		if(j > 0) matrix[i][j] += matrix[i][j - 1];
        		if(i > 0 && j > 0) matrix[i][j] -= matrix[i - 1][j - 1];
        	}
            // System.out.println(Arrays.toString(matrix[i]));
        }
        
        for(int r1 = 0; r1 < matrix.length; r1++) {
        	for(int r2 = r1; r2 < matrix.length; r2++) {
        		for(int c1 = 0; c1 < matrix[r1].length; c1++) {
        			for(int c2 = c1; c2 < matrix[r1].length; c2++) {
            			int tmp = matrix[r2][c2];
            			if(c1 > 0) tmp -= matrix[r2][c1 - 1];
            			if(r1 > 0) tmp -= matrix[r1 - 1][c2];
            			if(c1 > 0 && r1 > 0) tmp += matrix[r1 - 1][c1 - 1];
            			if(tmp == target) ret++;
        			}
        		}
        	}
        }
        
        return ret;
    }
}
