package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class minimum_height_trees {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> ret = new ArrayList<>();

		Map<Integer, List<Integer>> map = new HashMap<>();

		if(n < 2){
			return IntStream.range(0, n).boxed().collect(Collectors.toList());
		}

		for(int[] e: edges) {
			if(!map.containsKey(e[0])) {
				map.put(e[0], new ArrayList<>());
			}

			if(!map.containsKey(e[1])) {
				map.put(e[1], new ArrayList<>());
			}

			map.get(e[0]).add(e[1]);
			map.get(e[1]).add(e[0]);
		}

		Queue<Integer> q = new LinkedList<>();

		for(Map.Entry<Integer, List<Integer>> e: map.entrySet()) {
			if(e.getValue().size() == 1) {
				q.add(e.getKey());
			}
		}

		while(n > 2) {
			for(int i = q.size() - 1; i >= 0; i--) {
				n--;
				Integer node = q.poll();

				if(!map.containsKey(node)) continue;
				for(Integer neighbor: map.get(node)) {
					map.get(neighbor).remove(node);
					// map.get(node).remove(neighbor);

					if(map.get(neighbor).size() == 1) {
						q.add(neighbor);
					}
				}

			}
		}

		// System.out.println(q.toString());
		return q.stream().collect(Collectors.toList());
	}

	public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
		List<Integer> ret = new ArrayList<>();

		Map<Integer, List<Integer>> map = new HashMap<>();

		for(int[] e: edges) {
			if(!map.containsKey(e[0])) {
				map.put(e[0], new ArrayList<>());
			}

			if(!map.containsKey(e[1])) {
				map.put(e[1], new ArrayList<>());
			}

			map.get(e[0]).add(e[1]);
			map.get(e[1]).add(e[0]);
		}

		int min = n;
		for(int i = 0; i < n; i++) {
			int height = bfs(i, map, min);
			//System.out.println("height: " + height + " i: " + i);
			if(height < min) {
				ret.clear();
				ret.add(i);
				min = height;
			} else if(height == min) {
				ret.add(i);
			}
		}

		return ret;
	}

	public int bfs(int node, Map<Integer, List<Integer>> map, int max) {
		int height = -1;

		Queue<Integer[]> q = new LinkedList<Integer[]>();

		q.add(new Integer[] {node, -1}); // node, parent

		while(!q.isEmpty()) {
			height++;
			if(height > max) return max + 1;
			for(int i = q.size() - 1; i >=0; i--) {
				Integer[] e = q.poll();

				if(!map.containsKey(e[0])) continue;
				for(Integer n: map.get(e[0])) {
					if(n != e[1]) {
						q.add(new Integer[] {n, e[0]});
					}
				}
			}
		}

		return height;
	}
}
