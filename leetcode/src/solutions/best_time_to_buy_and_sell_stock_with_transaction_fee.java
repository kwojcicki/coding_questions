package solutions;

public class best_time_to_buy_and_sell_stock_with_transaction_fee {
	public int maxProfit(int[] prices, int fee) {
		int l0 = 0, l1 = Integer.MIN_VALUE;
		for(int i: prices){
			int t = l0;
			l0 = Math.max(l0, l1 + i);
			l1 = Math.max(l1, t - i - fee);
		}
		return l0;
	}
}
