package solutions;

import java.util.ArrayList;
import java.util.List;

public class camelcase_matching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        
    	List<Boolean> ret = new ArrayList<Boolean>();
    	
    	for(String q: queries) {
    		
    		int qL = 0;
    		int pL = 0;
    		boolean flag = true;
    		
    		while(qL < q.length() && pL < pattern.length()) {
    			
    			if(pattern.charAt(pL) == q.charAt(qL)) {
    				System.out.println("1");
    				pL++;
    				qL++;
    				continue;
    			} else if(q.charAt(qL) < 'a' && pattern.charAt(pL) < 'a') {
    				System.out.println("2");
    				flag = false;
    				break;
    			} else if(q.charAt(qL) < 'a') {
    				System.out.println("3");
    				flag = false;
    				break;
    			} else if(pattern.charAt(pL) < 'a') {
    				System.out.println("4");
    				qL++;
    			} else {
    				qL++;
    			}
    		}
    		
    		while(qL < q.length()) {
    			if(q.charAt(qL) >= 'a') {
    				qL++;
    			} else {
    				break;
    			}
    		}
    		
    		System.out.println(flag + " " + qL + " " + pL);
    		if(qL != q.length() || pL != pattern.length()) {
    			flag = false;
    		}
    		
    		ret.add(flag);
    		System.out.println("next: " + q);
    	}
    	
    	return ret;
    }
    public static void main(String[] args) {
    	System.out.println(new camelcase_matching().camelMatch(new String[] {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"},"FoBa"));
    }
}
