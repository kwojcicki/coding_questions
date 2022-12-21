package solutions;

import java.util.ArrayList;
import java.util.List;

public class possible_bipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] c = new int[n + 1];
        
        List<List<Integer>> m = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
        	m.add(new ArrayList<>());
        }
        
        for(int[] d: dislikes) {
        	m.get(d[0]).add(d[1]);
        	m.get(d[1]).add(d[0]);
        }
        
        for(int i = 1; i <= n; i++) {
        	if(c[i] == 0 && !dfs(c, m, i, 1)) return false;
        }
        
        return true;
    }
    
    public boolean dfs(int[] c, List<List<Integer>> m, int i, int col) {
    	c[i] = col;
    	
    	for(int n: m.get(i)) {
    		if(c[n] == 0 && !dfs(c, m, n, col * -1)) return false;
    		else if(c[n] != col * -1) return false;
    	}
    	
    	return true;
    }
}
