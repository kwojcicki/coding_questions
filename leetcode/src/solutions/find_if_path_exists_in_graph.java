package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class find_if_path_exists_in_graph {
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		Map<Integer, List<Integer>> m = new HashMap<>();
		for(int[] e: edges) {
			m.putIfAbsent(e[0], new ArrayList<>());
			m.putIfAbsent(e[1], new ArrayList<>());
			m.get(e[0]).add(e[1]);
			m.get(e[1]).add(e[0]);
		}

		return helper(source, m, destination);
	}

	public boolean helper(int s, Map<Integer, List<Integer>> m, int d) {
		if(s == d) return true;

		boolean f = false;
		List<Integer> neighbors = m.getOrDefault(s, List.of());
		m.remove(s);
		for(int n: neighbors) {
			f |= helper(n, m, d);
		}
		return f;
	}
}
