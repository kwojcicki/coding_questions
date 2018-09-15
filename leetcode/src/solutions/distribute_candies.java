package solutions;

import java.util.HashSet;
import java.util.Set;

public class distribute_candies {
    public int distributeCandies(int[] candies) {
    	
    	Set<Integer> set = new HashSet<Integer>();
    	for(int n: candies) {
    		set.add(n);
    	}
    	
    	return Math.min(set.size(), candies.length / 2);
    }
}
