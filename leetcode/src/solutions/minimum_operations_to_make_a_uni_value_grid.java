package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class minimum_operations_to_make_a_uni_value_grid {
    public int minOperations(int[][] grid, int x) {
    	int ret = 0;
    	List<Integer> list = new ArrayList<>();
    	int mod = grid[0][0] % x;
    	for(int[] row: grid) {
    		for(int cell: row) {
    			if(mod != (cell % x)) return -1;
    			list.add(cell);
    		}
    	}
    	
    	Collections.sort(list);
    	
    	int target = list.get(list.size() / 2);
    	
    	for(int[] row: grid) {
    		for(int cell: row) {
    			ret += Math.abs(cell - target) / x;
    		}
    	}
    	
    	return ret;
    }
}
