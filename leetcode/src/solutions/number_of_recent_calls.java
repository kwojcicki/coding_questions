package solutions;

import java.util.Deque;
import java.util.LinkedList;

public class number_of_recent_calls {
	class RecentCounter {

		Deque<Integer> queue;
	    public RecentCounter() {
	        queue = new LinkedList<>();
	    }
	    
	    public int ping(int t) {
	        while(!queue.isEmpty() && t - queue.peek() > 3000) {
	        	queue.pop();
	        }
	        
	        queue.add(t);
	        
	        return queue.size();
	    }
	}
}
