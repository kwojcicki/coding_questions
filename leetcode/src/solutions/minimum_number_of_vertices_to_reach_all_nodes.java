package solutions;

import java.util.ArrayList;
import java.util.List;

public class minimum_number_of_vertices_to_reach_all_nodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    	int[] in = new int[n];
        List<Integer> ret = new ArrayList<>();

        for(List<Integer> e: edges){
            in[e.get(1)]++;
        }
        
        for(int i = 0; i < in.length; i++) {
        	if(in[i] == 0) {
        		ret.add(i);
        	}
        }
        
        return ret;
    }
}
