package solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class kth_largest_element_in_a_stream {
	class KthLargest {

	    private Queue<Integer> q;
        private int k;
	    public KthLargest(int k, int[] nums) {
	    	 q = new PriorityQueue<>(k);
	    	 this.k = k;
	    	 
	    	 for(int i: nums) {
	    		 add(i);
	    	 }
	    }
	    
	    public int add(int val) {
	        q.add(val);
	    	if(q.size() > k) q.poll();
	        return q.peek();
	    }
	}
}
