package solutions;

public class find_the_duplicate_number {
    public int findDuplicate(int[] nums) {
        
    	int fast = 0;
    	int slow = 0;
    	
    	do {
    		fast = nums[nums[fast]];
    		slow = nums[slow];
    	} while(fast != slow);
    	
    	fast = 0;
    	
    	while(fast != slow) {
    		fast = nums[fast];
    		slow = nums[slow];
    	}
    	
    	return fast;
    }
}
