package solutions;

public class first_missing_positive {
    public static int firstMissingPositive(int[] nums) {
    	
        if(nums == null || nums.length == 0) return 1;
        int past = 0;
        
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] < 0) {
        		nums[i] = -2;
        	}
        }
        
        for(int i = 0; i < nums.length; i++) {
        	past = nums[i];
        	while(past != -1) {
        		if(past > nums.length || past < 1) {
        			past = -1;
        		} else {
        			int temp = nums[past - 1];
        			nums[past - 1] = -1;
        			past = temp;
        		}
        	}
        }
        
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] != -1) {
        		return i + 1;
        	}
        }
        
        return nums.length + 1;
    }
    
    public static void main(String[] args) {
    	System.out.println(firstMissingPositive(new int[] {1, 2, 0}));
    	System.out.println(firstMissingPositive(new int[] {3, 4, -1, 1}));
    	System.out.println(firstMissingPositive(new int[] {7, 8, 9, 11, 12}));
    }
}
