package solutions;

import java.util.Arrays;
import java.util.Comparator;

public class maximum_bags_with_full_capacity_of_rocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    	int[][] s = new int[capacity.length][2];
        for(int i = 0; i < capacity.length; i++) {
        	s[i] = new int[] { capacity[i], rocks[i] };
        }
        int ret = 0;
        
        Arrays.sort(s, Comparator.comparingInt(a -> a[0] - a[1]));
        for(int[] i: s) {
        	if(i[0] == i[1]) ret++;
        	else if(i[1] + additionalRocks >= i[0]) { ret++; additionalRocks -= (i[0] - i[1]); }
        	else break;
        }
        
        return ret;
    }
}
