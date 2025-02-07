package solutions;

import java.util.HashMap;
import java.util.Map;

public class find_the_number_of_distinct_colors_among_the_balls {
    public int[] queryResults(int limit, int[][] queries) {
    	int[] ret = new int[queries.length];
    	Map<Integer, Integer> b2c = new HashMap<>();
    	Map<Integer, Integer> c2c = new HashMap<>();
    	int i = 0;
    	for(int[] q: queries) {
    		Integer old = b2c.put(q[0], q[1]);
    		if(old != null && c2c.compute(old, (k,v) -> v - 1) == 0) {
    			c2c.remove(old);
    		}
    		c2c.compute(q[1], (k,v) -> v == null ? 1 : v + 1);
    		
    		ret[i++] = c2c.size();
    	}
    	
    	
    	return ret;
    }
}
