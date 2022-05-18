package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class critical_connections_in_a_network {
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<List<Integer>> ret = new ArrayList<>();
		Map<Integer, List<Integer>> edges = new HashMap<>();
		
		for(List<Integer> e: connections) {
			edges.putIfAbsent(e.get(0), new ArrayList<>());
			edges.putIfAbsent(e.get(1), new ArrayList<>());
			edges.get(e.get(0)).add(e.get(1));
			edges.get(e.get(1)).add(e.get(0));
		}
		
		boolean[] visited = new boolean[n];
		int[] depth = new int[n];
		int[] low = new int[n];
		Integer[] parent = new Integer[n];
		Arrays.fill(parent, null);
		
		getArticulationPoints(0, 0, edges, visited, depth, low, parent, ret);
		
		return ret;
	}
	
	private void getArticulationPoints(int i, int d, Map<Integer, List<Integer>> edges, boolean[] visited, int[] depth, int[] low, Integer[] parent,
			List<List<Integer>> ret) {
        
		visited[i] = true;
		depth[i] = d;
		low[i] = d;
		
		for(int e: edges.get(i)) {
			if(!visited[e]) {
			 	parent[e] = i;
			 	getArticulationPoints(e, d + 1, edges, visited, depth, low, parent, ret);
			 	low[i] = Math.min(low[i], low[e]);
			 	if(low[e] > depth[i]) {
			 		ret.add(Arrays.asList(e, i));
			 	}
			} else if(parent[i] != null && e != parent[i]) {
				low[i] = Math.min(low[i], depth[e]);
			}
		}
	}
}
