package solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class lru_cache {

}

class LRUNode {
	private int key;
	private int val;
	
	public LRUNode(int key, int val) {
		this.key = key;
		this.val = val;
	}
	
	public int getVal() {
		return val;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setVal(int v) {
		this.val = v;
	}
}

class LRUCache {

	private LinkedList<LRUNode> list = new LinkedList<LRUNode>();
	private Map<Integer, LRUNode> map = new HashMap<Integer, LRUNode>();
	private int cap;
	
    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
    	if(!map.containsKey(key)) return -1;
    	
    	list.remove(map.get(key));
    	list.addLast(map.get(key));
    	
    	return map.get(key).getVal();
    }
    
    public void put(int key, int value) {
    	System.out.println(map);
    	
    	if(!map.containsKey(key)) {
        	if(map.size() == cap) {
        		map.remove(list.getFirst().getKey());
        		list.removeFirst();
        	}
        	
    		map.put(key, new LRUNode(key, value));
    		list.addLast(map.get(key));
    	} else {
    		map.get(key).setVal(value);
    		
        	list.remove(map.get(key));
        	list.addLast(map.get(key));
    	}
    }
}