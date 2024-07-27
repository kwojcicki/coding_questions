package solutions;

import java.util.Arrays;

public class find_the_city_with_the_smallest_number_of_neighbors_at_a_threshold_distance {

	// Floyd–Warshall algorithm
	// https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    	int minIndex = 0;
        int min = Integer.MAX_VALUE;
        
        int[][] dp = new int[n][n];
        for(int[] d: dp) Arrays.fill(d, 100_000_000);
        for(int i = 0; i < n; i++) dp[i][i] = 0;
        for(int [] e: edges) {
            dp[e[0]][e[1]] = e[2];
            dp[e[1]][e[0]] = e[2];
        }
        
        for(int k = 0; k < n; k++) {
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			if(dp[i][j] > dp[i][k] + dp[k][j]) {
        				dp[i][j] = dp[i][k] + dp[k][j];
        			}
        		}
        	}
        }
        
        for(int idx = 0; idx < dp.length; idx++) {
        	int[] d = dp[idx];
        	int reachable = 0; 
        	for(int i: d) if(i <= distanceThreshold) reachable++;
        	if(reachable <= min) {
        		min = reachable;
        		minIndex = idx;
        	}
        }
        
        return minIndex; 
    }
}
