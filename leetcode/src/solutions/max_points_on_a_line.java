package solutions;

import java.util.HashMap;
import java.util.Map;

public class max_points_on_a_line {
	public int maxPoints(int[][] points) {
        int ret = 0;
        
        for(int i = 0; i < points.length; i++) {
        	Map<String, Integer> c = new HashMap<>();
        	int same = 1;
        	for(int j = i + 1; j < points.length; j++) {
        		if(points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
        			same++;
        		} else {
        			int dx = points[j][0] - points[i][0], dy = points[j][1] - points[i][1], g = gcd(dx, dy);
        			c.compute((dx / g) + "_" + (dy/g), (k,v) -> v == null ? 1 : v + 1);
        		}
        	}
        	
        	ret = Math.max(ret, same);
        	for(int a: c.values()) {
        		ret = Math.max(ret, a + same);
        	}
            // System.out.println(c);
            // System.out.println(i);
        }
        
        return ret;
    }
    
    int gcd(int a, int b) {
        if (b==0) return a;
        else return gcd(b,a%b);
    }
}
