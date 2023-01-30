package solutions;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class lfu_cache {
	class LFUCache {

	    Map<Integer, Integer> values  = new HashMap<>();
	    Map<Integer, Integer> counts = new HashMap<>();
	    Map<Integer, LinkedHashSet<Integer>> lists = new HashMap<>();
	    int capacity;
	    int min = -1;
	    public LFUCache(int capacity) {
	        this.capacity = capacity;
	        lists.put(1, new LinkedHashSet<>());
	    }
	    
	    public int get(int key) {
	        if(!values.containsKey(key)) return -1;
	        int count = counts.get(key);
	        counts.put(key, count + 1);
	        lists.get(count).remove(key);
	        if(count == min && lists.get(count).isEmpty()) {
	        	min++;
	        }
	        lists.putIfAbsent(count + 1, new LinkedHashSet<>());
	        lists.get(count + 1).add(key);
	        return values.get(key);
	    }
	    
	    public void put(int key, int value) {
	        if(capacity <= 0) return;
	        if(values.containsKey(key)) {
	        	values.put(key, value);
	        	this.get(key);
	        	return;
	        }
	        if(values.size() >= capacity) {
	        	int remove = lists.get(min).iterator().next();
	        	lists.get(min).remove(remove);
	        	values.remove(remove);
	        }
	        
	        values.put(key, value);
	        counts.put(key, 1);
	        min = 1;
	        lists.get(1).add(key);
	    }
	}
}
