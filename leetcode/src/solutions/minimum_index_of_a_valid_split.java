package solutions;

import java.util.List;

public class minimum_index_of_a_valid_split {
    public int minimumIndex(List<Integer> nums) {
        int majority = 0;
        int count = 0;
        for(int i: nums) {
        	if(i == majority) count++;
        	else if(count == 0) { majority = i; count = 1; }
        	else count--;
        }
        
        count = 0;
        for(int i: nums) if(i == majority) count++;
        
        // System.out.println(majority + " " + count);
        int leftCount = 0;
        for(int i = 0; i < nums.size() - 1; i++) {
        	if(nums.get(i) == majority) leftCount++;
            // System.out.println(leftCount + " " + i + " " + count);
            // System.out.println(((double) leftCount) / (i + 1) + " " + 
            // (double)(count - leftCount) / (nums.size() - i - 1));

        	if( ((double) leftCount) / (i + 1) > 0.5 && 
        			(double)(count - leftCount) / (nums.size() - i - 1) > 0.5) return i; 
        }
    	
    	return -1;
    }
}
