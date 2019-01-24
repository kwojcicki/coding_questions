package top_interview_easy.array;

import java.util.Arrays;

public class rotate_array {
	
    public void rotate(int[] nums, int k) {
        
    	for(int a = 0; a < k; a++) {
    		int temp = nums[0];
    		for(int i = 1; i <= nums.length; i++) {
    			int temp2 = nums[i % nums.length];
    			nums[i % nums.length] = temp;
    			temp = temp2;
    		}
    		System.out.println(Arrays.toString(nums));
    	}
    	
    }
	
    public static void main(String[] args) {
    	rotate_array s = new rotate_array();
    	int[] a = new int[] {1,2,3,4,5,6,7};
    	s.rotate(a, 3);
    	System.out.println(Arrays.toString(a));
    	
    	a = new int[] {-1,-100,3,99};
    	s.rotate(a, 2);
    	System.out.println(Arrays.toString(a));
    
    }
}
