package top_interview_easy.array;

import java.util.Arrays;

public class best_time_to_buy_sell_stocks_2 {
	
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        for(int i = 0; i < prices.length - 1; i++) {
        	if(prices[i] < prices[i + 1]) {
        		maxProfit += prices[i + 1] - prices[i];
        	}
        }
        
        return maxProfit;
    }
	
    public static void main(String[] args) {
    	best_time_to_buy_sell_stocks_2 s = new best_time_to_buy_sell_stocks_2();
    	int[] a = new int[] {1,2,3,4,5};
    	System.out.println(s.maxProfit(a));
    	System.out.println(Arrays.toString(a));
    	
    	a = new int[] {7,1,5,3,6,4};
    	System.out.println(s.maxProfit(a));
    	System.out.println(Arrays.toString(a));
    
    }
}
