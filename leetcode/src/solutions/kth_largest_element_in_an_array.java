package solutions;

import java.util.PriorityQueue;

public class kth_largest_element_in_an_array {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int num: nums) {
        	q.add(num);
        	if(q.size() > k) q.poll();
        }
        
        return q.peek();
    }
}
