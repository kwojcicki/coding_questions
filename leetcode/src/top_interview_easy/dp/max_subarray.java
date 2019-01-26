package top_interview_easy.dp;

import java.util.Arrays;

public class max_subarray {
	
    public int maxSubArray(int[] nums) {
        int soFar = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
        	if(soFar + nums[i] > nums[i]) {
        		soFar += nums[i];
        	} else {
        		soFar = nums[i];
        	}

    		max = Math.max(soFar, max);
        	System.out.println("max: " + max + " curr: " + soFar);
        }
        
        return max;
    }
	
    public static void main(String[] args) {
    	max_subarray s = new max_subarray();
    	int[] a = new int[] {-2,1,-3,4,-1,2,1,-5,4};
    	System.out.println(s.maxSubArray(a));
    	

    }
}
