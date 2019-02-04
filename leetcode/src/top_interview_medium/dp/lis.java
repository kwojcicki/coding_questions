package top_interview_medium.dp;

import java.util.Arrays;

public class lis {
    public int lengthOfLIS(int[] nums) {
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	
        int[] longest = new int[nums.length];
        longest[0] = 1;
        
        for(int i = 1; i < longest.length; i++) {
        	longest[i] = 1;
        	for(int j = 0; j < i; j++) {
        		if(nums[i] > nums[j]) longest[i] = Math.max(longest[i], longest[j] + 1);
        	}
        }
        
        System.out.println(Arrays.toString(longest));
        return Arrays.stream(longest).max().getAsInt();
    }
}
