package solutions;

import java.util.Arrays;

public class cheapest_flights_within_k_stops {
    public int findCheapestPrice(int n, 
    		int[][] flights, int src, int dst, int k) {
    	
    	int[] d = new int[n];
    	Arrays.fill(d, Integer.MAX_VALUE);
    	d[src] = 0;
    	
    	for(int i = 0; i <= k; i++) {
    		int[] tmp = Arrays.copyOf(d, n);
    		
    		for(int[] f: flights) {
    			if(d[f[0]] != Integer.MAX_VALUE) {
    				tmp[f[1]] = Math.min(d[f[0]] + f[2], tmp[f[1]]);
    			}
    		}

            d = tmp;
    	}
    	
    	
    	return d[dst] == Integer.MAX_VALUE ? -1 : d[dst];
    }
}
