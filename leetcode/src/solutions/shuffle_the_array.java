package solutions;

public class shuffle_the_array {
	public int[] shuffle(int[] nums, int n) {
        for(int i = 0; i < nums.length; i++) {
        	int j = i;
        	while(nums[i] >= 1) {
        		j = getIndex(j, n);
        		int t = nums[i];
        		nums[i] = nums[j];
        		nums[j] = - t;
        	}
        }
        
        for(int i = 0; i < nums.length; i++) nums[i] *= -1;
    	
    	return nums;
    }
    
    public int getIndex(int i, int n) {
    	if(i < n) {
    		return i * 2;
    	}
    	
    	return (i - n) * 2 + 1;
    }
    
    public static void main(String[] args) {
    	new shuffle_the_array().shuffle(new int[] {1,2,3,4,5,6,7,8}, 4);
    }
}
