package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class shortest_path_visiting_all_nodes {
    public int shortestPathLength(int[][] graph) {
    	Queue<Tuple> q = new LinkedList<>();
    	Set<Integer>[] sets = new HashSet[graph.length];
    	
    	for(int i = 0; i < graph.length; i++) {
    		q.add(new Tuple(1 << i, i, 0));
    		sets[i] = new HashSet<>();
    		sets[i].add(1 << i);
    	}
    	
    	while(!q.isEmpty()) {
    		Tuple t = q.poll();
    		
    		if(t.mask == (1 << graph.length) - 1) {
    			return t.length;
    		}
    		
    		for(int n: graph[t.node]) {
    			Tuple newT = new Tuple( t.mask | (1 << n), n, t.length + 1);
    			if(sets[n].add(newT.mask)) {
    				q.add(newT);
    			}
    		}
    	}
    	
    	return -1;
    }
    
    class Tuple {
    	public int mask;
    	public int node;
    	public int length;
    	public Tuple(int m, int n, int l) {
    		mask = m; node = n; length = l;
    	}
    }
}
