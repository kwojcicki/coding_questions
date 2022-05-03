package solutions;

public class shortest_unsorted_continuous_subarray {
    public int findUnsortedSubarray(int[] nums) {
        int startIndex = Integer.MAX_VALUE;
        int endIndex = 0;
        int ret = 0;
        int maxSeen = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] < maxSeen) {
        		endIndex = i;
        		int tmp = i - 1;
        		while(tmp >= 0 && nums[i] < nums[tmp]) {
        			tmp--;
        		}
        		startIndex = Math.min(startIndex, tmp + 1);
        		ret = Math.max(ret, endIndex - startIndex + 1);
        	}
        	maxSeen = Math.max(maxSeen, nums[i]);
        }
        
        // System.out.println(startIndex + " " + endIndex);
        return ret;
    }
}
