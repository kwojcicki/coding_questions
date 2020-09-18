package top_interview_easy.dp;

import java.util.Arrays;

public class best_time_to_buy_sell_stocks {
	
	public int maxProfit(int[] prices) {
		int max = 0;
		int maxElement = 0;
		
		for(int i = prices.length - 1; i >= 0; i--) {
			max = Math.max(maxElement - prices[i], max);
			maxElement = Math.max(maxElement, prices[i]);
		}
		
		return max;
	}
	
    public int maxProfit1(int[] prices) {
        int maxCur = 0;
        int maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
	
    public static void main(String[] args) {
    	best_time_to_buy_sell_stocks s = new best_time_to_buy_sell_stocks();
    	int[] a = new int[] {1,2,3,4,5};
    	System.out.println(s.maxProfit(a));
    	System.out.println(Arrays.toString(a));
    	
    	a = new int[] {7,1,5,3,6,4};
    	System.out.println(s.maxProfit(a));
    	System.out.println(Arrays.toString(a));
    
    }
}
