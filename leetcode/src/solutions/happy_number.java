package solutions;

import java.util.HashSet;
import java.util.Set;

public class happy_number {
    public boolean isHappy(int n) {
    	// alternative flyod cycle O(1) space
    	Set<Integer> seen = new HashSet<Integer>();
    	
    	while(n != 1) {
    		
    		if(seen.contains(n)) {
    			return false;
    		}
    		
    		seen.add(n);
    		
    		int newN = 0;
    		while(n > 0) {
    			newN += Math.pow(n % 10, 2);
    			n /= 10;
    		}
    		
    		n = newN;
    		
    	}
    	
    	
    	return true;
    }
}
