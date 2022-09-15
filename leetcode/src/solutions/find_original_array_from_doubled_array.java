package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class find_original_array_from_doubled_array {
    public int[] findOriginalArray(int[] changed) {
    	if(changed.length % 2 == 1) return new int[0];
        int[] ret = new int[changed.length / 2];
        int idx = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        Arrays.sort(changed);
        
        for(int i: changed) {
        	seen.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        
        for(int i: changed) {
            // System.out.println(i + " " + seen);
        	if(seen.get(i) == 0) continue;
        	
        	if(seen.getOrDefault(i * 2, 0) == 0 || 
              (i == 0 && seen.get(0) == 1)) return new int[0];
        	seen.compute(i * 2, (k,v) -> v - 1);
            seen.compute(i, (k,v) -> v - 1);
        	ret[idx++] = i;
        }
        
        return idx == ret.length ? ret : new int[0];
    }
}
