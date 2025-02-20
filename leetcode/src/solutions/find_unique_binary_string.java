package solutions;

import java.util.HashSet;
import java.util.Set;

public class find_unique_binary_string {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(String s: nums) seen.add(Integer.parseInt(s, 2));
        for(int i = 0; i < (int)Math.pow(2, nums.length); i++) {
        	if(!seen.contains(i)) {
        		String start = Integer.toBinaryString(i);
        		return "0".repeat(nums.length - start.length()) + start;
        	}
        }
        
        return null;
    }
}
