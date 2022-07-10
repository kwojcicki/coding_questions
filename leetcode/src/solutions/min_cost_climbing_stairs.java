package solutions;

public class min_cost_climbing_stairs {
	
    public int minCostClimbingStairs(int[] cost) {
    	int one = cost[1];
    	int two = cost[0];
    	int tmp = 0;
    	for(int i = 2; i < cost.length; i++) {
    		tmp = one;
    		one = Math.min(two, one) + cost[i];
    		two = tmp;
    	}
    	
    	return Math.min(one, two);
    }
	
    public int minCostClimbingStairs1(int[] cost) {
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
