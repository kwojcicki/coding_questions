package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class binary_trees_with_factors {
	long mod = (long) (Math.pow(10, 9) + 7);
	Set<Integer> numbers = new HashSet<>();
    Map<Integer, Long> ways = new HashMap<>();
    
    public int numFactoredBinaryTrees(int[] arr) {
        for(int i: arr) numbers.add(i);
        return numbers.stream().map(i -> helper(i)).
        		reduce((a,b) -> (a + b) % mod).get().intValue();
    }
    
    public long helper(int root) {
    	if(ways.containsKey(root)) return ways.get(root);
    	
    	long ret = 1;
    	for(int x: numbers) {
    		if(root % x == 0 && numbers.contains(root / x)) {
    			ret += helper(root / x) * helper(x) % mod;
    		}
    	}
    	
    	ways.put(root, ret);
    	return ret;
    }
}
