package solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class construct_target_array_with_multiple_sums {
    public boolean isPossible(int[] target) {
        
        int total = 0;
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    	for(int t: target) {
            total += t;
            pq.add(t);
        }
    	
    	while(!pq.isEmpty() && pq.peek() > 1){
    		int element = pq.poll();
    		
    		if(element - (total - element) < 1) return false;
    		
            // System.out.println(total + " "  + element);
            if(total == element) return false;
    		int newElement = element % (total - element);
            if(newElement == 0 && (total - element) != 1) return false;
    		total = total - (element - newElement);
            
    		pq.add(newElement);
    	}
    	
    	return true;
    }
}
