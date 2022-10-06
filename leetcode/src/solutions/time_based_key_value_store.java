package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class time_based_key_value_store {
	class TimeMap {
		Map<String, TreeMap<Integer, String>> map = new HashMap<>();
	    public TimeMap() {
	        
	    }
	    
	    public void set(String key, String value, int timestamp) {
	        map.putIfAbsent(key, new TreeMap<>());
	        map.get(key).put(timestamp, value);
	    }
	    
	    public String get(String key, int timestamp) {
	        if(!map.containsKey(key)) return "";
	        Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
	        return entry == null ? "" : entry.getValue();
	    }
	}

}
