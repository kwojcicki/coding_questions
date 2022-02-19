package solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class minimize_deviation_in_array {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        
        for(int i: nums) {
        	q.add(i % 2 == 1 ? i * 2 : i);
        	min = Math.min(min, i % 2 == 1 ? i * 2 : i);
        }
        
        int diff = Integer.MAX_VALUE;
        while(q.peek() % 2 == 0) {
        	int max = q.poll();
            // System.out.println(max + " " + max / 2);
            diff = Math.min(diff, max - min);
        	min = Math.min(min, max / 2);
        	q.add(max / 2);
        }
        
        // System.out.println(q.peek() + " " + min);
        return Math.min(diff, q.peek() - min);
    }
}
