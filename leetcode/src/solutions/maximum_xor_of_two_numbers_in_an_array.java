package solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class maximum_xor_of_two_numbers_in_an_array {
    public int findMaximumXOR(int[] nums) {
        
        int maxLength = Arrays.stream(nums).map(i -> Integer.toBinaryString(i).length()).max().getAsInt();
    	
    	int max = 0, curr = 0;
    	Set<Integer> prefix = new HashSet<Integer>();
    	for(int i = maxLength - 1; i >= 0; i--) {
    		max <<= 1;
    		curr = max | 1;
            
    		
    		prefix.clear();
    		for(int n: nums) prefix.add(n >> i);
    	
            
    		for(int n: prefix) {
    			if(prefix.contains(n ^ curr)) {
    				max = curr;
    				break;
    			}
    		}
    	}
    	
    	
    	return max;
    }
}
