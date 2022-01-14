package solutions;

import java.util.Arrays;

public class minimum_number_of_arrows_to_burst_balloons {
	
	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
		int ret = 0, min = points[0][1];
		
		for(int i = 0; i < points.length; i++) {
			if(points[i][0] > min) {
				ret++;
				min = points[i][1];
			}
		}
		
		return ret + 1;
	}
	
    public int findMinArrowShots2(int[][] points) {
    	Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
    	
    	if(points == null || points.length == 0) {
    		return 0;
    	}
    	
    	int ret = 0;
		int min = points[0][1];
		
    	for(int i = 0; i < points.length; i++) {
    		if(points[i][0] > min) {
    			ret++;
    			min = points[i][1];
    		} else if(points[i][1] < min) {
    			min = points[i][1];
    		}
    	}
    	
    	return ret + 1;
    }
	
	public int findMinArrowShots1(int[][] points) {
		Arrays.sort(points, (a,b)->{
			return Integer.compare(a[1], b[1]);
		});

		//         for(int[] a: points){
		//             System.out.println(Arrays.toString(a));
		//         }

		int overlapping = 0;
		Integer max = null;

		for(int i = 0; i < points.length; i++) {
			if(max != null && points[i][0] <= max && max <= points[i][1]) {
				overlapping++;
			} else {
				max = points[i][1];
			}
		}
		return points.length - overlapping;
	}
}
