package solutions;

import java.util.HashMap;
import java.util.Map;

public class longest_cycle_in_a_graph {
    public int longestCycle(int[] edges) {
        int ret = -1;
        Map<Integer, int[]> m = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++) {
        	int t = dfs(i, i, m, edges, 0);
        	if(t != 0) ret = Math.max(t, ret);
        }
        
        return ret;
    }
    
    public int dfs(int start, int i, Map<Integer, int[]> m, int[] edges, int dist) {
    	if(m.containsKey(i)) {
    		if(m.get(i)[0] == start) {
    			return dist - m.get(i)[1];
    		}
    		return 0;
    	}
    	m.put(i, new int[] {start, dist});
    	if(edges[i] == -1) return 0;
    	return dfs(start, edges[i], m, edges, dist +  1);
    }
}
