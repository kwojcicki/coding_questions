package solutions;

import java.util.ArrayList;
import java.util.List;

public class all_paths_from_source_to_target {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ret = new ArrayList<>();
        
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        recurse(ret, 0, curr, graph);
        
        return ret;
    }
    
    public void recurse(List<List<Integer>> ret, int n, List<Integer> curr, int[][] graph) {
    	if(n == graph.length - 1) {
    		ret.add(new ArrayList<>(curr));
    		return;
    	}
    	
    	for(int i: graph[n]) {
    		curr.add(i);
    		recurse(ret, i, curr, graph);
    		curr.remove(curr.size() - 1);
    	}
    }
}
