package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class least_number_of_unique_integers_after_k_removals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
    	Map<Integer, Integer> m = new HashMap<>();
        for(int i: arr) m.compute(i, (k1,v) -> v == null ? 1 : v + 1);
        Queue<Integer> q = new PriorityQueue<>((a,b) -> {
        	return Integer.compare(m.get(a), m.get(b));
        });
        for(int i: m.keySet()) q.add(i);
        int ret = m.size();
        while(k > 0 && !q.isEmpty()) {
        	int n = m.get(q.poll());
        	k -= n;
        	if(k >= 0) ret--;
        }
        return ret;
    }
}
