package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class number_of_good_paths {
	public int find(int[] f, int x) {
		if(f[x] != x) 
			f[x] = find(f, f[x]);
		return f[x];
	}

	public int numberOfGoodPaths(int[] vals, int[][] edges) {
		int ret = vals.length;
		int[] f = new int[vals.length];
		List<Map<Integer, Integer>> counts = new ArrayList<>(vals.length);
		for(int i = 0; i < f.length; i++) {
			f[i] = i;
			counts.add(new HashMap<>());
			counts.get(i).put(vals[i], 1);
		}
		int[][] edg = new int[edges.length][3];
		for(int i = 0; i < edges.length; i++) {
			edg[i] = new int[] { 
					Math.max(vals[edges[i][0]], vals[edges[i][1]]), 
					edges[i][0], 
					edges[i][1]
			};
		}

		Arrays.sort(edg, Comparator.comparingInt(a -> a[0]));

		for(int[] e: edg) {
			// System.out.println(Arrays.toString(e));
			// System.out.println(counts);
			int fi = find(f, e[1]);
			int fj = find(f, e[2]);
			if(fi == fj) continue;
			// System.out.println(fi + " " + fj);
			int ci = counts.get(fi).getOrDefault(e[0], 0);
			int cj = counts.get(fj).getOrDefault(e[0], 0);
			ret += ci * cj;
			f[fi] = fj;
			counts.get(fj).put(e[0], ci + cj);
		}

		return ret;
	}
}
