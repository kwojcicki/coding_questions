package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class longest_arithmetic_subsequence {
    public int longestArithSeqLength(int[] nums) {
int ret = 0;
        
        List<Map<Integer, Integer>> l = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
        	Map<Integer, Integer> m = new HashMap<>();
        	for(int j = 0; j < i; j++) {
        		int t = m.getOrDefault(nums[i] - nums[j], 0);
        		int t1 = l.get(j).getOrDefault(nums[i] - nums[j], 1);
        		
                int big = Math.max(t, t1 + 1);
                ret = Math.max(ret, big);
        		m.put(nums[i] - nums[j], Math.max(t, big));
        	}
        	
        	l.add(m);
        }
        // System.out.println(l);
        return ret;
    }
}
