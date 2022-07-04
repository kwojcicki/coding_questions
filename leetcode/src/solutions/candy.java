package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class candy {
    public int candy(int[] ratings) {
    	int ret = 0;
    	int up = 0, down = 0, peak = 0;
    	
    	for(int i = 1; i < ratings.length; i++) {
    		if(ratings[i] > ratings[i - 1]) {
    			up++;
    			down = 0;
    			peak = up;
    			ret += up;
    		} else if(ratings[i] == ratings[i - 1]) {
    			down = 0;
                peak = 0;
    			up = 0;
    		} else {
                up = 0;
    			down++;
    			ret += down + (down <= peak ? -1 : 0);
    		}
    	}
    	
    	return ret + ratings.length;
    }
    
    public int candy1(int[] ratings) {
        int[] c = new int[ratings.length];
        Arrays.fill(c, 1);
        
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[0]));
        
        for(int i = 0; i < ratings.length; i++) {
        	pq.add(new int[] {ratings[i], i});
        }
        
        while(!pq.isEmpty()) {
        	int[] n = pq.poll();
        	int i = n[1];
        	int r = n[0];
        	if(i > 0 && i < ratings.length - 1 && ratings[i - 1] < r 
        			&& ratings[i + 1] < r) {
        		c[i] = Math.max(c[i - 1], c[i + 1]) + 1;
        	} else if(i > 0 && ratings[i - 1] < r) {
        		c[i] = c[i - 1] + 1;
        	} else if(i < ratings.length - 1 && ratings[i + 1] < r) {
        		c[i] = c[i + 1] + 1;
        	} 
        }
        
        return Arrays.stream(c).sum();
    }
}
