package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class minimum_genetic_mutation {
	public int minMutation(String start, String end, String[] bank) {
        int ret = 0;
    	
        Set<String> b = new HashSet<>();
        for(String ba: bank) {
        	b.add(ba);
        }
        
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
        	for(int i1 = q.size() - 1; i1 >= 0; i1--) {
            	String n = q.poll();
            	
            	if(n.equals(end)) return ret;
            	if(visited.contains(n)) continue;
            	visited.add(n);
            	
            	char[] c = n.toCharArray();
            	for(int i = 0; i < 8; i++) {
            		char t = c[i];
            		
            		potentiallyAdd(c, t, i, 'A', q, b);
            		potentiallyAdd(c, t, i, 'C', q, b);
            		potentiallyAdd(c, t, i, 'G', q, b);
            		potentiallyAdd(c, t, i, 'T', q, b);
            		
            	}
        	}
        	
        	ret++;
        }
    	
    	return -1;
    }

	private void potentiallyAdd(char[] c, char t, int i, char d, Queue<String> q, Set<String> b) {
		if(c[i] == d) return;
		
		c[i] = d;
		
		if(b.contains(new String(c))) {
			q.add(new String(c));
		}
		
		c[i] = t;
	}
}
