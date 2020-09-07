package solutions;

public class find_minimum_in_rotated_sorted_array {
    public int findMin(int[] nums) {
    	int start = 0;
    	int end = nums.length - 1;
    	
    	while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end])
            	end = mid;
            else if (nums[mid] > nums[end])
            	start = mid + 1;
        }

        return nums[start];
    }
    
    public int findMin1(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        if(nums[0] < nums[end]) return nums[0];
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            System.out.println("start: " + start + " mid: " + mid + " end: " + end);
            if(nums[mid] < nums[start]){
                end = mid;
            } else {
                start = mid;
            }
            
        }
        
        return nums[end];
    }
}
