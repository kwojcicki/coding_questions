package solutions;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class sort_characters_by_frequency {
    public String frequencySort(String s) {
    	return s.
    		chars().
    		boxed().
    		collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
    		entrySet().
    		stream().
    		sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
    		reduce("", 
    				(a,b) -> a + String.join("", 
    						((char)(b.getKey() + 0) + "").repeat(b.getValue().intValue())),
    				(a,b) -> a + b);
    }
    
    public String frequencySort1(String s) {
        
    	StringBuilder sb = new StringBuilder();
    	
    	Map<Character, Integer> x = new HashMap<Character, Integer>();
    	for(char c: s.toCharArray()) {
    		x.put(c, x.getOrDefault(c, 0) + 1);
    	}
    	
    	PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>((p,q) -> q.getValue() - p.getValue());
    	
    	for(Map.Entry<Character, Integer> a: x.entrySet()) {
    		pq.add(a);
    	}
    	
    	while(!pq.isEmpty()) {
    		Map.Entry<Character, Integer> a = pq.poll();
    		for(int i = 0; i < a.getValue(); i++) {
    			sb.append(a.getKey());
    		}
    	}
    	
    	return sb.toString();
    }
}
