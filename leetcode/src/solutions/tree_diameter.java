package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class tree_diameter {
	
	
	public int treeDiameter(int[][] edges) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int[] edge: edges) {
			if(!map.containsKey(edge[0])) {
				map.put(edge[0], new ArrayList<>());
			}
			
			if(!map.containsKey(edge[1])) {
				map.put(edge[1], new ArrayList<>());
			}
			
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}
		
		return recurse(0, -1, map)[0];
	}
	
    public int[] recurse(int n, int parent, Map<Integer, List<Integer>> map) {
    	
    	int[] maxDepth1 = new int[] {0, 0}, maxDepth2 = new int[] {0, 0};
    	for(int x: map.get(n)) {
    		if(x == parent) continue;
    		int[] next = recurse(x, n, map);
    		if(next[1] > maxDepth1[1]) {
    			maxDepth2 = maxDepth1;
    			maxDepth1 = next;
    		} else if(next[1] > maxDepth2[1]) {
    			maxDepth2 = next;
    		}
    	}
    	
    	return new int[] {
    			Math.max(maxDepth1[0], Math.max(maxDepth2[0], maxDepth1[1] + maxDepth2[1])),
    			Math.max(maxDepth1[1], maxDepth2[1]) + 1
    	};
    }
	
	public int treeDiameter2(int[][] edges) {
		int max = 0;
		
		int B = bfs(0, edges)[1];
		
		return bfs(B, edges)[0];
	}
	
	public int[] bfs(int n, int[][] edges) {
		Queue<Integer> bfs = new LinkedList<>();
    	Set<Integer> visited = new HashSet<Integer>();
    	bfs.add(n);
    	visited.add(n);
    	
    	int lvl = -1;
    	int last = 0;
    	while(!bfs.isEmpty()) {
    		lvl += 1;
    		
    		Queue<Integer> next = new LinkedList<>();
    		
    		while(!bfs.isEmpty()) {
    			int x = bfs.poll();
    			last = x;
    			for(int[] edge: edges) {
    				if(edge[0] == x && !visited.contains(edge[1])) {
    					next.add(edge[1]);
    					visited.add(edge[1]);
    				} else if(edge[1] == x && !visited.contains(edge[0])) {
    					next.add(edge[0]);
    					visited.add(edge[0]);
    				}
    			}
    		}
    		
    		bfs.addAll(next);
    	}
    	
    	return new int[] {lvl, last};
	}
	
    public int treeDiameter1(int[][] edges) {
        int max = 0;
        
        
        for(int i = 0; i < edges.length; i++) {
        	
        	Queue<Integer> bfs = new LinkedList<>();
        	Set<Integer> visited = new HashSet<Integer>();
        	bfs.add(i);
        	visited.add(i);
        	
        	int level = 0;
        	while(!bfs.isEmpty()) {
        		level += 1;
        		
        		Queue<Integer> next = new LinkedList<>();
        		
        		while(!bfs.isEmpty()) {
        			int x = bfs.poll();
        			for(int[] edge: edges) {
        				if(edge[0] == x && !visited.contains(edge[1])) {
        					next.add(edge[1]);
        					visited.add(edge[1]);
        				} else if(edge[1] == x && !visited.contains(edge[0])) {
        					next.add(edge[0]);
        					visited.add(edge[0]);
        				}
        			}
        		}
        		
        		bfs.addAll(next);
        	}
        	
        	max = Math.max(level, max);
        }
        
        return max;
    }
}
