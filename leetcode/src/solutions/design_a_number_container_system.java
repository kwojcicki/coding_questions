package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class design_a_number_container_system {
	class NumberContainers {

		Map<Integer, SortedSet<Integer>> q = new HashMap<>();
		Map<Integer, Integer> m = new HashMap<>();
	    public NumberContainers() {
	        
	    }
	    
	    public void change(int index, int number) {
	        q.putIfAbsent(number, new TreeSet<>());
	        Integer currOccupiant = m.get(index);
	        if(currOccupiant != null) {
	        	q.get(currOccupiant).remove(index);
	        	m.remove(index);
	        }
	        m.put(index, number);
	        q.get(number).add(index);
	    }
	    
	    public int find(int number) {
	        SortedSet<Integer> spots = q.get(number);
	        if(spots == null) return -1;
            if(spots.isEmpty()) return -1;
	        return spots.first();
	    }
	}
}
