package solutions;

import java.util.Arrays;

public class earliest_possible_day_of_full_bloom {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
    	int[][] p = new int[plantTime.length][2];
        for(int i = 0; i < plantTime.length; i++) {
        	p[i][0] = plantTime[i];
        	p[i][1] = growTime[i];
        }
        
        Arrays.sort(p, (a,b) -> {
        	if(a[1] == b[1]) {
        		return Integer.compare(a[0], b[0]);
        	}
        	
        	return Integer.compare(b[1], a[1]);
        });
        int ret = 0;
        int curr = 0;
        for(int[] i: p) {
        	curr += i[0];
        	ret = Math.max(ret, curr + i[1]);
        }
        
        return ret;
    }
}
