package solutions;

public class single_element_in_a_sorted_array {
    public int singleNonDuplicate(int[] nums) {
    	int start = 0, end = nums.length - 1;
    	while(start < end) {
    		System.out.println(start + " " + end);
    		int mid = (start + end) / 2;
    		if(mid % 2 != 0) mid++;
    		
    		if(nums[mid] == nums[mid - 1]) {
    			end = mid - 2;
    		} else {
    			start = mid;
    		}
    	}
    	
    	return nums[start];
    }
    
    public static void main(String[] args) {
    	System.out.println(new single_element_in_a_sorted_array().singleNonDuplicate(new int[] {1,1,4,4,5}));
    	System.out.println(new single_element_in_a_sorted_array().singleNonDuplicate(new int[] {1,1,4,4,2,2,5}));
    	System.out.println(new single_element_in_a_sorted_array().singleNonDuplicate(new int[] {5,1,1,4,4,2,2}));
    	System.out.println(new single_element_in_a_sorted_array().singleNonDuplicate(new int[] {1,1,5,4,4,2,2}));
    }
}
