package solutions;

public class search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while(start <= end) {
        	int mid = start + (end - start) / 2;
        	System.out.println("start: " + start + " mid: " + mid + " end: " + end);
        	if(nums[mid] == target) {
        		return mid;
        	} else if(nums[mid] >= nums[start]){
                
                if(target > nums[mid] || target < nums[start]) start = mid + 1;
                else end = mid - 1;
                
            } else {
                
                if(target >= nums[start] || target < nums[mid]) end = mid - 1;
                else start = mid + 1;
                
            }
        	
        }
        
        return -1;
    }
}
