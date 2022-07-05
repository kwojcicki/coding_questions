package solutions;

import java.util.HashSet;
import java.util.Set;

public class longest_consecutive_sequence {

    public int longestConsecutive(int[] nums) {
    	int ret = 0;
        Set<Integer> set = new HashSet<>();
        for(int i: nums) set.add(i);
        
        for(int i: nums) {
        	if(!set.contains(i + 1)) {
        		int curr = 0;
        		while(set.contains(i)) {
        			curr++;
        			i--;
        		}
        		
        		ret = Math.max(curr, ret);
        	}
        }
        
        return ret;
    }
    
}
