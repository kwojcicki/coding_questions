package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class shortest_path_with_alternating_colors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
    	int[] blueC = new int[n];
    	int[] redC = new int[n];
        Arrays.fill(blueC, Integer.MAX_VALUE);
        Arrays.fill(redC, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        
        Map<Integer, Set<Integer>> red = new HashMap<>();
        Map<Integer, Set<Integer>> blue = new HashMap<>();
        for(int[] r: redEdges) {
        	red.computeIfAbsent(r[0], (k) -> new HashSet<>()).add(r[1]);
        }
        
        for(int[] b: blueEdges) {
        	blue.computeIfAbsent(b[0], (k) -> new HashSet<>()).add(b[1]);
        }
        
        int count = 0;
        q.add(new int[] {0, -1});
        q.add(new int[] {0, 1});
        while(!q.isEmpty()) {
        	for(int i = q.size() - 1; i >= 0; i--) {
        		int[] node = q.poll();
        		int[] ret = node[1] == 1 ? redC : blueC;
        		int[] otherR = node[1] == 1 ? blueC : redC;
        		ret[node[0]] = Math.min(ret[node[0]], count);
        		Map<Integer, Set<Integer>> m = node[1] == 1 ? red : blue;
        		if(!m.containsKey(node[0])) continue;
        		
        		for(int neighbor: m.get(node[0])) {
        			if(otherR[neighbor] != Integer.MAX_VALUE) continue;
        			q.add(new int[] {neighbor, - node[1]});
        		}
        	}
        	count++;
        }
        
    	int[] ret = new int[n];
        for(int i = 0; i < n; i++) {
        	ret[i] = Math.min(blueC[i], redC[i]);
        	ret[i] = ret[i] == Integer.MAX_VALUE ? -1 : ret[i];
        }
        
        return ret;
    }
}
