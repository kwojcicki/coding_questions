package solutions;

public class best_time_to_buy_and_sell_stock_iii {
    public int maxProfit(int[] prices) {
    	int max = 0;
    	
    	int[] left = new int[prices.length];
    	int[] right = new int[prices.length + 1];
    	
    	int leftMin = prices[0];
    	int rightMax = prices[prices.length - 1];
    	
    	for(int i = 1; i < prices.length; i++) {
    		
    		left[i] = Math.max(left[i - 1], prices[i] - leftMin);
    		leftMin = Math.min(leftMin, prices[i]);
    		
    		int r = prices.length - i - 1;
    		
    		right[r] = Math.max(right[r + 1], rightMax - prices[r]);
    		rightMax = Math.max(rightMax, prices[r]);
    	}
    	
    	//System.out.println(Arrays.toString(right));
    	//System.out.println(Arrays.toString(left));
    	
    	max = Math.max(right[0], left[left.length - 1]);
    	
    	for(int i = 0; i < left.length - 1; i++) {
    		max = Math.max(max, left[i] + right[i + 1]);
    	}
    	
    	return max;
    }
}
