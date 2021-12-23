package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class course_schedule_ii {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] edgesIn = new int[numCourses];
        
        for(int[] edge: prerequisites) {
        	map.putIfAbsent(edge[1], new ArrayList<>());
        	// map.putIfAbsent(edge[1], new ArrayList<>());
        	
        	map.get(edge[1]).add(edge[0]);
        	edgesIn[edge[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] ret = new int[numCourses];
        int node = 0;
        
        for(int i = 0; i < edgesIn.length; i++) {
        	if(edgesIn[i] == 0) {
        		q.add(i);
        	}
        }
        
        while(!q.isEmpty()) {
        	int n = q.poll();
            // System.out.println("n: " + n);
        	ret[node] = n;
        	node++;
        	
        	if(map.get(n) == null) continue;
        	
        	for(int neighbor: map.get(n)) {
        		edgesIn[neighbor]--;
        		
        		if(edgesIn[neighbor] == 0) {
        			q.add(neighbor);
        		}
        	}
        }
        
        return node == ret.length ? ret : new int[0]; 
    }
}
