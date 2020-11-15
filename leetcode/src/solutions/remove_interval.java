package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class remove_interval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ret = new ArrayList<>();
        
        if(intervals == null || intervals.length == 0) return ret;
        
        for(int[] i: intervals) {
        	if(i[1] < toBeRemoved[0] || i[0] > toBeRemoved[1]) {
        		ret.add(Arrays.asList(new Integer[] {i[0], i[1]}));
        	} else if(toBeRemoved[0] < i[0] && i[1] < toBeRemoved[1]) {
        		continue;
        	} else if (i[0] < toBeRemoved[0] && i[1] < toBeRemoved[1]) {
        		ret.add(Arrays.asList(new Integer[] {i[0], toBeRemoved[0]}));
        	} else if (toBeRemoved[0] < i[0] && toBeRemoved[1] < i[1]) {
        		ret.add(Arrays.asList(new Integer[] {toBeRemoved[1], i[1]}));
        	} else if (i[0] < toBeRemoved[0] && toBeRemoved[1] < i[1]) {
        		ret.add(Arrays.asList(new Integer[] {i[0], toBeRemoved[0]}));
        		ret.add(Arrays.asList(new Integer[] {toBeRemoved[1], i[1]}));
        	} else if (i[0] <= toBeRemoved[0] && toBeRemoved[1] < i[1]) {
        		ret.add(Arrays.asList(new Integer[] {toBeRemoved[1], i[1]}));
        	}
        }
        
        return ret;
    }
}
