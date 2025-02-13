package solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class minimum_operations_to_exceed_threshold_value_ii {
    public int minOperations(int[] nums, int k) {
        int ret = 0;
        
        Queue<Integer> q = new PriorityQueue<>();
        for(int i: nums) if(i < k) q.add(i);
        
        while(q.size() >= 2) {
        	int x = q.poll();
        	int y = q.poll();
        	int res = Math.min(x, y) * 2 + Math.max(x, y);
        	if(res < k && res > 0) q.add(res);
        	ret++;
        }
        
        return ret + (q.isEmpty() ? 0 : 1);
    }
}
