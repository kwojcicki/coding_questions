package solutions;

public class min_cost_climbing_stairs {
    public int minCostClimbingStairs(int[] cost) {
    	int temp = 0;
    	int oneStep = 0;
    	int twoStep = 0;
    	for(int i = cost.length - 1; i >=0; i--) {
    		temp = cost[i] + Math.min(oneStep, twoStep);
    		twoStep = oneStep;
    		oneStep = temp;
    	}
    	
    	return Math.min(oneStep, twoStep);
    }
}
