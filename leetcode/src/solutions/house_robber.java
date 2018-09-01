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
}
