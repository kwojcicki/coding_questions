package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class two_sum_iii_data_structure_design {
	
	class TwoSum {

		Map<Integer, Integer> map = new HashMap<>();
	    /** Initialize your data structure here. */
	    public TwoSum() {
	        
	    }
	    
	    /** Add the number to an internal data structure.. */
	    public void add(int number) {
	       map.put(number, map.getOrDefault(number, 0) + 1);
	    }
	    
	    /** Find if there exists any pair of numbers which sum is equal to the value. */
	    public boolean find(int value) {
	       for(int a: map.keySet()) {
	    	   if(value - a == a) {
	    		   if(map.get(a) > 1) return true;
	    	   } else {
	    		   if(map.containsKey(value - a)) return true;
	    	   }
	       }
	       return false;
	    }
	}
	
	class TwoSum1 {

		Set<Integer> single = new HashSet<>();
		Set<Integer> pair = new HashSet<>();
	    /** Initialize your data structure here. */
	    public TwoSum1() {
	        
	    }
	    
	    /** Add the number to an internal data structure.. */
	    public void add(int number) {
	        if(single.add(number)) {
	        	for(int i: single) {
	        		if(i != number) {
	        			pair.add(i + number);
	        		}
	        	}
	        }
	    }
	    
	    /** Find if there exists any pair of numbers which sum is equal to the value. */
	    public boolean find(int value) {
	        return pair.contains(value);
	    }
	}
	
	
}
