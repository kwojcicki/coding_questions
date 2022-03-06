package solutions;

public class count_all_valid_pickup_and_delivery_options {
    public int countOrders(int n) {
    	if(n == 1) {
    		return 1;
    	}

    	long ret = 1;
    	int mod = (int)Math.pow(10, 9) + 7;
    	for(int i = 1; i <= n; i++) {
    	    ret *= i;
    	    ret %= mod;
    		ret *= 2 * i - 1;
    	    ret %= mod;
    	}

    	return (int)(ret %= mod);
    }
}
