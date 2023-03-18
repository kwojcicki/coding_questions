package solutions;

import java.util.HashMap;
import java.util.Map;

public class design_browser_history {
	class BrowserHistory {
	    Map<Integer, String> m = new HashMap<>();
	    int max = 0;
	    int curr = -1;
	    public BrowserHistory(String homepage) {
	        visit(homepage);
	    }
	    
	    public void visit(String url) {
	        max = ++curr;
	        m.put(max, url);
	        // System.out.println(m);
	        // System.out.println(curr);
	    }
	    
	    public String back(int steps) {
	        curr = Math.max(0, curr - steps);
	        // System.out.println(m);
	        //  System.out.println(curr);
	        return m.get(curr);
	    }
	    
	    public String forward(int steps) {
	        curr = Math.min(max, curr + steps);
	        // System.out.println(m);
	        //System.out.println(curr);
	        return m.get(curr);
	    }
	}
}
