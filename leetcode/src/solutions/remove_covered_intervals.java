package solutions;

import java.util.Arrays;

public class remove_covered_intervals {
	
	public int removeCoveredIntervals(int[][] intervals) {
		
		int count = 0;
		
		Arrays.sort(intervals, (a, b)->{
			if(a[0] == b[0]) {
				return Integer.compare(b[1], a[1]);
			}
			
			return Integer.compare(a[0], b[0]);
		});
		
		int end = -1;
		
		for(int i = 0; i < intervals.length; i++) {
            //System.out.println(Arrays.toString(intervals[i]) + " " + end + " " + count);
			if(intervals[i][1] <= end) {
				count++;
			} else {
				end = intervals[i][1];
			}
		}
		
		return intervals.length - count;
	}
	
    public int removeCoveredIntervals1(int[][] intervals) {
        int count = 0;
        
        for(int i = 0; i < intervals.length; i++) {
        	boolean remove = false;
        	for(int j = 0; j < intervals.length; j++) {
        		
        		if(i == j) continue;
        		
        		if(intervals[j][0] <= intervals[i][0] && 
        				intervals[i][1] <= intervals[j][1]) {
        			remove = true;
        		}
        	}
        	
        	if(!remove) count++;
        }
        
        return count;
    }
}
