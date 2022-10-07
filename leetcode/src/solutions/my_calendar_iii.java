package solutions;

import java.util.Map;
import java.util.TreeMap;

public class my_calendar_iii {
	class MyCalendarThree {

		Map<Integer, Integer> count = new TreeMap<>();
	    public MyCalendarThree() {
	        
	    }
	    
	    public int book(int start, int end) {
	        count.compute(start, (k,v) -> v == null ? 1 : v + 1);
	        count.compute(end, (k,v) -> v == null ? -1 : v - 1);
	        int curr = 0;
	        int max = 0;
	        for(int v: count.values()) {
	        	curr += v;
	        	max = Math.max(curr, max);
	        }
	        return max;
	    }
	}
}
