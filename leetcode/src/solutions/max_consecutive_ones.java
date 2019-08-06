package solutions;

public class max_consecutive_ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int maxSoFar = 0;
        
        for(int i: nums) {
        	max += i;
        	if(i == 0) {
        		max = Math.max(max, maxSoFar);
        		maxSoFar = 0;
        	}
        }
        
        return max;
    }
}
