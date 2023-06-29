package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class path_with_maximum_probability {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		Map<Integer, List<int[]>> m = new HashMap<>();
		for (int i = 0; i < edges.length; ++i) {
			m.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(new int[]{edges[i][1], i});
			m.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(new int[]{edges[i][0], i});
		}
		double[] p = new double[n];
		p[start] = 1d;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int[] t : m.getOrDefault(cur, Collections.emptyList())) {
				if (p[cur] * succProb[t[1]] > p[t[0]]) {
					p[t[0]] = p[cur] * succProb[t[1]];
					q.offer(t[0]);
				}
			}
		}
		return p[end];
	}
}
