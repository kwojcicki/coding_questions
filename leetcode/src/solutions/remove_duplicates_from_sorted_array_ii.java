package solutions;

import java.util.Arrays;

public class remove_duplicates_from_sorted_array_ii {
    public int removeDuplicates(int[] nums) {
        int valid = 0;
        int curr = 0;
        
        while(curr < nums.length) {
        	if(valid < 2 || (valid >= 2 && (nums[valid - 1] != nums[curr] || nums[valid - 2] != nums[curr]))) {
        		nums[valid] = nums[curr];
        		valid++;
        	}
        	curr++;
        }
        
        System.out.println(Arrays.toString(nums));
        return valid;
    }
    
    public static void main(String[] args) {
    	System.out.println(new remove_duplicates_from_sorted_array_ii().removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
