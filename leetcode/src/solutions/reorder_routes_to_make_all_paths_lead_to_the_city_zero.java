package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class reorder_routes_to_make_all_paths_lead_to_the_city_zero {
    public int minReorder(int n, int[][] connections) {
    	Map<Integer, List<int[]>> m = new HashMap<>();
        for(int[] c: connections){
            m.computeIfAbsent(c[0], (k) -> new ArrayList<>()).add(new int[] {c[0], c[1], 1});
            m.computeIfAbsent(c[1], (k) -> new ArrayList<>()).add(new int[] {c[1], c[0], 0});
        }
        int ret = 0;
        
        boolean[] seen = new boolean[n];
        seen[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
        	int i = q.poll();
        	for(int[] c: m.getOrDefault(i, List.of())) {
        		if(!seen[c[1]]) {
        			seen[c[1]] = true;
        			ret += c[2];
        			q.add(c[1]);
        		}
        	}
        }
        
        return ret;
    }
}
