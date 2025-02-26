package solutions;

public class maximum_absolute_sum_of_any_subarray {
    public int maxAbsoluteSum(int[] nums) {
        int ret = 0;
        int currN = 0;
        int currP = 0;
        
        for(int i: nums) {
        	currN += i; currP += i;
        	if(i < 0) {
        		currN = Math.min(currN, i);
        	} else {
        		currP = Math.max(currP, i);
        	}
            ret = Math.max(currP, Math.max(ret, -1 * currN));
        }
        
        return ret;
    }
}
