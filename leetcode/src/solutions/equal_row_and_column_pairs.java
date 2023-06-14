package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class equal_row_and_column_pairs {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> l = new HashMap<>();
        int ret = 0;

        for(int[] i: grid){
        	List<Integer> t = Arrays.stream(i).boxed().collect(Collectors.toList());         	
        	l.put(t, l.getOrDefault(t, 0) + 1);
        }

// System.out.println(l);
        for(int i = 0; i < grid[0].length; i++) {
        	List<Integer> t = new ArrayList<>(grid.length);
        	for(int j = 0; j < grid.length; j++) {
        		t.add(grid[j][i]);
        	}
            // System.out.println("Getting");
            // System.out.println(t);
        	ret += l.getOrDefault(t, 0);
        }
        
        return ret;
    }
}
