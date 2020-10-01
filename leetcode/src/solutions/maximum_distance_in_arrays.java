package solutions;

import java.util.List;

public class maximum_distance_in_arrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDiff = 0;
        int oldMin = Integer.MAX_VALUE;
        int oldMax = 0;
        
        for(int i = 1; i < arrays.size(); i++){
            List<Integer> a = arrays.get(i);
            oldMin = min;
            oldMax = max;
        	min = Math.min(min, a.get(0));
        	max = Math.max(max, a.get(a.size() - 1));
            
            maxDiff = Math.max(maxDiff, Math.max(oldMax - a.get(0), a.get(a.size() - 1) - oldMin));
        }
        
        return maxDiff;
    }
}
