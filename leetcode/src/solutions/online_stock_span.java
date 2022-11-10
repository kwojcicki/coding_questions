package solutions;

import java.util.Stack;

public class online_stock_span {
	class StockSpanner {

		Stack<int[]> s = new Stack<>();
	    public StockSpanner() {
	        
	    }
	    
	    public int next(int price) {
	        int ret = 1;
	        while(!s.isEmpty() && s.peek()[0] <= price) {
	        	ret += s.pop()[1];
	        }
	        s.push(new int[] {price, ret});
	        return ret;
	    }
	}
}
