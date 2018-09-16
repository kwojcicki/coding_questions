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
        	}
        }
    	
    	return toRet;
    }
}
