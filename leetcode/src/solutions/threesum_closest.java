package solutions;

import java.util.Arrays;

public class threesum_closest {
    public int threeSumClosest(int[] nums, int target) {
    	if(nums.length == 3) {
    		return nums[0] + nums[1] + nums[2];
    	}
    	
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        
        for(int i = 0; i < nums.length - 2; i++) {
        	int j = i + 1;
        	int k = nums.length - 1;
        	while(j < k) {
        		int sum = nums[i] + nums[j] + nums[k];
        		if(Math.abs(target - sum) < 
        				Math.abs(target - ans)) {
        			ans = sum;
        		}
        		if(sum < target) {
        			j++;
        		} else {
        			k--;
        		}
        	}
        }
        
        return ans;
    }
}
