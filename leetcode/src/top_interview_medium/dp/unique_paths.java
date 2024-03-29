package top_interview_medium.dp;

import java.util.Arrays;

public class unique_paths {
    public int uniquePaths(int m, int n) {
    	int[] paths = new int[n];
    	paths[n - 1] = 1;
    	
    	for(int i = 0; i < m; i++) {
    		for(int j = n - 2; j >= 0; j--) {
    			paths[j] += paths[j + 1];
    		}
    	}
    	
    	return paths[0];
    }
    
    public int uniquePaths1(int m, int n) {
    	int[][] paths = new int[m + 1][n + 1];
    	paths[m - 1][n] = 1;
        for(int i = m - 1; i >= 0; i--) {
        	for(int j = n - 1; j >= 0; j--) {
        		paths[i][j] = paths[i + 1][j] + paths[i][j + 1];
        	}
        }
        
        for(int[] path: paths) {
        	System.out.println(Arrays.toString(path));
        }
        return paths[0][0];
    }
}
