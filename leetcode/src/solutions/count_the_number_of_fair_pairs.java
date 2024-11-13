package solutions;

import java.util.Arrays;

public class count_the_number_of_fair_pairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ret = 0;
        
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int i = 0;
        while(i < nums.length) {
        	int min = lower - nums[i];
        	int max = upper - nums[i];
        	int minI = Arrays.binarySearch(nums, min);
        	minI = minI >= 0 ? minI: (minI + 1) * -1;
            minI = Math.max(minI, i + 1);
        	int maxI = Arrays.binarySearch(nums, max);
        	maxI = maxI >= 0 ? maxI : (maxI + 2) * -1;
            maxI = Math.max(maxI, i + 1);
        	
        	if(minI >= 0 && maxI >= 0 &&
            minI < nums.length && maxI < nums.length &&
            nums[i] <= nums[minI] && 
             nums[i] + nums[minI] >= lower && nums[i] + nums[maxI] <= upper) {
                while(minI > i + 1 && nums[minI] == nums[minI - 1]) minI--;
                while(maxI < nums.length - 1 && nums[maxI] == nums[maxI + 1]) maxI++;
        		ret += (maxI - minI + 1); 
        	}
        	// System.out.println(minI + " " + maxI + " " + nums[i] + " " + ret);
            i++;
        }
        
        return ret;
    }
}
