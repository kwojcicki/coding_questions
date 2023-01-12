package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class number_of_nodes_in_the_sub_tree_with_the_same_label {
	int[] ret;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ret = new int[n];
        boolean[] v = new boolean[n];
        Map<Integer, List<Integer>> m = new HashMap<>();
        for(int[] e: edges) {
        	m.putIfAbsent(e[0], new ArrayList<>());
        	m.putIfAbsent(e[1], new ArrayList<>());
        	m.get(e[0]).add(e[1]);
        	m.get(e[1]).add(e[0]);
        }
        
        helper(0, m, v, labels.toCharArray());
    	return ret;
    }
    
    public int[] helper(int i, Map<Integer, List<Integer>> edges, boolean[] v, char[] labels) {
    	int[] r = new int[26];
    	if(v[i]) return r;
    	v[i] = true;
    	
    	for(int e: edges.getOrDefault(i, List.of())) {
    		int[] n = helper(e, edges, v, labels);
    		for(int j = 0; j < n.length; j++) r[j] += n[j];
    	}
    	
    	r[labels[i] - 'a']++;
    	ret[i] = r[labels[i] - 'a'];
    	return r;
    }
}
