package solutions;

import java.util.HashMap;
import java.util.Map;

public class minimum_number_of_operations_to_make_array_empty {
    public int minOperations(int[] nums) {
    	int ret = 0;
        Map<Integer, Integer> cnts = new HashMap<>();
        
        for(int i: nums) {
        	cnts.compute(i, (k,v) -> v == null ? 1 : v + 1);
        }
        
        for(int i: cnts.values()) {
        	if(i == 1) return -1;
            	int leftover = i % 3;
            	if(leftover == 0) ret += i / 3;
            	else if(leftover == 1) ret += (i - 3) / 3 + 2;
            	else if(leftover == 2) ret += i / 3 + 1;
        	
        }
        
        return ret;
    }
}
