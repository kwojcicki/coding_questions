package solutions;

import java.util.ArrayList;
import java.util.Stack;

public class final_prices_with_a_special_discount_in_a_shop {
    public int[] finalPrices(int[] prices) {
    	Stack<int[]> q = new Stack<>();
    	
    	for(int i = 0; i < prices.length; i++) {
    		while(!q.isEmpty() && q.peek()[0] >= prices[i]) {
    			prices[q.pop()[1]]-=prices[i];
    		}
    		
    		q.add(new int[] {prices[i], i});
    	}
        return prices;
    }
}
