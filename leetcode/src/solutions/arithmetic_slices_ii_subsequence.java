package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class arithmetic_slices_ii_subsequence {
    public int numberOfArithmeticSlices(int[] nums) {
        int ret = 0;
        List<Map<Integer, Integer>> dp = new ArrayList<>(nums.length);
        
        for(int i = 0; i < nums.length; i++) {
        	dp.add(new HashMap<>());
        	for(int j = 0; j < i; j++) {
        		long diff = (long)nums[i] - nums[j];
        		if(diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE) continue;
        		
        		int d = (int)diff;
        		dp.get(i).putIfAbsent(d, 0);
        		int other = dp.get(j).getOrDefault(d, 0);
        		ret += other;
        		dp.get(i).compute(d, (k,v) -> v + other + 1);
        	}
        }
        
        return ret;
    }
}
