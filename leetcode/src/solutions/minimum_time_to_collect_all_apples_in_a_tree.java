package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class minimum_time_to_collect_all_apples_in_a_tree {
	int ret = 0;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    	Map<Integer, List<Integer>> e = new HashMap<>();
    	for(int[] ed: edges) {
    		e.putIfAbsent(ed[0], new ArrayList<>());
    		e.putIfAbsent(ed[1], new ArrayList<>());
    		e.get(ed[0]).add(ed[1]);
    		e.get(ed[1]).add(ed[0]);
    	}
        helper(e, hasApple, 0, -1);
        
        return ret;
    }
    
    public boolean helper(Map<Integer, List<Integer>> edges, List<Boolean> hasApple, int i, int prev) {
    	boolean f = hasApple.get(i);
    	
    	for(int e: edges.getOrDefault(i, List.of())) {
    		if(prev == e) continue;
    		boolean t = helper(edges, hasApple, e, i);
    		if(t) {
    			ret += 2;
    			f = true;
    		}
    	}
    	
    	return f;
    }
}
