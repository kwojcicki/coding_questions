package solutions;

import java.util.Arrays;

public class two_city_scheduling {
    public int twoCitySchedCost(int[][] costs) {
        int ret = 0;
        
        for(int i = 0; i < costs.length; i++) {
        	ret += costs[i][0];
        	costs[i][1] = costs[i][1] - costs[i][0];
        }
        
        Arrays.sort(costs, (a, b) -> Integer.compare(a[1], b[1]));
        
        for(int i = 0; i < costs.length / 2; i++) {
        	ret += costs[i][1];
        }
        
        return ret;
    }
}
