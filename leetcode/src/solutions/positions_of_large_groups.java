package solutions;

import java.util.ArrayList;
import java.util.List;

public class positions_of_large_groups {
    public List<List<Integer>> largeGroupPositions(String S) {
    	
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	int count = 1;
    	for(int i = 1; i < S.length(); i++) {
    		if(S.charAt(i) == S.charAt(i - 1)) {
    			count++;
    		} else {
    			
    			if(count >= 3) {
    				List<Integer> newGroup = new ArrayList<>();
    				newGroup.add(i - count);
    				newGroup.add(i - 1);
    				ret.add(newGroup);
    			}
    			
    			count = 1;
    		}
    	}
    	
		if(count >= 3) {
			List<Integer> newGroup = new ArrayList<>();
			newGroup.add(S.length() - count);
			newGroup.add(S.length() - 1);
			ret.add(newGroup);
		}
    	return ret;
    }
}
