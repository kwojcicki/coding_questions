package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class top_k_frequent_words {
    public List<String> topKFrequent(String[] words, int k) {
    	List<String> ret = new ArrayList<>(k);
        Map<String, Integer> count = new HashMap<>();
        Queue<Map.Entry<String, Integer>> q = new PriorityQueue<>((a,b) -> {
        	if(a.getValue() == b.getValue()) {
        		return b.getKey().compareTo(a.getKey());
        	}
        	
        	return a.getValue() - b.getValue();
        });
        
        for(String w: words) {
        	count.compute(w, (k1, v) -> v == null ? 1 : v + 1);
        }
        
        for(Map.Entry<String, Integer> w: count.entrySet()) {
        	q.add(w);
        	if(q.size() > k) q.poll();
        }
        
        while(k-- > 0) {
        	ret.add(q.poll().getKey());
        }
        
        Collections.reverse(ret);
        return ret;
    }
}
