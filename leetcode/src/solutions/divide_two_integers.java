package solutions;

public class divide_two_integers {
    public int divide(int dividend, int divisor) {
    	if (dividend == Integer.MAX_VALUE && divisor == -1) return Integer.MAX_VALUE - 1;
    	int x = 0;
    	int ret = 0;
    	while(dividend >= divisor) {
    		x = 0;
    		while(dividend >= (divisor << (x << 1))) {
    			x++;
    		}
    		ret += 1 << x;
    		dividend -= divisor << x;
    	}
        
    	return (dividend > 0) == (divisor > 0) ? ret : -ret;
    }
}
