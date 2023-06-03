package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class time_needed_to_inform_all_employees {
	int max = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    	Map<Integer, List<Integer>> m = new HashMap<>();
    	for(int i = 0; i < manager.length; i++) {
    		m.computeIfAbsent(manager[i], (k) -> new ArrayList<>()).add(i);
    	}
    	dfs(headID, m, informTime, 0);
    	return max;
    }
    
    public void dfs(int i, Map<Integer, List<Integer>> m, int[] informTime, int curr) {
    	max = Math.max(max, curr + informTime[i]);
    	
    	for(int j: m.getOrDefault(i, List.of())){
    		dfs(j, m, informTime, curr + informTime[i]);
    	}
    }
}
