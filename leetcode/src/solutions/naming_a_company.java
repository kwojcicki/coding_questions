package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class naming_a_company {
    public long distinctNames(String[] ideas) {
        long ret = 0;
        Map<Character, Set<String>> c = new HashMap<>();
        for(String idea: ideas) {
        	c.computeIfAbsent(idea.charAt(0), (k) -> new HashSet<>())
        		.add(idea.substring(1));
        }
        
        for(char k1: c.keySet()) {
        	for(char k2: c.keySet()) {
        		if(k1 == k2) continue;
        		Set<String> left = c.get(k1);
        		Set<String> right = c.get(k2);
        		long k1Count = left.stream().filter(i -> !right.contains(i)).count();
        		long k2Count = right.stream().filter(i -> !left.contains(i)).count();
        		
        		ret += k1Count * k2Count;
        	}
        }
        
        return ret;
    }
}
