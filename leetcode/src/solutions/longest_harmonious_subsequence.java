package solutions;

import java.util.HashMap;
import java.util.Map;

public class longest_harmonious_subsequence {
    public int findLHS(int[] nums) {
        int ret = 0;
        
        Map<Integer, Integer> count = new HashMap<>();
        for(int i: nums) {
        	int newCount = count.getOrDefault(i, 0) + 1;
        	count.put(i, newCount);
        	
        	int left = count.getOrDefault(i - 1, 0)  + newCount;
        	int right = count.getOrDefault(i + 1, 0) + newCount;
        	
        	if(left != newCount) {
        		ret = Math.max(ret, left);
        	}
        	
        	if(right != newCount) {
        		ret = Math.max(ret, right);
        	}
        }
        
        return ret;
    }
}
