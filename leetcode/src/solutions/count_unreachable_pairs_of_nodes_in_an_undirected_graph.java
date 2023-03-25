package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class count_unreachable_pairs_of_nodes_in_an_undirected_graph {
	public long countPairs(int n, int[][] edges) {
        long ret = 0;
        List<Long> groupSizes = new ArrayList<>(n);
        boolean[] seen = new boolean[n];
        Map<Integer, List<Integer>> m = new HashMap<>();
        for(int[] e: edges) {
        	m.computeIfAbsent(e[0], (k) -> new ArrayList<>()).add(e[1]);
        	m.computeIfAbsent(e[1], (k) -> new ArrayList<>()).add(e[0]);
        }
        
        for(int i: m.keySet()) {
        	long size = dfs(i, m, seen);
        	if(size != 0) groupSizes.add(size);
        }
        for(int i = m.size(); i < n; i++) {
        	groupSizes.add(1L);
        }
        long total = 0;
        for(long i: groupSizes) {
        	ret += i * (n - total - i);
        	total += i;
        }
        
        return ret;
    }
    
    public long dfs(int i, Map<Integer, List<Integer>> m, boolean[]  seen) {
    	if(seen[i]) return 0;
    	seen[i] = true;
    	long ret = 1;
    	for(int n: m.getOrDefault(i, List.of())) {
    		ret += dfs(n, m, seen);
    	}
    	return ret;
    }
}
