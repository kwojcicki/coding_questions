package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class course_schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int found = 0;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> m = new HashMap<>();
        int[] inbound = new int[numCourses];
        
        for(int[] n: prerequisites) {
        	m.putIfAbsent(n[1], new ArrayList<>());
        	m.get(n[1]).add(n[0]);
        	inbound[n[0]]++;
        }
        
        for(int i = 0; i < inbound.length; i++) {
        	if(inbound[i] == 0) {
        		q.add(i);
        	}
        }
        
        while(!q.isEmpty()) {
        	Integer n = q.poll();
			found++;
        	if(!m.containsKey(n)) continue;
        	
        	for(Integer next: m.get(n)) {
        		if(--inbound[next] == 0) {
        			q.add(next);
        		}
        	}
        }
    	
    	return found == numCourses;
    }
}
