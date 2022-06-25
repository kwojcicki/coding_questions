package solutions;

public class non_decreasing_array {
    public boolean checkPossibility(int[] nums) {
        boolean switched = false;
        
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] > nums[i - 1]) continue;
        	else if(switched) return false;
        	switched = true;
        }
        
        // return true;
    }
}
