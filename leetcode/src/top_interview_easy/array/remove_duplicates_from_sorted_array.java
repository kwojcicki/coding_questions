package top_interview_easy.array;

import java.util.Arrays;

public class remove_duplicates_from_sorted_array {
	
    public int removeDuplicates(int[] nums) {
    	if(nums == null || nums.length <= 1) {
    		return nums.length;
    	}
    	
        int id = 0;
        int duplicates = 0;
        
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] > nums[id]) {
        		int temp = nums[i];
        		nums[i] = nums[id + 1];
        		nums[id + 1] = temp;
        		id++;
        	} else {
        		duplicates++;
        	}
        }
        
        return nums.length - duplicates;
    }
    
    public static void main(String[] args) {
    	remove_duplicates_from_sorted_array s = new remove_duplicates_from_sorted_array();
    	int[] a = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    	System.out.println(s.removeDuplicates(a));
    	System.out.println(Arrays.toString(a));
    	
    	a = new int[] {1, 1, 2};
    	System.out.println(s.removeDuplicates(a));
    	System.out.println(Arrays.toString(a));
    	
    	a = new int[] {1, 1};
    	System.out.println(s.removeDuplicates(a));
    	System.out.println(Arrays.toString(a));
    	
    	a = new int[] {0, 0, 1, 1, 1};
    	System.out.println(s.removeDuplicates(a));
    	System.out.println(Arrays.toString(a));
    }

}
