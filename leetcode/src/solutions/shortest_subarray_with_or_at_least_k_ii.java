package solutions;

public class shortest_subarray_with_or_at_least_k_ii {
	public int minimumSubarrayLength(int[] nums, int k) {
        int currCount = 0;
        int[] curr = new int[32];
        int minLength = Integer.MAX_VALUE;
        int left = 0, right = 0;
        if(k == 0) return 1;
        
        while(true) {
            // System.out.println(currCount + " " + k + " " + Arrays.toString(curr));
            // System.out.println(left + " " + right);
            // System.out.println("---");
        	if(currCount >= k && left < nums.length) {
        		minLength = Math.min(right - left, minLength);
        		currCount = subtract(curr, nums[left]);
        		left++;
        	} else if(right < nums.length) {
        		currCount = add(curr, nums[right]);
        		right++;
        	} else {
        		break;
        	}
        }
        
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
    
    public int subtract(int[] curr, int num) {
    	int i = 0;
    	while(num > 0) {
    		curr[i] = Math.max(0, curr[i] - (num % 2 == 1 ? 1 : 0));
    		num = num / 2;
    		i++;
    	}
    	int ret = 0;
    	for(int j = curr.length - 1; j >= 0; j--) ret = ret * 2 + (curr[j] > 0 ? 1 : 0);
    	return ret;
    }
    
    public int add(int[] curr, int num) {
    	int i = 0;
    	while(num > 0) {
    		curr[i] += num % 2;
    		num = num / 2;
    		i++;
    	}
    	int ret = 0;
    	for(int j = curr.length - 1; j >= 0; j--) ret = ret * 2 + (curr[j] > 0 ? 1 : 0);
    	return ret;
    }
}
