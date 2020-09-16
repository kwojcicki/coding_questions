package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge_intervals {
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> ret = new ArrayList<>();
        
        int[] curr = intervals[0];
        ret.add(curr);
        
        for(int[] interval: intervals) {
        	if(interval[0] > curr[1]) {
        		curr = interval;
        		ret.add(curr);
        	} else {
        		curr[1] = Math.max(curr[1], interval[1]);
        	}
        }
        
        return ret.toArray(new int[ret.size()][]);
    }
    
    public static void main(String[] args) {
    	int[][] a = merge(new int[][] {
    		{1,3}, {2, 4}
    	});
    	
    	for(int[] b: a) {
    		System.out.println(Arrays.toString(b));
    	}
    }
}
