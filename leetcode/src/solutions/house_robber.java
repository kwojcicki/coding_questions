package solutions;

public class house_robber {
	public int rob(int[] nums) {
    	int temp = 0;
    	int oneStep = 0;
    	int twoStep = 0;
    	for(int i = nums.length - 1; i >=0; i--) {
    		temp = Math.max(oneStep, nums[i] + twoStep);
    		twoStep = oneStep;
    		oneStep = temp;
    	}
    	
    	return Math.max(oneStep, twoStep);
    }
	
    public int rob1(int[] nums) {
        int one = 0;
        int two = 0;
        
        for(int i: nums){
            int temp = Math.max(one, two + i);
            
            two = one;
            one = temp;
        }
        
        
        return Math.max(one, two);
    }
}
