package solutions;

import java.util.HashMap;
import java.util.Map;

public class max_sum_of_a_pair_with_equal_sum_of_digits {
    public int maximumSum(int[] nums) {
        int ret = -1;
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i: nums) {
        	int tmp = i;
        	int sum = 0;
        	while(i > 0) {
        		sum += i % 10;
        		i /= 10;
        	}
        	
        	Integer pair = m.get(sum);
        	if(pair != null) ret = Math.max(ret, tmp + pair);
        	
        	m.compute(sum, (k,v) -> v == null ? tmp : Math.max(tmp, v));
        }
        return ret;
    }
}
