package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class minimum_score_of_a_path_between_two_cities {
	
    int ret = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        boolean[] seen = new boolean[n + 1];
        Map<Integer, List<int[]>> m = new HashMap<>();
        for(int[] r: roads) {
        	m.computeIfAbsent(r[0], (k) -> new ArrayList<>()).add(r);
        	m.computeIfAbsent(r[1], (k) -> new ArrayList<>()).add(r);
        }
        
        dfs(m, seen, 1);
        return ret;
    }
    
    public void dfs(Map<Integer, List<int[]>> m, boolean[] seen, int i) {
    	if(seen[i]) return;
    	seen[i] = true;
    	for(int[] n: m.getOrDefault(i, List.of())) {
    		ret = Math.min(ret, n[2]);
    		if(n[1] == i) {
        		dfs(m, seen, n[0]);
    		} else {
        		dfs(m, seen, n[1]);
    		}
    	}
    }
}
