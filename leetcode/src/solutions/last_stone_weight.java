package solutions;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class last_stone_weight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i: stones) q.add(i);
        
        while(true) {
        	int y = q.poll();
        	if(q.isEmpty()) return y;
        	
        	int x = q.poll();
        	
        	q.add(y - x);
        }
    }
}
