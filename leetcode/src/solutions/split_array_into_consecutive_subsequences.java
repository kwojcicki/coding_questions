package solutions;

public class split_array_into_consecutive_subsequences {
    public boolean isPossible(int[] nums) {
    	int[] count = new int[2004];
        int[] tails = new int[2004];
        for(int i: nums) {
        	count[i + 1001]++;
        }

        for(int i = 1; i < count.length;) {
        	if(count[i] == 0) { i++; continue;}
        	count[i]--;
        	if(tails[i - 1] > 0) {
        		tails[i - 1]--;
        		tails[i]++;
        	} else if(count[i + 1] > 0 && count[i + 2] > 0) {
        		count[i + 1]--;
        		count[i + 2]--;
        		tails[i + 2]++;
        	} else {
                return false;
            }
        	if(count[i] == 0) { i++; continue;}
        }
        
        return true;
    }
}
