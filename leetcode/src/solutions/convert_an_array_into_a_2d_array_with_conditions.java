package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class convert_an_array_into_a_2d_array_with_conditions {
    public List<List<Integer>> findMatrix(int[] nums) {
    	List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        for(int i: nums) {
        	m.compute(i, (k,v) -> v == null ? 1 : v + 1);
        }
        
        while(true) {
        	List<Integer> r = new ArrayList<>();
        	for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
        	    if(entry.getValue() > 0) {
        	    	r.add(entry.getKey());
        	    	entry.setValue(entry.getValue() - 1);
        	    }
        	}
            if(r.isEmpty()){
                break;
            }
        	ret.add(r);
        }
        
        return ret;
    }
}
