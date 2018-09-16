package solutions;

import java.util.HashMap;
import java.util.Map;

public class number_of_boomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int toRet = 0;
    	
        Map<Integer, Integer> x = new HashMap<Integer, Integer>();
        for(int i = 0; i < points.length; i++) {
        	for(int j = 0; j < points.length; j++) {
        		if(j == i) {
        			continue;
        		}
        		
        		
        		int xDiff = points[i][0] - points[j][0];
        		int yDiff = points[i][1] - points[j][1];
        		int diff = xDiff * xDiff + yDiff * yDiff;
        		x.put(diff, x.getOrDefault(diff, 0) + 1);
        	}
        	
        	for(int n: x.values()) {
        		toRet += n * (n-1);
        	}
        	
        	x.clear();
        }
    	
    	return toRet;
    }
}
