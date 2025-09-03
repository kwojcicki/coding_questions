package solutions;

import java.util.Arrays;

public class find_the_number_of_ways_to_place_people_ii {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ret = 0;
        
        for(int i = 0; i < points.length; i++) {
            // System.out.println(Arrays.toString(points[i]));
        	int y = Integer.MIN_VALUE;
        	for(int j = i + 1; j < points.length; j++) {
        		if(points[j][1] > y && points[j][1] <= points[i][1]) {
        			ret++;
        			y = points[j][1];
        		}
        	}
        }
        
        return ret;
    }
}
