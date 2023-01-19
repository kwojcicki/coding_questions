package solutions;

import java.util.HashMap;
import java.util.Map;

public class subarray_sums_divisible_by_k {
    public int subarraysDivByK(int[] nums, int k) {
    	int ret = 0;
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i: nums) {
        	total = (total + i) % k;
            if(total < 0) total += k;
        	ret += map.getOrDefault(total, 0);
        	map.compute(total, (k1,v) -> v == null ? 1 : v + 1);
        }
        return ret;
    }
}
