package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class find_eventual_safe_states {
	public List<Integer> eventualSafeNodes(int[][] graph) {
    	List<Integer> ret = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
    	int[] edges = new int[graph.length];
    	List<List<Integer>> reverse = new ArrayList<>();
    	for(int i = 0; i < graph.length; i++) reverse.add(new ArrayList<>());
    	
    	for(int i = 0; i < graph.length; i++) {
    		for(int n: graph[i]) {
    			edges[i]++;
    			reverse.get(n).add(i);
    		}
    	}
    	
    	for(int i = 0; i < edges.length; i++) if(edges[i] == 0) q.add(i);
    	
    	while(!q.isEmpty()) {
    		int n = q.poll();
    		ret.add(n);
    		for(int i: reverse.get(n)) {
    			edges[i]--;
    			if(edges[i] == 0) q.add(i);
    		}
    	}
    	
    	Collections.sort(ret);
    	return ret;
    }
}
