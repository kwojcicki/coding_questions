package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class top_k_frequent_elements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ret = new int[k];
        
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i: nums) count.compute(i, (key, v) -> v == null ? 1 : v + 1);
        
        Queue<Integer[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        
        for(Map.Entry<Integer, Integer> e: count.entrySet()) {
        	q.add(new Integer[] { e.getValue(), e.getKey() });
        	if(q.size() > k) q.poll();
        }
        
        for(int i = 0; i < k; i++) {
        	ret[i] = q.poll()[1];
        }
        
        return ret;
    }
}
