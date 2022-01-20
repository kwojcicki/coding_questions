package solutions;

import java.util.Arrays;

public class koko_eating_bananas {
	
	public boolean check(int k, int[] piles, int h) {
		int turns = 0;
		for(int i: piles) {
			turns += Math.ceil( (double)i / k);
            if(turns > h) return false;
		}
		
		return true;
	}
	
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = Arrays.stream(piles).max().getAsInt();
        int ret = Integer.MAX_VALUE;
        
        while(start <= end) {
        	int m = (end - start) / 2 + start;
        	boolean possible = check(m, piles, h);
        	if(possible) {
        		ret = m;
        		end = m - 1;
        	} else {
        		start = m + 1;
        	}
        	
        }
        
        return ret;
    }
}
