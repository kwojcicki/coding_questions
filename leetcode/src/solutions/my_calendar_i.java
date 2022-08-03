package solutions;

import java.util.TreeMap;

public class my_calendar_i {
	class MyCalendar {

		TreeMap<Integer, Integer> map = new TreeMap<>();
	    public MyCalendar() {
	        
	    }
	    
	    public boolean book(int start, int end) {
	        Integer lower = map.lowerKey(end);
	        if(lower == null || map.get(lower) <= start) {
	        	map.put(start, end);
	        	return true;
	        }
	        
	        return false;
	    }
	}
}
